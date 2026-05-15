package com.sakila.utils;

/* Clase de validaciones con expresiones regulares.
   Proyecto Sakila ORM */
public class RegexHelper {

    /* Validar correo electronico.
       @param email correo a validar
       @return true si es valido */
    public static boolean isValidEmail(String email) {

        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    /* Validar telefono.
       @param phone telefono
       @return true si es valido */
    public static boolean isValidPhone(String phone) {

        return phone.matches("^[0-9]{10}$");
    }

    /* Validar numeros solamente.
       @param value valor
       @return true si es numerico */
    public static boolean isNumeric(String value) {

        return value.matches("^[0-9]+$");
    }
}