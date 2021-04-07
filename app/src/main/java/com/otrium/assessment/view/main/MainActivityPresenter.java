package com.otrium.assessment.view.main;

import android.content.Context;

import com.otrium.assessment.utils.RxBus;
import com.otrium.assessment.utils.modules.ProfileManagerModule;
import com.otrium.assessment.view.base.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

public class MainActivityPresenter extends BasePresenter<MainActivityView> {

    private final RxBus bus;
    private final Context context;
    private final ProfileManagerModule profileManager;
    private final CompositeDisposable disposable;

    private RepoAdapter adapter;

    public MainActivityPresenter(RxBus bus, ProfileManagerModule managerModule, Context context) {
        this.bus = bus;
        this.profileManager = managerModule;
        this.context = context;

        adapter = new RepoAdapter();
        this.disposable = new CompositeDisposable();
    }

    @Override
    protected void onViewAttached(MainActivityView view) {
        super.onViewAttached(view);
        disposable.clear();
        disposable.add(bus.obtain()
                .subscribe(event -> {
                    if (isViewAttached()) {

                    }
                })
        );

        getDetails();
    }

    /**
     * Execute GraphQL Call
     */
    private void getDetails() {
//        profileManager.getProfile();
    }

    // Temp Method to demonstrate
    public void onSuccessUser(){
        getView().setHeaderDetails("Kasunka Gallage", "kazunka", "kasunka.gallage@gmail.com", 23,32);
    }

    /**
     * get Account List Adapter
     *
     * @return {@link RepoAdapter}
     */
    public RepoAdapter getAdapter() {
        return adapter;
    }
}
