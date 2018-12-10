package com.vanillastorm.web;

import com.sun.xml.internal.rngom.parse.host.Base;
import com.vanillastorm.controllers.BaseController;
import com.vanillastorm.controllers.ErrorController;
import com.vanillastorm.controllers.HomeController;
import com.vanillastorm.controllers.MovieController;
import org.springframework.cglib.core.Local;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GeneralRequestDispatcherServlet extends HttpServlet {

    private Map<String, BaseController> mappings = new HashMap<>();
    private BaseController errorController = new ErrorController();

    @Override
    public void init() throws ServletException {
        super.init();
        mappings.put("/app/movie", new MovieController());
        mappings.put("/app", new HomeController());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Inside General servlet" + request.getRequestURI());

        Map<String, Object> model = new HashMap<>();
        model.put("RequestUri", request.getRequestURI());
        model.put("Time", LocalDateTime.now().toString());

        BaseController controller = mappings.getOrDefault(request.getRequestURI(), errorController);
        String view = controller.process(request, model);

        request.setAttribute("model", model);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/" + view);
        //RequestDispatcher rd = getServletContext().getRequestDispatcher(/general.jsp);
        rd.forward(request, response);

    }

}