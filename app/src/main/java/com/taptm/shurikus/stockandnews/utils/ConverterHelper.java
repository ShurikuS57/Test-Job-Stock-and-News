package com.taptm.shurikus.stockandnews.utils;

import android.support.annotation.NonNull;

import com.taptm.shurikus.stockandnews.data.News;
import com.taptm.shurikus.stockandnews.data.source.remote.api.Content;

import java.util.ArrayList;
import java.util.List;

public class ConverterHelper {

    public static List<News> convertContextToNews(@NonNull List<Content> contentList){
        List<News> newsList = new ArrayList<>();

        for (Content contentAPI: contentList){
            News news = new News();
            news.setId(contentAPI.getId());
            news.setContentTypeId(contentAPI.getContentTypeId());
            news.setHeader(contentAPI.getHeader());
            news.setShortText(contentAPI.getShortText());
            news.setFullText(contentAPI.getFullText());
            news.setImgPreviewUrl(contentAPI.getImgPreviewUrl());
            news.setImgUrl(contentAPI.getImgUrl());
            news.setPublishTime(contentAPI.getPublishTime());
            news.setLink(contentAPI.getLink());

            newsList.add(news);
        }

        return newsList;
    }
}
