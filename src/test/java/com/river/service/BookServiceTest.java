package com.river.service;

import com.river.beans.Book;
import com.river.repositories.BookDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookDao bookDaoMock;

    @InjectMocks
    private BookServiceImpl classUnderTest;

    private String givenBookId = "12345";

    @Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
        classUnderTest = new BookServiceImpl(bookDaoMock);
    }

    @Test
    public void whenSaveBookThenReturnBookInstanceReturned() {
        Book givenBook = new Book();
        when(bookDaoMock.insert(givenBook)).thenReturn(null);
        classUnderTest.addBook(givenBook);
        verify(bookDaoMock, times(1)).insert(givenBook);
    }

    @Test
    public void whenGetBookThenReturnBookInstance() {
        when(bookDaoMock.findOne(anyString())).thenReturn(new Book());
        Book book = classUnderTest.getBook(givenBookId);
        assertNotNull(book);
    }
}
