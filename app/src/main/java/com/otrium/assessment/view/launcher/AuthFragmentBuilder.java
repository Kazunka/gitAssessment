package com.otrium.assessment.view.launcher;

import com.otrium.assessment.view.launcher.auth.AuthFragment;
import com.otrium.assessment.view.launcher.auth.AuthFragmentModule;
import com.otrium.assessment.view.launcher.splash.SplashFragment;
import com.otrium.assessment.view.launcher.splash.SplashFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

@Module
public abstract class AuthFragmentBuilder {

    @ContributesAndroidInjector(modules = SplashFragmentModule.class)
    abstract SplashFragment bindSplashFragment();

    @ContributesAndroidInjector(modules = AuthFragmentModule.class)
    abstract AuthFragment bindAuthFragment();
}
