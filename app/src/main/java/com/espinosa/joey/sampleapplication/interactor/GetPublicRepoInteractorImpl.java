package com.espinosa.joey.sampleapplication.interactor;

import android.content.Context;

import com.espinosa.joey.sampleapplication.SampleApplication;
import com.espinosa.joey.sampleapplication.api.ApiService;
import com.espinosa.joey.sampleapplication.api.NoConnectivityException;
import com.espinosa.joey.sampleapplication.model.Repository;
import com.espinosa.joey.sampleapplication.utils.Utility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Joey on 16/03/2017.
 */

public class GetPublicRepoInteractorImpl implements GetPublicRepoInteractor {

    @Override
    public void getPublicRepositories(String username, Context context, final OnGetPublicRepoListener listener) {

        SampleApplication application = SampleApplication.get(context);
        ApiService service = application.getAppService(context);
        service.getPublicRepositories(username).enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if (response.body() != null) {
                    if (response.body().isEmpty()) {
                        listener.onError("This account's repository is empty.");
                    } else {
                        listener.onSuccess(response.body());
                    }
                } else {
                    listener.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                if (t instanceof NoConnectivityException) {
                    listener.onError(t.getMessage());
                } else if (Utility.isHttp404(t)) {
                    listener.onError("Username not found.");
                } else {
                    listener.onError("Error in loading repositories.");
                }
            }
        });
    }
}
