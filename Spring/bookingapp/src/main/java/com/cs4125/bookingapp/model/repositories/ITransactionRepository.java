package com.cs4125.bookingapp.model.repositories;


import com.cs4125.bookingapp.model.entities.TransactionRecord;
import org.springframework.data.repository.CrudRepository;

public interface ITransactionRepository extends CrudRepository<TransactionRecord, Integer> {
}
