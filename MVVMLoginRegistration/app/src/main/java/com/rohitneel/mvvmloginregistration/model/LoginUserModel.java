package com.rohitneel.mvvmloginregistration.model;

import android.util.Patterns;

public class LoginUserModel {

    private String userEmail;
    private String userPass;

    public LoginUserModel(String Email, String Pass){
        userEmail = Email;
        userPass = Pass;
    }

    public String getUserEmail(){
        return userEmail;
    }

    public String getUserPass(){
        return userPass;
    }

    public boolean isEmailValid(){
        return Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches();
    }

    public boolean isPasswordLengthGreaterThan5() {
        return getUserPass().length() > 5;
    }

}
