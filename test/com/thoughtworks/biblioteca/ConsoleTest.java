package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsoleTest {

    private Console console;
    private BufferedReader reader;

    @Before
    public void setUp() throws Exception {
        reader = mock(BufferedReader.class);
        console = new Console(reader);
    }

    @Test
    public void shouldReturn3WhenUserInput3() throws Exception {
        when(reader.readLine()).thenReturn("3");
        assertThat(console.getUserInput(), is("3"));
    }
}