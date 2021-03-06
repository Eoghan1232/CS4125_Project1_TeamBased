package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.services.Filter;
import com.cs4125.bookingapp.services.Target;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilterChain {
    private List<Filter> filters = new ArrayList<Filter>();
    private Target target;

    public void addFilter(Filter filter){
        // Doesn't allow duplicate filters.
        if(!filters.contains(filter)){
            filters.add(filter);
        }
    }

    public String execute(String request){
        for (Filter filter : filters) {
            filter.execute(request);
        }
        return target.execute(request);
        // We return the String as that how our system runs but for the future the filters will be able to alter the result string as well
    }

    public void setTarget(Target target){
        this.target = target;
    }
}
