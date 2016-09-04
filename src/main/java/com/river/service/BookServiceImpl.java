package com.river.service;

import com.river.beans.Book;
import com.river.exceptions.BookNotFoundException;
import com.river.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBook(long id) throws BookNotFoundException {
        LOGGER.debug("Fetching book with id: {}", id);
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public void removeBook(long id) {
        LOGGER.debug("Removing book with id: {}", id);
        bookRepository.delete(id);
    }

    @Override
    public Iterable<Book> getBooks() {
        LOGGER.debug("Fetching all books");
        return bookRepository.findAll();
    }

    @Override
    public long addBook(Book book) {
        LOGGER.debug("Adding book: {}", book);
        return bookRepository.save(book).getId();
    }
}
