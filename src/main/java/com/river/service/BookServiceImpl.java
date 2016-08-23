package com.river.service;

import com.river.exceptions.BookNotFoundException;
import com.river.repositories.BookDao;
import com.river.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao){
        this.bookDao = bookDao;
    }

    public Book addBook(Book book) {
        return bookDao.insert(book);
    }

    public Book getBook(String id) throws BookNotFoundException {
        Book book = bookDao.findOne(id);
        if(book == null)
            throw new BookNotFoundException();
        return bookDao.findOne(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookDao.findAll();
    }
}
