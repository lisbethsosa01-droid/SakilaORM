package com.sakila.models;

//Modelo Country
public final class Country extends Entity {

    private String country;

    public Country() {
    }

    public Country(int id, String country) {

        this.id = id;
        this.country = country;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    @Override
    public String toString() {

        return country;
    }
}