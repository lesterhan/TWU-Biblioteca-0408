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
        Library myLibrary = new Library(oneBook);

        myLibrary.displayBooks(fakePrintStream);

        verify(fakePrintStream).println("BookName");
    }

    @Test
    public void shouldPrintNothingWhenLibraryIsEmpty(){
        ArrayList<String> noBooks = new ArrayList<String>();
        Library myLibrary = new Library(noBooks);

        myLibrary.displayBooks(fakePrintStream);
        verify(fakePrintStream, times(0)).println();
    }

}