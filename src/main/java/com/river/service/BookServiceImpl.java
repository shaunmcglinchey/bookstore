package com.river.service;

import com.river.repositories.BookDao;
import com.river.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao){
        this.bookDao = bookDao;
    }

    public Book addBook(Book book) {
        return bookDao.insert(book);
    }

    public Book getBook(String id) {
        return bookDao.findOne(id);
    }
}
