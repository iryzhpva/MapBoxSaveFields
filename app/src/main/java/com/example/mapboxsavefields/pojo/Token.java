package com.example.mapboxsavefields.pojo;

import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("access")
    private String accessToken;
    @SerializedName("refresh")
    private String refreshToken;
    private int deathDay;
    private String phoneNumber;

    public Token(String accessToken, String refreshToken, int expireDate) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.deathDay = expireDate;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public int getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(int deathDay) {
        this.deathDay = deathDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
