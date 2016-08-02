package com.xlinyu.cookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by gavin on 02/08/2016.
 */
@WebServlet(name = "GetServlet", urlPatterns = {"/get"})
public class GetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        if(cookies != null){

            for(Cookie cookie:cookies){
                out.println("cookie: " + cookie.getName() + ":" + cookie.getValue());
            }

        }else{
            out.println("No Cookie Found!!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
