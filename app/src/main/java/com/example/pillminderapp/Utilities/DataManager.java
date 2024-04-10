package com.example.pillminderapp.Utilities;

import com.example.pillminderapp.Adapters.LocalDateAdapter;
import com.example.pillminderapp.Model.Cabinet;
import com.example.pillminderapp.Model.Pill;
import com.example.pillminderapp.Model.Prescription;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataManager {
    public static Cabinet getCabinet(){
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class,new LocalDateAdapter()).create();
        Cabinet cab= (Cabinet) gson.fromJson(SharedPreferencesManager.getInstance().getString("PRESCRIPTION", ""), Cabinet.class);
        if (cab == null) {
            cab= new Cabinet();
        }
        return cab;
    }


    public static Cabinet hardCab(){
        Cabinet cabinet  = new Cabinet();
        cabinet.addNewPrescription(new Prescription("Dopamin",1,2,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",9,20,1));
        cabinet.addNewPrescription(new Prescription("Dopamin",1,2,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",9,20,1));
        cabinet.addNewPrescription(new Prescription("Adamati",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",10,30,1));
        cabinet.addNewPrescription(new Prescription("Tpvaster",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",8,30,1));
        cabinet.addNewPrescription(new Prescription("LSD",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",11,30,1));
        cabinet.addNewPrescription(new Prescription("Ompepradex",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",8,30,1));
        cabinet.addNewPrescription(new Prescription("Ompepradex",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",14,30,1));
        cabinet.addNewPrescription(new Prescription("LOP",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",23,30,1));
        cabinet.addNewPrescription(new Prescription("Shlokozin",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",12,30,1));
        cabinet.addNewPrescription(new Prescription("APAO",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",5,30,1));
        cabinet.addNewPrescription(new Prescription("Oaempic",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",22,30,1));
        cabinet.addNewPrescription(new Prescription("Ritalin",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",6,30,1));
        cabinet.addNewPrescription(new Prescription("Salon",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",8,30,1));
        return cabinet;
    }

    public static ArrayList<Pill> hardPills(){
        ArrayList<Pill> pills = new ArrayList<>();
        pills.add(new Pill("Dopamin","https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q="));
        pills.add(new Pill("Adamati","https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q="));
        pills.add(new Pill("Salon","https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q="));
        pills.add(new Pill("Ritalin","https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q="));
        pills.add(new Pill("Ompepradex","https://superpharmstorage.blob.core.windows.net/hybris/products/mobile/medium/7290010578511.jpg"));
        pills.add(new Pill("Ompa","https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q="));
        return pills;
    }


}
