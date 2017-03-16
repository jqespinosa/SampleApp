package com.espinosa.joey.sampleapplication;

import android.app.Application;
import android.content.Context;

import com.espinosa.joey.sampleapplication.api.ApiService;

/**
 * Created by Joey on 16/03/2017.
 */

public class SampleApplication extends Application {

    private ApiService apiService;

    public static SampleApplication get(Context context) {
        return (SampleApplication) context.getApplicationContext();
    }

    public ApiService getAppService(Context context) {
        if (apiService == null) {
            apiService = ApiService.Factory.create(context);
        }
        return apiService;
    }

    public void setApiService(ApiService apiService) {
        this.apiService = apiService;
    }
}
