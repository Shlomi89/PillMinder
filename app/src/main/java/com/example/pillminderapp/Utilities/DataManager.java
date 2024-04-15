package com.example.pillminderapp.Utilities;

import com.example.pillminderapp.Model.Cabinet;
import com.example.pillminderapp.Model.Pill;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class DataManager {
//    public static Cabinet getCabinet(){
////        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class,new LocalDateAdapter()).create();
////        Cabinet cab= (Cabinet) gson.fromJson(SharedPreferencesManager.getInstance().getString("PRESCRIPTION", ""), Cabinet.class);
////        if (cab == null) {
////            cab= new Cabinet();
////        }
////        return cab;
//
//
//
//    }


    public static Cabinet hardCab(){
        Cabinet cabinet  = new Cabinet();
//        cabinet.addNewPrescription(new Prescription("Dopamin",1,2,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",9,20,1));
//        cabinet.addNewPrescription(new Prescription("Dopamin",1,2,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",9,20,1));
//        cabinet.addNewPrescription(new Prescription("Adamati",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",10,30,1));
//        cabinet.addNewPrescription(new Prescription("Tpvaster",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",8,30,1));
//        cabinet.addNewPrescription(new Prescription("LSD",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",11,30,1));
//        cabinet.addNewPrescription(new Prescription("Ompepradex",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",8,30,1));
//        cabinet.addNewPrescription(new Prescription("Ompepradex",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",14,30,1));
//        cabinet.addNewPrescription(new Prescription("LOP",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",23,30,1));
//        cabinet.addNewPrescription(new Prescription("Shlokozin",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",12,30,1));
//        cabinet.addNewPrescription(new Prescription("APAO",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",5,30,1));
//        cabinet.addNewPrescription(new Prescription("Oaempic",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",22,30,1));
//        cabinet.addNewPrescription(new Prescription("Ritalin",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",6,30,1));
//        cabinet.addNewPrescription(new Prescription("Salon",2,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",8,30,1));
        return cabinet;
    }

    public static ArrayList<Pill> hardPills(){
        ArrayList<Pill> pills = new ArrayList<>();
//        pills.add(new Pill("Dopamin","","https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q="));
//        pills.add(new Pill("Adamati","","https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q="));
//        pills.add(new Pill("Salon","","https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q="));
//        pills.add(new Pill("Ritalin","","https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q="));
//        pills.add(new Pill("Ompepradex","","https://superpharmstorage.blob.core.windows.net/hybris/products/mobile/medium/7290010578511.jpg"));
        return pills;
    }

    public static void  addPillsToDB(){
        HashMap<String,Pill> pillHashMap= new HashMap<>();
        pillHashMap.put("Vicodin",new Pill("Vicodin","Strong Pain","https://firebasestorage.googleapis.com/v0/b/pillminder-8bc65.appspot.com/o/Vicodin.png?alt=media&token=a5a49dc4-8779-4e04-948d-5d232f15c35f"));
        pillHashMap.put("Ibuprofen",new Pill("Ibuprofen","Pain Killer","https://firebasestorage.googleapis.com/v0/b/pillminder-8bc65.appspot.com/o/Ibuprofin.png?alt=media&token=a2029c20-5a75-4352-894b-74ed31f57118"));
        pillHashMap.put("Acyclovir",new Pill("Acyclovir","Infection","https://firebasestorage.googleapis.com/v0/b/pillminder-8bc65.appspot.com/o/Acyclovir.png?alt=media&token=69bc49d7-ee52-431f-8003-2aba6ac924c5"));
        pillHashMap.put("Amoxicillin",new Pill("Amoxicillin","Bacterial infection","https://firebasestorage.googleapis.com/v0/b/pillminder-8bc65.appspot.com/o/Amoxicillin.png?alt=media&token=527d059c-7ef7-4f2c-bfa5-de2e6aadf84f"));
        pillHashMap.put("Gabapentin",new Pill("Gabapentin","Control seizures","https://firebasestorage.googleapis.com/v0/b/pillminder-8bc65.appspot.com/o/Gabapentin.png?alt=media&token=07b718fa-cca5-4d71-ae76-b0b2edce58ac"));
        pillHashMap.put("Omeprazole",new Pill("Omeprazole","Acidity","https://firebasestorage.googleapis.com/v0/b/pillminder-8bc65.appspot.com/o/Omepradex.png?alt=media&token=cec2eb75-f6c8-4d44-9cc9-312620e07a5d"));
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference ref = db.getReference("pills");
        ref.setValue(pillHashMap);
    }


}
