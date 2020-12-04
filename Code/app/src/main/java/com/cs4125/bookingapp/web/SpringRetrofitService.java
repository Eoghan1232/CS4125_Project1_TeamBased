package com.cs4125.bookingapp.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SpringRetrofitService
{
    @GET("/loginuser")
    Call<ResponseBody> getUser();

    @FormUrlEncoded
    @POST("/registeruser")
    Call<ResponseBody> newUser();

    @GET("/getroute/{id}")
    Call<ResponseBody> getRoute(@Path("id") int id);

    @GET("/getroute")
    Call<ResponseBody> getRoute();

    @GET("/getallroutes")
    Call<ResponseBody> getRoutes();

    @FormUrlEncoded
    @POST("/newroute")
    Call<ResponseBody> newRoute();

    @FormUrlEncoded
    @POST("/updateroute/{id}")
    Call<ResponseBody> updateRoute(@Path("id") int id);

    @FormUrlEncoded
    @POST("/deleteroute/{id}")
    Call<ResponseBody> deleteRoute(@Path("id") int id);

    @GET("/getdiscount/{id}")
    Call<ResponseBody> getDiscount(@Path("id") int id);

    @GET("/getdiscount")
    Call<ResponseBody> getDiscount();

    @GET("/getalldiscounts")
    Call<ResponseBody> getAllDiscounts();

    @FormUrlEncoded
    @POST("/newdiscount")
    Call<ResponseBody> createNewDiscount();

    @FormUrlEncoded
    @POST("/updatediscount/{id}")
    Call<ResponseBody> updateDiscount(@Path("id") int id);

    @FormUrlEncoded
    @POST("/deletediscount/{id}")
    Call<ResponseBody> removeOldDiscount(@Path("id") int id);

    @GET("/getbooking/{id}")
    Call<ResponseBody> getBooking(@Path("id") int id);

    @GET("/getallbookings/{passengerId}")
    Call<ResponseBody> getAllBookings(@Path("passengerId") int passengerId);

    @FormUrlEncoded
    @POST("/newbooking")
    Call<ResponseBody> newBooking();

    @FormUrlEncoded
    @POST("/paybooking/{id}")
    Call<ResponseBody> updateBooking(@Path("id") int id);

    @FormUrlEncoded
    @POST("/cancelbooking/{id}")
    Call<ResponseBody> cancelBooking(@Path("id") int id);
}
