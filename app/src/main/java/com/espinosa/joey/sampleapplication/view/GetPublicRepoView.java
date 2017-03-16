package com.espinosa.joey.sampleapplication.view;

import com.espinosa.joey.sampleapplication.base.BaseView;
import com.espinosa.joey.sampleapplication.model.Repository;

import java.util.List;

/**
 * Created by Joey on 16/03/2017.
 */

public interface GetPublicRepoView extends BaseView {

    void showRepositories(List<Repository> repositories);
}
