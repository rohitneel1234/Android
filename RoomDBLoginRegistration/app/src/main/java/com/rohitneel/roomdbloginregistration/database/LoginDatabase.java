package com.rohitneel.roomdbloginregistration.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.rohitneel.roomdbloginregistration.database.dao.Dao;
import com.rohitneel.roomdbloginregistration.database.model.LoginModel;

@Database(entities = {LoginModel.class}, version = 1, exportSchema = false)
public abstract class LoginDatabase extends RoomDatabase {

    private static LoginDatabase instance;

    // abstract variable for dao.
    public abstract Dao Dao();


    public static LoginDatabase getDatabase(final Context context) {

        if (instance == null) {

            synchronized (LoginDatabase.class) {

                if (instance == null) {

                    instance = Room.databaseBuilder(
                            context, LoginDatabase.class, "LOGIN_DATABASE")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;

    }


}
