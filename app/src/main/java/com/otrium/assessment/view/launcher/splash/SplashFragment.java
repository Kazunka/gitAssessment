package com.otrium.assessment.view.launcher.splash;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Slide;

import com.otrium.assessment.R;
import com.otrium.assessment.view.base.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

public class SplashFragment extends BaseFragment<SplashFragmentView, SplashFragmentPresenter> implements SplashFragmentView {

    private static final String TAG = SplashFragment.class.getName();
    public static final String KEY_SPLASH_TIMER = "SPLASH_TIMER";

    private Unbinder unbinder;

    @Inject
    SplashFragmentPresenter splashPresenter;

    // Incase of Need for init from other activities
    public static SplashFragment newInstance(int timer) {
        SplashFragment fragment = new SplashFragment();
        fragment.setEnterTransition(new Slide(Gravity.RIGHT));
        fragment.setExitTransition(new Slide(Gravity.LEFT));

        Bundle args = new Bundle();
        args.putInt(KEY_SPLASH_TIMER, timer);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_splash, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUI(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        splashPresenter.startTimer(getArguments() != null ? getArguments().getInt(KEY_SPLASH_TIMER) : -1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
