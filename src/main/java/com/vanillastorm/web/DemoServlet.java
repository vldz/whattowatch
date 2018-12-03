package com.vanillastorm.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        out.print("<h3>Request param : </h3> " + request.getParameter("myParam"));

        HttpSession session = request.getSession();
        session.setAttribute("myParam", request.getParameter("myParam"));
        System.out.println("----------*****-----------");
        System.out.println(session.getAttribute("myParam"));


        //out.println(this);
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
