package com.version1.andreascrona.memories;

import android.os.AsyncTask;

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

/**
 * Created by AndreasCrona on 2015-10-27.
 */
public class Networking extends AsyncTask{
    @Override
    protected Object doInBackground(Object[] params) {
        account newAccount = (account) params[0];
        getJSON("http://mymemories-prod.elasticbeanstalk.com/v1/account/Register", newAccount);
        return null;
    }

    private void getJSON(String url, account newAccount){
        HttpClient httpClient = new DefaultHttpClient();
        HttpRequest request = new HttpPost(url);
        List<NameValuePair> postParameters = new ArrayList<NameValuePair>();

        postParameters.add(new BasicNameValuePair("username", newAccount.username));
        postParameters.add(new BasicNameValuePair("email", newAccount.email));
        postParameters.add(new BasicNameValuePair("password", newAccount.password));

        BufferedReader bufferReader = null;
        StringBuffer stringBuffer = new StringBuffer("");

        try{
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postParameters);
            request.setParams((HttpParams) entity);
            HttpResponse response = httpClient.execute((HttpUriRequest) request);
            bufferReader= new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line ="";
            String LineSeperator = System.getProperty("line.seperator");
            while((line = bufferReader.readLine()) != null){
                stringBuffer.append(line + LineSeperator);
            }
            bufferReader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}




