package com.cs4125.bookingapp.memento;

import com.google.android.material.chip.Chip;

public class Memento {
    private String state;


    public Memento(String state){
        this.state = state;

    }

    public String getState(){
        return state;
    }
}
