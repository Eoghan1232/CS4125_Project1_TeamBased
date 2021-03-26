package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.web.RetrofitClientInstance;
import com.cs4125.bookingapp.web.SpringRetrofitService;

import java.io.IOException;
import java.io.Serializable;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentRepositoryImpl implements PaymentRepository, Serializable
{
    private final SpringRetrofitService web = RetrofitClientInstance.getWebInstance();

    @Override
    public void getPaymentIntent(double price, ResultCallback callback)
    {
        Call<ResponseBody> returnVal = web.newPaymentInent(price);

        returnVal.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //System.out.println("RESPONSE!");
                String s = null;  // <- response is null here
                try {
                    if(response != null && response.body() != null)
                        s = response.body().string();
                    else
                        s = "Error with request!";
                    callback.onResult(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //System.out.println("BODY!\t" + s);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //System.out.println("FAILED!!   " + t.toString());
                callback.onFailure(t);
            }
        });
    }
}
