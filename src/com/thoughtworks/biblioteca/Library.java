package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by kristinebrown on 7/29/14.
 *
 */
public class Library {
    private List<String> books;
    private PrintStream out;

    public Library(List<String> books, PrintStream out) {

        this.books = books;
        this.out = out;
    }

    public void welcome() {
        out.println("Welcome!");
    }

    public void displayBooks() {
        for (String book : books) {
            out.println(book);
        }
    }
}
