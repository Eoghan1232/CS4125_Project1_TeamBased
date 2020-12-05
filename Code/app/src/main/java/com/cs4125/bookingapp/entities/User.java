package com.cs4125.bookingapp.entities;

import java.util.Date;

public class User
{
    private final int userID;
    private final String username;
    private final String password;
    private final String email;
    private final UserType userType;

    // Private constructor for the builder
    private User(UserBuilder builder)
    {
        this.userID = builder.userID;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.userType = builder.userType;
    }

    //region Getters
    public int getUserID()
    {
        return userID;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }

    public UserType getUserType()
    {
        return userType;
    }
    //endregion

    @Override
    public String toString()
    {
        return "User{" + "userID=" + userID + ", username='" + username + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", userType=" + userType + '}';
    }

    private static class UserBuilder
    {
        private int userID;
        private String username;
        private String password;
        private String email;
        private UserType userType;

        public UserBuilder setUserID(int userID)
        {
            this.userID = userID;

            return this;
        }

        public UserBuilder setUsername(String username)
        {
            this.username = username;

            return this;
        }

        public UserBuilder setPassword(String password)
        {
            this.password = password;

            return this;
        }

        public UserBuilder setEmail(String email)
        {
            this.email = email;

            return this;
        }

        public UserBuilder setUserType(UserType userType)
        {
            this.userType = userType;

            return this;
        }

        public User build()
        {
            // Not needed unless, need to do something with the object before returning it e.g. testing the data
            //Booking booking = new Booking(this);
            return new User(this);
        }
    }
}
