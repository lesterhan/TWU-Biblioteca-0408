package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

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
        ArrayList<String> oneBook = new ArrayList<String>();
        oneBook.add("BookName");
        Library myLibrary = new Library(oneBook, fakePrintStream);

        myLibrary.displayBooks();
        verify(fakePrintStream).println("BookName");
    }

    @Test
    public void shouldPrintNothingWhenLibraryIsEmpty(){
        ArrayList<String> noBooks = new ArrayList<String>();
        Library myLibrary = new Library(noBooks, fakePrintStream);

        myLibrary.displayBooks();
        verify(fakePrintStream, times(0)).println();
    }

    @Test
    public void welcomeMessage(){
        ArrayList<String> books = new ArrayList<String>();
        Library myLibrary = new Library(books, fakePrintStream);

        myLibrary.welcome();
        verify(fakePrintStream).println("Welcome!");
    }

}