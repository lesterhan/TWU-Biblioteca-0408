package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    private PrintStream fakePrintStream;


    @Before
    public void setup(){
        fakePrintStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintOneBookWhenLibraryHasOneBook(){
        List<Book> oneBook = new ArrayList<Book>();
        Book book1 = new Book("BookName", "BookAuthor", "2000");
        oneBook.add(book1);
        Library myLibrary = new Library(oneBook, fakePrintStream);

        myLibrary.displayBooks();
        verify(fakePrintStream).println("BookName                       BookAuthor                     2000");
    }

    @Test
    public void shouldPrintNothingWhenLibraryIsEmpty(){
        List<Book> noBooks = new ArrayList<Book>();
        Library myLibrary = new Library(noBooks, fakePrintStream);

        myLibrary.displayBooks();
        verify(fakePrintStream, times(0)).println();
    }

    @Test
    public void welcomeMessage(){
        List<Book> books = new ArrayList<Book>();
        Library myLibrary = new Library(books, fakePrintStream);

        myLibrary.welcome();
        verify(fakePrintStream).println("Welcome!");
    }

}