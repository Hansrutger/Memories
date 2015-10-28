package com.version1.andreascrona.memories;

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
        if (username.getText().toString() != null || password.getText().toString() != null){
            AccessTokenRequest reqToken = new AccessTokenRequest(username.getText().toString(), password.getText().toString());
            //Networking n = new Networking();
            //n.execute(reqToken, "login");

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try{
                URL url = new URL("http://mymemories-prod.elasticbeanstalk.com/token");
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                connection.setRequestProperty("grant_type", reqToken.grant_type);
                connection.setRequestProperty("username", reqToken.username);
                connection.setRequestProperty("password", reqToken.password);

                connection.setUseCaches(false);
                connection.setDoInput(true);
                connection.setDoOutput(true);

                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                wr.flush();
                wr.close();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();

                String line = "";
                while((line = reader.readLine()) != null){
                    buffer.append(line);
                }

            }
            catch (MalformedURLException e ){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            finally {
                if (connection != null){
                    connection.disconnect();
                }
                try{
                    reader.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        else{
            Context con = getApplicationContext();
            CharSequence text = "You have to fill in the textfields!";
            int duration = Toast.LENGTH_SHORT;

            Toast toastMsg = Toast.makeText(con, text, duration);
            toastMsg.show();
        }
    }

    public void registerClick(View v){
        Intent newIntent = new Intent(this, RegisterActivity.class);
        startActivity(newIntent);
    }
}
