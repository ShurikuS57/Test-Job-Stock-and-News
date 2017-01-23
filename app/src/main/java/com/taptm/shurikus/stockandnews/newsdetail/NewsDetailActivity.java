package com.taptm.shurikus.stockandnews.newsdetail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.taptm.shurikus.stockandnews.R;
import com.taptm.shurikus.stockandnews.StockAndNewsApplication;
import com.taptm.shurikus.stockandnews.utils.ActivityUtils;

import javax.inject.Inject;

public class NewsDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NEWS_ID = "newsId";

    @Inject
    NewsDetailPresenter mNewsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        initToolbar();

        int contentId = getIntent().getIntExtra(EXTRA_NEWS_ID, 0);

        NewsDetailFragment newsDetailFragment = (NewsDetailFragment) getFragmentManager()
                .findFragmentById(R.id.contentFrame);

        if(newsDetailFragment == null){
            newsDetailFragment = NewsDetailFragment.newInstance(contentId);
            ActivityUtils.addFragmentToActivity(getFragmentManager(),
                    newsDetailFragment, R.id.contentFrame);
        }

        DaggerNewsDetailComponent.builder()
                .newsDetailPresenterModule(new NewsDetailPresenterModule(newsDetailFragment, contentId))
                .newsRepositoryComponent(((StockAndNewsApplication) getApplication())
                        .getRepositoryComponent())
                .build().inject(this);

    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
