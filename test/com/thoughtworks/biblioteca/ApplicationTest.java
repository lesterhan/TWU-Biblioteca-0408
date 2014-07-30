package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    private Library library;
    private Application application;
    private PrintStream fakePrintStream;
    private BufferedReader fakeInputStream;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        fakePrintStream = mock(PrintStream.class);
        fakeInputStream = new BufferedReader(new StringReader("1"));
        application = new Application(library, fakePrintStream, fakeInputStream);
    }

    @Test
    public void shouldWelcomeUserWhenStarting(){
        application.start();
        verify(library).welcome();
    }

    @Test
    public void shouldDisplayMenuWhenStarting(){
        application.start();
        verify(fakePrintStream).println("1. List books");
    }

    @Test
    public void shouldGetUserInputWhenMenuDisplays(){
        application.displayMenu();
        assertThat(application.getInput(), is("1"));
    }

    @Test
    public void shouldDisplayBooksWhenOption1IsChosen(){
        application.displayMenu();
        verify(library).displayBooks();
    }

    @Test
    public void shouldPrintErrorMessageWhenInvalidOptionIsChosen() {
        Application app = new Application(library, fakePrintStream, new BufferedReader(new StringReader("2")));
        app.displayMenu();
        verify(fakePrintStream).println("Error, invalid input!");
    }

}