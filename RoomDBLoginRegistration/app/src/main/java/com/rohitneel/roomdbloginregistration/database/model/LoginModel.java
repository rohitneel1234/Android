package com.rohitneel.roomdbloginregistration.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "login_table")
public class LoginModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;

    @ColumnInfo(name = "Email")
    private String userEmail;

    @ColumnInfo(name = "Password")
    private String userPass;

    public String getUserEmail(){
        return userEmail;
    }

    public void setUserEmail(String email){
         userEmail = email;
    }

    public String getUserPass(){
        return userPass;
    }

    public void setUserPass(String pass){
        userPass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
