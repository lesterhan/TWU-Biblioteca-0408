package com.thoughtworks.biblioteca;

import java.io.PrintStream;

public class Application {

    Library library;
    PrintStream out;

    public Application(Library library, PrintStream out) {
        this.library = library;
        this.out = out;
    }

    public void start() {
        library.welcome();
        displayMenu();
    }

    private void displayMenu() {
        out.println("1. List books");
    }
}
