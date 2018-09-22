package com.vanillastorm.util;

import com.vanillastorm.repository.InMemMovieRepository;
import com.vanillastorm.service.SimpleMovieService;

import java.util.HashMap;
import java.util.Map;

public class JavaConfig implements Config {

    private Map<String, Class<?>> configs = new HashMap<>();

    public JavaConfig() {
        this.configs.put("movieRepository", InMemMovieRepository.class);
        this.configs.put("movieService", SimpleMovieService.class);
    }

    @Override
    public <T> Class<T> getImpl(String name) {
        return (Class<T>)configs.get(name);
    }

}
