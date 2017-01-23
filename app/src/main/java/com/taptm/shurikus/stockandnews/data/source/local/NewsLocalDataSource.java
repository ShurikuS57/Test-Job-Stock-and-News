package com.taptm.shurikus.stockandnews.data.source.local;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.taptm.shurikus.stockandnews.data.News;
import com.taptm.shurikus.stockandnews.data.post.ContentPost;
import com.taptm.shurikus.stockandnews.data.post.TokenPost;
import com.taptm.shurikus.stockandnews.data.source.NewsDataSource;
import com.taptm.shurikus.stockandnews.data.source.local.PersistenceContract.NewsEntry;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import static dagger.internal.Preconditions.checkNotNull;

@Singleton
public class NewsLocalDataSource implements NewsDataSource {

    private Context mComtext;

    private DbHelper mDbHelper;

    public NewsLocalDataSource(@NonNull Context context) {
        checkNotNull(context);
        this.mComtext = context;
        mDbHelper = new DbHelper(context);

    }

    @Override
    public void getToken(@NonNull TokenPost tokenPost, @NonNull LoadTokenCallback callback) {
    }

    @Override
    public String getTokenStr() {
        return SettingHelper.getToken(mComtext);
    }

    @Override
    public void getContentsFromNetwork(@NonNull ContentPost contentPost, @NonNull LoadNewsCallback calllback) {

    }

    @Override
    public void saveNewsLocal(@NonNull List<News> newsList) {
        checkNotNull(newsList);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        for (News item: newsList){
            ContentValues values = new ContentValues();
            values.put(NewsEntry.COLUMN_NAME_ENTRY_ID, item.getId());
            values.put(NewsEntry.COLUMN_NAME_HEADER, item.getHeader());
            values.put(NewsEntry.COLUMN_NAME_SHOT_TEXT, item.getShortText());
            values.put(NewsEntry.COLUMN_NAME_FULL_TEXT, item.getFullText());
            values.put(NewsEntry.COLUMN_NAME_IMG_URL, item.getImgUrl());
            values.put(NewsEntry.COLUMN_NAME_IMG_PREVIEW_URL, item.getImgPreviewUrl());
            values.put(NewsEntry.COLUMN_NAME_CONTENT_TYPE_ID, item.getContentTypeId());
            values.put(NewsEntry.COLUMN_NAME_PUBLISH_TIME, item.getPublishTime());
            values.put(NewsEntry.COLUMN_NAME_LINK, item.getLink());

            db.insert(NewsEntry.TABLE_NAME, null, values);
        }
        db.close();
    }

    @Override
    public void getNewsLocal(@NonNull LoadNewsCallback callback) {
        List<News> newsList = new ArrayList<>();
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                NewsEntry.COLUMN_NAME_ENTRY_ID,
                NewsEntry.COLUMN_NAME_HEADER,
                NewsEntry.COLUMN_NAME_SHOT_TEXT,
                NewsEntry.COLUMN_NAME_FULL_TEXT,
                NewsEntry.COLUMN_NAME_IMG_URL,
                NewsEntry.COLUMN_NAME_IMG_PREVIEW_URL,
                NewsEntry.COLUMN_NAME_CONTENT_TYPE_ID,
                NewsEntry.COLUMN_NAME_PUBLISH_TIME,
                NewsEntry.COLUMN_NAME_LINK
        };

        Cursor c = db.query(
                NewsEntry.TABLE_NAME, projection, null, null, null, null, null);

        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                int itemId = c.getInt(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_ENTRY_ID));
                String header = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_HEADER));
                String shotText = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_SHOT_TEXT));
                String fullText = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_FULL_TEXT));
                String imgUrl = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_IMG_URL));
                String imgPreview = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_IMG_PREVIEW_URL));
                int contentId = c.getInt(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_CONTENT_TYPE_ID));
                String publishTime = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_PUBLISH_TIME));
                String link = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_LINK));

                News news = new News(itemId,header,shotText,fullText,imgUrl,imgPreview,contentId,publishTime, link);
                newsList.add(news);
            }
        }
        if (c != null) {
            c.close();
        }

        db.close();

        if (newsList.isEmpty()) {
            callback.onDataNotAvailable("No data in database");
        } else {
            callback.onNewsLoaded(newsList);
        }

    }

    @Override
    public void getNewsItem(@NonNull int newsId, @NonNull GetNewsCallback callback) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        String[] projection = {
                NewsEntry.COLUMN_NAME_ENTRY_ID,
                NewsEntry.COLUMN_NAME_HEADER,
                NewsEntry.COLUMN_NAME_SHOT_TEXT,
                NewsEntry.COLUMN_NAME_FULL_TEXT,
                NewsEntry.COLUMN_NAME_IMG_URL,
                NewsEntry.COLUMN_NAME_IMG_PREVIEW_URL,
                NewsEntry.COLUMN_NAME_CONTENT_TYPE_ID,
                NewsEntry.COLUMN_NAME_PUBLISH_TIME,
                NewsEntry.COLUMN_NAME_LINK
        };

        String selection = NewsEntry.COLUMN_NAME_ENTRY_ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(newsId) };

        Cursor c = db.query(
                NewsEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        News news = null;


        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            int itemId = c.getInt(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_ENTRY_ID));
            String header = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_HEADER));
            String shotText = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_SHOT_TEXT));
            String fullText = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_FULL_TEXT));
            String imgUrl = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_IMG_URL));
            String imgPreview = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_IMG_PREVIEW_URL));
            int contentId = c.getInt(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_CONTENT_TYPE_ID));
            String publishTime = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_PUBLISH_TIME));
            String link = c.getString(c.getColumnIndexOrThrow(NewsEntry.COLUMN_NAME_LINK));

            news = new News(itemId,header,shotText,fullText,imgUrl,imgPreview,contentId,publishTime, link);
        }
        if (c != null) {
            c.close();
        }

        db.close();

        if (news != null) {
            callback.onNewsLoaded(news);
        } else {
            callback.onDataNotAvailable();
        }


    }

    @Override
    public void deleteAllNewsDetail() {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.delete(PersistenceContract.NewsEntry.TABLE_NAME, null, null);

        db.close();

    }

    @Override
    public void saveTokenStr(String token) {
        SettingHelper.saveToken(mComtext, token);
    }
}
