package com.cs4125.bookingapp.entities;

import java.util.Date;

public class Booking
{
    private final long bookingID;
    private final long passengerID;
    private final long routeID;
    private final int quantity;
    private final Date dateTime;
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
    public long getBookingID()
    {
        return bookingID;
    }

    public long getPassengerID()
    {
        return passengerID;
    }

    public long getRouteID()
    {
        return routeID;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public Date getDateTime()
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
        private long bookingID;
        private long passengerID;
        private long routeID;
        private int quantity;
        private Date dateTime;
        private float price;

        public BookingBuilder setBookingID(long bookingID)
        {
            this.bookingID = bookingID;

            return this;
        }

        public BookingBuilder setPassengerID(long passengerID)
        {
            this.passengerID = passengerID;

            return this;
        }

        public BookingBuilder setRouteID(long routeID)
        {
            this.routeID = routeID;

            return this;
        }

        public BookingBuilder setQuantity(int quantity)
        {
            this.quantity = quantity;

            return this;
        }

        public BookingBuilder setDateTime(Date dateTime)
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
