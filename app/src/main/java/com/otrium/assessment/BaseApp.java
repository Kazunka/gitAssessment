package com.otrium.assessment;

import com.otrium.assessment.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

public class BaseApp extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
