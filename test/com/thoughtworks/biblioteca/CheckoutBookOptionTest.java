package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutBookOptionTest {

    private Library library;
    private CheckoutBookOption checkoutBookOption;
    private PrintStream fakePrintStream;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        fakePrintStream = mock(PrintStream.class);
        checkoutBookOption = new CheckoutBookOption(library, fakePrintStream);
    }

    @Test
    public void shouldPromptUserOnExecute() {
        checkoutBookOption.execute();
        verify(library).displayBooksWithNumbers();
        verify(fakePrintStream).print("Choose a book: ");
    }
}