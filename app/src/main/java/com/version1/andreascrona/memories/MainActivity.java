package com.version1.andreascrona.memories;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(false)
            setContentView(R.layout.activity_main);
        else
            setContentView(R.layout.activity_login);
    }

}
