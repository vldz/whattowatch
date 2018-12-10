package com.vanillastorm.controllers;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class HomeController implements BaseController {

    @Override
    public String process(HttpServletRequest request, Map<String, Object> model) {
        model.put("Greeting message", "Hello, greeting message");
        return "home.jsp";
    }
}
