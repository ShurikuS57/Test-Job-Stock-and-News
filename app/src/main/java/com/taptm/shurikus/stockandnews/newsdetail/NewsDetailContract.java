package com.taptm.shurikus.stockandnews.newsdetail;


import android.support.annotation.StringRes;

import com.taptm.shurikus.stockandnews.BasePresenter;
import com.taptm.shurikus.stockandnews.BaseView;
import com.taptm.shurikus.stockandnews.data.News;

public interface NewsDetailContract {

    interface View extends BaseView<Presenter> {

        void showNews(News news);

        void showMessage(@StringRes int resId);

    }

    interface Presenter extends BasePresenter {

        void loadNewsDetail(int idNews);

    }
}
