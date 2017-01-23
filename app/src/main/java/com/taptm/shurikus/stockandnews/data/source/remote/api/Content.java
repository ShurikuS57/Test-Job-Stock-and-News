package com.taptm.shurikus.stockandnews.data.source.remote.api;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("short_text")
    @Expose
    private String shortText;
    @SerializedName("full_text")
    @Expose
    private String fullText;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("img_preview_url")
    @Expose
    private String imgPreviewUrl;
    @SerializedName("img_banner_url")
    @Expose
    private Object imgBannerUrl;
    @SerializedName("content_type_id")
    @Expose
    private Integer contentTypeId;
    @SerializedName("template")
    @Expose
    private Integer template;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;
    @SerializedName("img_height")
    @Expose
    private Object imgHeight;
    @SerializedName("img_width")
    @Expose
    private Object imgWidth;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("content_status_id")
    @Expose
    private Integer contentStatusId;
    @SerializedName("banner")
    @Expose
    private Integer banner;
    @SerializedName("publish_time")
    @Expose
    private String publishTime;
    @SerializedName("change_datetime")
    @Expose
    private String changeDatetime;
    @SerializedName("start_datetime")
    @Expose
    private String startDatetime;
    @SerializedName("end_datetime")
    @Expose
    private String endDatetime;
    @SerializedName("deleted")
    @Expose
    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgPreviewUrl() {
        return imgPreviewUrl;
    }

    public void setImgPreviewUrl(String imgPreviewUrl) {
        this.imgPreviewUrl = imgPreviewUrl;
    }

    public Object getImgBannerUrl() {
        return imgBannerUrl;
    }

    public void setImgBannerUrl(Object imgBannerUrl) {
        this.imgBannerUrl = imgBannerUrl;
    }

    public Integer getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(Integer contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public Integer getTemplate() {
        return template;
    }

    public void setTemplate(Integer template) {
        this.template = template;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Object getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(Object imgHeight) {
        this.imgHeight = imgHeight;
    }

    public Object getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(Object imgWidth) {
        this.imgWidth = imgWidth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getContentStatusId() {
        return contentStatusId;
    }

    public void setContentStatusId(Integer contentStatusId) {
        this.contentStatusId = contentStatusId;
    }

    public Integer getBanner() {
        return banner;
    }

    public void setBanner(Integer banner) {
        this.banner = banner;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getChangeDatetime() {
        return changeDatetime;
    }

    public void setChangeDatetime(String changeDatetime) {
        this.changeDatetime = changeDatetime;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
