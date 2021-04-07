package com.otrium.assessment.view.launcher.auth;

import android.content.Context;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;
import com.otrium.assessment.R;
import com.otrium.assessment.event.PopupMessageEvent;
import com.otrium.assessment.event.UIEvent;
import com.otrium.assessment.utils.ColorUtils;
import com.otrium.assessment.utils.RxBus;
import com.otrium.assessment.utils.modules.ValidationUtilsModule;
import com.otrium.assessment.view.base.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

class AuthFragmentPresenter extends BasePresenter<AuthFragmentView> {

    private final RxBus bus;
    private final Context context;
    private final CompositeDisposable disposable = new CompositeDisposable();

    public AuthFragmentPresenter(RxBus bus, Context context) {
        this.bus = bus;
        this.context = context;
    }

    @Override
    protected void onViewAttached(AuthFragmentView view) {
        super.onViewAttached(view);

        disposable.add(bus.obtain()
                        .subscribe(event -> {
                            if (isViewAttached()) {
                                // Catch event on network operation
                            }})
        );
    }

    @Override
    protected void onViewDetached() {
        super.onViewDetached();
        disposable.clear();
    }

    /**
     * Validate Locally User Inputs for SignIn
     * @param userName Enterd UserName
     * @param password Password
     */
    public void validateInputs(@Nullable String userName, @Nullable String password) {
        boolean isValid = Boolean.TRUE;
        // Check UserName validity
        if (!isValidUserName(userName)){
            isValid = Boolean.FALSE;
            bus.send(new PopupMessageEvent(R.string.invalid_user_name, ColorUtils.ERROR, Snackbar.LENGTH_LONG));
        }
        // Check Password validity
        else if (!isValidPassword(password)){
            isValid = Boolean.FALSE;
            bus.send(new PopupMessageEvent(R.string.invalid_password, ColorUtils.ERROR, Snackbar.LENGTH_LONG));
        }

        if (isValid) {
            bus.send(new UIEvent(R.id.action_show_progress_view, View.VISIBLE));
            // TODO: Perform network operation
            navigateToLandingScreen();
        }
    }

    /**
     * Finish And Navigate to Home Screen/ Previous Screen
     */
    private void navigateToLandingScreen(){
        bus.send(new UIEvent<Integer>(R.id.action_show_landing_screen));
    }


    /**
     * Vaildate UserName with the Regex
     * @param userName User input String
     * @return True if Valid
     */
    private boolean isValidUserName(String userName) {
        return ValidationUtilsModule.isValidUserName(userName );
    }

    /**
     * Vaildate Password with the Regex
     * @param password User input String
     * @return True if Valid
     */
    private boolean isValidPassword(String password) {
        return ValidationUtilsModule.isValidPassword(password );
    }
}
