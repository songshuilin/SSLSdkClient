package com.sslsdk.platform.domain;

/**
 * author 游戏人日常
 * 用户bean
 */

public class User {

    private String userName;
    private String userId;
    private String client;
    private String tokenTime;
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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(String tokenTime) {
        this.tokenTime = tokenTime;
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
                ", client='" + client + '\'' +
                ", tokenTime='" + tokenTime + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
