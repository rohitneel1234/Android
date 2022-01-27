package com.rohitneel.roomdbloginregistration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.rohitneel.roomdbloginregistration.database.model.LoginModel;
import com.rohitneel.roomdbloginregistration.databinding.ActivityMainBinding;
import com.rohitneel.roomdbloginregistration.databinding.Listener;
import com.rohitneel.roomdbloginregistration.viewmodel.LoginViewModel;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements Listener {

    private LoginViewModel loginViewModel;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        activityMainBinding.setClickListener((MainActivity) this);

        loginViewModel = ViewModelProviders.of(MainActivity.this).get(LoginViewModel.class);

        loginViewModel.getGetAllData().observe(this, new Observer<List<LoginModel>>() {
            @Override
            public void onChanged(@Nullable List<LoginModel> data) {
                try {
                    activityMainBinding.lblEmailAnswer.setText((Objects.requireNonNull(data).get(0).getUserEmail()));
                    activityMainBinding.lblPasswordAnswer.setText((Objects.requireNonNull(data.get(0).getUserPass())));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void onClick(View view) {
        String strEmail = activityMainBinding.txtEmailAddress.getText().toString().trim();
        String strPassword = activityMainBinding.txtPassword.getText().toString().trim();

        LoginModel data = new LoginModel();

        if (TextUtils.isEmpty(strEmail)) {
            activityMainBinding.txtEmailAddress.setError("Please Enter Your E-mail Address");
        }
        else if (TextUtils.isEmpty(strPassword)) {
            activityMainBinding.txtPassword.setError("Please Enter Your Password");
        }
        else {

            data.setUserEmail(strEmail);
            data.setUserPass(strPassword);
            loginViewModel.insert(data);

        }

    }
}
