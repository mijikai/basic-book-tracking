package com.library.service;

import java.util.List;

import com.library.model.Book;

public interface BookService 
{
    public void addBook(Book book);
    public void removeBook(Book book);
    public void editBook(Book oldInfo, Book newInfo);

    public List<Book> getAllBook();

    public List<Book> searchBook(String keyword);

}
