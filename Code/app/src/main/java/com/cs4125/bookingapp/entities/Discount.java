package com.cs4125.bookingapp.entities;

import java.util.List;

public class Discount
{
    private final String code;
    private final List<Long> routeIDs;
    private final float discountPercent;

    private Discount(DiscountBuilder builder)
    {
        this.code = builder.code;
        this.routeIDs = builder.routeIDs;
        this.discountPercent = builder.discountPercent;
    }

    //region Getters
    public String getCode()
    {
        return code;
    }

    public List<Long> getRouteIDs()
    {
        return routeIDs;
    }

    public float getDiscountPercent()
    {
        return discountPercent;
    }
    //endregion

    @Override
    public String toString()
    {
        return "Discount{" + "code='" + code + '\'' + ", routeIDs=" + routeIDs + ", discountPercent=" + discountPercent + '}';
    }

    private static class DiscountBuilder
    {
        private String code;
        private List<Long> routeIDs;
        private float discountPercent;

        public DiscountBuilder setCode(String code)
        {
            this.code = code;

            return this;
        }

        public DiscountBuilder setRouteIDs(List<Long> routeIDs)
        {
            this.routeIDs = routeIDs;

            return this;
        }

        public DiscountBuilder setDiscountPercent(float discountPercent)
        {
            this.discountPercent = discountPercent;

            return this;
        }

        public Discount build()
        {
            //Discount discount = new Discount(this)
            return new Discount(this);
        }
    }
}
