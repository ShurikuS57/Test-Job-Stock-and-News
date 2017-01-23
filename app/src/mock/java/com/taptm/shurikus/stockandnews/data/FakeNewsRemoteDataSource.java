package com.taptm.shurikus.stockandnews.data;

import android.support.annotation.NonNull;

import com.taptm.shurikus.stockandnews.data.post.ContentPost;
import com.taptm.shurikus.stockandnews.data.post.TokenPost;
import com.taptm.shurikus.stockandnews.data.source.NewsDataSource;
import com.taptm.shurikus.stockandnews.utils.ConverterHelper;

import java.util.List;

public class FakeNewsRemoteDataSource implements NewsDataSource {
    @Override
    public void getToken(@NonNull TokenPost tokenPost, @NonNull LoadTokenCallback callback) {
        callback.onTokenLoaded(FakeData.getFakeToken());
    }

    @Override
    public String getTokenStr() {
        return "";
    }

    @Override
    public void getContentsFromNetwork(@NonNull ContentPost contentPost, @NonNull LoadNewsCallback calllback) {
        calllback.onNewsLoaded(ConverterHelper
                .convertContextToNews(FakeData
                        .getFakeContentList()));
    }

    @Override
    public void saveNewsLocal(@NonNull List<News> newses) {

    }

    @Override
    public void getNewsLocal(@NonNull LoadNewsCallback callback) {

    }

    @Override
    public void getNewsItem(@NonNull int newsId, @NonNull GetNewsCallback callback) {

    }

    @Override
    public void deleteAllNewsDetail() {

    }

    @Override
    public void saveTokenStr(String token) {

    }
}
