package com.otrium.assessment.di;

import com.otrium.assessment.view.launcher.AuthActivity;
import com.otrium.assessment.view.launcher.AuthActivityModule;
import com.otrium.assessment.view.launcher.AuthFragmentBuilder;
import com.otrium.assessment.view.main.MainActivity;
import com.otrium.assessment.view.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = {AuthActivityModule.class,
            AuthFragmentBuilder.class })
    abstract AuthActivity bindLauncherActivity();

    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity bindMainActivity();
}
