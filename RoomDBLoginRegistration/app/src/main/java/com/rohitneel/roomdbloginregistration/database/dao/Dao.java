package com.rohitneel.roomdbloginregistration.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;


import com.rohitneel.roomdbloginregistration.database.model.LoginModel;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insertDetails(LoginModel data);

    @Query("select * from login_table")
    LiveData<List<LoginModel>> getDetails();

    @Query("delete from login_table")
    void deleteAllData();
}
