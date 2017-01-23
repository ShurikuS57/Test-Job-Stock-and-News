package com.taptm.shurikus.stockandnews.data.source.remote.api;

import com.taptm.shurikus.stockandnews.data.post.ContentPost;
import com.taptm.shurikus.stockandnews.data.post.TokenPost;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class RestClient {

    private static final String url = "http://service-retailmob.rhcloud.com";

    private static Api mApi;

    private interface Api{

        @POST("/api/v1/mobclient/register")
        Call<TokenMsg> getToken(@Body TokenPost post);

        @POST("/api/v1/mobclient/getcontent")
        Call<ContentMsg> getContent(@Body ContentPost post);
    }

    static {
        setupRestClient();
    }

    private static void setupRestClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApi = retrofit.create(Api.class);
    }

    public Call<TokenMsg> getToken(TokenPost post){
        return mApi.getToken(post);
    }

    public Call<ContentMsg> getContent(ContentPost post){
        return mApi.getContent(post);
    }


}
