package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutMovieOptionTest {
    private Library library;
    private CheckoutMovieOption checkOutMovieOption;
    private PrintStream fakePrintStream;
    private Console console;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        fakePrintStream = mock(PrintStream.class);
        console = mock(Console.class);
        checkOutMovieOption = new CheckoutMovieOption(library, fakePrintStream, console);

        when(console.getUserInput()).thenReturn("1");
    }

    @Test
    public void shouldPromptUserOnExecute() {
        checkOutMovieOption.execute();
        verify(library).displayMoviesWithNumbers();
        verify(fakePrintStream).print("Choose a movie: ");
    }

    @Test
    public void shouldGetInputFromConsoleOnExecute() {
        checkOutMovieOption.execute();

        verify(console).getUserInput();
    }

    @Test
    public void shouldCheckoutMovieFromLibrary(){
        checkOutMovieOption.execute();
        verify(library).checkoutMovie(1);
    }

    @Test
    public void shouldDisplayMessageWhenCheckoutSuccessful() {
        when(library.checkoutMovie(1)).thenReturn(true);
        checkOutMovieOption.execute();
        verify(console).displaySuccessfulCheckout();

    }

    @Test
    public void shouldDisplayMessageWhenCheckoutUnsuccessful() {
        when(library.checkoutMovie(3)).thenReturn(false);
        checkOutMovieOption.execute();
        verify(console).displayUnsuccessfulCheckout();

    }
}