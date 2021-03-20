package com.cs4125.bookingapp.services.abstractFactory;

import com.cs4125.bookingapp.services.criteria.Criteria;

public abstract class AbstractCriteriaFactory<T> {
    public abstract Criteria<T> getCriteria(String criteriaType);
}
