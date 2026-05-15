package com.sakila.models;

//Modelo Film
public final class Film extends Entity {

    private String title;
    private String description;
    private int releaseYear;

    public Film() {
    }

    public Film(int id, String title, String description, int releaseYear) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public int getReleaseYear() {

        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {

        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {

        return id + " " + title;
    }
}