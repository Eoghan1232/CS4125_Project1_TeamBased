package com.cs4125.bookingapp.services;

import com.cs4125.bookingapp.model.entities.Discount;
import com.cs4125.bookingapp.model.repositories.DiscountRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountRepository discountRepository;

    /**
     * Searches discount by id
     * @param id id of the discount
     * @return SUCCESS: discount information if found the discount, else FAILURE: error code
     */
    @Override
    public String searchDiscount(int id) {
        Discount resDiscount = discountRepository.findById(id).orElse(null);
        if(resDiscount == null) {
            return "FAILURE: 1";
        }

        return "SUCCESS: " + resDiscount.toString();
    }

    /**
     * Searches discount by the code
     * @param code discount code
     * @return SUCCESS: discount information if found the discount, else FAILURE: error code
     */
    @Override
    public String searchDiscount(String code) {
        Discount resDiscount = discountRepository.findByCode(code);
        if(resDiscount == null) {
            return "FAILURE: 1";
        }

        return "SUCCESS: " + resDiscount.toString();
    }

    /**
     * Searches and returns all discounts
     * @return SUCCESS: discount information if found the discounts, else FAILURE: error code
     */
    @Override
    public List<String> searchAllDiscounts() {
        List<Discount> discounts = Lists.newArrayList(discountRepository.findAll());
        List<String> result = new ArrayList<>();
        if(discounts == null)
        {
            result.add("FAILURE: 1");
            return result;
        }

        if(discounts.size() == 0)
        {
            result.add("FAILURE: 2");
            return result;
        }

        for(Discount d : discounts) {
            result.add("SUCCESS: " + d.toString());
        }

        return result;
    }

    /**
     * Add a new discount
     * @param d discount to be added
     * @return SUCCESS: discount id if adding was successful, else FAILURE: error code
     */
    @Override
    public String addDiscount(Discount d) {
        Discount discountCheck = discountRepository.findByCode(d.getCode());
        if (discountCheck != null) {
            return "FAILURE: 1";
        }
        d = discountRepository.save(d);

        return "SUCCESS: " + d.getRouteId();
    }

    /**
     * Update a discount
     * @param d discount with updated variables
     * @return SUCCESS: discount id if update was successful, else FAILURE: error code
     */
    @Override
    public String updateRoute(Discount d) {
        // no id supplied
        if (d.getDiscountId() == 0) {
            return "FAILURE: 1";
        }

        if (!discountRepository.existsById(d.getDiscountId())) {
            return "FAILURE: 2";
        }
        // if there is a discount with given id already save() will update the entry
        d = discountRepository.save(d);

        return "SUCCESS: " + d.getDiscountId();
    }

    /**
     * Delete a discount
     * @param d discount to be deleted
     * @return SUCCESS: 0 if deletion was successful, else FAILURE: error code
     */
    @Override
    public String deleteRoute(Discount d) {
        // no id supplied
        if (d.getDiscountId() == 0) {
            return "FAILURE: 1";
        }

        if (!discountRepository.existsById(d.getDiscountId())) {
            return "FAILURE: 2";
        }

        // Delete route and check if deletion was successful
        discountRepository.deleteById(d.getDiscountId());
        if (discountRepository.existsById(d.getDiscountId())) {
            return "FAILURE: 3";
        }

        return "SUCCESS: 0";
    }
}
