package com.sakila.models;

//Modelo Store
public final class Store extends Entity {

    private String name;

    public Store() {
    }

    public Store(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public String toString() {

        return name;
    }
}