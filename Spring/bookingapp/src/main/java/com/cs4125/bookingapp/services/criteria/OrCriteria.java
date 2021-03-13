package com.cs4125.bookingapp.services.criteria;

import com.cs4125.bookingapp.model.entities.Connection;

import java.util.List;

public class OrCriteria implements Criteria <Connection> {
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Connection> meetCriteria(List<Connection> connections) {
        List<Connection> firstCriteriaItems = criteria.meetCriteria(connections);
        List<Connection> otherCriteriaItems = otherCriteria.meetCriteria(connections);

        for (Connection connection : otherCriteriaItems) {
            if(!firstCriteriaItems.contains(connection)){
                firstCriteriaItems.add(connection);
            }
        }
        return firstCriteriaItems;
    }
}
