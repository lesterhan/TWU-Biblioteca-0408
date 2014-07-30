package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void shouldGetBookDetails(){
        Book book = new Book("Book Name", "Book Author", "2000");
        assertEquals("Book Name                      Book Author                    2000", book.getDetails());
    }

    @Test
    public void shouldInsertEllipsesWhenBookTitleIsTooLong(){
        Book book = new Book("This is a really really really really really long book title!", "Book Author", "2000");
        assertEquals("This is a really really rea... Book Author                    2000", book.getDetails());
    }

    @Test
    public void shouldInsertEllipsesWhenBookAuthorIsTooLong(){
        Book book = new Book("Book Name", "Alex Jablonskiiiiiiiiiiiiiiiiiiiiii", "2000");
        assertEquals("Book Name                      Alex Jablonskiiiiiiiiiiiiii... 2000", book.getDetails());
    }
}