package com.sakila.models;

//Modelo City
public final class City extends Entity {

    private String city;

    //Foreign Key agregada
    private Country country;

    public City() {
    }

    public City(int id, String city, Country country) {

        this.id = id;
        this.city = city;
        this.country = country;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public Country getCountry() {

        return country;
    }

    public void setCountry(Country country) {

        this.country = country;
    }

    @Override
    public String toString() {

        return city + " - " + country;
    }
}