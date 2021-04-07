package com.otrium.assessment.view.launcher;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.otrium.assessment.utils.RxBus;

import dagger.Module;
import dagger.Provides;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

@Module
public class AuthActivityModule {

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        private final RxBus bus;
        private final Application context;

        public Factory(RxBus bus, Application context) {
            this.bus = bus;
            this.context = context;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass ) {
            return (T) new AuthPresenter(bus , context);
        }
    }

    @Provides
    public static AuthView provideLauncherView(AuthActivity activity ) {
        return activity;
    }

    @Provides
    public static AuthPresenter providePresenter(AuthActivity activity, RxBus bus, Application context) {
        return new ViewModelProvider(activity, new Factory(bus, context)).get(AuthPresenter.class);
    }
}
