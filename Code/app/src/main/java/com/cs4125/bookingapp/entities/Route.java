package com.cs4125.bookingapp.entities;


import java.sql.Timestamp;

public class Route
{
    private final int routeID;
    private final String startStation;
    private final String endStation;
    private final Timestamp dateTime;
    private final float price;

    private Route(RouteBuilder builder)
    {
        this.routeID = builder.routeID;
        this.startStation = builder.startStation;
        this.endStation = builder.endStation;
        this.dateTime =builder.dateTime;
        this.price = builder.price;
    }

    //region Getters
    public int getRouteID()
    {
        return routeID;
    }

    public String getStartStation()
    {
        return startStation;
    }

    public String getEndStation()
    {
        return endStation;
    }

    public Timestamp getDateTime()
    {
        return dateTime;
    }

    public float getPrice()
    {
        return price;
    }
    //endregion

    @Override
    public String toString()
    {
        return "Route{" + "routeID=" + routeID + ", startStation='" + startStation + '\'' + ", endStation='" + endStation + '\'' + ", dateTime=" + dateTime + ", price=" + price + '}';
    }

    public static class RouteBuilder
    {
        public int routeID;
        public String startStation;
        public String endStation;
        public Timestamp dateTime;
        public float price;

        public RouteBuilder setRouteID(int routeID)
        {
            this.routeID = routeID;

            return this;
        }

        public RouteBuilder setStartStation(String startStation)
        {
            this.startStation = startStation;

            return this;
        }

        public RouteBuilder setEndStation(String endStation)
        {
            this.endStation = endStation;

            return this;
        }

        public RouteBuilder setDateTime(Timestamp dateTime)
        {
            this.dateTime = dateTime;

            return this;
        }

        public RouteBuilder setPrice(float price)
        {
            this.price = price;

            return this;
        }

        public Route build()
        {
            //Route route = new Route(this)
            return new Route(this);
        }
    }
}
