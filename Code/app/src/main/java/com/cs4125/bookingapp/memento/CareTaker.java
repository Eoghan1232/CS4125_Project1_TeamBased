package com.cs4125.bookingapp.memento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>(Collections.nCopies(4, null));

    public void add(Memento state, int index){
        mementoList.set(index, state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }

    public int getLength(){
        return mementoList.size();
    }
}
