package com.cs4125.bookingapp.services;

import org.springframework.stereotype.Service;

@Service
public class TransactionRecordCancelledState implements TransactionRecordState {

    @Override
    public void next(TransactionContext t) {
        // Cancelled State is currently the last state!
    }

    @Override
    public void cancel(TransactionContext t, long daysBeforeTravel) {
        // Already cancelled! do nothing
    }

    @Override
    public String currentState() {
        return "TransactionState{Transaction Cancelled!}";
    }
}
