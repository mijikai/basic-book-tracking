package com.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticateServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private String username = "root";
    private String password = "password";

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession(true);
        if(this.username.equals(username) && this.password.equals(password)) {
            session.setAttribute("login", true);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.setAttribute("error", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null) {
            session.removeAttribute("login");
            response.sendRedirect("home.jsp");
        }
    }
}
