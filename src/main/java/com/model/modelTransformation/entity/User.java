package com.model.modelTransformation.entity;

public class User
{
    public String username;
    public String password;
    public String phone;

    public User(){}
    public User(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public String getName(){
        return  username;
    }
    public void setName(String username){
        this.username = username;
    }
    public String getPassword(){
        return  password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone= phone;
    }
}
