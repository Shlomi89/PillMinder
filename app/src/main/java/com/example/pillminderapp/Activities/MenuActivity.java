package com.example.pillminderapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.pillminderapp.Adapters.PillAdapter;
import com.example.pillminderapp.Interfaces.RemoveCallback;
import com.example.pillminderapp.Model.Cabinet;
import com.example.pillminderapp.Model.Prescription;
import com.example.pillminderapp.Notification.NotificationHelper;
import com.example.pillminderapp.R;
import com.example.pillminderapp.Utilities.AlarmUtils;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class MenuActivity extends AppCompatActivity {


    private RecyclerView recyclerview_list_pills;
    private ExtendedFloatingActionButton menu_BTN_add;
    private MaterialButton menu_BTN_logout;
    private ProgressBar progressBar;
    private Cabinet cabinet = new Cabinet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        cabinetFromDB();
        findViews();
        menu_BTN_add.setOnClickListener(view -> changeActivity());
    }

    private void changeActivity() {
        Intent addPillIntent = new Intent(this, AddNewPillActivity.class);
        startActivity(addPillIntent);
    }


    private void changeLoginActivity() {
        Intent LoginIntent = new Intent(this, LoginActivity.class);
        startActivity(LoginIntent);
    }


    public void cabinetFromDB() {
        FirebaseDatabase.getInstance().getReference(Objects.requireNonNull(FirebaseAuth.getInstance().getUid())).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Prescription> prescriptions = new ArrayList<>();
                for (DataSnapshot prescriptionSnapshot : snapshot.child("prescriptions").getChildren()) {
                    Prescription prescription = prescriptionSnapshot.getValue(Prescription.class);
                    long dayDiff = prescription.getEndDaysDate() - LocalDate.now().toEpochDay();
                    if (dayDiff >= 0)
                        prescriptions.add(prescription);
                }
                cabinet.setPrescriptions(prescriptions);
                initViews();
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference ref = db.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());
                ref.setValue(cabinet);
//                updateAlarms();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void initViews() {
        progressBar.setVisibility(View.GONE);
        menu_BTN_logout.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
            // Set the message show for the Alert time
            builder.setMessage("Are you sure you want to Logout?");
            builder.setTitle("Logout");
            builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                changeLoginActivity();
                            }
                        });
            });
            builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                // If user click no then dialog box is canceled.
                dialog.cancel();
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });
        Log.d("Pills", cabinet.toString());
        PillAdapter pillAdapter = new PillAdapter(this, cabinet);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview_list_pills.setLayoutManager(linearLayoutManager);
        recyclerview_list_pills.setAdapter(pillAdapter);
        pillAdapter.setRemoveCallback(new RemoveCallback() {
            @Override
            public void removePill(ArrayList<Prescription> prescriptions, int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                // Set the message show for the Alert time
                builder.setMessage("Are you sure you want to delete?");
                // Set Alert Title
                builder.setTitle("Delete " + prescriptions.get(position).getName());
                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    String nameOfPill = prescriptions.get(position).getName();
                    prescriptions.removeIf(p -> p.getName().matches(nameOfPill));
                    cabinet.setPrescriptions(prescriptions);
                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    DatabaseReference ref = db.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    ref.setValue(cabinet);
                    recyclerview_list_pills.getAdapter().notifyDataSetChanged();
                });
                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    dialog.cancel();
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private void findViews() {
        recyclerview_list_pills = findViewById(R.id.menu_RYC_medList);
        menu_BTN_add = findViewById(R.id.menu_BTN_add);
        menu_BTN_logout = findViewById(R.id.menu_BTN_logout);
        progressBar = findViewById(R.id.idLoadingPB);
    }

    private void updateAlarms() {
        NotificationHelper.createNotificationChannel(this);
        AlarmUtils.updateAlarms(this, cabinet.getPrescriptions());
    }
}