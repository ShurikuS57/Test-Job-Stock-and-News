package com.taptm.shurikus.stockandnews.data.post;


public class ContentPost extends PostAbstract {

    private String UID;

    private int last_session_datetime;

    private int content_type_id;

    private int from_id;

    private int max;

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public int getLast_session_datetime() {
        return last_session_datetime;
    }

    public void setLast_session_datetime(int last_session_datetime) {
        this.last_session_datetime = last_session_datetime;
    }

    public int getContent_type_id() {
        return content_type_id;
    }

    public void setContent_type_id(int content_type_id) {
        this.content_type_id = content_type_id;
    }

    public int getFrom_id() {
        return from_id;
    }

    public void setFrom_id(int from_id) {
        this.from_id = from_id;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
