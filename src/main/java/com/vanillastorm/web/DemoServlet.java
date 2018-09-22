package com.vanillastorm.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {

    private int counter = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        counter++;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Hello World!</h3> " + counter);
        out.println(this);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("servlet init");
        //существует всегда один. объект который создается один раз
    }

    @Override
    public void destroy() {
        System.out.println("bye-bye");
    }
}
