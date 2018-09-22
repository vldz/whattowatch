package com.vanillastorm.service;

import com.vanillastorm.entity.Movie;
import com.vanillastorm.repository.MovieRepository;
import com.vanillastorm.util.PostCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service(value = "movieService") //присваеваем название  бина в контекст
public class SimpleMovieService implements MovieService {

    @Autowired // связываем с мувирепозитори через аннотации
    private MovieRepository movieRepository;

    public SimpleMovieService() {
    }

    @Override
    public boolean watchMovie(long id) {
        Movie movie = movieRepository.find(id);
        if (movie != null) {
            System.out.println("Watching movie " + movie.getName());
            return true;
        } else {
            return false;
        }
    }

    @PostConstruct
    public void postCreate () {
        System.out.println("Simple movie service was created!");
    }

    @PostConstruct
    public  void anotherPostCreate () {
        System.out.println("anotherPostCreate method...");
    }

    //@PreDestroy
    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
}


//Dependency injection(внедрение зависимостей). 2 вида (Constructor injection(через конструктор), Setter injection(через сетер))
//связываем сервис и репозитории