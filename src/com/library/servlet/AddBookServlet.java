package com.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.model.Book;

import com.library.serviceimpl.BookServiceImpl;

public class AddBookServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Book book = new Book();

        try {
            book.setAuthor(req.getParameter("author"));
            book.setEdition(Integer.parseInt(req.getParameter("edition")));
            book.setPublicationYear(Integer.parseInt(req.getParameter("publicationYear")));
            book.setPublisher(req.getParameter("publisher"));
            book.setTitle(req.getParameter("title"));
            book.setType(req.getParameter("type"));
        } catch(NumberFormatException ex) {
            req.setAttribute("error", true);
            req.getRequestDispatcher("addBook.jsp").forward(req, resp);
            return;
        }
        BookServiceImpl impl = new BookServiceImpl();
        impl.addBook(book);
        resp.sendRedirect("DisplayBookServlet");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(true);
        if(session.getAttribute("login") == null) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("addBook.jsp").forward(req, resp);
    }
}
