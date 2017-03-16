package com.espinosa.joey.sampleapplication.base;

import android.content.Context;

/**
 * Created by Joey on 16/03/2017.
 */

public interface BaseView {

    void showProgress();

    void hideProgress();

    void showError(String message);

    Context getContext();
}
