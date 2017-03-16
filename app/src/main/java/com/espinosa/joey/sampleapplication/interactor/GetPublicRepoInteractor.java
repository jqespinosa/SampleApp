package com.espinosa.joey.sampleapplication.interactor;

import android.content.Context;

import com.espinosa.joey.sampleapplication.model.Repository;

import java.util.List;

/**
 * Created by Joey on 16/03/2017.
 */

public interface GetPublicRepoInteractor {

    interface OnGetPublicRepoListener {

        void onSuccess(List<Repository> items);

        void onError(String message);
    }

    void getPublicRepositories(String username, Context context,OnGetPublicRepoListener listener);
}
