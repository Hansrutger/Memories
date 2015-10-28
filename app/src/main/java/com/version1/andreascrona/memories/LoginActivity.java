package com.version1.andreascrona.memories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.version1.andreascrona.memories.Classes.AccessTokenRequest;

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
        if (username.getText().toString() != null || password.getText().toString() != null){
            AccessTokenRequest reqToken = new AccessTokenRequest(username.getText().toString(), password.getText().toString());


        }
        else{
            //visa att username och password edittext inte har någon text!
        }
    }

    public void registerClick(View v){
        Intent newIntent = new Intent(this, RegisterActivity.class);
        startActivity(newIntent);
    }
}
