package com.cs4125.bookingapp.services.interceptor;

import org.springframework.stereotype.Component;


@Component
public class FilterManager {
    FilterChain filterChain;

    public FilterManager(){
        filterChain = new FilterChain();
    }
    public void setFilter(Filter filter){

        filterChain.addFilter(filter);
    }

    public String filterRequest(String request){
        String result = filterChain.execute(request);
        // We return the String as that how our system runs but for the future the filters will be able to alter the result string as well
        return result;
    }

    public void setTarget(Target target){
        filterChain.setTarget(target);
    }
}
