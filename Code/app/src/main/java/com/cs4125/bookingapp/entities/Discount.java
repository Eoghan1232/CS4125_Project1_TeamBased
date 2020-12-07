package com.cs4125.bookingapp.entities;

import java.util.List;

public class Discount
{
    private final String code;
    private final List<String> routeIDs;
    private final float discountPercent;
    private final int discountId;

    private Discount(DiscountBuilder builder)
    {
        this.code = builder.code;
        this.routeIDs = builder.routeIDs;
        this.discountPercent = builder.discountPercent;
        this.discountId = builder.discountId;
    }

    //region Getters
    public String getCode()
    {
        return code;
    }

    public List<String> getRouteIDs()
    {
        return routeIDs;
    }

    public float getDiscountPercent()
    {
        return discountPercent;
    }

    public int getDiscountId() { return discountId; }
    //endregion

    @Override
    public String toString()
    {
        return "Discount{" + "code='" + code + '\'' + ", routeIDs=" + routeIDs + ", discountPercent=" + discountPercent + "discountId =" + discountId + '}';
    }

    public static class DiscountBuilder
    {
        private String code;
        private List<String> routeIDs;
        private float discountPercent;
        private int discountId;

        public DiscountBuilder setCode(String code)
        {
            this.code = code;

            return this;
        }

        public DiscountBuilder setRouteIDs(List<String> routeIDs)
        {
            this.routeIDs = routeIDs;

            return this;
        }

        public DiscountBuilder setDiscountPercent(float discountPercent)
        {
            this.discountPercent = discountPercent;

            return this;
        }

        public DiscountBuilder setDiscountId(int discountId)
        {
            this.discountId = discountId;

            return this;
        }

        public Discount build()
        {
            //Discount discount = new Discount(this)
            return new Discount(this);
        }
    }
}
