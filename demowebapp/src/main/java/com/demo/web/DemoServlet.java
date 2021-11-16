package com.demo.web;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class DemoServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        //String name=req.getParameter("name");
        res.getWriter().write("<h1>Hello there from Servlet</h1>");
        res.getWriter().write("<h1>Driver is " + getServletConfig().getInitParameter("driver") + "</h1>");
        /*res.getWriter().write("<?xml version = \"1.0\"?>\n" +
                "<notes>\n" +
                "    <note date=\"2021-10-22\">\n" +
                "        <header>breaks</header>\n" +
                "        <body>Lunch break at 13:30 hrs</body>\n" +
                "    </note>\n" +
                "</notes>");
    }*/
    }
}
