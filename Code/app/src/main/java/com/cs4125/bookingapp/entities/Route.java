package com.cs4125.bookingapp.entities;


import java.sql.Timestamp;

public class Route
{
    private final int routeID;
    private final String startStation;
    private final String endStation;
    private final String connectionPath;
    private final double price;
    private final String dateTime;

    private Route(RouteBuilder builder)
    {
        this.routeID = builder.routeID;
        this.startStation = builder.startStation;
        this.endStation = builder.endStation;
        this.connectionPath = builder.connectionPath;
        this.price = builder.price;
        this.dateTime = builder.dateTime;
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

    public String getConnectionPath()
    {
        return connectionPath;
    }

    public double getPrice()
    {
        return price;
    }

    public String getDateTime()
    {
        return dateTime;
    }

    //endregion

    @Override
    public String toString()
    {
        return "Route{" + "routeID=" + routeID + ", startStation=" + startStation +
                ", endStation=" + endStation  + ", connectionPath=" + connectionPath
                + ", price=" + price + ", dateTime=" + dateTime + "}";
    }

    public static class RouteBuilder
    {
        public int routeID;
        public String startStation;
        public String endStation;
        public String connectionPath;
        public double price;
        public String dateTime;

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

        public RouteBuilder setConnectionPath(String connectionPath)
        {
            this.connectionPath = connectionPath;

            return this;
        }

        public RouteBuilder setPrice(double price)
        {
            this.price = price;

            return this;
        }

        public RouteBuilder setDateTime(String dateTime)
        {
            this.dateTime = dateTime;

            return this;
        }

        public Route build()
        {
            //Route route = new Route(this)
            return new Route(this);
        }
    }
}
