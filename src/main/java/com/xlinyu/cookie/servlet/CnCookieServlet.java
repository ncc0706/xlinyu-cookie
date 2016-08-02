package com.xlinyu.cookie.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by gavin on 02/08/2016.
 */
@WebServlet(name = "CnCookieServlet", urlPatterns = {"/cn/cookie"})
public class CnCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String value = "中文";

        String encode = URLEncoder.encode(value, "UTF-8");


        Cookie cookie = new Cookie("CN", encode);
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8 ");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for(Cookie cookie:cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                if(name.equals("CN")){
                    value = URLDecoder.decode(value, "UTF-8");
                }

                out.println("cookie: " + name  + ":" + value + "<br/>");


            }
        } else {
            out.println("No Cookie Found!!");
        }
    }
}
