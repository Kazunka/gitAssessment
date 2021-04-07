package com.otrium.assessment.view.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.otrium.assessment.utils.RxBus;
import com.otrium.assessment.utils.modules.ProfileManagerModule;

import dagger.Module;
import dagger.Provides;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

@Module
public class MainActivityModule {

    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        private final RxBus bus;
        private final Application context;
        private final ProfileManagerModule managerModule;

        public Factory(RxBus bus, ProfileManagerModule managerModule, Application context) {
            this.bus = bus;
            this.context = context;
            this.managerModule = managerModule;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass ) {
            return (T) new MainActivityPresenter(bus , managerModule, context);
        }
    }

    @Provides
    public static MainActivityView provideLauncherView(MainActivity activity ) {
        return activity;
    }

    @Provides
    public static MainActivityPresenter providePresenter(MainActivity activity, RxBus bus, ProfileManagerModule managerModule, Application context) {
        return new ViewModelProvider(activity, new MainActivityModule.Factory(bus, managerModule, context)).get(MainActivityPresenter.class);
    }
}
