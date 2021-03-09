package com.cs4125.bookingapp.services.criteria;

import com.cs4125.bookingapp.model.entities.Connection;

import java.util.List;

public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Connection> meetCriteria(List<Connection> connections) {

        List<Connection> firstCriteriaPersons = criteria.meetCriteria(connections);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
