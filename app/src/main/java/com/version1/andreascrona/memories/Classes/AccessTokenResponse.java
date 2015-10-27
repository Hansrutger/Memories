package com.version1.andreascrona.memories.Classes;

/**
 * Created by AndreasCrona on 2015-10-27.
 */
public class AccessTokenResponse {

    String access_token, token_type;
    int expires_in;

    public AccessTokenResponse(String _token, String _type, int _expires){
        this.access_token = _token;
        this.token_type = _type;
        this.expires_in = _expires;
    }
}
