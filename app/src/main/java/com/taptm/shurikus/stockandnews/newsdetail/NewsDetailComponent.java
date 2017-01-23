package com.taptm.shurikus.stockandnews.newsdetail;

import com.taptm.shurikus.stockandnews.data.source.NewsRepositoryComponent;
import com.taptm.shurikus.stockandnews.utils.FragmentScoped;

import dagger.Component;

@FragmentScoped
@Component(dependencies = NewsRepositoryComponent.class, modules = NewsDetailPresenterModule.class)
public interface NewsDetailComponent {

    void inject(NewsDetailActivity activity);

}
