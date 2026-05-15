package com.sakila.models;

//Modelo Inventory
public final class Inventory extends Entity {

    private Film film;
    private Store store;

    public Inventory() {
    }

    public Inventory(int id, Film film, Store store) {

        this.id = id;
        this.film = film;
        this.store = store;
    }

    public Film getFilm() {

        return film;
    }

    public void setFilm(Film film) {

        this.film = film;
    }

    public Store getStore() {

        return store;
    }

    public void setStore(Store store) {

        this.store = store;
    }

    @Override
    public String toString() {

        return "Inventory ID: " + id;
    }
}