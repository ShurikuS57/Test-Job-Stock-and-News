package com.taptm.shurikus.stockandnews.newsdetail;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsDetailPresenterModule {

    private final NewsDetailContract.View mView;

    public NewsDetailPresenterModule(NewsDetailContract.View view, int contentId) {
        mView = view;
    }

    @Provides
    NewsDetailContract.View provideNewsContractView() {
        return mView;
    }
}
