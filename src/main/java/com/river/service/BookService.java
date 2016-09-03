package com.river.service;

import com.river.beans.Book;
import com.river.exceptions.BookNotFoundException;

public interface BookService {
    long addBook(Book book);
    void removeBook(long id);
    Book getBook(long id) throws BookNotFoundException;
    Iterable<Book> getBooks();
}
