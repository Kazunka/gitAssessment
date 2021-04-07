package com.otrium.assessment.view.launcher;

import android.content.Context;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.otrium.assessment.R;
import com.otrium.assessment.event.PopupMessageEvent;
import com.otrium.assessment.event.UIEvent;
import com.otrium.assessment.utils.RxBus;
import com.otrium.assessment.view.base.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

class AuthPresenter extends BasePresenter<AuthView> {

    private final RxBus bus;
    private final Context mContext;
    private final CompositeDisposable disposable = new CompositeDisposable();

    public AuthPresenter(RxBus bus, Context context) {
        this.bus = bus;
        this.mContext = context;
    }


    @Override
    protected void onViewAttached(AuthView view) {
        super.onViewAttached(view);
        disposable.clear();
        disposable.add(bus.obtain()
                .subscribe(event -> {
                    if (isViewAttached()) {
                        if (event instanceof PopupMessageEvent) {
                            String message = ((PopupMessageEvent) event).getMessageText();
                            int messageId  = ((PopupMessageEvent)event).getmMessageIdId();
                            int alertColor = ((PopupMessageEvent)event).getMessageColor();
                            int duration   = ((PopupMessageEvent)event).getDuration();
                            getView().showSnackBar(TextUtils.isEmpty(message)?
                                            mContext.getResources().getString(messageId):message,
                                    alertColor, null, null, duration);
                        }

                        // Receives UI events to switch between fragments
                        // Perform User interactions
                        else if (event instanceof UIEvent) {
                            final UIEvent ev = (UIEvent) event;
                            uiEventsHandler(ev);
                        }
                    }
                })
        );
    }

    /**
     * The UI events handler. Receives events like onClick from the Auth Views.
     *
     * @param event The event object to handle.
     */
    private void uiEventsHandler(@NonNull UIEvent event) {
        // Login Navigation events and Other touch events
        // Used Switch rather than if, By predicting the number of events
        switch (event.id) {

            // Shows Home Screen
            case R.id. action_show_landing_screen:
                getView().navigateToLandingScreen();
                break;

            case R.id.action_splashFragment_to_authFragment:
                getView().navigateFragment(event.id);
                break;
        }
    }
}
