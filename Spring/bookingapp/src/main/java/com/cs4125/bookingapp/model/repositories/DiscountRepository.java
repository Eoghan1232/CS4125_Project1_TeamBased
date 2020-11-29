package com.cs4125.bookingapp.model.repositories;

import com.cs4125.bookingapp.model.entities.Discount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, Integer> {
    Discount findByCode(String code);
}
