package com.umamshafiq.sheguard.api;

import com.umamshafiq.sheguard.model.NotificationSenderModel;
import com.umamshafiq.sheguard.util.NotificationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NotificationAPI {

    @Headers("Content-Type:application/json")
    @POST("v1/projects/sheguard-48946/messages:send") //sheguard-48946 project Id
    Call<NotificationResponse> sendNotification(@Header("Authorization") String authHeader, @Body NotificationSenderModel body);
}
