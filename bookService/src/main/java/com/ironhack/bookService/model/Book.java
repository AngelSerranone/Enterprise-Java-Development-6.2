package com.ironhack.bookService.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Book {

    /** Properties **/

    @Id
    private String isbn;

    private String title;
    private String author;
    private String genre;

    public Book() {
    }

    /** Constructor **/


    public Book(String isbn, String title, String author, String genre) {
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
    }

    /** Getters & Setters **/
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
