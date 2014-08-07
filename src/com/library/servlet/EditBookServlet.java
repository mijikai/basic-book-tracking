package com.library.servlet;

import java.io.IOException;

import java.util.Enumeration;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.serviceimpl.BookServiceImpl;

import com.library.model.Book;

public class EditBookServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if(req.getParameter("edit") != null) {
            Enumeration<String> paramNames = req.getParameterNames();
            String paramName;
            while(paramNames.hasMoreElements()) {
                paramName = paramNames.nextElement();
                req.setAttribute(paramName, req.getParameter(paramName));
            }
            req.getRequestDispatcher("editBook.jsp").forward(req, resp);
        } else if(req.getParameter("delete") != null) {
            Book book = new Book();
            book.setAuthor(req.getParameter("author"));
            book.setEdition(Integer.parseInt(req.getParameter("edition")));
            book.setPublicationYear(Integer.parseInt(req.getParameter("publicationYear")));
            book.setPublisher(req.getParameter("publisher"));
            book.setTitle(req.getParameter("title"));
            book.setType(req.getParameter("type"));
            BookServiceImpl impl = new BookServiceImpl();
            impl.removeBook(book);
            resp.sendRedirect("DisplayBookServlet");
        } else if(req.getParameter("update") != null) {
            Book oldValue = new Book();
            Book newValue = new Book();
            try {
                oldValue.setAuthor(req.getParameter("author"));
                oldValue.setEdition(Integer.parseInt(req.getParameter("edition")));
                oldValue.setPublicationYear(Integer.parseInt(req.getParameter("publicationYear")));
                oldValue.setPublisher(req.getParameter("publisher"));
                oldValue.setTitle(req.getParameter("title"));
                oldValue.setType(req.getParameter("type"));

                newValue.setAuthor(req.getParameter("newAuthor"));
                newValue.setEdition(Integer.parseInt(req.getParameter("newEdition")));
                newValue.setPublicationYear(Integer.parseInt(req.getParameter("newPublicationYear")));
                newValue.setPublisher(req.getParameter("newPublisher"));
                newValue.setTitle(req.getParameter("newTitle"));
                newValue.setType(req.getParameter("newType"));
            } catch(NumberFormatException ex) {
                Enumeration<String> names = req.getParameterNames();
                String paramName;
                while(names.hasMoreElements()) {
                    paramName = names.nextElement();
                    req.setAttribute(paramName, req.getParameter(paramName));
                }
                req.setAttribute("error", true);
                req.getRequestDispatcher("editBook.jsp").forward(req, resp);
                return;
            }
            BookServiceImpl impl = new BookServiceImpl();
            impl.editBook(oldValue, newValue);
            resp.sendRedirect("DisplayBookServlet");
        }
    }

}
