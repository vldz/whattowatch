package com.vanillastorm.controllers;

import com.vanillastorm.entity.Movie;
import com.vanillastorm.service.MovieService;
import com.vanillastorm.util.spring.ContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public String movie(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "movie";
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    public String selectedMovie(@PathVariable Long id, @RequestParam String myParam, Model model) {
        model.addAttribute("movie", movieService.findById(id));
        System.out.println(myParam);
        return "movie";
    }
}


//if (request.getMethod().equals("POST")) {
//        String name = request.getParameter("name");
//        long id = Long.parseLong(request.getParameter("id"));
//        movieService.save(new Movie(id, name));
//        }