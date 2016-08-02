package com.xlinyu.servlet;

import com.xlinyu.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by gavin on 02/08/2016.
 */
@WebServlet(name = "IndexServlet", urlPatterns = {"/"})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User)request.getSession().getAttribute("user");

        System.out.println("..........");

        if(null == user){
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return ;
        }

        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

    }
}
