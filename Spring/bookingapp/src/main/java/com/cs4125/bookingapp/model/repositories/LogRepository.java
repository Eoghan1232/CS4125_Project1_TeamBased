package com.cs4125.bookingapp.model.repositories;

import com.cs4125.bookingapp.model.entities.Booking;
import com.cs4125.bookingapp.model.entities.Log;
import com.cs4125.bookingapp.model.entities.TransactionRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LogRepository extends CrudRepository<Log, Integer> {
}

