package com.cs4125.bookingapp.controllers;

import com.cs4125.bookingapp.services.Filter;
import com.cs4125.bookingapp.services.Target;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Component
public class FilterManager {
    FilterChain filterChain;

    public FilterManager(Target target){
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }
    public void setFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public String filterRequest(String request){
        String result = filterChain.execute(request);
        // We return the String as that how our system runs but for the future the filters will be able to alter the result string as well
        return result;
    }
}
