package com.ironhack.bookService.controller.interfaces;

import com.ironhack.bookService.controller.dto.BookDto;

public interface IBookController {

    public BookDto getBook(String isbn);
}
