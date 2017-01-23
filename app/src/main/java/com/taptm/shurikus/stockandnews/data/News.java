package com.taptm.shurikus.stockandnews.data;

public class News {

    private int Id;

    private String header;

    private String shortText;

    private String fullText;

    private String imgUrl;

    private String  imgPreviewUrl;

    private int contentTypeId;

    private String publishTime;

    private String link;

    public News() {
    }

    public News(int id, String header, String shortText, String fullText, String imgUrl, String imgPreviewUrl, int contentTypeId, String publishTime, String link) {
        Id = id;
        this.header = header;
        this.shortText = shortText;
        this.fullText = fullText;
        this.imgUrl = imgUrl;
        this.imgPreviewUrl = imgPreviewUrl;
        this.contentTypeId = contentTypeId;
        this.publishTime = publishTime;
        this.link = link;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getImgPreviewUrl() {
        return imgPreviewUrl;
    }

    public void setImgPreviewUrl(String imgPreviewUrl) {
        this.imgPreviewUrl = imgPreviewUrl;
    }

    public int getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(int contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
