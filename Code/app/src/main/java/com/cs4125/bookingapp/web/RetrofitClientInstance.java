package com.cs4125.bookingapp.web;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

// Singleton
// Only ever need one instance of retrofit to talk with the web services
public class RetrofitClientInstance
{
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://bookingappv2-env.eba-jiuphjjt.eu-west-1.elasticbeanstalk.com/";
    private static SpringRetrofitService web;

    public static Retrofit getRetrofitInstance()
    {
        if (retrofit == null)
        {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static SpringRetrofitService getWebInstance()
    {
        if (retrofit == null)
        {
            getRetrofitInstance();
        }
        if (web == null)
        {
            web = RetrofitClientInstance.getRetrofitInstance().create(SpringRetrofitService.class);
        }

        return web;
    }
}
