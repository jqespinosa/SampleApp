package com.espinosa.joey.sampleapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.espinosa.joey.sampleapplication.base.BaseActivity;
import com.espinosa.joey.sampleapplication.base.BaseRecyclerViewAdapter;
import com.espinosa.joey.sampleapplication.model.Repository;
import com.espinosa.joey.sampleapplication.presenter.GetPublicRepoPresenter;
import com.espinosa.joey.sampleapplication.presenter.GetPublicRepoPresenterImpl;
import com.espinosa.joey.sampleapplication.view.GetPublicRepoView;

import java.util.List;

public class MainActivity extends BaseActivity implements GetPublicRepoView {

    private EditText usernameEditText;
    private Button submitButton;
    private RecyclerView repositoriesRecyclerView;
    private GetPublicRepoPresenter getPublicRepoPresenter;
    private BaseRecyclerViewAdapter<Repository> adapter;
    private ProgressDialog progressDialog;

    @Override
    protected void loadContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initializeFields() {
        // Intentionally did not use Butterknife
        usernameEditText = (EditText) findViewById(R.id.edittext_username);
        submitButton = (Button) findViewById(R.id.button_submit);
        repositoriesRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_repositories);
        repositoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processItem();
            }
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.msg_loading));
    }

    @Override
    protected void initializePresenters() {
        getPublicRepoPresenter = new GetPublicRepoPresenterImpl(this);
    }

    @Override
    protected void processItem() {

        if (TextUtils.isEmpty(usernameEditText.getText())) {
            Toast.makeText(getApplicationContext(), R.string.err_empty_username, Toast.LENGTH_SHORT).show();
            return;
        }

        getPublicRepoPresenter.processRepoSearch(usernameEditText.getText().toString().trim());
    }

    @Override
    public void showRepositories(List<Repository> repositories) {

        if (adapter != null) { adapter.clear(); }
        adapter = new BaseRecyclerViewAdapter<>(repositories,
                R.layout.item_repo,
                com.espinosa.joey.sampleapplication.BR.model,
                new BaseRecyclerViewAdapter.ItemClickListener<Repository>() {
                    @Override
                    public void onItemClick(View v, Repository item, int position) {
                        Toast.makeText(getApplicationContext(), "Clicked: " + item.getName(), Toast.LENGTH_SHORT).show();
                    }
                });
        repositoriesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);
        alertDialogBuilder
                .setMessage("Do you want to close the application?")
                .setCancelable(true)
                .setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                MainActivity.this.finish();
                            }
                        })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
