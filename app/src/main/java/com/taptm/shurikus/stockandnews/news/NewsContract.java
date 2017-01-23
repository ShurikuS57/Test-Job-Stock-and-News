package com.taptm.shurikus.stockandnews.news;


import android.support.annotation.StringRes;

import com.taptm.shurikus.stockandnews.BasePresenter;
import com.taptm.shurikus.stockandnews.BaseView;
import com.taptm.shurikus.stockandnews.data.News;
import com.taptm.shurikus.stockandnews.data.post.ContentPost;
import com.taptm.shurikus.stockandnews.data.post.TokenPost;

import java.util.List;

public interface NewsContract {

    interface View extends BaseView<Presenter> {

        void showNews(List<News> newsList);

        void showNewsDetailActivity(News news);

        void showMessage(@StringRes int idRes);

        void setLoadingIndicator(boolean isActive);

    }

    interface Presenter extends BasePresenter {

        void loadContent(TokenPost tokenPost, ContentPost contentPost);

        void clickedNews(News news);
    }
}
