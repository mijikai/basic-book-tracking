package com.library.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.model.Book;
import com.library.serviceimpl.BookServiceImpl;

public class SearchBookServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        HttpSession session = request.getSession(true);
        if(session.getAttribute("login") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        String keyword = request.getParameter("keyword");

        BookServiceImpl bookserviceimpl = new BookServiceImpl();

        List<Book> bookList = bookserviceimpl.searchBook(keyword);

        session.setAttribute("bookList", bookList);

        request.getRequestDispatcher("booksearch.jsp").forward(request, response);
    }
}
