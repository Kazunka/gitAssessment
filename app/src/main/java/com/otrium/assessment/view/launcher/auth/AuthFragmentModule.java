package com.otrium.assessment.view.launcher.auth;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.otrium.assessment.di.scope.AuthScope;
import com.otrium.assessment.utils.RxBus;

import dagger.Module;
import dagger.Provides;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

@Module
@AuthScope
public class AuthFragmentModule {

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
            return (T) new AuthFragmentPresenter(bus, context);
        }
    }

    @Provides
    AuthFragmentView provideView(AuthFragment fragment ) {
        return fragment;
    }

    @Provides
    AuthFragmentPresenter providePresenter(AuthFragment fragment, RxBus bus, Application context) {
        return new ViewModelProvider(fragment, new AuthFragmentModule.Factory(bus , context)).get(AuthFragmentPresenter.class);
    }
}
