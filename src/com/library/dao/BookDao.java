package com.library.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;

public class BookDao
{
    private final File BOOK_FILE = new File("D:/book.txt");

    public BookDao()
    {
        try {
            if(!BOOK_FILE.exists()) {
                BOOK_FILE.createNewFile();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertBook(Book book)
    {
        try {
            FileWriter writer = new FileWriter(BOOK_FILE, true);
            writer.write(book.getAuthor());
            writer.write(";");
            writer.write(Integer.toString(book.getEdition()));
            writer.write(";");
            writer.write(Integer.toString(book.getPublicationYear()));
            writer.write(";");
            writer.write(book.getPublisher());
            writer.write(";");
            writer.write(book.getTitle());
            writer.write(";");
            writer.write(book.getType());
            writer.write("\n");
            writer.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteBook(Book book)
    {
        try {
            List<Book> arr = getAllBook();
            FileWriter writer = new FileWriter(BOOK_FILE);
            for(Book elem : arr) {
                if(!elem.equals(book)) {
                    writer.write(elem.getAuthor());
                    writer.write(";");
                    writer.write(Integer.toString(elem.getEdition()));
                    writer.write(";");
                    writer.write(Integer.toString(elem.getPublicationYear()));
                    writer.write(";");
                    writer.write(elem.getPublisher());
                    writer.write(";");
                    writer.write(elem.getTitle());
                    writer.write(";");
                    writer.write(elem.getType());
                    writer.write("\n");
                }
            }
            writer.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateBook(Book book, Book newValue)
    {
        List<Book> all = getAllBook();
        int index = all.indexOf(book);
        if(index == -1) {
            return;
        }

        try {
            all.set(index, newValue);
            FileWriter writer = new FileWriter(BOOK_FILE);
            for(Book elem : all) {
                writer.write(elem.getAuthor());
                writer.write(";");
                writer.write(Integer.toString(elem.getEdition()));
                writer.write(";");
                writer.write(Integer.toString(elem.getPublicationYear()));
                writer.write(";");
                writer.write(elem.getPublisher());
                writer.write(";");
                writer.write(elem.getTitle());
                writer.write(";");
                writer.write(elem.getType());
                writer.write("\n");
            }
            writer.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    //filterBook() - search for book

    public List<Book> filterBook(String keyword)
    {
        List<Book> all = getAllBook();
        List<Book> result = new ArrayList<Book>();
        keyword = keyword.toLowerCase();
        for(Book elem : all) {
            if(elem.getAuthor().toLowerCase().contains(keyword) ||
                    Integer.toString(elem.getEdition()).toLowerCase().contains(keyword) ||
                    Integer.toString(elem.getPublicationYear()).toLowerCase().contains(keyword) ||
                    elem.getPublisher().toLowerCase().contains(keyword) ||
                    elem.getTitle().toLowerCase().contains(keyword) ||
                    elem.getType().toLowerCase().contains(keyword)) {
                result.add(elem);
            }
        }
        return result;
    }

    public List<Book> getAllBook()
    {
        String bookArr[];
        List<Book> bookList = new ArrayList<Book>();

        try {

            LineNumberReader lnr = new LineNumberReader(new FileReader(BOOK_FILE));

            for(String bookData = lnr.readLine(); bookData!=null;bookData = lnr.readLine()){

                bookArr = bookData.split(";");
                if(bookArr.length < 4) {
                    continue;
                }

                Book book = new Book();

                book.setAuthor(bookArr[0]);
                book.setEdition(Integer.parseInt(bookArr[1]));
                book.setPublicationYear(Integer.parseInt(bookArr[2]));
                book.setPublisher(bookArr[3]);
                book.setTitle(bookArr[4]);
                book.setType(bookArr[5]);

                bookList.add(book);
            }

            lnr.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return bookList;
    }
}
