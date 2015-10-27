package com.version1.andreascrona.memories.Classes;

/**
 * Created by AndreasCrona on 2015-10-27.
 */
public class User {
    public int id;
    public String firstName, lastName, username, email;

    public User(int _id, String _username, String _email, String _firstName, String _lastName){
        this.id = _id;
        this.username = _username;
        this.email = _email;
        this.firstName = _firstName;
        this.lastName = _lastName;
    }

    public User(int _id, String _username, String _email){
        this.id = _id;
        this.username = _username;
        this.email = _email;
        this.firstName = "";
        this.lastName = "";
    }
}
