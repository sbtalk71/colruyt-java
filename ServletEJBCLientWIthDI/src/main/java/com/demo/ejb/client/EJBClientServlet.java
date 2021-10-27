package com.demo.ejb.client;

import com.demo.ejb3.AddRemote;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/add")
public class EJBClientServlet extends HttpServlet {
    @EJB
    AddRemote adder;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int result=adder.add(45,80);
        resp.getWriter().write("<h1>Result ="+result+" </h1>");
    }
}
