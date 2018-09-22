package com.vanillastorm;

import com.vanillastorm.service.MovieService;
import com.vanillastorm.util.JavaApplicationContext;
import com.vanillastorm.util.ServiceLocator;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {

//        ServiceLocator serviceLocator = new ServiceLocator(); // чтобы уменьшить зависимость от отпределенного класса

//        MovieRepository movieRepository = (MovieRepository) serviceLocator.createObject("movieRepository");
//        MovieService movieService = new SimpleMovieService(movieRepository);

        JavaApplicationContext context = new JavaApplicationContext();
        MovieService movieService = (MovieService) context.getBean("movieService");

        movieService.watchMovie(2);
    }
}
