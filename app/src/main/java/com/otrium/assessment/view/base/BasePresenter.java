package com.otrium.assessment.view.base;

import androidx.annotation.CallSuper;
import androidx.lifecycle.ViewModel;

/*
 * Declares a contract of persistent (during the activity life) presenter with non-persistent view.
 * Created by Kasunka Gallage on 2021-04-07,
 */

public class BasePresenter <V> extends ViewModel {

    /**
     * @interface {ViewModel} Object
     */
    private V view;


    /**
     * Get the attached view to the ViewModel.
     * @return attached View Object
     */
    protected V getView() {
        return view;
    }

    /**
     * Check the View is Attached to the ViewModel Class
     * @return true if model is attached.
     */
    protected boolean isViewAttached() {
        return view != null;
    }

    /**
     * Overriding method of the child class will call the super class method
     * @param view ViewModel Object
     */
    @CallSuper
    protected void onViewAttached( V view ) {
        this.view = view;
    }

    /**
     * Overriding method of the child class will call the super class method
     * Clear attached ViewModel Object
     */
    @CallSuper
    protected void onViewDetached() {
        this.view = null;
    }
}
