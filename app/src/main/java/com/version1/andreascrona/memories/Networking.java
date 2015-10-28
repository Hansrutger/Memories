package com.version1.andreascrona.memories;

import android.os.AsyncTask;

import com.version1.andreascrona.memories.Classes.account;
import com.version1.andreascrona.memories.Classes.*;

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
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AndreasCrona on 2015-10-27.
 */
public class Networking extends AsyncTask{
    @Override
    protected Object doInBackground(Object[] params) {
        switch((String)params[1]){
            case "register":
                account newAccount = (account) params[0];
                registerAccount(newAccount);
                break;
            case "login":
                AccessTokenRequest reqToken = (AccessTokenRequest) params[0];
                logginAccount(reqToken);
                break;
            default:
                //logga fel
        }
        return null;
    }

    private void registerAccount(account newAccount){
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try{
            URL url = new URL("http://mymemories-prod.elasticbeanstalk.com/api/v1/account/Register");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

            JSONObject data = new JSONObject();
            try {
                data.put("username", newAccount.username);
                data.put("email", newAccount.email);
                data.put("password", newAccount.password);
            } catch (JSONException e) {
                e.printStackTrace();
            }


            writer.write(data.toString());
            writer.close();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();

            String line = "";
            while((line = reader.readLine()) != null){
                buffer.append(line);
            }
            System.out.println(buffer);

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

    private void logginAccount(AccessTokenRequest reqToken){
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try{
            URL url = new URL("http://mymemories-prod.elasticbeanstalk.com/token");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

            writer.write("grant_type=password&username="+reqToken.username+"&password="+reqToken.password);
            writer.close();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();

            String line = "";
            while((line = reader.readLine()) != null){
                buffer.append(line);
            }
            System.out.println(buffer);

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
}




