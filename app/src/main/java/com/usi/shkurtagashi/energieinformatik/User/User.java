package com.usi.shkurtagashi.energieinformatik.User;

/**
 * Created by shkurtagashi on 17.01.17.
 */

public class User {

    public String _android_id;
    public String _username;
    public String _empaticaID;
    public String _emailAdress;
    public String _gender;
    public String _age;
    public String _status;

    public User(){}

    public User(String android_id, String username, String empaticaID, String email, String gender, String age, String status){
        setAndroidId(android_id);
        setUsername(username);
        setEmpaticaID(empaticaID);
        setEmail(email);
        setGender(gender);
        setAge(age);
        setStatus(status);
    }

    public User(String username, String empaticaID, String email, String gender, String age, String status){
        setUsername(username);
        setEmpaticaID(empaticaID);
        setEmail(email);
        setGender(gender);
        setAge(age);
        setStatus(status);
    }



    public void setAndroidId(String id) {
        this._android_id = id;
    }

    public String getAndroidId(){
        return this._android_id;
    }

    public void setGender(String gender) {
        this._gender = gender;
    }

    public String getGender(){
        return this._gender;
    }

    public void setAge(String age) {
        this._age = age;
    }

    public String getAge(){
        return this._age;
    }

    public void setStatus(String status) {
        this._status = status;
    }

    public String getStatus() {
        return this._status;
    }

    public void setUsername(String username) {
        this._username = username;
    }

    public String getUsername(){
        return this._username;
    }

    public void setEmpaticaID(String empaticaID) {
        this._empaticaID = empaticaID;
    }

    public String getEmpaticaID(){
        return this._empaticaID;
    }

    public void setEmail(String email) {
        this._emailAdress = email;
    }

    public String getEmail(){
        return this._emailAdress;
    }


}
