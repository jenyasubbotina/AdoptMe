package com.jenyasubbotina.adoptme.ui.network;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    /* Authentication */
    @POST("/api/auth/registration")
    Call<Response> register(@Body final Integer registerParams);
}

