package com.version1.andreascrona.memories;

import android.content.Context;
import android.content.SharedPreferences;

import com.version1.andreascrona.memories.Classes.User;

/**
 * Created by AndreasCrona on 2015-10-27.
 */
public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putInt("id", user.id);
        spEditor.putString("username", user.username);
        spEditor.putString("email", user.email);
        spEditor.putString("firstName", user.firstName);
        spEditor.putString("lastName", user.lastName);
        spEditor.apply();
    }

    public User getLoggedInUser(){
        String username = userLocalDatabase.getString("username", "");
        String firstName = userLocalDatabase.getString("firstName","");
        String lastName = userLocalDatabase.getString("lastName","");
        String email = userLocalDatabase.getString("email","");
        int id = userLocalDatabase.getInt("id", -1);

        User storedUser = new User(id, username, email, firstName, lastName);

        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.apply();
    }

    public boolean getUserLoggedIn(){
        if(userLocalDatabase.getBoolean("loggedIn", false) == true){
            return true;
        }
        else{
            return false;
        }
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
    }
}
