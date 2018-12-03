package com.vanillastorm.web;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Before doFilter");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println("---------");
        System.out.println(httpServletRequest.getSession(false).getAttribute("myParam"));
        if (!"ADMIN".equals(httpServletRequest.getParameter("myParam"))) {
            System.out.println("Not Admin!");
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletResponse.sendError(400);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

        System.out.println("After doFilter");
    }

    @Override
    public void destroy() {

    }
}
