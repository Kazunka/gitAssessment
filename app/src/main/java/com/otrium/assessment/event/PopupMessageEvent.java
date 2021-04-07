package com.otrium.assessment.event;

/*
 * Snack message event.
 * Created by Kasunka Gallage on 2021-04-07,
 */

import android.view.View;

public class PopupMessageEvent {

    // Text Message, As Int Id or a String Message
    private String mMessageText;
    private int mMessageId;
    private int mMessageColor;
    private int duration;

    private int mMessageAction;
    private View.OnClickListener listener;

    /**
     * PopUp Message with String Message, Used to show the network errors and messages
     * @param msg
     * @param color
     * @param duration
     */
    public PopupMessageEvent(String msg, int color, int duration) {
        this.mMessageText = msg;
        this.mMessageColor = color;
        this.duration = duration;
    }

    /**
     * PopUp Message with Resource ID Message, Used to show the local error messages and validations
     * @param mMessageId
     * @param color
     * @param duration
     */
    public PopupMessageEvent(int mMessageId, int color, int duration) {
        this.mMessageId = mMessageId;
        this.mMessageColor = color;
        this.duration = duration;
    }

    /**
     * PopUp Message with the action event
     * @param mMessageId
     * @param mMessageAction
     * @param color
     * @param duration
     * @param listener
     */
    public PopupMessageEvent(int mMessageId, int mMessageAction, int color, int duration, View.OnClickListener listener) {
        this.mMessageId = mMessageId;
        this.mMessageAction = mMessageAction;
        this.listener = listener;
        this.mMessageColor = color;
        this.duration = duration;
    }

    public String getMessageText() {
        return mMessageText;
    }

    public int getmMessageIdId() {
        return mMessageId;
    }

    public int getmMessageAction() {
        return mMessageAction;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public int getMessageColor() {
        return mMessageColor;
    }

    public int getDuration() {
        return duration;
    }
}
