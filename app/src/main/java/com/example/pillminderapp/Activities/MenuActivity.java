package com.example.pillminderapp.Activities;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.pillminderapp.Adapters.PillAdapter;
import com.example.pillminderapp.Interfaces.RemoveCallback;
import com.example.pillminderapp.Model.Cabinet;
import com.example.pillminderapp.Model.Pill;
import com.example.pillminderapp.R;
import com.example.pillminderapp.Utilities.DataManager;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuActivity extends AppCompatActivity {


    private RecyclerView recyclerview_list_pills;
    private ExtendedFloatingActionButton menu_BTN_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        findViews();
        initViews();
        menu_BTN_add.setOnClickListener(view-> changeActivity());

    }

    private void changeActivity() {
        Intent addPillIntent = new Intent(this, AddNewPillActivity.class);
        startActivity(addPillIntent);
    }


    private void initViews() {
       Cabinet pills = DataManager.hardCab();
       Log.d("Pills",pills.toString());
        PillAdapter pillAdapter = new PillAdapter(this,pills);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerview_list_pills.setLayoutManager(linearLayoutManager);
        recyclerview_list_pills.setAdapter(pillAdapter);
        pillAdapter.setRemoveCallback(new RemoveCallback() {
            @Override
            public void removePill(ArrayList<Pill> pills, int position) {
                pills.remove(position);
                recyclerview_list_pills.getAdapter().notifyItemRemoved(position);
            }
        });
    }

    private void findViews() {
        recyclerview_list_pills = findViewById(R.id.recyclerview_list_pills);
        menu_BTN_add = findViewById(R.id.menu_BTN_add);
    }

}