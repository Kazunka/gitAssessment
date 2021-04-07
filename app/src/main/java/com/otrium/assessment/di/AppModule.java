package com.otrium.assessment.di;

import com.otrium.assessment.utils.AppSchedulerProvider;
import com.otrium.assessment.utils.RxBus;
import com.otrium.assessment.utils.SchedulerProvider;
import com.otrium.assessment.utils.modules.ProfileManagerModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

@Module
public class AppModule {

    /**
     * Provides Event Bus
     * @return {@link RxBus}
     */
    @Provides
    @Singleton
    RxBus provideBus() {
        return new RxBus();
    }


    @Provides
    @Singleton
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    ProfileManagerModule provideProfileManager() {
        return new ProfileManagerModule();
    }
}
