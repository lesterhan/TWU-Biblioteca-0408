package com.thoughtworks.biblioteca;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Application(library()).start();
    }

    private static Library library() {
        List<String> listOfBooks = new ArrayList<String>();
        listOfBooks.add("Book 1");
        listOfBooks.add("Book 2");
        return new Library(listOfBooks, System.out);
    }
}
