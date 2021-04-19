package com.forbitbd.task.ui.allmovie;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbitbd.myplayer.models.Movie;
import com.forbitbd.task.R;
import com.forbitbd.task.api.ApiClient;
import com.forbitbd.task.api.ServiceGenerator;
import com.forbitbd.task.ui.main.categorie.MovieAdapter;
import com.forbitbd.task.ui.main.popularVideos.RecyclerviewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieFragment extends Fragment {

    private RecyclerView recyclerView;
    private MovieAdapter adapter;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        getFeaturedMovies();
        return view;
    }

    private void getFeaturedMovies() {
        ApiClient client = ServiceGenerator.createService(ApiClient.class);
        client.getMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()){
                    renderMovies(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }

    private void renderMovies(List<Movie> movieList) {
        for (Movie x : movieList) {
            adapter.addMovie(x);
        }
    }

}