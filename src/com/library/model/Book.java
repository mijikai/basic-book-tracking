package com.library.model;

public class Book
{
    private String author;
    private int edition;
    private int publicationYear;
    private String publisher;
    private String title;
    private String type;

    public Book()
    {
        super();
    }

    public Book(String author, int edition, int publicationYear, String publisher, String title, String type)
    {
        super();
        this.author = author;
        this.edition = edition;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.title = title;
        this.type = type;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getEdition()
    {
        return edition;
    }

    public int getPublicationYear()
    {
        return publicationYear;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public String getType()
    {
        return type;
    }

    public String getTitle()
    {
        return title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setEdition(int edition)
    {
        this.edition = edition;
    }

    public void setPublicationYear(int publicationYear)
    {
        this.publicationYear = publicationYear;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Book) {
            Book book = (Book)obj;
            return book.author.equalsIgnoreCase(author) &&
                book.edition == edition &&
                book.publicationYear == publicationYear &&
                book.publisher.equalsIgnoreCase(publisher) &&
                book.type.equalsIgnoreCase(type) &&
                book.title.equalsIgnoreCase(title);
        }
        return false;
    }
}
