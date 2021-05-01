package com.forbitbd.chayabaji.ui.allmovie;

import android.util.Log;

import com.forbitbd.myplayer.models.Movie;
import com.forbitbd.chayabaji.api.ApiClient;
import com.forbitbd.chayabaji.api.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter implements MovieContract.Presenter{

    private MovieContract.View mview;

    public MoviePresenter(MovieContract.View mview) {
        this.mview = mview;
    }

    public void getAllMovies() {
        ApiClient client = ServiceGenerator.createService(ApiClient.class);

        client.getAllMovies()
                .enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()){
                    mview.renderMovies(response.body());

                    Log.d("hhhhhhh", "onResponse: " + response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d("hhhhhhh", "onResponse: " + t);
            }
        });
    }

}
