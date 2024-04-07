package com.example.pillminderapp.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Cabinet {

    ArrayList<Pill> Pills = new ArrayList<>();


    public ArrayList<Pill> getPills() {
        return Pills;
    }


    public void addNewPill(Pill pill) {
        Pills.add(pill);
        Collections.sort(Pills);
    }


}
