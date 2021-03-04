package com.cs4125.bookingapp.entities;


import java.sql.Timestamp;
import java.util.Objects;

public class Booking
{
    private final int bookingID;
    private final int passengerID;
    private final int routeID;
    private final int quantity;
    private final Timestamp dateTime;
    private final float price;

    // Private constructor for the builder
    private Booking(BookingBuilder builder)
    {
        this.bookingID = builder.bookingID;
        this.passengerID = builder.passengerID;
        this.routeID = builder.routeID;
        this.quantity = builder.quantity;
        this.dateTime = builder.dateTime;
        this.price = builder.price;
    }

    //region Getters
    public int getBookingID()
    {
        return bookingID;
    }

    public int getPassengerID()
    {
        return passengerID;
    }

    public int getRouteID()
    {
        return routeID;
    }

    public int getQuantity()
    {
        return quantity;
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
        return "Booking{" + "bookingID=" + bookingID + ", passengerID=" + passengerID + ", routeID=" + routeID + ", quantity=" + quantity + ", dateTime=" + dateTime + ", price=" + price + '}';
    }

    public static class BookingBuilder
    {
        private int bookingID;
        private int passengerID;
        private int routeID;
        private int quantity;
        private Timestamp dateTime;
        private float price;

        public BookingBuilder setBookingID(int bookingID)
        {
            this.bookingID = bookingID;

            return this;
        }

        public BookingBuilder setPassengerID(int passengerID)
        {
            this.passengerID = passengerID;

            return this;
        }

        public BookingBuilder setRouteID(int routeID)
        {
            this.routeID = routeID;

            return this;
        }

        public BookingBuilder setQuantity(int quantity)
        {
            this.quantity = quantity;

            return this;
        }

        public BookingBuilder setDateTime(Timestamp dateTime)
        {
            this.dateTime = dateTime;

            return this;
        }

        public BookingBuilder setPrice(float price)
        {
            this.price = price;

            return this;
        }

        public Booking build()
        {
            // Not needed unless, need to do something with the object before returning it e.g. testing the data
            //Booking booking = new Booking(this);
            return new Booking(this);
        }
    }
}
