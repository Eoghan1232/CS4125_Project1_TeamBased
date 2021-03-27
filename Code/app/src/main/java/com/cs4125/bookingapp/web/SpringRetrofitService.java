package com.cs4125.bookingapp.web;

import java.sql.Timestamp;
import java.util.List;

import kotlin.reflect.KCallable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SpringRetrofitService
{
    @GET("/loginuser")
    Call<ResponseBody> getUser(@Query("name") String name, @Query("password") String password);

    @FormUrlEncoded
    @POST("/registeruser")
    Call<ResponseBody> newUser(@Field("name") String name, @Field("password") String password, @Field("email") String email);

    @GET("/generateroutes")
    Call<ResponseBody> getRoutes(@Query("startNodeName") String startNodeName, @Query("endNodeName") String endNodeName, @Query("dateTime") String dateTime);

    @GET("/generatefilteredroutes")
    Call<ResponseBody> getFilteredRoutes(@Query("startNodeName") String startNodeName, @Query("endNodeName") String endNodeName, @Query("filters") String filters, @Query("dateTime") String dateTime);

    @FormUrlEncoded
    @POST("/stripe/createpaymentintent")
    Call<ResponseBody> newPaymentIntent(@Field("paymentType") String paymentType, @Field("price") double price);

    @FormUrlEncoded
    @POST("/stripe/confirmpayment")
    Call<ResponseBody> confirmPayment(@Field("paymentType") String paymentType, @Field("price") long transactionId);

    @GET("/getdiscount/{id}")
    Call<ResponseBody> getDiscount(@Path("id") int id);

    @GET("/getdiscount")
    Call<ResponseBody> getDiscount(@Query("code") String code);

    @GET("/getalldiscounts")
    Call<ResponseBody> getAllDiscounts();

    @FormUrlEncoded
    @POST("/newdiscount")
    Call<ResponseBody> createNewDiscount(@Field("code") String code, @Field("routeIds") List<String> routeIds, @Field("discountPercent") double discountPercent);

    @FormUrlEncoded
    @POST("/updatediscount/{id}")
    Call<ResponseBody> updateDiscount(@Path("id") int id, @Field("code") String code, @Field("routeIds") List<String> routeIds, @Field("discountPercent") double discountPercent);

    @FormUrlEncoded
    @POST("/deletediscount/{id}")
    Call<ResponseBody> removeOldDiscount(@Path("id") int id, @Field("code") String code, @Field("routeIds") List<String> routeIds, @Field("discountPercent") double discountPercent);

    @GET("/getbooking/{id}")
    Call<ResponseBody> getBooking(@Path("id") int id);

    @GET("/getallbookings/{passengerId}")
    Call<ResponseBody> getAllBookings(@Path("passengerId") int passengerId);

    @FormUrlEncoded
    @POST("/newbooking")
    Call<ResponseBody> newBooking(@Field("startNode") String startNode, @Field("endNode") String endNode,
                                  @Field("connectionPath") String connectionPath, @Field("price") double price,
                                  @Field("dateTime") String dateTime, @Field("userId") int userId,
                                  @Field("quantity") int quantity, @Field("discountCode") String discountCode);

    @POST("/paybooking/{id}")
    Call<ResponseBody> updateBooking(@Path("id") int id);

    @FormUrlEncoded
    @POST("/cancelbooking/{id}")
    Call<ResponseBody> cancelBooking(@Path("id") int id);

    // OLD CODE
//    @GET("/getroute/{id}")
//    Call<ResponseBody> getRoute(@Path("id") int id);
//
//    @GET("/getroute")
//    Call<ResponseBody> getRoute(@Query("startStation") String startStation, @Query("endStation") String endStation, @Query("dateTime") Timestamp dateTime);
//
//    /**
//     * All params are optional i.e. it can return all routes that match for example the start station
//     */
//    @GET("/getallroutes")
//    Call<ResponseBody> getRoutes(@Query("startStation") String startStation, @Query("endStation") String endStation, @Query("dateTime") Timestamp dateTime);
//
//    @FormUrlEncoded
//    @POST("/newroute")
//    Call<ResponseBody> newRoute(@Field("startStation") String startStation, @Field("endStation") String endStation, @Field("dateTime") Timestamp dateTime, @Field("price") double price);
//
//    @FormUrlEncoded
//    @POST("/updateroute/{id}")
//    Call<ResponseBody> updateRoute(@Path("id") int id, @Field("startStation") String startStation, @Field("endStation") String endStation, @Field("dateTime") Timestamp dateTime, @Field("price") double price);
//
//    @FormUrlEncoded
//    @POST("/deleteroute/{id}")
//    Call<ResponseBody> deleteRoute(@Path("id") int id, @Field("startStation") String startStation, @Field("endStation") String endStation, @Field("dateTime") Timestamp dateTime, @Field("price") double price);

}
