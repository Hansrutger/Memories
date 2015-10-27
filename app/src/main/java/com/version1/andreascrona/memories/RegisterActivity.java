package com.version1.andreascrona.memories;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.version1.andreascrona.memories.Classes.account;

public class RegisterActivity extends ActionBarActivity {

    EditText _username, _email, _password, _repassword;

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
            account newAccount = new account(_username.getText().toString(), _email.getText().toString(), _password.getText().toString());
            creatAccount(newAccount);
        }
        else{
            final AlertDialog passwordAlert = new AlertDialog.Builder(this).create();
            passwordAlert.setTitle("Ooops");
            passwordAlert.setMessage("Password doesnt match eachother");
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
        
    }
}
