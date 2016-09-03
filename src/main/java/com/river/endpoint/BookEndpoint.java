package com.river.endpoint;

import com.river.beans.Book;
import com.river.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookEndpoint.class);

    private BookService bookService;

    @Autowired
    public BookEndpoint(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping(value = "/books/{id}")
    public ResponseEntity<Object> book(@PathVariable("id") long id) {
        LOGGER.debug("Received request to fetch book with id: {}", id);
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> removeBook(@PathVariable("id") long id) {
        LOGGER.debug("Received request to remove book with id: {}", id);
        bookService.removeBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Book>> books() {
        LOGGER.debug("Received request to list all books");
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity createBook(@RequestBody Book book) {
        LOGGER.debug("Received request to add book: {}", book);
        long bookId = bookService.addBook(book);
        return new ResponseEntity<>(bookId, HttpStatus.CREATED);
    }

}
