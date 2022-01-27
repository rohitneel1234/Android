package com.rohitneel.mvvmloginregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.TextUtils;

import com.rohitneel.mvvmloginregistration.databinding.ActivityMainBinding;
import com.rohitneel.mvvmloginregistration.model.LoginUserModel;
import com.rohitneel.mvvmloginregistration.viewmodel.LoginViewModel;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setLifecycleOwner(this);
        activityMainBinding.setLoginViewModel(loginViewModel);

        loginViewModel.getUser().observe(this, new Observer<LoginUserModel>() {
            @Override
            public void onChanged(LoginUserModel loginUserModel) {

                if (TextUtils.isEmpty(Objects.requireNonNull(loginUserModel).getUserEmail())) {
                    activityMainBinding.txtEmailAddress.setError("Enter an E-Mail Address");
                    activityMainBinding.txtEmailAddress.requestFocus();
                }
                else if (!loginUserModel.isEmailValid()) {
                    activityMainBinding.txtEmailAddress.setError("Enter a Valid E-mail Address");
                    activityMainBinding.txtEmailAddress.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(loginUserModel).getUserPass())) {
                    activityMainBinding.txtPassword.setError("Enter a Password");
                    activityMainBinding.txtPassword.requestFocus();
                }
                else if (!loginUserModel.isPasswordLengthGreaterThan5()) {
                    activityMainBinding.txtPassword.setError("Enter at least 6 Digit password");
                    activityMainBinding.txtPassword.requestFocus();
                }
                else {
                    activityMainBinding.lblEmailAnswer.setText(loginUserModel.getUserEmail());
                    activityMainBinding.lblPasswordAnswer.setText(loginUserModel.getUserPass());
                }

            }
        });

    }
}