package com.cs4125.bookingapp.web;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClientInstance
{
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://localhost:8080";

    public static Retrofit getRetrofitInstance()
    {
        if (retrofit == null)
        {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
