package com.cs4125.bookingapp.services.criteria;

import java.util.List;

public interface Criteria <T> {
    public List<T> meetCriteria(List<T> paramList);
}
