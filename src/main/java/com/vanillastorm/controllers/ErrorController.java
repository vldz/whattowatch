package com.vanillastorm.controllers;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ErrorController implements BaseController {

    @Override
    public String process(HttpServletRequest request, Map<String, Object> model) {
        model.put("Error message", "Something went wrong");
        return "error.jsp";
    }
}
