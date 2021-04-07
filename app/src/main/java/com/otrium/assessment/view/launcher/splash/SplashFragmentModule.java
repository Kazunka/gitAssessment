package com.otrium.assessment.view.launcher.splash;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.otrium.assessment.di.scope.AuthScope;
import com.otrium.assessment.utils.RxBus;

import dagger.Module;
import dagger.Provides;

@Module
@AuthScope
public class SplashFragmentModule {

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        private final RxBus bus;
        private final Context context;

        Factory(RxBus bus, Context context) {
            this.bus = bus;
            this.context = context;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass ) {
            return (T) new SplashFragmentPresenter(bus, context);
        }
    }

    @Provides
    SplashFragmentView provideView(SplashFragment fragment ) {
        return fragment;
    }

    @Provides
    SplashFragmentPresenter providePresenter(SplashFragment fragment, RxBus bus, Application context) {
        return new ViewModelProvider(fragment, new Factory(bus , context)).get(SplashFragmentPresenter.class);
    }
}
