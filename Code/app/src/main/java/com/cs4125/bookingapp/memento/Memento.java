package com.cs4125.bookingapp.memento;

import com.google.android.material.chip.Chip;

public class Memento {
    private State state;


    public Memento(State state){
        this.state = state;

    }

    public State getState(){
        return state;
    }
}
