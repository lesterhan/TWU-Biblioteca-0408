package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    private PrintStream fakePrintStream;
    private List<Book> books;
    private Book book1;
    private Library myLibrary;


    @Before
    public void setup(){
        fakePrintStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        book1 = mock(Book.class);
        books.add(book1);
        myLibrary = new Library(books, fakePrintStream);
    }

    @Test
    public void shouldPrintOneBookWhenLibraryHasOneBook() {

        myLibrary.displayBooks();

        verify(book1).getDetails();
    }

    @Test
    public void shouldPrintBooksWhenLibraryHasMultipleBooks(){
        Book book2 = mock(Book.class);
        books.add(book2);

        myLibrary.displayBooks();

        verifyBookListPrinted(books);
    }

    @Test
    public void shouldListBooksWithNumbers() {
        Book book2 = mock(Book.class);
        books.add(book2);

        myLibrary.displayBooksWithNumbers();

        verifyBookListPrinted(books);

        verify(fakePrintStream).print("1. ");
        verify(fakePrintStream).print("2. ");
    }

    @Test
    public void shouldPrintNothingWhenLibraryIsEmpty(){
        List<Book> noBooks = new ArrayList<Book>();
        Library myLibrary = new Library(noBooks, fakePrintStream);

        myLibrary.displayBooks();
        verify(fakePrintStream, times(0)).println();
    }

    @Test
    public void welcomeMessage(){
        myLibrary.welcome();

        verify(fakePrintStream).println("Welcome!");
    }

    @Test
    public void shouldRemoveCorrectBookWhenValidUserChoicePassed() {
        Book book2 = mock(Book.class);
        books.add(book2);

        boolean checkedOut = myLibrary.checkoutBook(1);

        assertEquals(checkedOut, true);
        assertEquals(books.size(), 1);
        assertEquals(books.get(0), book2);
    }

    @Test
    public void shouldReturnFalseWhenInvalidUserChoicePassed() {
        Book book2 = mock(Book.class);
        books.add(book2);

        boolean checkedOut = myLibrary.checkoutBook(10);

        assertEquals(checkedOut, false);
        assertEquals(books.size(), 2);

    }

    private void verifyBookListPrinted(List<Book> books) {
        for (Book book : books) {
            verify(book).getDetails();
        }
    }
}