package com.sakila.utils;

/* Clase Menu
   Muestra las opciones principales del sistema.
   @author Lisbeth Sosa */
public class Menu {

    //Mostrar menu principal
    public static void showMainMenu() {
        System.out.println("\n========================================");
        System.out.println("===        SISTEMA SAKILA ORM        ===");
        System.out.println("========================================");
        System.out.println("1. Insertar actor");
        System.out.println("2. Buscar actor");
        System.out.println("3. Actualizar actor");
        System.out.println("4. Eliminar actor");
        System.out.println("5. Listar actores");
        System.out.println("6. Mostrar estadísticas");
        System.out.println("7. Exportar CSV");
        System.out.println("8. Exportar JSON");
        System.out.println("0. Salir");

        System.out.print("\nSeleccione una opción: ");
    }
}