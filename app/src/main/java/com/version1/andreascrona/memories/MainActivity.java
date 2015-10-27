package com.version1.andreascrona.memories;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {

    UserLocalStore localStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        localStore = new UserLocalStore(this);

        if(localStore.getUserLoggedIn()){
            setContentView(R.layout.activity_main);
        }
        else{
            Intent newIntent = new Intent(this, LoginActivity.class);
            startActivity(newIntent);
        }
    }
}
