package com.otrium.assessment.view.launcher.splash;

import android.content.Context;
import android.util.Log;

import com.otrium.assessment.R;
import com.otrium.assessment.event.UIEvent;
import com.otrium.assessment.utils.RxBus;
import com.otrium.assessment.view.base.BasePresenter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.CompositeDisposable;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

class SplashFragmentPresenter extends BasePresenter<SplashFragmentView> {

    private static final String TAG = SplashFragmentPresenter.class.getName();

    private final RxBus bus;
    private final Context context;
    private final CompositeDisposable disposable = new CompositeDisposable();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public SplashFragmentPresenter(RxBus bus, Context context) {
        this.bus = bus;
        this.context = context;
    }

    @Override
    protected void onViewAttached(SplashFragmentView view) {
        super.onViewAttached(view);

        disposable.add(bus.obtain()
                .subscribe(event -> {
                    if (isViewAttached()) {
//                        if (event instanceof AuthPINEvent) {
//                            if (((AuthPINEvent) event).isSuccess()){
//                                navigateToLandingScreen();
//                            }
//                        }
//
//                        else if (event instanceof BiometricAuthEvent){
//                            handleBiometricAuthEvent((BiometricAuthEvent)event);
//                        }
                    }})
        );
    }

    @Override
    protected void onViewDetached() {
        super.onViewDetached();
//        disposable.clear();
    }

    /*
     * New Handler to start the Landing-Activity
     * and close this Splash-Screen after SPLASH_DISPLAY_DURATION seconds.
     */
    public void startTimer(int anInt){
        /* Splash Screen Display Duration in ms */
        int SPLASH_DISPLAY_DURATION = 2000;
        Log.d(TAG, "startTimer: " + anInt);

        if (anInt < 0 ) {
            Runnable postDelayedRun = () -> {
                if (isViewAttached()) {
                    finishAndNavigate();
                    scheduler.shutdown();
                }
            };
            scheduler.schedule(postDelayedRun, SPLASH_DISPLAY_DURATION, TimeUnit.MILLISECONDS);
        } else {
            // TODO: Handle special Senario which need to navigate without any delay
            // Perform Unbound Notification Navigation
        }

    }

    /**
     * Navigate according to user login status. And manage the session if required
     * If new user/Logged out user, will navigate to Auth Fragment.
     */
    private void finishAndNavigate() {
        if (isLoggedIn()) {
            navigateToLandingScreen();
        } else {
            navigateToAuthScreen();
        }
    }

    /**
     * Finish And Navigate to Home Screen/ Previous Screen
     */
    private void navigateToLandingScreen(){
        bus.send(new UIEvent<Integer>(R.id.action_show_landing_screen));
    }

    /**
     * Finish And Navigate to Auth Screen
     */
    private void navigateToAuthScreen(){
        bus.send(new UIEvent<Integer>(R.id.action_splashFragment_to_authFragment));
    }

    /**
     * Check user loggin.
     * @return true if user is already loggedIn.
     */
    private boolean isLoggedIn() {
//        return settings.getBoolean(SettingsHelper.Meta.IS_USER_REGISTERED);
        // TODO: Return Actual Value
        return Boolean.FALSE;
    }
}
