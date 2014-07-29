package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by kristinebrown on 7/29/14.
 *
 */
public class Library {
    private ArrayList<String> books;

    public Library(ArrayList<String> books) {

        this.books = books;
    }

    public void displayBooks(PrintStream out) {
        out.println(books.get(0));
    }
}
