package com.taptm.shurikus.stockandnews.data.source.local;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "News.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String INTEGER_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PersistenceContract.NewsEntry.TABLE_NAME + " (" +
                    PersistenceContract.NewsEntry._ID + INTEGER_TYPE + " PRIMARY KEY," +
                    PersistenceContract.NewsEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    PersistenceContract.NewsEntry.COLUMN_NAME_HEADER + TEXT_TYPE + COMMA_SEP +
                    PersistenceContract.NewsEntry.COLUMN_NAME_SHOT_TEXT + TEXT_TYPE + COMMA_SEP +
                    PersistenceContract.NewsEntry.COLUMN_NAME_FULL_TEXT + TEXT_TYPE + COMMA_SEP +
                    PersistenceContract.NewsEntry.COLUMN_NAME_IMG_URL + TEXT_TYPE + COMMA_SEP +
                    PersistenceContract.NewsEntry.COLUMN_NAME_IMG_PREVIEW_URL + TEXT_TYPE + COMMA_SEP +
                    PersistenceContract.NewsEntry.COLUMN_NAME_CONTENT_TYPE_ID + INTEGER_TYPE + COMMA_SEP +
                    PersistenceContract.NewsEntry.COLUMN_NAME_PUBLISH_TIME + TEXT_TYPE + COMMA_SEP +
                    PersistenceContract.NewsEntry.COLUMN_NAME_LINK + TEXT_TYPE +
                    " )";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
