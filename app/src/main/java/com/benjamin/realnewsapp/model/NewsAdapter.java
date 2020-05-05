package com.benjamin.realnewsapp.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//import com.benjamin.newsapp.R;

import com.benjamin.realnewsapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<NewsResults.ArticlesBean> {
    public NewsAdapter(@NonNull Context context, int resource, @NonNull List<NewsResults.ArticlesBean> newsData) {
        super(context, 0, newsData);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        NewsResults.ArticlesBean currentNews = getItem(position);

        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_news, parent, false);
        }

        TextView titleTV = view.findViewById(R.id.news_title);
        TextView dateTV = view.findViewById(R.id.news_date);
        ImageView imageView = view.findViewById(R.id.news_image);

        titleTV.setText(currentNews.getTitle());
        dateTV.setText(currentNews.getPublishedAt());
//        imageView.setImageResource(currentNews.getImageResourceId());
        Picasso.with(getContext()).load(currentNews.getUrlToImage()).into(imageView);

        return view;
    }
}
