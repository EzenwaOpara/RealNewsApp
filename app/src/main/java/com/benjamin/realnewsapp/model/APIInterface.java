package com.benjamin.realnewsapp.model;

/*
 * Created by OPARA BENJAMIN
 * On 5/5/2020 - 8:59 AM
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/v2/{category}")
    Call<NewsResults> listOfHeadlines(
            @Path("category")String category,
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

    @GET("/v2/{category}")
    Call<NewsResults> listOfNews(
            @Path("category")String category,
            @Query("q") String q,
            @Query("apiKey") String apiKey
    );
}
