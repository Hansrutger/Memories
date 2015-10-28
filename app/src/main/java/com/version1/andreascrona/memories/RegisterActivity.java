package com.version1.andreascrona.memories;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.version1.andreascrona.memories.Classes.account;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends ActionBarActivity {

    EditText _username, _email, _password, _repassword;
    Boolean registerOK = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        _username = (EditText)findViewById(R.id.usernameTxt);
        _email = (EditText)findViewById(R.id.emailTxt);
        _password = (EditText)findViewById(R.id.passwordTxt);
        _repassword = (EditText)findViewById(R.id.repasswordTxt);
    }

    public void registerOnclick(View v){
        if(_password.getText().toString().equals(_repassword.getText().toString())){
            if(_username.getText().toString().length() == 0 || _email.getText().toString().length() == 0 || _password.getText().toString().length() == 0){
                final AlertDialog passwordAlert = new AlertDialog.Builder(this).create();
                passwordAlert.setTitle("Ooops");
                passwordAlert.setMessage("Fill all fields");
                passwordAlert.setButton(DialogInterface.BUTTON_POSITIVE,
                        "OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                passwordAlert.dismiss();
                            }
                        });
                passwordAlert.show();
            }
            else{
                Button button = (Button) v;
                ((Button)v).setText("createAccount");
                account newAccount = new account(_username.getText().toString(), _email.getText().toString(), _password.getText().toString());
                creatAccount(newAccount);
            }
        }
        else{
            final AlertDialog passwordAlert = new AlertDialog.Builder(this).create();
            passwordAlert.setTitle("Ooops");
            passwordAlert.setMessage("Matching passwords plz");
            passwordAlert.setButton(DialogInterface.BUTTON_POSITIVE,
                    "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            passwordAlert.dismiss();
                        }
                    });
            passwordAlert.show();
        }
    }

    public void creatAccount(account newAccount){
        Networking n = new Networking();
        n.execute(newAccount, "register");
    }

}


