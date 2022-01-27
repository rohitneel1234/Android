package com.rohitneel.roomdbloginregistration.database.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.rohitneel.roomdbloginregistration.database.LoginDatabase;
import com.rohitneel.roomdbloginregistration.database.model.LoginModel;
import com.rohitneel.roomdbloginregistration.database.dao.Dao;

import java.util.List;

public class LoginRepository {

    private Dao loginDao;
    private LiveData<List<LoginModel>> allData;

    public LoginRepository(Application application) {

        LoginDatabase db = LoginDatabase.getDatabase(application);
        loginDao = db.Dao();
        allData = loginDao.getDetails();

    }

    public void deleteData() {
        loginDao.deleteAllData();
    }

    public LiveData<List<LoginModel>> getAllData() {
        return allData;
    }

    public void insertData(LoginModel data) {
        new LoginInsertion(loginDao).execute(data);
    }

    private static class LoginInsertion extends AsyncTask<LoginModel, Void, Void> {

        private Dao loginDao;

        private LoginInsertion(Dao loginDao) {

            this.loginDao = loginDao;

        }

        @Override
        protected Void doInBackground(LoginModel... data) {

            loginDao.deleteAllData();
            loginDao.insertDetails(data[0]);
            return null;

        }

    }

}
