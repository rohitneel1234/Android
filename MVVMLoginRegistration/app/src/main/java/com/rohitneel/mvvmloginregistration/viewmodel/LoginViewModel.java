package com.rohitneel.mvvmloginregistration.viewmodel;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rohitneel.mvvmloginregistration.model.LoginUserModel;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> emailMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> passMutableLiveData = new MutableLiveData<>();

    private MutableLiveData<LoginUserModel> loginUserModelMutableLiveData;

    public MutableLiveData<LoginUserModel> getUser(){

        if(loginUserModelMutableLiveData == null){

            loginUserModelMutableLiveData = new MutableLiveData<>();
        }

        return loginUserModelMutableLiveData;
    }

    public void onClick(View view) {
        LoginUserModel loginUserModel = new LoginUserModel(emailMutableLiveData.getValue(), passMutableLiveData.getValue());
        loginUserModelMutableLiveData.setValue(loginUserModel);
    }

}
