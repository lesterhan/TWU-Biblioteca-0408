package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    private final PrintStream fakePrintStream = mock(PrintStream.class);

    @Test
    public void shouldPrintOneBookWhenLibraryHasOneBook(){
        ArrayList<String> oneBook = new ArrayList<String>();
        oneBook.add("BookName");
        Library myLibrary = new Library(oneBook);

        myLibrary.displayBooks(fakePrintStream);

        verify(fakePrintStream).println("BookName");
    }
}