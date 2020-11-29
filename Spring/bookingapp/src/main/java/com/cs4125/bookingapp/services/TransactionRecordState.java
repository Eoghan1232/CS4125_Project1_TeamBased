package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.TransactionRecord;
import org.springframework.stereotype.Service;

@Service
public interface TransactionRecordState {
    void next(TransactionContext t);
    void cancel(TransactionContext t, long daysBeforeTravel);
    String currentState();
}
