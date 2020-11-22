package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.entities.Booking;
import org.springframework.data.repository.CrudRepository;

public interface IBookingRepository extends CrudRepository<Booking, Integer> {
}
