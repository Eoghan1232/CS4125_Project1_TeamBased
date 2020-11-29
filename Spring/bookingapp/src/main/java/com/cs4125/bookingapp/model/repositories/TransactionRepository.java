package com.cs4125.bookingapp.model.repositories;


import com.cs4125.bookingapp.model.entities.TransactionRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionRecord, Integer> {
}
