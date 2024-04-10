package com.example.pillminderapp.Model;

import java.util.ArrayList;
import java.util.Collections;

public class Cabinet {

    ArrayList<Prescription> prescriptions = new ArrayList<>();


    public ArrayList<Prescription> getPrescriptions() {
        return prescriptions;
    }


    public void setPrescriptions(ArrayList<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public void addNewPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        Collections.sort(prescriptions);
    }



    @Override
    public String toString() {
        return "Cabinet{" +
                "prescriptions=" + prescriptions +
                '}';
    }
}
