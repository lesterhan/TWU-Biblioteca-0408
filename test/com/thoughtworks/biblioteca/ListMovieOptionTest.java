package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListMovieOptionTest {

    private Library library;
    private ListMovieOption listMovieOption;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        listMovieOption = new ListMovieOption(library);
    }

    @Test
    public void shouldListMoviesOnExecute() {
        listMovieOption.execute();

        verify(library).displayMovies();
    }
}