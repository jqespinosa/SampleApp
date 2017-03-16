package com.espinosa.joey.sampleapplication.presenter;

import com.espinosa.joey.sampleapplication.interactor.GetPublicRepoInteractor;
import com.espinosa.joey.sampleapplication.interactor.GetPublicRepoInteractorImpl;
import com.espinosa.joey.sampleapplication.model.Repository;
import com.espinosa.joey.sampleapplication.view.GetPublicRepoView;

import java.util.List;

/**
 * Created by Joey on 16/03/2017.
 */

public class GetPublicRepoPresenterImpl implements GetPublicRepoPresenter,
        GetPublicRepoInteractor.OnGetPublicRepoListener {

    private GetPublicRepoView view;
    private GetPublicRepoInteractor interactor;

    public GetPublicRepoPresenterImpl(GetPublicRepoView view) {
        this.view = view;
        this.interactor = new GetPublicRepoInteractorImpl();
    }

    @Override
    public void onSuccess(List<Repository> items) {
        if (view != null){
            view.hideProgress();
            view.showRepositories(items);
        }
    }

    @Override
    public void onError(String message) {

        if (view != null) {
            view.hideProgress();
            view.showError(message);
        }
    }

    @Override
    public void processRepoSearch(String username) {
        if (view != null) {
            view.showProgress();
        }

        interactor.getPublicRepositories(username, view.getContext(), this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
