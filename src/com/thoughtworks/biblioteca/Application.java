package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Application {

    Library library;
    PrintStream printStream;
    Console console;

    public Application(Library library, PrintStream printStream, Console console) {
        this.library = library;
        this.printStream = printStream;
        this.console = console;
    }

    public void start() {
        Map<String, MenuOption> menuOptions = new HashMap<String, MenuOption>();
        menuOptions.put("1", new ListBookOption(library));
        menuOptions.put("2", new CheckoutBookOption(library, printStream, console));

        console.displayWelcomeMessage();
        displayMenu();
        String input = console.getUserInput();

        while (!input.equals("Q")) {
            if (menuOptions.containsKey(input)) {
                menuOptions.get(input).execute();
            } else {
                printStream.println("Select a valid option!");
            }

            displayMenu();
            input = console.getUserInput();
        }
    }

    public void displayMenu() {
        printStream.println();
        printStream.println("1. List books");
        printStream.println("2. Checkout book");
        printStream.println("Q. Quit");
        printStream.println();
        printStream.print("Enter option number: ");
    }
}
