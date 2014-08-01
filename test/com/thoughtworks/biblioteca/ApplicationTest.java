package com.thoughtworks.biblioteca;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    private Library library;
    private Application application;
    private PrintStream fakePrintStream;
    private BufferedReader fakeInputStream;
    private Console fakeConsole;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        fakePrintStream = mock(PrintStream.class);
        fakeInputStream = new BufferedReader(new StringReader("1\nQ"));
        fakeConsole = mock(Console.class);
        application = new Application(library, fakePrintStream, fakeInputStream, fakeConsole);
    }

    @Test
    public void shouldWelcomeUserWhenStarting(){
        application.start();

        verify(library).welcome();
    }

    @Test
    public void shouldDisplayMenuWhenStarting(){
        application.start();
        verifyMenuDisplayedTimes(2);
    }

    @Test
    public void shouldGetUserInput(){
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
        Application app = new Application(library, fakePrintStream, new BufferedReader(new StringReader("X\n1\nQ")), fakeConsole);

        app.start();
        verify(fakePrintStream).println("Select a valid option!");
        verifyMenuDisplayedTimes(3);
        verify(library).displayBooks();
    }

    @Test
    public void shouldLoopUntilQuit() {
        Application app = new Application(library, fakePrintStream, new BufferedReader(new StringReader("1\n1\nQ")), fakeConsole);

        app.start();

        verifyMenuDisplayedTimes(3);
        verify(library, times(2)).displayBooks();
    }

    @Test
    public void shouldPromptUserWhenCheckoutSelected() {
        Application app = new Application(library, fakePrintStream, new BufferedReader(new StringReader("2\nQ")), fakeConsole);

        CheckoutBookOption checkoutBookOption = mock(CheckoutBookOption.class);

        app.start();

        verify(checkoutBookOption).execute();
    }

    private void verifyMenuDisplayedTimes(int t) {
        verify(fakePrintStream, times(t)).println("1. List books");
        verify(fakePrintStream, times(t)).println("2. Checkout book");
        verify(fakePrintStream, times(t)).println("Q. Quit");
        verify(fakePrintStream, times(t)).print("Enter option number: ");
    }

}