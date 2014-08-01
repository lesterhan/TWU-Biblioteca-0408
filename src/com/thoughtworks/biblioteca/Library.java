package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private List<Book> books;
    private PrintStream printStream;

    public Library(List<Book> books, PrintStream printStream) {

        this.books = books;
        this.printStream = printStream;
    }

    public void displayBooks() {
        for (Book book : books) {
            printStream.println(book.getDetails());
        }
    }

    public void displayBooksWithNumbers() {
        for (int i=1; i<=books.size(); i++) {
            printStream.print(i + ". ");
            printStream.println(books.get(i - 1).getDetails());
        }
    }

    public boolean checkoutBook(int userChoice) {
        int id = userChoice - 1;
        if (id < books.size() && id >= 0) {
            books.remove(id);
            return true;
        }
        return false;
    }
}
