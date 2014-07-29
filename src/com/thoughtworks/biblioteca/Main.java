package com.thoughtworks.biblioteca;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Application(library()).start();
    }

    private static Library library() {
        List<Book> listOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Book 1", "", "");
        Book book2 = new Book("Book 2", "", "");
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        return new Library(listOfBooks, System.out);
    }
}
