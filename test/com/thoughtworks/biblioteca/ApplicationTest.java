package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    private Library library;
    private Application application;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        application = new Application(library);
    }

    @Test
    public void shouldWelcomeUserWhenStarting(){
        application.start();
        verify(library).welcome();
    }

    @Test
    public void shouldDisplayBooksWhenStarting(){
        application.start();
        verify(library).displayBooks();
    }

}