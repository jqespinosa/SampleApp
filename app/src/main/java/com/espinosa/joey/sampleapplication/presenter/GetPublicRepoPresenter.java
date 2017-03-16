package com.espinosa.joey.sampleapplication.presenter;

import com.espinosa.joey.sampleapplication.base.BasePresenter;

/**
 * Created by Joey on 16/03/2017.
 */

public interface GetPublicRepoPresenter extends BasePresenter{

    void processRepoSearch(String username);
}
