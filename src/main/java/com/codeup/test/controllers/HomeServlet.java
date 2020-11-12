package com.codeup.test.controllers;

import com.codeup.test.dao.DaoFactory;
import com.codeup.test.dao.Users;
import com.codeup.test.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "controllers.HomeServlet", urlPatterns="")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Users users = DaoFactory.getUsersDao();
        HttpSession session = request.getSession();

        try {
            User user = users.findByUsername(username);

            if (user == null) {
                User userToAdd = new User(username);

                System.out.println("user = null");
                long id = users.insert(userToAdd);
                userToAdd.setId(id);
                session.setAttribute("user", userToAdd);
                response.sendRedirect("/test");
            } else {
                System.out.println("user.getUsername() = " + user.getUsername() + "; already in use");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");

        if (username == null) {
            request.setAttribute("welcomeMsg", "Welcome!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("/test");
        }
    }
}
