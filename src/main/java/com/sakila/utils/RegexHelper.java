package com.sakila.utils;
/* Clase de validaciones con expresiones regulares
   Utilidad general del sistema Sakila ORM */
public class RegexHelper {

    // Evita instanciación
    private RegexHelper() {
    }

    /* Validar email */
    public static boolean isValidEmail(String email) {

        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    /* Validar teléfono (10 dígitos) */
    public static boolean isValidPhone(String phone) {

        return phone.matches("^[0-9]{10}$");
    }

    /* Validar números */
    public static boolean isNumeric(String value) {

        return value.matches("^[0-9]+$");
    }
}