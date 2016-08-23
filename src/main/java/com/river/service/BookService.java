package com.river.service;

import com.river.beans.Book;
import com.river.exceptions.BookNotFoundException;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book getBook(String id) throws BookNotFoundException;
    List<Book> getBooks();
}
