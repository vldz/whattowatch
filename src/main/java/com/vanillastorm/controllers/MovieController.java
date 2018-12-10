package com.vanillastorm.controllers;

import com.vanillastorm.entity.Movie;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class MovieController implements BaseController {
    @Override
    public String process(HttpServletRequest request, Map<String, Object> model) {
        model.put("Movie", new Movie(1l, "Spider-Man"));
        return "movie.jsp";
    }
}
