package com.cs4125.bookingapp.model.repositories;

import com.cs4125.bookingapp.model.entities.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogRepository extends CrudRepository<Log, Integer> {
}
