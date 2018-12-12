package com.vanillastorm.service;

import com.vanillastorm.entity.Movie;

import java.util.List;

public interface MovieService {
    boolean watchMovie(long id);
    List<Movie> findAll();

    void save(Movie movie);
}
