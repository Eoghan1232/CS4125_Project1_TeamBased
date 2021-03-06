package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.TransactionRecord;
import com.cs4125.bookingapp.model.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionContext {

    private TransactionRecord transactionRecord;
    private TransactionRecordState transactionRecordState;

    public TransactionRecord getTransactionRecord() {
        return transactionRecord;
    }

    public void setTransactionRecord(TransactionRecord transactionRecord) {
        this.transactionRecord = transactionRecord;
        initTransactionState();
    }

    private void initTransactionState() {
        if(transactionRecord != null) {
            switch(transactionRecord.getStatus()) {
                case 0:
                    this.transactionRecordState = new TransactionRecordInitialState();
                    break;
                case 1:
                    this.transactionRecordState = new TransactionRecordInProgressState();
                    break;
                case 2:
                    this.transactionRecordState = new TransactionRecordCompletedState();
                    break;
                case -1:
                    this.transactionRecordState = new TransactionRecordCancelledState();
                    break;
            }
        }
    }

    public void setTransactionRecordState(TransactionRecordState transactionRecordState) {
        this.transactionRecordState = transactionRecordState;
    }

    public void nextState() {
        transactionRecordState.next(this);
    }

    public void cancelTransaction(long daysBeforeTravel) {
        transactionRecordState.cancel(this, daysBeforeTravel);
    }

    public String getCurrentState() {
        return transactionRecordState.currentState();
    }
}
