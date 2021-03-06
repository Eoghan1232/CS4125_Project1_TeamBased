package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountService {
    String searchDiscount(int id);
    String searchDiscount(String code);
    List<String> searchAllDiscounts();
    String addDiscount(Discount d);
    String updateDiscount(Discount d);
    String deleteDiscount(Discount d);
}