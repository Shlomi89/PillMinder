package com.example.pillminderapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pillminderapp.R;
import com.google.android.material.button.MaterialButton;

public class AddNewPillActivity extends AppCompatActivity {


    private MaterialButton add_BTN_add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_pill);
    }
}