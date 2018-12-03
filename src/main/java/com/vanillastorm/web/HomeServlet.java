package com.vanillastorm.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Demo");
//        rd.forward(request, response);
        System.out.println("Inside home servlet");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
        request.setAttribute("myAtr", "my model");
        request.setAttribute("list", Arrays.asList("first", "second", "third"));
        rd.forward(request, response);

    }

}