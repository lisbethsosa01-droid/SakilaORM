package com.sakila.models;

    /* Clase padre de entidades
       Representa la estructura base de todas las tablas */
public abstract class Entity {

    protected int id;

    // constructor vacío base
    public Entity() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
}