package com.cs4125.bookingapp.repositories;

import com.cs4125.bookingapp.entities.Discount;
import com.cs4125.bookingapp.web.RetrofitClientInstance;
import com.cs4125.bookingapp.web.SpringRetrofitService;

import java.io.IOException;
import java.io.Serializable;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscountRepositoryImpl implements DiscountRepository, Serializable
{
    private final SpringRetrofitService web = RetrofitClientInstance.getWebInstance();

    @Override
    public void getAllDiscounts(ResultCallback callback)
    {
        Call<ResponseBody> returnVal = web.getAllDiscounts();

        returnVal.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("RESPONSE!");
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
    @Override
    public void getDiscountById(Discount discount, ResultCallback callback)
    {
        Call<ResponseBody> returnVal = web.getDiscount(discount.getDiscountId());

        returnVal.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("RESPONSE!");
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
    @Override
    public void getDiscountByCode(Discount discount, ResultCallback callback)
    {
        Call<ResponseBody> returnVal = web.getDiscount(discount.getCode());

        returnVal.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("RESPONSE!");
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
    @Override
    public void newDiscount(Discount discount, ResultCallback callback)
    {
        Call<ResponseBody> returnVal = web.createNewDiscount(discount.getCode(), discount.getRouteIDs(), discount.getDiscountPercent());

        returnVal.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("RESPONSE!");
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
    @Override
    public void updateDiscount(Discount discount, ResultCallback callback)
    {
        Call<ResponseBody> returnVal = web.updateDiscount(discount.getDiscountId(), discount.getCode(), discount.getRouteIDs(), discount.getDiscountPercent());

        returnVal.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("RESPONSE!");
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
    @Override
    public void removeOldDiscount(Discount discount, ResultCallback callback)
    {
        Call<ResponseBody> returnVal = web.removeOldDiscount(discount.getDiscountId());

        returnVal.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("RESPONSE!");
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
