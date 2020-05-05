package com.benjamin.realnewsapp.activity;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.benjamin.realnewsapp.R;
import com.benjamin.realnewsapp.model.APIInterface;
import com.benjamin.realnewsapp.model.NewsResults;
import com.benjamin.realnewsapp.categories.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HeadlinesFragment();
                case 1:
                    return new MedicineFragment();
                case 2:
                    return new SportsFragment();
                case 3:
                    return new TechFragment();
                case 4:
                    return new EconomicsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.headlines);
                case 1:
                    return getResources().getText(R.string.medicine);
                case 2:
                    return getResources().getText(R.string.sports);
                case 3:
                    return getResources().getText(R.string.tech);
                case 4:
                    return getResources().getText(R.string.economics);
            }
            return null;
        }
    }
}


//
//
//        call.enqueue(new Callback<NewsResults>() {
//            @Override
//            public void onResponse(Call<NewsResults> call, Response<NewsResults> response) {
//
//                String[] news = new String[listOfHeadlines.size()];
//                for (int i = 0; i < listOfHeadlines.size(); i++){
//                    NewsResults.ArticlesBean currentNews = listOfHeadlines.get(i);
//                    news[i] = (currentNews.getTitle());
//                }
//                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
//                        android.R.layout.simple_list_item_1, news);
//
//                ListView listView = findViewById(R.id.list_item_main);
//                listView.setAdapter(adapter);
//
//            }
//
//            @Override
//            public void onFailure(Call<NewsResults> call, Throwable t) {
//
//            }
//        });
//
//    }
//}