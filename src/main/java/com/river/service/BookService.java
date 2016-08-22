package com.river.service;

import com.river.beans.Book;

public interface BookService {
    Book addBook(Book book);
    Book getBook(String id);
}
