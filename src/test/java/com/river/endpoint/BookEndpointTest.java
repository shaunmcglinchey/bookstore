package com.river.endpoint;

import com.river.beans.Book;
import com.river.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookEndpointTest {

    @Mock
    private BookService bookServiceMock;

    @InjectMocks
    private BookEndpoint classUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new BookEndpoint(bookServiceMock);
    }

    @Test
    public void whenBookThenReturnBook() {
        Book expectedBook = new Book();
        when(bookServiceMock.getBook(anyString())).thenReturn(expectedBook);
        Book actualBook = classUnderTest.book("Catch 22");
        assertEquals(expectedBook, actualBook);
        verify(bookServiceMock, times(1)).getBook(anyString());
    }

    @Test
    public void whenBooksThenReturnListOfBooks() {
        List<Book> expectedBooks = Arrays.asList(new Book(), new Book());
        when(bookServiceMock.getBooks()).thenReturn(expectedBooks);
        List<Book> actualBooks = classUnderTest.books();
        assertEquals(expectedBooks, actualBooks);
        verify(bookServiceMock, times(1)).getBooks();
    }
}
