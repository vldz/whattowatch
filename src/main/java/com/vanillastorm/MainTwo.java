package com.vanillastorm;

import com.vanillastorm.repository.MovieRepository;
import com.vanillastorm.service.MovieService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTwo {
    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");


//      MovieRepository movieRepository = (MovieRepository) appContext.getBean("movieRepository");
        MovieService movieService = (MovieService) appContext.getBean("movieService");

        movieService.watchMovie(1);
    }
}
