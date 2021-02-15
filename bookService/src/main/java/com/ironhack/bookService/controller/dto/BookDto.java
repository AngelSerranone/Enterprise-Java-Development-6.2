package com.ironhack.bookService.controller.dto;

import com.sun.istack.NotNull;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class BookDto {

    /** Properties **/

    @Id
    @NotNull
    @NotEmpty
    private String isbn;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String author;

    @NotNull
    @NotEmpty
    private String genre;

    @NotNull
    private String[] formats;

    /** Constructor **/
    public BookDto() {
    }

    public BookDto(@NotEmpty String isbn, @NotEmpty String title, @NotEmpty String author, @NotEmpty String genre) {
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

    public String[] getFormats() {
        return formats;
    }

    public void setFormats(String[] formats) {
        this.formats = formats;
    }
}
