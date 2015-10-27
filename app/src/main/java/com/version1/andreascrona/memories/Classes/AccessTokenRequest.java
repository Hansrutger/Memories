package com.version1.andreascrona.memories.Classes;

/**
 * Created by AndreasCrona on 2015-10-27.
 */
public class AccessTokenRequest {

    String grant_type, username, password;

    public AccessTokenRequest(String _username, String _password){
        this.grant_type = "password";
        this.username = _username;
        this.password = _password;
    }
}
