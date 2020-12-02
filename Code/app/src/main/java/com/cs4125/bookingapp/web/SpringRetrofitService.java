package com.cs4125.bookingapp.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SpringRetrofitService
{
    @FormUrlEncoded
    @GET("/loginuser")
    Call<ResponseBody> getUser();

    @FormUrlEncoded
    @POST("/registeruser")
    Call<ResponseBody> newUser();

    @FormUrlEncoded
    @GET("/getroute/{id}")
    Call<ResponseBody> getRoute(@Path("id") int id);

    @FormUrlEncoded
    @GET("/getroute")
    Call<ResponseBody> getRoute();

    @FormUrlEncoded
    @GET("/getallroutes")
    Call<ResponseBody> getRoutes();

    @FormUrlEncoded
    @POST("/newroute")
    String newRoute();

    @FormUrlEncoded
    @POST("/updateroute/{id}")
    String updateRoute(@Path("id") int id);

    @FormUrlEncoded
    @POST("/deleteroute/{id}")
    String deleteRoute(@Path("id") int id);

    @FormUrlEncoded
    @GET("/getdiscount/{id}")
    String getDiscount(@Path("id") int id);

    @FormUrlEncoded
    @GET("/getdiscount")
    String getDiscount();

    @FormUrlEncoded
    @GET("/getalldiscounts")
    String getAllDiscounts();

    @FormUrlEncoded
    @POST("/newdiscount")
    String createNewDiscount();

    @FormUrlEncoded
    @POST("/updatediscount/{id}")
    String updateDiscount(@Path("id") int id);

    @FormUrlEncoded
    @POST("/deletediscount/{id}")
    String removeOldDiscount(@Path("id") int id);

    @FormUrlEncoded
    @GET("/getbooking/{id}")
    String getBooking(@Path("id") int id);

    @FormUrlEncoded
    @GET("/getallbookings/{passengerId}")
    String getAllBookings(@Path("passengerId") int passengerId);

    @FormUrlEncoded
    @POST("/newbooking")
    String newBooking();

    @FormUrlEncoded
    @POST("/paybooking/{id}")
    String updateBooking(@Path("id") int id);

    @FormUrlEncoded
    @POST("/cancelbooking/{id}")
    String cancelBooking(@Path("id") int id);
}
