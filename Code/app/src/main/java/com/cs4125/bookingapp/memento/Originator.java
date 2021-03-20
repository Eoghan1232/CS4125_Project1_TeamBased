package com.cs4125.bookingapp.memento;

import com.google.android.material.chip.Chip;

public class Originator {
    private State state;

    public void setState(State state){
        this.state = state;
    }

    public void setState(String route, String quantity, String discount){
        this.state = new State(route, quantity,discount);
    }

    public void setState(String from, String to, String date, String time, Chip filter){
        this.state = new State(from, to, date, time, filter);
    }

    public State getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento){
        state = memento.getState();
    }
}
