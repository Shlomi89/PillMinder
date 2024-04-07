package com.example.pillminderapp.Utilities;

import com.example.pillminderapp.Model.Cabinet;
import com.example.pillminderapp.Model.Pill;
import com.google.gson.Gson;

public class DataManager {
    public static Cabinet getCabinet(){
        Cabinet cab= (Cabinet) new Gson().fromJson(SharedPreferencesManager.getInstance().getString("LEADERBOARD", ""), Cabinet.class);
        if (cab.getPills().get(0) == null) {
            cab= new Cabinet();
        }
        return cab;
    }


    public static Cabinet hardCab(){
        Cabinet cabinet  = new Cabinet();
        cabinet.addNewPill(new Pill("Dopamin",true,2,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",9,20));
        cabinet.addNewPill(new Pill("Adamati",false,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",10,30));
        cabinet.addNewPill(new Pill("Tpvaster",false,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",8,30));
        cabinet.addNewPill(new Pill("LSD",false,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",11,30));
        cabinet.addNewPill(new Pill("Ompepradex",false,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",8,30));
        cabinet.addNewPill(new Pill("LOP",false,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",23,30));
        cabinet.addNewPill(new Pill("Shlokozin",false,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",12,30));
        cabinet.addNewPill(new Pill("APAO",false,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",5,30));
        cabinet.addNewPill(new Pill("Oaempic",false,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",22,30));
        cabinet.addNewPill(new Pill("Ritalin",false,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",6,30));
        cabinet.addNewPill(new Pill("Salon",false,3,"https://media.istockphoto.com/id/1072626580/vector/medicine-flat-design-icon-isolated-on-white-background.jpg?s=612x612&w=0&k=20&c=I0ZVPGWIHoLbx6VC25v-aplRocMd7Al8OQUO2Mwri7Q=",8,30));
        return cabinet;
    }


}
