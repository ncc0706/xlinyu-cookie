package com.xlinyu.cookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gavin on 02/08/2016.
 */
@WebServlet(name = "AddCookieServlet", urlPatterns = {"/cookie/add"})
public class AddCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("2222", "this is a 2222 cookie");
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
        response.getWriter().println("add cookie ok ");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
