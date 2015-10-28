package com.version1.andreascrona.memories;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import com.version1.andreascrona.memories.Classes.AccessTokenRequest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends ActionBarActivity {

    UserLocalStore localStore;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        localStore = new UserLocalStore(this);

        username = (EditText)findViewById(R.id.usernameTxt);
        password = (EditText)findViewById(R.id.passwordTxt);
    }

    public void loginClick(View v){
        if (username.getText().toString().length() != 0 || password.getText().toString().length() != 0){
            AccessTokenRequest reqToken = new AccessTokenRequest(username.getText().toString(), password.getText().toString());
            Networking n = new Networking();
            n.execute(reqToken, "login");
        }
        else{
            Toast.makeText(this, "Enter username and password", Toast.LENGTH_SHORT).show();
        }
    }

    public void registerClick(View v){
        Intent newIntent = new Intent(this, RegisterActivity.class);
        startActivity(newIntent);
    }
}
