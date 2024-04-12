package com.example.pillminderapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.pillminderapp.Adapters.LocalDateAdapter;
import com.example.pillminderapp.Model.Cabinet;
import com.example.pillminderapp.Model.Pill;
import com.example.pillminderapp.Model.Prescription;
import com.example.pillminderapp.R;
import com.example.pillminderapp.Utilities.DataManager;
import com.example.pillminderapp.Utilities.ImageLoader;
import com.example.pillminderapp.Utilities.SharedPreferencesManager;
import com.example.pillminderapp.Utilities.SignalManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class AddNewPillActivity extends AppCompatActivity {


    private MaterialButton add_BTN_add;

    private MaterialAutoCompleteTextView add_TXT_name;
    private ShapeableImageView add_IMG_pill;
    private AppCompatSpinner add_SPN_quantity;
    private TextInputEditText add_TXT_duration;
    private MaterialTextView add_TXTVIEW_duration;
    private MaterialCheckBox add_CHK_permanent;
    private AppCompatSpinner add_SPN_meal;
    private AppCompatSpinner add_SPN_hour;
    private AppCompatSpinner add_SPN_minute;
    private AppCompatSpinner add_SPN_frequency;

    private Cabinet cabinet = new Cabinet();
    private ExtendedFloatingActionButton add_BTN_back;

    private String imgURL="";

    public static final String PRESCRIPTION = "PRESCRIPTION";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_pill);
        findViews();
        cabinetFromDB();
        pillTextListener();
        add_CHK_permanent.setOnClickListener(v -> {
            if (((MaterialCheckBox) v).isChecked()){
                add_TXT_duration.setEnabled(false);
                add_TXT_duration.setVisibility(View.INVISIBLE);
                add_TXTVIEW_duration.setVisibility(View.INVISIBLE);
            }
            else {
                add_TXT_duration.setEnabled(true);
                add_TXT_duration.setVisibility(View.VISIBLE);
                add_TXTVIEW_duration.setVisibility(View.VISIBLE);
            }
        });
        add_BTN_add.setOnClickListener(v-> addPrescription());
        add_BTN_back.setOnClickListener(v-> changeActivity());

    }

    private void changeActivity() {
        Intent menuIntent = new Intent(this, MenuActivity.class);
        startActivity(menuIntent);
    }

    private boolean checkfields(){

        if (add_CHK_permanent.isChecked()){
            if (!add_TXT_name.getText().toString().isEmpty())
                return true;
        }
        else {
            return !add_TXT_name.getText().toString().isEmpty() && !add_TXT_duration.getText().toString().isEmpty();
        }
        return true;
    }

    private void addPrescription() {
        if (checkfields()) {
            double decimalHours = 24 / Double.parseDouble(add_SPN_frequency.getSelectedItem().toString());

            int addhour = (int) decimalHours;
            int addminute = (int) ((decimalHours - addhour) * 60);
            int hour = Integer.parseInt(add_SPN_hour.getSelectedItem().toString());
            int minute = Integer.parseInt(add_SPN_minute.getSelectedItem().toString());
            for (int i = 0; i < Integer.parseInt(add_SPN_frequency.getSelectedItem().toString()); i++) {
                Prescription prescription = new Prescription(add_TXT_name.getText().toString(), //Name
                        add_SPN_meal.getSelectedItemPosition(), //Before\After Meal
                        Integer.parseInt(add_SPN_quantity.getSelectedItem().toString()), // Quantity
                        imgURL, // IMG
                        hour, // Hour
                        minute, // Minute
                        add_CHK_permanent.isChecked() ? -1 : LocalDate.now().plusDays(Integer.parseInt(add_TXT_duration.getText().toString())).toEpochDay()); // Duration
                Log.d("Pres", prescription.toString());
                hour += addhour;
                if (hour >= 24)
                    hour = hour - 24;
                minute += addminute;
                if (minute >= 60)
                    minute = minute - 60;
                cabinet.addNewPrescription(prescription);
            }
            //Add To Db / SharedPref

            //Shared Pref
//            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class,new LocalDateAdapter())
//                    .create();
//            SharedPreferencesManager.getInstance().putString(PRESCRIPTION, gson.toJson(cabinet));
            //DB
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference ref = db.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());
            ref.setValue(cabinet);
            Log.d("Pres", cabinet.toString());
            SignalManager.getInstance().toast(add_TXT_name.getText().toString() + " Added Successfully");
            changeActivity();
        }
        else
            SignalManager.getInstance().toast("Please Fill All Fields");
    }


    private void pillTextListener(){
        ArrayList<String> names = new ArrayList<>();
        for (Pill p :
                DataManager.hardPills()) {
            names.add(p.getName());
        }
        String[] nameArr = new String[DataManager.hardPills().size()];
        nameArr = names.toArray(nameArr);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, nameArr);
        add_TXT_name.setAdapter(adapter);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                for (Pill p :
                        DataManager.hardPills()) {
                    if (add_TXT_name.getText().toString().matches(p.getName())) {
                        ImageLoader.getInstance().load(p.getImgURL(), add_IMG_pill);
                        imgURL = p.getImgURL();
                        break;
                    } else {
                        ImageLoader.getInstance().load("https://www.clalit.co.il/he/new_article_images/medical/drugs/183828247/medium.jpg", add_IMG_pill);
                        imgURL = p.getImgURL();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };


        add_TXT_name.addTextChangedListener(textWatcher);
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
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void findViews() {
        add_BTN_add = findViewById(R.id.add_BTN_add);
        add_BTN_back = findViewById(R.id.add_BTN_back);
        add_TXT_name = findViewById(R.id.add_TXT_name);
        add_IMG_pill = findViewById(R.id.add_IMG_pill);
        add_SPN_quantity = findViewById(R.id.add_SPN_quantity);
        add_TXT_duration = findViewById(R.id.add_TXT_duration);
        add_TXTVIEW_duration = findViewById(R.id.add_TXTVIEW_duration);
        add_CHK_permanent = findViewById(R.id.add_CHK_permanent);
        add_SPN_meal = findViewById(R.id.add_SPN_meal);
        add_SPN_hour = findViewById(R.id.add_SPN_hour);
        add_SPN_minute = findViewById(R.id.add_SPN_minute);
        add_SPN_frequency = findViewById(R.id.add_SPN_frequency);

    }
}