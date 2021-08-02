package com.jenyasubbotina.adoptme.network;

import com.jenyasubbotina.adoptme.model.PetTypeModel;

import java.util.List;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    /* Authentication */
    @POST("/api/auth/registration")
    Call<Response> register(@Body final Integer registerParams);

    /* Pet types */
    @GET("/api/getAvailablePetTypes")
    Call<List<PetTypeModel>> getAvailablePetTypes();
}

