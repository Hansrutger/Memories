package com.version1.andreascrona.memories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends ActionBarActivity {

    UserLocalStore localStore;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        localStore = new UserLocalStore(this);
    }

    public void loginClick(View v){
        Button button = (Button) v;
        ((Button)v).setText("clicked");
    }

    public void registerClick(View v){
        Intent newIntent = new Intent(this, RegisterActivity.class);
        startActivity(newIntent);
    }
}
