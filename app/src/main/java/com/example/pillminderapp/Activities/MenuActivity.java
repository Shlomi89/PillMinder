package com.example.pillminderapp.Activities;

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
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {


    private RecyclerView recyclerview_list_pills;
    private ExtendedFloatingActionButton menu_BTN_add;
    private  Cabinet cabinet = DataManager.getCabinet();

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
       Log.d("Pills",cabinet.toString());
        PillAdapter pillAdapter = new PillAdapter(this,cabinet);
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
                SharedPreferencesManager.getInstance().putString("PRESCRIPTION", new Gson().toJson(cabinet));
                recyclerview_list_pills.getAdapter().notifyDataSetChanged();

//                pills.remove(position);
//                recyclerview_list_pills.getAdapter().notifyItemRemoved(position);
            }
        });
    }

    private void findViews() {
        recyclerview_list_pills = findViewById(R.id.recyclerview_list_pills);
        menu_BTN_add = findViewById(R.id.menu_BTN_add);
    }

}