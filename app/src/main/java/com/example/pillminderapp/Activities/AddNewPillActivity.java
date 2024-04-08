package com.example.pillminderapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;

import com.example.pillminderapp.Model.Pill;
import com.example.pillminderapp.R;
import com.example.pillminderapp.Utilities.DataManager;
import com.example.pillminderapp.Utilities.ImageLoader;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;

import java.util.ArrayList;

public class AddNewPillActivity extends AppCompatActivity {


    private MaterialButton add_BTN_add;

    private MaterialAutoCompleteTextView add_TXT_name;
    private ShapeableImageView add_IMG_pill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_pill);
        findViews();
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
                    if (add_TXT_name.getText().toString().matches(p.getName())){
                        ImageLoader.getInstance().load(p.getImgURL(), add_IMG_pill);
                        break;
                    }
                    else
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
    }
}