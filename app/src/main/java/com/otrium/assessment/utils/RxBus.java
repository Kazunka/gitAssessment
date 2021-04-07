package com.otrium.assessment.utils;

import com.jakewharton.rxrelay2.PublishRelay;

import io.reactivex.Observable;

/*
 * An RxJava event bus implementation.
 * Created by Kasunka Gallage on 2021-04-07,
 */

public class RxBus {

    private final PublishRelay<Object> relay = PublishRelay.create();

    public void send( Object o ) {
        relay.accept( o );
    }

    public Observable<Object> obtain() {
        return relay;
    }
}
