package com.cs4125.bookingapp.model.repositories;

import com.cs4125.bookingapp.model.entities.Booking;
import org.springframework.data.repository.CrudRepository;

public interface IBookingRepository extends CrudRepository<Booking, Integer> {
}
