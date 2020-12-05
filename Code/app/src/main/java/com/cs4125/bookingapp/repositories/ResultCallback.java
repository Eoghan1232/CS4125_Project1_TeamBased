package com.cs4125.bookingapp.repositories;

public interface ResultCallback
{
    void onResult(String result);
    void onFailure(Throwable error);
}
