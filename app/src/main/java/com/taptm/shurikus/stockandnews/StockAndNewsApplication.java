package com.taptm.shurikus.stockandnews;

import android.app.Application;

import com.taptm.shurikus.stockandnews.data.source.DaggerNewsRepositoryComponent;
import com.taptm.shurikus.stockandnews.data.source.NewsRepositoryComponent;

public class StockAndNewsApplication extends Application {

    private NewsRepositoryComponent mRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mRepositoryComponent = DaggerNewsRepositoryComponent.builder()
                .applicationModule(new ApplicationModule((getApplicationContext())))
                .build();
    }


    public NewsRepositoryComponent getRepositoryComponent() {
        return mRepositoryComponent;
    }
}
