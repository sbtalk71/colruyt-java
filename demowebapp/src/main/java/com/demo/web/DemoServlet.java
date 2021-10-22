package com.demo.web;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class DemoServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String name=req.getParameter("name");
        res.getWriter().write("<h1>Hello "+name+" there from Servlet</h1>");
    }
}
