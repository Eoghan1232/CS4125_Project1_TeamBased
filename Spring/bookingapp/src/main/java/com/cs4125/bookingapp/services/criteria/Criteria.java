package com.cs4125.bookingapp.services.criteria;

import com.cs4125.bookingapp.model.entities.Connection;


import java.util.List;

public interface Criteria {
    public List<Connection> meetCriteria(List<Connection> connections);
}
