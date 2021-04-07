package com.otrium.assessment.view.launcher.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import com.otrium.assessment.R;
import com.otrium.assessment.view.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 * Created by Kasunka Gallage on 2021-04-07,
 */

public class AuthFragment extends BaseFragment<AuthFragmentView, AuthFragmentPresenter> implements AuthFragmentView, View.OnClickListener {

    private static final String TAG = AuthFragment.class.getName();

    private Unbinder unbinder;

    @Inject
    AuthFragmentPresenter authPresenter;

    @BindView(R.id.auth_sign_in)
    Button signInButton;

    @BindView(R.id.edt_username)
    AppCompatEditText userNameTxt;
    @BindView(R.id.edt_password)
    AppCompatEditText passwordTxt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_auth, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUI(view);
        initActions();
    }

    private void initActions() {
        signInButton.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.auth_sign_in){
            authPresenter.validateInputs(getUserName(), getPassword());
        }
    }

    private String getUserName() {
        return userNameTxt.getText().toString();
    }

    private String getPassword() {
        return passwordTxt.getText().toString();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
