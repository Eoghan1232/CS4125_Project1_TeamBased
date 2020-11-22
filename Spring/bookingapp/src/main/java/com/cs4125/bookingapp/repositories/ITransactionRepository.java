package com.cs4125.bookingapp.repositories;


import com.cs4125.bookingapp.entities.TransactionRecord;
import org.springframework.data.repository.CrudRepository;

public interface ITransactionRepository extends CrudRepository<TransactionRecord, Integer> {
}
