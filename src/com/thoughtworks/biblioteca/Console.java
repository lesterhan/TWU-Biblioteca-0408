package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

public class Console {


    private BufferedReader reader;

    public Console(BufferedReader reader) {
        this.reader = reader;
    }

    public String getUserInput() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
