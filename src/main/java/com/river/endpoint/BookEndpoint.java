package com.river.endpoint;

import com.river.beans.Book;
import com.river.exceptions.BookNotFoundException;
import com.river.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class BookEndpoint {

    private BookService bookService;

    @Autowired
    public BookEndpoint(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books/{id}")
    public Book book(String id) throws BookNotFoundException {
        return bookService.getBook(id);
    }

    @RequestMapping("/books")
    public List<Book> books() {
        return bookService.getBooks();
    }
}
