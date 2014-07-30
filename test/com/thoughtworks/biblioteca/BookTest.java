package com.thoughtworks.biblioteca;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void shouldGetBookDetails(){
        Book book = new Book("Book Name", "Book Author", "2000");
        assertThat(book.getDetails(), CoreMatchers.containsString("Book Name"));
        assertThat(book.getDetails(), CoreMatchers.containsString("Book Author"));
        assertThat(book.getDetails(), CoreMatchers.containsString("2000"));
    }

    @Test
    public void shouldInsertEllipsesWhenBookTitleIsTooLong(){
        Book book = new Book("This is a really really really really really long book title!",
                "Alex Jablonskiiiiiiiiiiiiiiiiiiiiii",
                "2000");
        assertThat(book.getDetails(), CoreMatchers.containsString("This is a really really rea..."));
        assertThat(book.getDetails(), CoreMatchers.containsString("Alex Jablonskiiiiiiiiiiiiii..."));
        assertThat(book.getDetails(), CoreMatchers.containsString("2000"));
    }
}