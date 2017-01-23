package com.taptm.shurikus.stockandnews.data.source.remote.api;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContentMsg {

    @SerializedName("data")
    @Expose
    private ContentList data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status")
    @Expose
    private Integer status;

    public ContentList getData() {
        return data;
    }

    public void setData(ContentList data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
