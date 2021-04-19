package com.forbitbd.task.api;


import com.forbitbd.myplayer.models.Category;
import com.forbitbd.myplayer.models.Movie;
import com.forbitbd.myplayer.models.OnlineStatus;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiClient {

    @GET("/categories")
    Call<List<Category>> getAllCategories();

    @GET("/categories/{cat_id}/movies")
    Call<List<Movie>> getCategorizedMovies(@Path("cat_id") String catId);

    @GET("/categories/{cat_id}/movies/{query}")
    Call<List<Movie>> getCategorizedQueryMovies(@Path("cat_id") String catId, @Path("query") String query);

    @GET("/categories/{cat_id}/movies/year/{year}")
    Call<List<Movie>> getCategorizedYearlyMovies(@Path("cat_id") String catId, @Path("year") int year);

    @GET("/movies/popular")
    Call<List<Movie>> getPopularMovies();

    @GET("/movies/featured")
    Call<List<Movie>> getFeaturedMovies();

    @GET("/status")
    Call<OnlineStatus> getOnlineStatus();

    }

