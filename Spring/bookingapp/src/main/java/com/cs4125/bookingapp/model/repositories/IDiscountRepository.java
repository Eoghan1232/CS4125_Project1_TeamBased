package com.cs4125.bookingapp.model.repositories;

import com.cs4125.bookingapp.model.entities.Discount;
import org.springframework.data.repository.CrudRepository;

public interface IDiscountRepository extends CrudRepository<Discount, Integer> {
}
