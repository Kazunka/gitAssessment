package com.otrium.assessment.view.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.otrium.assessment.utils.RxBus;

import java.util.Objects;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

/*
 * Created by Kasunka Gallage on 2021-04-06,
 */

public class BaseActivity <V, P extends BasePresenter<V>> extends DaggerAppCompatActivity {

    @Inject
    Lazy<P> lazyPresenter;

    @Inject
    RxBus bus;

    @Override
    protected void onStart() {
        super.onStart();
        lazyPresenter.get().onViewAttached((V) this);
    }

    @Override
    protected void onStop() {
        lazyPresenter.get().onViewDetached();
        super.onStop();
    }

    /**
     * Navigation Base Method. Navigate Between Activities
     * @param activityClass Destination Activity
     */
    protected void navigateToActivity(Class<?> activityClass) {
        Intent mainIntent = new Intent(getApplicationContext(), activityClass);
        startActivity(mainIntent);
    }

    /**
     * Set Up on Touch Listener for the Non {@link EditText} Components.
     * Hide soft keyboard if request focused the Non Edit Text
     * @param view object of the Parent Layout
     */
    protected void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                @SuppressLint("ClickableViewAccessibility")
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard();
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

    /**
     * Hide soft keyboard Pragmatically.
     */
    protected void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(), 0);
        }
    }
}
