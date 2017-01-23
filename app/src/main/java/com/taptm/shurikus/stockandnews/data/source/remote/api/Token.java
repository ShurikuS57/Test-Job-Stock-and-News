package com.taptm.shurikus.stockandnews.data.source.remote.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Token {

    @SerializedName("UID")
    @Expose
    private String uID;
    @SerializedName("eula")
    @Expose
    private String eula;
    @SerializedName("region")
    @Expose
    private Region region;

    public String getUID() {
        return uID;
    }

    public void setUID(String uID) {
        this.uID = uID;
    }

    public String getEula() {
        return eula;
    }

    public void setEula(String eula) {
        this.eula = eula;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

}
