package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class CheckoutBookOption implements MenuOption {

    private final PrintStream out;
    private final Library library;
    private final Console console;

    public CheckoutBookOption(Library library, PrintStream out, Console console) {
        this.library = library;
        this.out = out;
        this.console = console;
    }

    @Override
    public void execute() {
        library.displayBooksWithNumbers();
        out.print("Choose a book: ");
        String userInput = console.getUserInput();
        library.checkoutBook(Integer.parseInt(userInput));
    }
}
