package com.taptm.shurikus.stockandnews.data.source;

import android.support.annotation.NonNull;

import com.taptm.shurikus.stockandnews.data.News;
import com.taptm.shurikus.stockandnews.data.post.ContentPost;
import com.taptm.shurikus.stockandnews.data.post.TokenPost;
import com.taptm.shurikus.stockandnews.data.source.remote.api.Token;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NewsRepository implements NewsDataSource {

    private final NewsDataSource mNewsRemoteDataSource;

    private final NewsDataSource mNewsLocalDataSource;

    @Inject
    public NewsRepository(@Remote NewsDataSource mNewsRemoteDataSource,
                          @Local NewsDataSource mNewsLocalDataSource) {
        this.mNewsRemoteDataSource = mNewsRemoteDataSource;
        this.mNewsLocalDataSource = mNewsLocalDataSource;
    }

    @Override
    public void getToken(@NonNull TokenPost tokenPost, @NonNull final LoadTokenCallback callback) {
        mNewsRemoteDataSource.getToken(tokenPost, new LoadTokenCallback() {
            @Override
            public void onTokenLoaded(Token token) {
                callback.onTokenLoaded(token);
            }

            @Override
            public void onDataNotAvailable(String msg) {
                callback.onDataNotAvailable(msg);
            }
        });
    }

    @Override
    public String getTokenStr() {
        return mNewsLocalDataSource.getTokenStr();
    }

    @Override
    public void getContentsFromNetwork(@NonNull final ContentPost contentPost, @NonNull final LoadNewsCallback calllback) {

        mNewsRemoteDataSource.getContentsFromNetwork(contentPost, new LoadNewsCallback() {
            @Override
            public void onNewsLoaded(List<News> newsList) {
                //Delete all news from db. Save new data in db and return callback
                mNewsLocalDataSource.deleteAllNewsDetail();
                mNewsLocalDataSource.saveNewsLocal(newsList);
                calllback.onNewsLoaded(newsList);
            }

            @Override
            public void onDataNotAvailable(String msg) {
                calllback.onDataNotAvailable(msg);
            }
        });
    }

    @Override
    public void saveNewsLocal(@NonNull List<News> newses) {
        mNewsLocalDataSource.saveNewsLocal(newses);
    }

    @Override
    public void getNewsLocal(@NonNull LoadNewsCallback callback) {
        mNewsLocalDataSource.getNewsLocal(callback);
    }

    @Override
    public void getNewsItem(@NonNull int newsId, @NonNull GetNewsCallback callback) {
        mNewsLocalDataSource.getNewsItem(newsId, callback);
    }

    @Override
    public void deleteAllNewsDetail() {
        mNewsLocalDataSource.deleteAllNewsDetail();
    }

    @Override
    public void saveTokenStr(String token) {
        mNewsLocalDataSource.saveTokenStr(token);
    }
}
