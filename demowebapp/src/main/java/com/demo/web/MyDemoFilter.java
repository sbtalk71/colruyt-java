package com.demo.web;

import javax.servlet.*;
import java.io.IOException;

public class MyDemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter Activated..");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String country=request.getParameter("country");
        if(country.equals("india")){
           chain.doFilter(request,response);
        }else{
            response.getWriter().write("<h1>Only Indians are allowed next</h1>");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter Removed..");
    }
}
