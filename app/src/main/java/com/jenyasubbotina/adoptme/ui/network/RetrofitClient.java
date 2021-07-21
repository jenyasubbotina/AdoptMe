package com.jenyasubbotina.adoptme.ui.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.jenyasubbotina.adoptme.ui.constants.Constants;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private final Retrofit.Builder retrofitBuilder;
    private final OkHttpClient.Builder okHttpBuilder;
    private ApiService apiService;

    private static String BASE_URL = "";
    private static RetrofitClient INSTANCE;

    private RetrofitClient(@NonNull final Context context) {
        this.okHttpBuilder = new OkHttpClient.Builder()
                .connectTimeout(60L, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .writeTimeout(60L, TimeUnit.SECONDS)
                .callTimeout(60L, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        this.retrofitBuilder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(
                        new GsonBuilder()
                                .setLenient()
                                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (json, typeOfT, context1) ->
                                        new Date(json.getAsJsonPrimitive().getAsLong()))
                                .create()));
    }

    public void setAuthorizationHeader(final Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFS, Context.MODE_PRIVATE);
        final String bearerToken = sharedPreferences.getString(Constants.BEARER_TOKEN, "");
        if (!TextUtils.isEmpty(bearerToken)) {
            final AuthInterceptor interceptor = new AuthInterceptor(bearerToken);
            okHttpBuilder.addInterceptor(interceptor);
        }
        apiService = retrofitBuilder.client(okHttpBuilder.build()).build().create(ApiService.class);
    }

    public static RetrofitClient getInstance(@NonNull final Context context) {
        if (INSTANCE == null) {
            synchronized (RetrofitClient.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RetrofitClient(context);
                }
            }
        }
        return INSTANCE;
    }

    /* Authentication */
    public Response<okhttp3.Response> register(final Integer registerParams) throws IOException {
        return apiService.register(registerParams).execute();
    }
}
