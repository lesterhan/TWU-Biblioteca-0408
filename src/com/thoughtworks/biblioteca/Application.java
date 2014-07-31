package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, MenuOption> menuOptions = new HashMap<String, MenuOption>();
        menuOptions.put("1", new ListBookOption(library));
        menuOptions.put("2", new CheckoutBookOption(library, out));

        library.welcome();
        displayMenu();
        String input = getInput();

        while (!input.equals("Q")) {
            if (!menuOptions.containsKey(input)) {
                out.println("Select a valid option!");
            } else {
                menuOptions.get(input).execute();
            }

            displayMenu();
            input = getInput();
        }
    }

    public void displayMenu() {
        out.println("1. List books");
        out.println("2. Checkout book");
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
