package com.cs4125.bookingapp.services;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class TransactionRecordInProgressState implements TransactionRecordState {

    @Override
    public void next(TransactionContext t) {
        t.getTransactionRecord().setStatus(2);
        t.getTransactionRecord().setDateOfPayment(Timestamp.valueOf(LocalDateTime.now()));
        t.setTransactionRecordState(new TransactionRecordCompletedState());
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
        return "TransactionState{Transaction In Progress!}";
    }
}
