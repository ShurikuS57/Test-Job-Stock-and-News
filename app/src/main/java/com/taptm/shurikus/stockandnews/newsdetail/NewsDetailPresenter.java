package com.taptm.shurikus.stockandnews.newsdetail;

import com.taptm.shurikus.stockandnews.R;
import com.taptm.shurikus.stockandnews.data.News;
import com.taptm.shurikus.stockandnews.data.source.NewsDataSource;
import com.taptm.shurikus.stockandnews.data.source.NewsRepository;

import javax.inject.Inject;

public class NewsDetailPresenter implements NewsDetailContract.Presenter {

    private final NewsRepository mRepository;

    private final NewsDetailContract.View mNewsView;


    @Inject
    NewsDetailPresenter (NewsRepository newsRepository, NewsDetailContract.View newsView) {
        mRepository = newsRepository;
        mNewsView = newsView;
    }

    @Inject
    void setupListeners() {
        mNewsView.setPresenter(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void loadNewsDetail(int idNews) {
        mRepository.getNewsItem(idNews, new NewsDataSource.GetNewsCallback() {
            @Override
            public void onNewsLoaded(News news) {
                mNewsView.showNews(news);
            }

            @Override
            public void onDataNotAvailable() {
                mNewsView.showMessage(R.string.msg_fail_load_news_detail);
            }
        });
    }
}
