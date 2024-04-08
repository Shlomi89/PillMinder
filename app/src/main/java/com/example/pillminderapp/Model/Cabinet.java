package com.example.pillminderapp.Model;

import java.util.ArrayList;
import java.util.Collections;

public class Cabinet {

    ArrayList<Prescription> prescriptions = new ArrayList<>();


    public ArrayList<Prescription> getPills() {
        return prescriptions;
    }


    public void addNewPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        Collections.sort(prescriptions);
    }


}
