package com.taptm.shurikus.stockandnews.data.source;

import com.taptm.shurikus.stockandnews.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NewsRepositoryModule.class, ApplicationModule.class})
public interface NewsRepositoryComponent {

    NewsRepository getTasksRepository();

}
