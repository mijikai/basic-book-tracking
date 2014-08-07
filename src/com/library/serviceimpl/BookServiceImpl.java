package com.library.serviceimpl;

import java.util.List;
import com.library.dao.BookDao;
import com.library.model.Book;
import com.library.service.BookService;

public class BookServiceImpl implements BookService
{
    public void addBook(Book book) 
    {
        BookDao bookdao = new BookDao();
        bookdao.insertBook(book);
    }

    public void removeBook(Book book)
    {
        BookDao bookdao = new BookDao();
        bookdao.deleteBook(book);
    }

    public void editBook(Book oldValue, Book newValue) 
    {
        BookDao bookdao = new BookDao();
        bookdao.updateBook(oldValue, newValue);
    }

    public List<Book> getAllBook()
    {

        BookDao bookdao = new BookDao();
        List<Book> bookList = bookdao.getAllBook();

        return bookList;
    }

    public List<Book> searchBook(String keyword)
    {

        BookDao bookdao = new BookDao();
        List<Book> bookList = bookdao.filterBook(keyword);

        return bookList;
    }
}
