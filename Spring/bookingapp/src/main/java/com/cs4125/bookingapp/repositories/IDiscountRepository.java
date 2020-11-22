package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.entities.Discount;
import org.springframework.data.repository.CrudRepository;

public interface IDiscountRepository extends CrudRepository<Discount, Integer> {
}
