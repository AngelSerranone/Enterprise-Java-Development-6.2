package com.ironhack.bookFormatService.controller.dto;

import com.sun.istack.NotNull;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class BookFormatDto {

    /** Properties **/

    @Id
    @NotNull
    @NotEmpty
    private String isbn;

    @NotNull
    @NotEmpty
    private String[] formats;

    /** Constructor **/
    public BookFormatDto() {
    }

    public BookFormatDto(@NotEmpty String isbn, @NotEmpty String[] formats) {
        setIsbn(isbn);
        setFormats(formats);
    }

    /** Getters & Setters **/

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String[] getFormats() {
        return formats;
    }

    public void setFormats(String[] formats) {
        this.formats = formats;
    }
}
