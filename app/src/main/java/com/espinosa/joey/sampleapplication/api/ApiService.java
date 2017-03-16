package com.espinosa.joey.sampleapplication.api;

import android.content.Context;

import com.espinosa.joey.sampleapplication.model.Repository;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Joey on 16/03/2017.
 */

public interface ApiService {

    @GET("users/{username}/repos")
    Call<List<Repository>> getPublicRepositories(@Path("username") String username);

    class Factory {
        public static ApiService create(Context context) {

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new ConnectivityInterceptor(context))
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(ApiService.class);
        }
    }
}
