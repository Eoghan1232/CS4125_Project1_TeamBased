package com.cs4125.bookingapp.services.abstractFactory;

import com.cs4125.bookingapp.model.entities.Route;
import com.cs4125.bookingapp.services.criteria.Criteria;

public class RouteCriteriaFactory extends AbstractCriteriaFactory<Route> {

    @Override
    public Criteria<Route> getCriteria(String criteriaType) {

        Criteria<Route> criteria;

        //TODO: Add different criteria for routes
        switch (criteriaType)
        {
            default:
                criteria = null;
        }

        return criteria;
    }
}
