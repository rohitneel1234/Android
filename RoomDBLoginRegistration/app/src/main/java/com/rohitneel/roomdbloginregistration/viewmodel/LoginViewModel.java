package com.rohitneel.roomdbloginregistration.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.rohitneel.roomdbloginregistration.database.model.LoginModel;
import com.rohitneel.roomdbloginregistration.database.repository.LoginRepository;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {

    private LoginRepository repository;
    private LiveData<List<LoginModel>> getAllData;

    public LoginViewModel(@NonNull Application application) {
        super(application);

        repository = new LoginRepository(application);
        getAllData = repository.getAllData();

    }

    public void insert(LoginModel data) {
        repository.insertData(data);
    }

    public LiveData<List<LoginModel>> getGetAllData() {
        return getAllData;
    }

}
