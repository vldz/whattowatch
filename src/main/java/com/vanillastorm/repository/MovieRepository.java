package com.vanillastorm.repository;

import com.vanillastorm.entity.Movie;

import java.util.List;

public interface MovieRepository {
    Movie find(long id);
    List<Movie> findAll();

    void save(Movie movie);
}
