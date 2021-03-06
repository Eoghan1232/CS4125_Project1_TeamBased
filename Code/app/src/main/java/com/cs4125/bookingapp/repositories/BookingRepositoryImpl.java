package com.cs4125.bookingapp.repositories;

import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.entities.Route;
import com.cs4125.bookingapp.web.RetrofitClientInstance;
import com.cs4125.bookingapp.web.SpringRetrofitService;

import java.io.IOException;
import java.io.Serializable;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingRepositoryImpl implements BookingRepository, Serializable
{
    private final SpringRetrofitService web = RetrofitClientInstance.getWebInstance();

    @Override
    public void userBooking(Route route, Booking booking, String discountCode, ResultCallback callback) {
        Call<ResponseBody> returnVal = web.newBooking(route.getStartStation(), route.getEndStation(),
                route.getConnectionPath(), route.getPrice(), route.getDateTime(), booking.getPassengerID(),
                booking.getQuantity(), discountCode);

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

    @Override
    public void bookingUpdate(Booking booking, ResultCallback callback) {
        Call<ResponseBody> returnVal = web.updateBooking(booking.getBookingID());

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
    public void bookingCancel(Booking booking, ResultCallback callback) {
        Call<ResponseBody> returnVal = web.cancelBooking(booking.getBookingID());

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
    public void bookingList(Booking booking, ResultCallback callback) {
        Call<ResponseBody> returnVal = web.getAllBookings(booking.getPassengerID());

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
    public void getBooking(Booking booking, ResultCallback callback) {
        Call<ResponseBody> returnVal = web.getBooking(booking.getBookingID());

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
