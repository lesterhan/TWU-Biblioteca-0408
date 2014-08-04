package com.thoughtworks.biblioteca;

import java.io.PrintStream;

/**
 * Created by hanlei on 8/4/14.
 */
public class CheckoutMovieOption implements MenuOption {
    private Console console;
    private Library library;
    private PrintStream printStream;

    public CheckoutMovieOption(Library library, PrintStream printStream, Console console) {
        this.printStream = printStream;
        this.console = console;
        this.library = library;
    }

    @Override
    public void execute() {
        library.displayMoviesWithNumbers();
        printStream.print("Choose a movie: ");
        String userInput = console.getUserInput();
        if (library.checkoutMovie(Integer.parseInt(userInput))) {
            console.displaySuccessfulCheckout();
        } else {
            console.displayUnsuccessfulCheckout();

        }
    }
}
