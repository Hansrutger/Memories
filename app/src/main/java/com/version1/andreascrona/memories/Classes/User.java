package com.version1.andreascrona.memories.Classes;

/**
 * Created by AndreasCrona on 2015-10-27.
 */
public class User {
    int id;
    String firstName, lastName, username, email;

    public User(int _id, String _username, String _email){
        this.id = _id;
        this.username = _username;
        this.email = _email;
        this.firstName = "";
        this.lastName = "";
    }
}
