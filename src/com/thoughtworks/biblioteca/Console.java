package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Console {


    private BufferedReader reader;
    private PrintStream printStream;

    public Console(BufferedReader reader, PrintStream printStream) {
        this.reader = reader;
        this.printStream = printStream;
    }



    public String getUserInput() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void displayWelcomeMessage() {
        printStream.println("Welcome!");
    }
}
