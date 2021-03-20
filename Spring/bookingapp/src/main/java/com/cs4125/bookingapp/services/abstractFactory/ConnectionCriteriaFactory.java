package com.cs4125.bookingapp.services.abstractFactory;

import com.cs4125.bookingapp.model.entities.Connection;
import com.cs4125.bookingapp.services.criteria.*;

public class ConnectionCriteriaFactory extends AbstractCriteriaFactory<Connection> {

    @Override
    public Criteria<Connection> getCriteria(String criteriaType) {

        Criteria<Connection> criteria;
        switch(criteriaType) {
            case("WALK"):
                criteria = new WalkCriteria();
                break;
            case("BUS"):
                criteria = new BusCriteria();
                break;
            case("CAR"):
                criteria = new CarCriteria();
                break;
            case("BIKE"):
                criteria = new BikeCriteria();
                break;
            case("UBER"):
                criteria = new UberCriteria();
                break;
            case("TAXI"):
                criteria = new TaxiCriteria();
                break;
            case("TRAIN"):
                criteria = new TrainCriteria();
                break;
            case("PLANE"):
                criteria = new PlaneCriteria();
                break;
            default:
                return criteria = null;
        }

        return criteria;
    }
}
