package com.otrium.assessment.view.base;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerFragment;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

public class BaseFragment <V,P extends BasePresenter<V>> extends DaggerFragment {

    @Inject
    Lazy<P> lazyPresenter;

    @Override
    public void onResume() {
        super.onResume();
        lazyPresenter.get().onViewAttached( (V) this );
    }

    @Override
    public void onPause() {
        lazyPresenter.get().onViewDetached();
        super.onPause();
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
                    // TODO : Add relevant Activity
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

    protected void hideSoftKeyBoard(){
        // TODO: Get activity and Hide KeyBoard
    }
}
