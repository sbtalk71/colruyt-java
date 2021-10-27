package com.demo.web.client;

import com.demo.ejb.Cart;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/cart")
public class CartClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            InitialContext ctx = new InitialContext();
            Cart cart = (Cart) ctx.lookup("com.demo.ejb.Cart");

            cart.addToCart("pen", 3);
            cart.addToCart("pen", 3);
            cart.addToCart("pencil", 4);
            cart.addToCart("shirt", 3);
            cart.addToCart("shirt", 3);
            HashMap<String, Integer> cartValue=cart.getCart();
            cart.checkOut();
            resp.getWriter().write("<h2>"+cartValue+"</h2>");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
