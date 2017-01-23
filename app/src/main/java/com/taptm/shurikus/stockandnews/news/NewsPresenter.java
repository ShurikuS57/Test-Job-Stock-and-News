package com.taptm.shurikus.stockandnews.news;


import com.taptm.shurikus.stockandnews.R;
import com.taptm.shurikus.stockandnews.data.News;
import com.taptm.shurikus.stockandnews.data.post.ContentPost;
import com.taptm.shurikus.stockandnews.data.post.TokenPost;
import com.taptm.shurikus.stockandnews.data.source.NewsDataSource;
import com.taptm.shurikus.stockandnews.data.source.NewsRepository;
import com.taptm.shurikus.stockandnews.data.source.remote.api.Token;

import java.util.List;

import javax.inject.Inject;

public class NewsPresenter implements NewsContract.Presenter {

    private final NewsRepository mNewsRepository;

    private final NewsContract.View mNewsView;

    private static String tokenStr;

    @Inject
    NewsPresenter(NewsRepository newsRepository, NewsContract.View newsView) {
        mNewsRepository = newsRepository;
        mNewsView = newsView;
    }

    @Inject
    void setupListeners() {
        mNewsView.setPresenter(this);
    }

    @Override
    public void start() {
        loadLocalData();
    }

    @Override
    public void loadContent(TokenPost tokenPost, ContentPost contentPost) {
        mNewsView.setLoadingIndicator(true);
        loadToken(tokenPost, contentPost);
    }

    @Override
    public void clickedNews(News news) {
        mNewsView.showNewsDetailActivity(news);
    }

    private void loadToken(TokenPost tokenPost, final ContentPost contentPost) {
        tokenStr = mNewsRepository.getTokenStr();
        // Check local token
        if(tokenStr.equals("")){
            // Invalidate token
            mNewsRepository.getToken(tokenPost, new NewsDataSource.LoadTokenCallback() {
                @Override
                public void onTokenLoaded(Token token) {
                    mNewsRepository.saveTokenStr(token.getUID());
                    contentPost.setUID(token.getUID());
                    loadRemoteData(contentPost);
                }

                @Override
                public void onDataNotAvailable(String msg) {
                    mNewsView.showMessage(R.string.msg_no_connect_to_server);
                }
            });
        }else {
            // Validate token
            contentPost.setUID(tokenStr);
            loadRemoteData(contentPost);

        }
    }

    private void loadRemoteData(final ContentPost contentPost){

        mNewsRepository.getContentsFromNetwork(contentPost, new NewsDataSource.LoadNewsCallback() {
            @Override
            public void onNewsLoaded(List<News> contents) {
                mNewsView.setLoadingIndicator(false);
                mNewsView.showNews(contents);
            }

            @Override
            public void onDataNotAvailable(String msg) {
                mNewsView.setLoadingIndicator(false);
                mNewsView.showMessage(R.string.msg_no_connect_to_server);
            }
        });
    }

    private void loadLocalData() {
        mNewsRepository.getNewsLocal(new NewsDataSource.LoadNewsCallback() {
            @Override
            public void onNewsLoaded(List<News> contents) {
                mNewsView.showNews(contents);
            }

            @Override
            public void onDataNotAvailable(String msg) {
            }
        });
    }
}
