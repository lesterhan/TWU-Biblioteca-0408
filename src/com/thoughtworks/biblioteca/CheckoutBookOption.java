package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class CheckoutBookOption implements MenuOption {

    private final PrintStream printStream;
    private final Library library;
    private final Console console;

    public CheckoutBookOption(Library library, PrintStream printStream, Console console) {
        this.library = library;
        this.printStream = printStream;
        this.console = console;
    }

    @Override
    public void execute() {
        library.displayBooksWithNumbers();
        printStream.print("Choose a book: ");
        String userInput = console.getUserInput();
        if(library.checkoutBook(Integer.parseInt(userInput))) {
            console.displaySuccessfulCheckout();
        } else {
            console.displayUnsuccessfulCheckout();
        }
    }
}
