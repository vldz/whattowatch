package com.vanillastorm.controllers;

import com.vanillastorm.entity.Movie;
import com.vanillastorm.service.MovieService;
import com.vanillastorm.util.spring.ContextProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class MovieController implements BaseController {
    private MovieService movieService = (MovieService) ContextProvider.getBean("movieService");

    @Override
    public String process(HttpServletRequest request, Map<String, Object> model) {
        if (request.getMethod().equals("POST")) {
            String name = request.getParameter("name");
            long id = Long.parseLong(request.getParameter("id"));
            movieService.save(new Movie(id, name));
        }
            model.put("Movie", new Movie(1l, "Spider-Man"));
            model.put("movies", movieService.findAll());
        return "movie.jsp";
    }
}
