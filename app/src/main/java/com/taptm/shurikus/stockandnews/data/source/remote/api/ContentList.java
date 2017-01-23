package com.taptm.shurikus.stockandnews.data.source.remote.api;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContentList {

    @SerializedName("content")
    @Expose
    private List<Content> content = null;
    @SerializedName("hasMore")
    @Expose
    private Boolean hasMore;

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
}
