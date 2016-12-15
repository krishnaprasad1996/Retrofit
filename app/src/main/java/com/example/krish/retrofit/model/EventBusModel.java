package com.example.krish.retrofit.model;

import java.util.List;

/**
 * Created by krish on 12/15/2016.
 */

public class EventBusModel {
    public final List<Movie> movieList;

    public EventBusModel(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
