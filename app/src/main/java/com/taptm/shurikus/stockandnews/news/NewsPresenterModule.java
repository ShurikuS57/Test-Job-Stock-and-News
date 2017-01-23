package com.taptm.shurikus.stockandnews.news;


import dagger.Module;
import dagger.Provides;

@Module
public class NewsPresenterModule {

    private final NewsContract.View mView;

    public NewsPresenterModule(NewsContract.View view) {
        mView = view;
    }

    @Provides
    NewsContract.View provideNewsContractView() {
        return mView;
    }

}
