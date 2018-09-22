package com.vanillastorm.repository;

import com.vanillastorm.entity.Movie;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemMovieRepository implements MovieRepository {

    private Map<Long, Movie> movies;

    public InMemMovieRepository() {
        movies = new HashMap<>();
        movies.put(1l, new Movie(1, "It"));
        movies.put(2l, new Movie(2, "Fight club"));
        movies.put(3l, new Movie(3, "Pulp Fiction"));
        movies.put(4l, new Movie(4, "Lord of the rings"));
    }

    @Override
    public Movie find(long id) {
        return movies.get(id);
    }
}
