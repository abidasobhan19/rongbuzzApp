package com.forbitbd.chayabaji.ui.allmovie;

import com.forbitbd.myplayer.models.Movie;

import java.util.List;

public interface MovieContract {

    interface Presenter{
        void getAllMovies();
    }

    interface View{
        void renderMovies(List<Movie> movieList);
    }
}
