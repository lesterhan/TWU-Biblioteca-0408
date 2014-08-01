package com.thoughtworks.biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class ApplicationTest {

    private Library library;
    private Application application;
    private PrintStream fakePrintStream;
    private Console fakeConsole;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        fakePrintStream = mock(PrintStream.class);
        fakeConsole = mock(Console.class);
        application = new Application(library, fakePrintStream, fakeConsole);

        when(fakeConsole.getUserInput()).thenReturn("1").thenReturn("Q");
    }

    @Test
    public void shouldWelcomeUserWhenStarting(){
        application.start();

        verify(fakeConsole).displayWelcomeMessage();
    }

    @Test
    public void shouldDisplayMenuWhenStarting(){
        application.start();
        verifyMenuDisplayedTimes(2);
    }

    @Test
    public void shouldGetUserInput(){
        when(fakeConsole.getUserInput()).thenReturn("Q");

        application.start();

        verify(fakeConsole).getUserInput();
    }

    @Test
    public void shouldDisplayBooksWhenOption1IsChosen(){
        application.start();

        verify(library).displayBooks();
    }

    @Test
    public void shouldPrintErrorMessageWhenInvalidOptionIsChosen() {
        when(fakeConsole.getUserInput()).thenReturn("X").thenReturn("1").thenReturn("Q");

        application.start();
        verify(fakePrintStream).println("Select a valid option!");
        verifyMenuDisplayedTimes(3);
        verify(library).displayBooks();
    }

    @Test
    public void shouldLoopUntilQuit() {
        when(fakeConsole.getUserInput()).thenReturn("1").thenReturn("1").thenReturn("Q");

        application.start();

        verifyMenuDisplayedTimes(3);
        verify(library, times(2)).displayBooks();
    }

    private void verifyMenuDisplayedTimes(int t) {
        verify(fakePrintStream, times(t)).println("1. List books");
        verify(fakePrintStream, times(t)).println("2. Checkout book");
        verify(fakePrintStream, times(t)).println("Q. Quit");
        verify(fakePrintStream, times(t)).print("Enter option number: ");
    }

}