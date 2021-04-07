package com.otrium.assessment.view.launcher;

import android.view.View;

import androidx.annotation.NonNull;

import com.otrium.assessment.utils.ColorUtils;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

interface AuthView {

    /**
     * Init Navigation
     * @param navigation
     */
    void navigateFragment(int navigation);

    /**
     * Shows snackbar message.
     * @param msg Message
     * @param alertColor
     * @param action
     * @param listener
     * @param duration
     */
    void showSnackBar(@NonNull String msg, @ColorUtils.AlertColor int alertColor, String action, View.OnClickListener listener, int duration);

    /**
     * Navigate to Landing Screen
     */
    void navigateToLandingScreen();
}
