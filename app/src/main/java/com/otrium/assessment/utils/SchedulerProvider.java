package com.otrium.assessment.utils;

import io.reactivex.Scheduler;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler io();

}
