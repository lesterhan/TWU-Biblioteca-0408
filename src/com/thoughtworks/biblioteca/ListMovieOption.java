package com.thoughtworks.biblioteca;

/**
 * Created by hanlei on 8/4/14.
 */
public class ListMovieOption implements MenuOption{

    Library library;

    public ListMovieOption(Library library) {
        this.library = library;
    }
    @Override
    public void execute() {
        library.displayMovies();
    }
}
