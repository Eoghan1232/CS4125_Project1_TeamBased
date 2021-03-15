package com.cs4125.bookingapp.services;

import org.springframework.stereotype.Service;

@Service
public class TransactionRecordInitialState implements TransactionRecordState {

    @Override
    public void next(TransactionContext t) {
        t.getTransactionRecord().setStatus(1);
        t.setTransactionRecordState(new TransactionRecordInProgressState());
    }

    @Override
    public void cancel(TransactionContext t, long daysBeforeTravel) {
        int status = -3;
        if(daysBeforeTravel <= 1) {
            status = -1;
        }
        else if(daysBeforeTravel <= 7) {
            status = -2;
        }
        t.getTransactionRecord().setStatus(status);
        t.setTransactionRecordState(new TransactionRecordCancelledState());
    }

    @Override
    public String currentState() {
        return "TransactionState{Transaction Initiated!}";
    }
}
