package com.forbitbd.task.ui.allmovie;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forbitbd.myplayer.MyPlayerActivity;
import com.forbitbd.myplayer.models.Movie;
import com.forbitbd.task.R;
import com.forbitbd.task.ui.main.popularVideos.ItemClickListener;
import com.forbitbd.task.ui.main.popularVideos.RecyclerviewAdapter;
import com.forbitbd.task.utils.Constant;

import java.util.List;

public class MovieFragment extends Fragment implements MovieContract.View, ItemClickListener {

    RecyclerviewAdapter recyclerviewAdapter;
    RecyclerView recyclerView;
    private MoviePresenter moviePresenter;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moviePresenter = new MoviePresenter(this);
        recyclerviewAdapter = new RecyclerviewAdapter(getContext(),this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recyclerviewAdapter);

        moviePresenter.getAllMovies();
        return view;
    }

    @Override
    public void renderMovies(List<Movie> movieList) {
        for (Movie x:movieList){
            recyclerviewAdapter.add(x);
        }
    }

    @Override
    public void onItemClick(Movie movie) {
        Intent intent = new Intent(getContext(), MyPlayerActivity.class);
        intent.putExtra(Constant.VIDEO_URL, movie.getVideo_url());
        startActivity(intent);
    }
}