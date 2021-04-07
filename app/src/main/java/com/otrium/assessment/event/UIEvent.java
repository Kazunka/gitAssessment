package com.otrium.assessment.event;

/*
 * A UI event DTO object contains the info about touch event like onClick, onLongClick etc.
 * Created by Kasunka Gallage on 2021-04-07,
 */

public class UIEvent<T> {

    public final int id;
    public final T extra;

    public UIEvent(int id ) {
        this.id = id;
        this.extra = null;
    }

    public UIEvent(int id, T extra ) {
        this.id = id;
        this.extra = extra;
    }
}
