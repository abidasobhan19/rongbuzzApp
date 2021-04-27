package com.forbitbd.task.ui.allmovie;

import com.forbitbd.myplayer.models.Movie;

import java.util.List;

public interface MovieContract {

    interface View {
        void renderMovies(List<Movie> movieList);
    }

    interface Presenter {
        void getAllMovies();
    }
}
