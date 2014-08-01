package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Application {

    Library library;
    PrintStream out;
    BufferedReader in;
    Console console;

    public Application(Library library, PrintStream out, BufferedReader in, Console console) {
        this.library = library;
        this.out = out;
        this.in = in;
        this.console = console;
    }

    public void start() {
        Map<String, MenuOption> menuOptions = new HashMap<String, MenuOption>();
        menuOptions.put("1", new ListBookOption(library));
        menuOptions.put("2", new CheckoutBookOption(library, out, console));

        library.welcome();
        displayMenu();
        String input = console.getUserInput();

        while (!input.equals("Q")) {
            if (menuOptions.containsKey(input)) {
                menuOptions.get(input).execute();
            } else {
                out.println("Select a valid option!");
            }

            displayMenu();
            input = console.getUserInput();
        }
    }

    public void displayMenu() {
        out.println("1. List books");
        out.println("2. Checkout book");
        out.println("Q. Quit");
        out.print("Enter option number: ");
    }
}
