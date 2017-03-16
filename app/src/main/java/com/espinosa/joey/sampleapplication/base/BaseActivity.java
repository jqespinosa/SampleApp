package com.espinosa.joey.sampleapplication.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Joey on 16/03/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadContentView(savedInstanceState);
        initializeFields();
        initializePresenters();
    }

    protected abstract void loadContentView(Bundle savedInstanceState);
    protected abstract void initializeFields();
    protected abstract void initializePresenters();

    protected abstract void processItem();


}
