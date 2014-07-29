package com.thoughtworks.biblioteca;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> listOfBooks = new ArrayList<String>();
        listOfBooks.add("Book 1");
        listOfBooks.add("Book 2");
        Library library = new Library(listOfBooks);
        library.displayBooks(System.out);
    }
}
