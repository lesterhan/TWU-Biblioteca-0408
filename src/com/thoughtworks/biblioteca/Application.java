package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Application {

    Library library;
    PrintStream out;
    BufferedReader in;

    public Application(Library library, PrintStream out, BufferedReader in) {
        this.library = library;
        this.out = out;
        this.in = in;
    }

    public void start() {
        library.welcome();
        displayMenu();
        String input = getInput();
        while (!input.equals("Q")) {
            if (input.equals("1")) {
                library.displayBooks();
            } else {
                out.println("Select a valid option!");
            }
            displayMenu();
            input = getInput();
        }
    }

    public void displayMenu() {
        out.println("1. List books");
        out.println("Q. Quit");
        out.print("Enter option number: ");
    }

    public String getInput() {
        try {
            return this.in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
