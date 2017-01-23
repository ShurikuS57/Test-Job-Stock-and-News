package com.taptm.shurikus.stockandnews.data.post;


public abstract class PostAbstract {

    private String app_key;

    private String package_name;

    private String app_version;

    private String latitude;

    private String longitude;

    private String devicetype;

    private String deviceversion;

    private String devicemodel;

    private String screenwidth;

    private String screenheight;

    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public String getDeviceversion() {
        return deviceversion;
    }

    public void setDeviceversion(String deviceversion) {
        this.deviceversion = deviceversion;
    }

    public String getDevicemodel() {
        return devicemodel;
    }

    public void setDevicemodel(String devicemodel) {
        this.devicemodel = devicemodel;
    }

    public String getScreenwidth() {
        return screenwidth;
    }

    public void setScreenwidth(String screenwidth) {
        this.screenwidth = screenwidth;
    }

    public String getScreenheight() {
        return screenheight;
    }

    public void setScreenheight(String screenheight) {
        this.screenheight = screenheight;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }
}
