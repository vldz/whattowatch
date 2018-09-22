package com.vanillastorm.repository;

import com.vanillastorm.entity.Movie;

public interface MovieRepository {
    Movie find(long id);
}
