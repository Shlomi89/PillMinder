package com.example.pillminderapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.QuickContactBadge;

import com.example.pillminderapp.Model.Pill;
import com.example.pillminderapp.Model.Prescription;
import com.example.pillminderapp.R;
import com.example.pillminderapp.Utilities.DataManager;
import com.example.pillminderapp.Utilities.ImageLoader;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_pill);
        findViews();
        pillTextListener();
        add_CHK_permanent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((MaterialCheckBox) v).isChecked()){
                    add_TXT_duration.setEnabled(false);
                    add_TXTVIEW_duration.setVisibility(View.INVISIBLE);
                }
                else {
                    add_TXT_duration.setEnabled(true);
                    add_TXTVIEW_duration.setVisibility(View.VISIBLE);
                }
            }
        });


        add_BTN_add.setOnClickListener(v-> addPrescription());


    }

    private void addPrescription() {
        Prescription prescription = new Prescription();
        prescription.setName(add_TXT_name.getText().toString());
        prescription.setQuantity(Integer.parseInt(add_SPN_quantity.getSelectedItem().toString()));
        prescription.setAfterMeal(add_SPN_meal.getSelectedItemPosition());
        if (add_TXT_duration.isEnabled()) {
            // TODO: Duration in Class Prescription
        }
        else {
            // TODO: Duration in Class Prescription
            //prescrpstion.setduration -1
        }

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
                        break;
                    } else
                        ImageLoader.getInstance().load("https://www.clalit.co.il/he/new_article_images/medical/drugs/183828247/medium.jpg", add_IMG_pill);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };


        add_TXT_name.addTextChangedListener(textWatcher);
    }

    private void findViews() {
        add_BTN_add = findViewById(R.id.add_BTN_add);
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