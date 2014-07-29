package com.thoughtworks.biblioteca;

public class Application {

    Library library;

    public Application(Library library) {
        this.library = library;
    }



    public void start() {
        library.welcome();
        library.displayBooks();
    }
}
