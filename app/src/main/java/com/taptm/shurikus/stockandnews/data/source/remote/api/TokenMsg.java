package com.taptm.shurikus.stockandnews.data.source.remote.api;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenMsg {

    @SerializedName("data")
    @Expose
    private Token token;
    @SerializedName("message")
    @Expose
    private Object message;
    @SerializedName("status")
    @Expose
    private Integer status;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
