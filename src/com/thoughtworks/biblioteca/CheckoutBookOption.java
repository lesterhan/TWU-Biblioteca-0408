package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class CheckoutBookOption implements MenuOption {

    private final PrintStream out;
    private final Library library;

    public CheckoutBookOption(Library library, PrintStream out) {
        this.library = library;
        this.out = out;
    }

    @Override
    public void execute() {
        library.displayBooksWithNumbers();
        out.print("Choose a book: ");
    }
}
