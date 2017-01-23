package com.taptm.shurikus.stockandnews.news;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.taptm.shurikus.stockandnews.R;
import com.taptm.shurikus.stockandnews.data.News;
import com.taptm.shurikus.stockandnews.data.post.ContentPost;
import com.taptm.shurikus.stockandnews.data.post.TokenPost;
import com.taptm.shurikus.stockandnews.newsdetail.NewsDetailActivity;
import com.taptm.shurikus.stockandnews.utils.ParserUtil;
import com.taptm.shurikus.stockandnews.utils.PostHelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class NewsFragment extends Fragment implements NewsContract.View, SwipeRefreshLayout.OnRefreshListener {

    private NewsContract.Presenter mPresenter;

    private TokenPost mTokenPost;

    private ContentPost mContentPost;

    private NewsAdapter mNewsAdapter;

    private SwipeRefreshLayout mSwipeRefresh;

    public static NewsFragment newInstance(){
        return new NewsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTokenPost = PostHelper.calcTokenPost(getActivity(), new TokenPost());
        mContentPost = PostHelper.calcContentPost(getActivity(), new ContentPost());

        mNewsAdapter = new NewsAdapter(getActivity(),
                new ArrayList<News>(0), mNewsItemListener);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.list_news);
        listView.setAdapter(mNewsAdapter);

        mSwipeRefresh = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh);
        mSwipeRefresh.setOnRefreshListener(this);
        mSwipeRefresh.setColorSchemeResources(R.color.colorPrimary,
                R.color.colorPrimaryDark,
                R.color.color_orange);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
        mPresenter.loadContent(mTokenPost, mContentPost);
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showNews(List<News> newsList) {
        mNewsAdapter.replaceData(newsList);
    }

    @Override
    public void showNewsDetailActivity(News news) {
        Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
        intent.putExtra(NewsDetailActivity.EXTRA_NEWS_ID, news.getId());
        startActivity(intent);
    }

    @Override
    public void showMessage(@StringRes int idRes) {
        Toast.makeText(getActivity(),idRes,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setLoadingIndicator(boolean isActive) {
        mSwipeRefresh.setRefreshing(isActive);
    }

    NewsItemListener mNewsItemListener = new NewsItemListener() {
        @Override
        public void onNewsClick(News clickedNews) {
            mPresenter.clickedNews(clickedNews);
        }
    };

    @Override
    public void onRefresh() {
        mPresenter.loadContent(mTokenPost, mContentPost);
    }

    public static class NewsAdapter extends BaseAdapter{

        private Context mContext;
        private List<News> mNewsList;
        private NewsItemListener mItemListener;
        private final String[] mContentTypeArray;

        public NewsAdapter(Context context, List<News> newsList, NewsItemListener mItemListener) {
            this.mNewsList = newsList;
            this.mItemListener = mItemListener;
            this.mContext = context;

            mContentTypeArray = context.getResources().getStringArray(R.array.content_type);
        }

        public void replaceData(List<News> newList){
            setList(newList);
            notifyDataSetChanged();
        }

        private void setList(List<News> newsList) {
            mNewsList = checkNotNull(newsList);
        }

        @Override
        public int getCount() {
            return mNewsList.size();
        }

        @Override
        public News getItem(int position) {
            return mNewsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = convertView;
            if(rowView == null){
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                rowView = inflater.inflate(R.layout.item_news, parent, false);
            }

            final News news = getItem(position);

            ImageView imagePreview = (ImageView) rowView.findViewById(R.id.image_preview);
            String imageUrl = news.getImgPreviewUrl();
            if(!imageUrl.equals("")){
                Picasso.with(mContext)
                        .load(news.getImgPreviewUrl())
                        .placeholder(R.drawable.ic_image_empty)
                        .into(imagePreview);
            }else {
                imagePreview.setImageResource(R.drawable.ic_image_empty);
            }

            TextView titleNews = (TextView) rowView.findViewById(R.id.text_title_news);
            titleNews.setText(news.getHeader());

            TextView textDateNews = (TextView) rowView.findViewById(R.id.text_date_news);
            try {
                String strTypeContent = mContentTypeArray[news.getContentTypeId()];
                String publishData = ParserUtil.parseStrTOData(news.getPublishTime());
                textDateNews.setText(strTypeContent+" "+publishData);
            } catch (NullPointerException | ParseException e){
                e.printStackTrace();
            }

            TextView textDescriptionNews = (TextView) rowView.findViewById(R.id.text_description_news);
            textDescriptionNews.setText(news.getShortText());

            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemListener.onNewsClick(news);
                }
            });

            return rowView;
        }
    }

    public interface NewsItemListener {

        void onNewsClick(News clickedNews);

    }
}
