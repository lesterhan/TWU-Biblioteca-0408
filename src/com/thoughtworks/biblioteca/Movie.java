package com.thoughtworks.biblioteca;

/**
 * Created by hanlei on 8/4/14.
 */
public class Movie {


    private String name;
    private String year;
    private String director;
    private String rating;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getDetails() {
        String nameToPrint = shortenTextIfNecessary(name);
        String directorToPrint = shortenTextIfNecessary(director);
        return String.format("%-30s %-30s %-4s %-2s", nameToPrint, directorToPrint, year, rating);
    }

    private String shortenTextIfNecessary(String text) {
        if (text.length() > 30) {
            return text.substring(0, 27) + "...";
        } else {
            return text;
        }
    }

}
