package com.sslsdk.platform.domain;

import com.google.gson.annotations.SerializedName;

/**
 * author 游戏人日常
 * 用户bean
 */

public class User {

    @SerializedName("username")
    private String userName;

    @SerializedName("uid")
    private String userId;

    @SerializedName("token")
    private String token;




    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", token='" + token + '\'' +
                '}';
    }


    public  User getUser(){

        return  this;
    }
}
