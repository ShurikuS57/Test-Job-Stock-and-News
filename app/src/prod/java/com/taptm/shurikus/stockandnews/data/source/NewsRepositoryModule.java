package com.taptm.shurikus.stockandnews.data.source;


import android.content.Context;

import com.taptm.shurikus.stockandnews.data.source.local.NewsLocalDataSource;
import com.taptm.shurikus.stockandnews.data.source.remote.NewsRemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsRepositoryModule {

    @Singleton
    @Provides
    @Local
    NewsDataSource provideNewsLocalDataSource(Context context) {
        return new NewsLocalDataSource(context);
    }

    @Singleton
    @Provides
    @Remote
    NewsDataSource provideNewsRemoteDataSource() {
        return new NewsRemoteDataSource();
    }

}
