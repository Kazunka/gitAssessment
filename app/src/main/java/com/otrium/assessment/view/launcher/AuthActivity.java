package com.otrium.assessment.view.launcher;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;
import com.otrium.assessment.R;
import com.otrium.assessment.view.base.BaseActivity;
import com.otrium.assessment.view.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * Created by Kasunka Gallage on 2021-04-06,
 */

public class AuthActivity extends BaseActivity<AuthView, AuthPresenter> implements AuthView{

    @BindView(R.id.root_launcher)
    CoordinatorLayout rootView;

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);
        setUpView();
    }

    /**
     * Set Up UI Functions
     */
    private void setUpView() {
        setupUI(rootView); // Default Common UI Functions
        navController = Navigation.findNavController(this, R.id.nav_host_root_fragment);
    }

    @Override
    public void navigateFragment(int navigation) {
        navController.navigate(navigation, null,
                new NavOptions.Builder()
                        .setEnterAnim(android.R.animator.fade_in)
                        .setExitAnim(android.R.animator.fade_out)
                        .build()
        );
    }

    @Override
    public void showSnackBar(@NonNull String msg, int alertColor, String action, View.OnClickListener listener, int duration) {
        final Snackbar snackbar = Snackbar.make(rootView, msg, duration);
        snackbar.setAction(action, listener);

        final View snackBarview = snackbar.getView();

        //set te action button text color
        snackbar.setActionTextColor(getResources().getColor(R.color.snack_bar_text));
        //Get the view of the snackbar
        snackBarview.setBackgroundColor(getResources().getColor(alertColor));
        snackbar.show();
    }

    @Override
    public void navigateToLandingScreen() {
        navigateToActivity(MainActivity.class);
    }
}
