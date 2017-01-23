package com.taptm.shurikus.stockandnews.data.source.remote;

import android.support.annotation.NonNull;

import com.taptm.shurikus.stockandnews.data.News;
import com.taptm.shurikus.stockandnews.data.post.ContentPost;
import com.taptm.shurikus.stockandnews.data.post.TokenPost;
import com.taptm.shurikus.stockandnews.data.source.NewsDataSource;
import com.taptm.shurikus.stockandnews.data.source.remote.api.Content;
import com.taptm.shurikus.stockandnews.data.source.remote.api.ContentMsg;
import com.taptm.shurikus.stockandnews.data.source.remote.api.RestClient;
import com.taptm.shurikus.stockandnews.data.source.remote.api.Token;
import com.taptm.shurikus.stockandnews.data.source.remote.api.TokenMsg;
import com.taptm.shurikus.stockandnews.utils.ConverterHelper;

import java.util.List;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class NewsRemoteDataSource implements NewsDataSource {

    private static final int RESULT_OK = 0;

    @Override
    public void getToken(@NonNull TokenPost tokenPost, @NonNull final LoadTokenCallback callback) {
        RestClient restClient = new RestClient();

        final Call<TokenMsg> call = restClient.getToken(tokenPost);
        call.enqueue(new Callback<TokenMsg>() {
            @Override
            public void onResponse(Call<TokenMsg> call, Response<TokenMsg> response) {
                TokenMsg tokenMsg = response.body();
                int status = tokenMsg.getStatus();
                if(status == RESULT_OK){
                    Token token = response.body().getToken();
                    callback.onTokenLoaded(token);
                }else {
                    callback.onDataNotAvailable(response.body().getMessage().toString());
                }

            }

            @Override
            public void onFailure(Call<TokenMsg> call, Throwable t) {
                callback.onDataNotAvailable(t.getMessage());
            }
        });
    }

    @Override
    public String getTokenStr() {
        return null;
    }

    @Override
    public void getContentsFromNetwork(@NonNull ContentPost contentPost, @NonNull final LoadNewsCallback calllback) {
        RestClient restClient = new RestClient();

        final Call<ContentMsg> call = restClient.getContent(contentPost);

        call.enqueue(new Callback<ContentMsg>() {
            @Override
            public void onResponse(Call<ContentMsg> call, Response<ContentMsg> response) {
                ContentMsg contentMsg = response.body();
                int status = contentMsg.getStatus();
                if(status == RESULT_OK){
                    List<Content> contents = contentMsg.getData().getContent();
                    if(contents != null && contents.size()>0){
                        calllback.onNewsLoaded(ConverterHelper.convertContextToNews(contents));
                    }else {
                        calllback.onDataNotAvailable("No data from server.");
                    }
                }else {
                    calllback.onDataNotAvailable("Status error: "+status);
                }
            }

            @Override
            public void onFailure(Call<ContentMsg> call, Throwable t) {
                calllback.onDataNotAvailable(t.getMessage());
            }
        });
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
