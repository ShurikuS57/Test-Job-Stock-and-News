package com.taptm.shurikus.stockandnews.news;

import com.taptm.shurikus.stockandnews.data.source.NewsRepositoryComponent;
import com.taptm.shurikus.stockandnews.utils.FragmentScoped;

import dagger.Component;

@FragmentScoped
@Component(dependencies = NewsRepositoryComponent.class, modules = NewsPresenterModule.class)
public interface NewsComponent {

    void inject(NewsActivity activity);

}
