package com.example.pillminderapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.pillminderapp.Adapters.PillAdapter;
import com.example.pillminderapp.Interfaces.RemoveCallback;
import com.example.pillminderapp.Model.Cabinet;
import com.example.pillminderapp.Model.Prescription;
import com.example.pillminderapp.R;
import com.example.pillminderapp.Utilities.DataManager;
import com.example.pillminderapp.Utilities.SharedPreferencesManager;
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
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class MenuActivity extends AppCompatActivity {


    private RecyclerView recyclerview_list_pills;
    private ExtendedFloatingActionButton menu_BTN_add;
    private MaterialButton menu_BTN_logout;
    private Cabinet cabinet =new Cabinet();

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
        FirebaseDatabase.getInstance().getReference(Objects.requireNonNull(FirebaseAuth.getInstance().getUid())).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Prescription> prescriptions = new ArrayList<>();
                for (DataSnapshot prescriptionSnapshot : snapshot.child("prescriptions").getChildren()) {
                    Prescription prescription = prescriptionSnapshot.getValue(Prescription.class);
                    prescriptions.add(prescription);
                }
                cabinet.setPrescriptions(prescriptions);
                Log.d("CabFromDB",cabinet.toString());
                initViews();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void initViews() {
        menu_BTN_logout.setOnClickListener(v -> {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            changeLoginActivity();
                        }
                    });
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
                String nameOfpill = prescriptions.get(position).getName();
                prescriptions.removeIf(p -> p.getName().matches(nameOfpill));
                cabinet.setPrescriptions(prescriptions);
                FirebaseDatabase db = FirebaseDatabase.getInstance();
                DatabaseReference ref = db.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());
                ref.setValue(cabinet);
//                SharedPreferencesManager.getInstance().putString("PRESCRIPTION", new Gson().toJson(cabinet));
                recyclerview_list_pills.getAdapter().notifyDataSetChanged();

//                pills.remove(position);
//                recyclerview_list_pills.getAdapter().notifyItemRemoved(position);
            }
        });
    }





    private void findViews() {
        recyclerview_list_pills = findViewById(R.id.recyclerview_list_pills);
        menu_BTN_add = findViewById(R.id.menu_BTN_add);
        menu_BTN_logout = findViewById(R.id.menu_BTN_logout);
    }

}