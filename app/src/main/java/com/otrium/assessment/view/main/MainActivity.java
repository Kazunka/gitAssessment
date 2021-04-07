package com.otrium.assessment.view.main;


import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.otrium.assessment.R;
import com.otrium.assessment.view.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainActivityView, MainActivityPresenter> implements MainActivityView {

    @BindView(R.id.profile_name)
    TextView profileName;
    @BindView(R.id.profile_id)
    TextView profileID;
    @BindView(R.id.profile_mail)
    TextView profileMail;
    @BindView(R.id.profile_follow)
    TextView profileFollow;

    @BindView(R.id.pinned_list)
    RecyclerView pinnedList;
    @BindView(R.id.top_repo_list)
    RecyclerView topRepoList;
    @BindView(R.id.starred_list)
    RecyclerView starredList;

    @Inject
    MainActivityPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    // TODO: Alter the Argumnets with network model
    @Override
    public void setHeaderDetails(@NonNull String name, @NonNull String id, @NonNull String email, @NonNull int followers, @NonNull int following) {
        profileName.setText(name);
        profileID.setText(id);
        profileMail.setText(email);
        profileFollow.setText(getResources().getString(R.string.profile_follow, followers, following));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.onSuccessUser();
        initPinnedRecyclerView();
        initTopRecyclerView();
        initStarttedRecyclerView();
    }

    /**
     *
     */
    private void initPinnedRecyclerView() {
        final RepoAdapter accountAdapter = mainPresenter.getAdapter();
        pinnedList.setHasFixedSize(true);
        pinnedList.setLayoutManager(new LinearLayoutManager(this));
        pinnedList.setAdapter(accountAdapter);
    }

    private void initTopRecyclerView() {
        final RepoAdapter accountAdapter = mainPresenter.getAdapter();
        topRepoList.setHasFixedSize(true);
        topRepoList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, Boolean.FALSE));
        topRepoList.setAdapter(accountAdapter);
    }

    private void initStarttedRecyclerView() {
        final RepoAdapter accountAdapter = mainPresenter.getAdapter();
        starredList.setHasFixedSize(true);
        starredList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, Boolean.FALSE));
        starredList.setAdapter(accountAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}