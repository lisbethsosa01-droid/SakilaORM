package com.sakila.app;
import com.sakila.controllers.ActorController;
import com.sakila.models.Actor;
import com.sakila.reports.CsvExport;
import com.sakila.reports.JsonExport;
import com.sakila.reports.Statistics;
import com.sakila.utils.Menu;
import java.util.Scanner;

/* Clase principal del sistema.
   @author Lisbeth Sosa */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ActorController controller = new ActorController();

        int option;

        do {

            Menu.showMainMenu();

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:

                    System.out.println("\n=== INSERTAR ACTOR ===\n");
                    Actor actor = new Actor();
                    System.out.print("Nombre: ");
                    actor.setFirstName(sc.nextLine());
                    System.out.print("Apellido: ");
                    actor.setLastName(sc.nextLine());

                    if (controller.post(actor)) {

                        System.out.println("\nActor insertado correctamente.");

                    } else {

                        System.out.println("\nError al insertar actor.");
                    }

                    break;

                case 2:

                    System.out.println("\n=== BUSCAR ACTOR ===\n");
                    System.out.print("ID Actor: ");

                    int idSearch = sc.nextInt();

                    Actor found = controller.get(idSearch);

                    if (found != null) {

                        System.out.println("\nActor encontrado:");
                        System.out.println(found);

                    } else {

                        System.out.println("\nActor no encontrado.");
                    }

                    break;

                case 3:

                    System.out.println("\n=== ACTUALIZAR ACTOR ===\n");
                    System.out.print("ID Actor: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();

                    Actor updateActor = new Actor();
                    updateActor.setId(idUpdate);
                    System.out.print("Nuevo nombre: ");
                    updateActor.setFirstName(sc.nextLine());
                    System.out.print("Nuevo apellido: ");
                    updateActor.setLastName(sc.nextLine());

                    if (controller.put(updateActor)) {

                        System.out.println("\nActor actualizado correctamente.");

                    } else {

                        System.out.println("\nNo se pudo actualizar actor.");
                    }

                    break;

                case 4:

                    System.out.println("\n=== ELIMINAR ACTOR ===\n");
                    System.out.print("ID Actor: ");

                    int idDelete = sc.nextInt();

                    if (controller.delete(idDelete)) {

                        System.out.println("\nActor eliminado correctamente.");

                    } else {

                        System.out.println("\nNo se pudo eliminar actor.");
                    }

                    break;

                case 5:

                    System.out.println("\n=== LISTADO ACTORES ===\n");
                    controller.get().forEach(System.out::println);

                    break;

                case 6:

                    System.out.println("\n=== ESTADÍSTICAS ===\n");
                    System.out.println("Total actores: " + Statistics.totalActors());

                    break;

                case 7:

                    System.out.println("\n=== EXPORTAR CSV ===\n");
                    CsvExport.exportActors(controller.get());

                    break;

                case 8:

                    System.out.println("\n=== EXPORTAR JSON ===\n");
                    JsonExport.exportActors(controller.get());

                    break;

                case 0:

                    System.out.println("\nSaliendo del sistema...");

                    break;

                default:

                    System.out.println("\nOpción inválida.");
            }

        } while (option != 0);

        sc.close();
    }
}