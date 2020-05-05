package com.benjamin.realnewsapp.categories;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.benjamin.realnewsapp.R;
import com.benjamin.realnewsapp.model.APIInterface;
import com.benjamin.realnewsapp.model.NewsAdapter;
import com.benjamin.realnewsapp.model.NewsResults;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class EconomicsFragment extends Fragment {

    private static String BASE_URL = "https://newsapi.org";
    private static String API_KEY = "my_apiKEY";
    private static String CATEGORY = "everything";
    private static String TOPIC = "economics";


    public EconomicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_economics, container, false);
        final ListView listView = view.findViewById(R.id.economics_list);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface apiInterface = retrofit.create(APIInterface.class);

        Call<NewsResults> call = apiInterface.listOfNews(CATEGORY, TOPIC, API_KEY);

        call.enqueue(new Callback<NewsResults>() {
            @Override
            public void onResponse(Call<NewsResults> call, Response<NewsResults> response) {
                NewsResults newsResults = response.body();
                List<NewsResults.ArticlesBean> listOfNews = newsResults.getArticles();

                NewsAdapter adapter = new NewsAdapter(getContext(), 0, listOfNews);
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<NewsResults> call, Throwable t) {

            }
        });
        return view;
    }

}
