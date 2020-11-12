package com.codeup.test.controllers;

import com.codeup.test.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("/");
        } else {
            session.setAttribute("username", user.getUsername());
            session.setAttribute("id", user.getId());
            request.getRequestDispatcher("/WEB-INF/test.jsp").forward(request, response);
        }


    }

}
