package com.wit.data.retrofit.connection;

import com.wit.data.retrofit.device.ObjectResponseDevice;
import com.wit.data.retrofit.events.ObjectResponseEvents;
import com.wit.data.retrofit.user.ObjectResponseUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApiService {

    @GET("user")
    Call<ObjectResponseUser> getUser(
            @Query("id") String id
    );


    @GET("device")
    Call<ObjectResponseDevice> getDevice(
            @Query("user_id") String user_id,
            @Query("device_type") String device_type
    );


    @GET("events")
    Call<ObjectResponseEvents> getEvents(
            @Query("device_id") String device_id,
            @Query("from") String from,
            @Query("to") String to
    );


}
