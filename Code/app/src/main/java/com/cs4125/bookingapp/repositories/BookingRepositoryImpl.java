package com.cs4125.bookingapp.repositories;

import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.cs4125.bookingapp.entities.Booking;
import com.cs4125.bookingapp.web.RetrofitClientInstance;
import com.cs4125.bookingapp.web.SpringRetrofitService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingRepositoryImpl implements BookingRepository {
    private SpringRetrofitService web = RetrofitClientInstance.getWebInstance();

    @Override
    public LiveData<String> userBooking(Booking booking, String discountCode) {
        Call<ResponseBody> returnVal = web.newBooking(booking.getRouteID(), booking.getPassengerID(), booking.getQuantity(), discountCode);

        returnVal.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("RESPONSE!");
                String s = null;  // <- response is null here
                try {
                    s = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("BODY!\t" + s);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("FAILED!!   " + t.toString());
            }
        });
    }

    @Override
    public LiveData<String> bookingUpdate(Booking booking){
        Call<ResponseBody> returnVal =  web.updateBooking(booking.getBookingID());

        returnVal.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("RESPONSE!");
                String s = null;  // <- response is null here
                try {
                    s = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("BODY!\t" + s);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("FAILED!!   " + t.toString());
            }
        });


    }
}
