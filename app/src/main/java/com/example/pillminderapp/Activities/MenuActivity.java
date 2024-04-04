package com.example.pillminderapp.Activities;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.pillminderapp.Adapters.PillAdapter;
import com.example.pillminderapp.Model.Pill;
import com.example.pillminderapp.R;
import com.example.pillminderapp.Utilities.DataManager;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuActivity extends AppCompatActivity {


    private RecyclerView recyclerview_list_pills;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findViews();
        initViews();

    }



    private void initViews() {
       ArrayList<Pill> pills = DataManager.hardCab().getPills();
       Log.d("Pills",pills.toString());
        PillAdapter pillAdapter = new PillAdapter(this,pills);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview_list_pills.setLayoutManager(linearLayoutManager);
        recyclerview_list_pills.setAdapter(pillAdapter);
    }

    private void findViews() {
        recyclerview_list_pills = findViewById(R.id.recyclerview_list_pills);
    }

}