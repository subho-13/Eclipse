package com.reyansh.shop.controller.signin;

public class SigninResponse {
    private boolean success;

    private String token;

    public String getToken() {
        return this.token;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
