package com.taptm.shurikus.stockandnews.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.taptm.shurikus.stockandnews.R;
import com.taptm.shurikus.stockandnews.StockAndNewsApplication;
import com.taptm.shurikus.stockandnews.utils.ActivityUtils;

import javax.inject.Inject;

public class NewsActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback{

    @Inject
    NewsPresenter mNewsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        initToolbar();

        NewsFragment newsFragment = (NewsFragment) getFragmentManager()
                .findFragmentById(R.id.contentFrame);

        if(newsFragment == null){
            newsFragment = NewsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getFragmentManager(),
                    newsFragment, R.id.contentFrame);
        }

        DaggerNewsComponent.builder()
                .newsPresenterModule(new NewsPresenterModule(newsFragment))
                .newsRepositoryComponent(((StockAndNewsApplication) getApplication())
                        .getRepositoryComponent())
                .build().inject(this);

    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title_stock_and_news);
    }

}
