package com.taptm.shurikus.stockandnews.data.source.local;


import android.provider.BaseColumns;

public class PersistenceContract {


    private PersistenceContract() {}

    public static abstract class NewsEntry implements BaseColumns {
        public static final String TABLE_NAME = "news";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_HEADER = "header";
        public static final String COLUMN_NAME_SHOT_TEXT = "short_text";
        public static final String COLUMN_NAME_FULL_TEXT = "full_text";
        public static final String COLUMN_NAME_IMG_URL = "img_url";
        public static final String COLUMN_NAME_IMG_PREVIEW_URL = "img_preview_url";
        public static final String COLUMN_NAME_CONTENT_TYPE_ID = "content_type_id";
        public static final String COLUMN_NAME_PUBLISH_TIME = "publish_time";
        public static final String COLUMN_NAME_LINK = "link";

    }

}
