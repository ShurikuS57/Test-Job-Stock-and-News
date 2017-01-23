package com.taptm.shurikus.stockandnews.newsdetail;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.taptm.shurikus.stockandnews.R;
import com.taptm.shurikus.stockandnews.data.News;
import com.taptm.shurikus.stockandnews.utils.ParserUtil;

import java.text.ParseException;
import java.util.List;

public class NewsDetailFragment extends Fragment implements NewsDetailContract.View {

    private NewsDetailContract.Presenter mPresenter;

    private static int mNewsId;

    private String[] contentTypeArray;

    private Toolbar mToolBar;

    private ImageView mImageNews;

    private TextView mTitleNews;

    private TextView mDataNews;

    private TextView mTextNews;

    private TextView mTextLink;

    public static NewsDetailFragment newInstance(int newsId){
        mNewsId = newsId;
        return new NewsDetailFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentTypeArray = getResources().getStringArray(R.array.content_type);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
        mPresenter.loadNewsDetail(mNewsId);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_news_detail,container,false);

        mImageNews = (ImageView) root.findViewById(R.id.image_news);
        mTitleNews = (TextView) root.findViewById(R.id.text_title_news);
        mDataNews = (TextView) root.findViewById(R.id.text_date_news);
        mTextNews = (TextView) root.findViewById(R.id.text_full_news);
        mTextLink = (TextView) root.findViewById(R.id.text_link);

        mToolBar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        return root;
    }

    @Override
    public void setPresenter(NewsDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void showNews(News news) {
        List<String> imgUrlList = ParserUtil.parserUrls(news.getImgUrl());
        if(imgUrlList.size()>0){
            Picasso.with(getActivity())
                    .load(imgUrlList.get(0))
                    .placeholder(R.drawable.ic_image_empty)
                    .into(mImageNews);
        }else {
            mImageNews.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_image_empty));
        }

        mTitleNews.setText(news.getHeader());
        try {
            mDataNews.setText(ParserUtil.parseStrTOData(news.getPublishTime()));
        } catch (ParseException e) {
            mDataNews.setText(news.getPublishTime());
        }

        mTextNews.setText(fromHtml(news.getFullText()));

        mToolBar.setTitle(contentTypeArray[news.getContentTypeId()]);

        mTextLink.setText(news.getLink());
    }

    @Override
    public void showMessage(@StringRes int resId) {
        Toast.makeText(getActivity(),resId,Toast.LENGTH_LONG).show();
    }

    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html){
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html,Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

}
