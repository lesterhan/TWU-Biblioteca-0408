package com.thoughtworks.biblioteca;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldGetMovieDetails(){
        Movie movie1 = new Movie("The Matrix", "1999", "Wachowski's","8");
        assertThat(movie1.getDetails(), Matchers.containsString("The Matrix"));
        assertThat(movie1.getDetails(), Matchers.containsString("1999"));
        assertThat(movie1.getDetails(), Matchers.containsString("Wachowski's"));
        assertThat(movie1.getDetails(), Matchers.containsString("8"));
    }

    @Test
    public void shouldInsertEllipsesWhenMovieTitleIsTooLong(){

        Movie movie1 = new Movie("This is a really really really really really long book title!", "1999", "Alex Jablonskiiiiiiiiiiiiiiiiiiiiii","8");

        assertThat(movie1.getDetails(), Matchers.containsString("This is a really really rea..."));
        assertThat(movie1.getDetails(), Matchers.containsString("Alex Jablonskiiiiiiiiiiiiii..."));
    }

}