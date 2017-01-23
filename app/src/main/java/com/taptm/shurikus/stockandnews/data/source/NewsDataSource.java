package com.taptm.shurikus.stockandnews.data.source;

import android.support.annotation.NonNull;

import com.taptm.shurikus.stockandnews.data.News;
import com.taptm.shurikus.stockandnews.data.post.ContentPost;
import com.taptm.shurikus.stockandnews.data.post.TokenPost;
import com.taptm.shurikus.stockandnews.data.source.remote.api.Token;

import java.util.List;

public interface NewsDataSource {

    interface LoadTokenCallback {

        void onTokenLoaded(Token token);

        void onDataNotAvailable(String msg);
    }

    interface LoadNewsCallback {

        void onNewsLoaded(List<News> newsList);

        void onDataNotAvailable(String msg);

    }

    interface GetNewsCallback {

        void onNewsLoaded(News news);

        void onDataNotAvailable();

    }


    void getToken(@NonNull TokenPost tokenPost, @NonNull LoadTokenCallback callback);

    String getTokenStr();

    void getContentsFromNetwork(@NonNull ContentPost contentPost, @NonNull LoadNewsCallback calllback);

    void saveNewsLocal(@NonNull List<News> newses);

    void getNewsLocal(@NonNull LoadNewsCallback callback);

    void getNewsItem(@NonNull int newsId, @NonNull GetNewsCallback callback);

    void deleteAllNewsDetail();

    void saveTokenStr(String token);
}
