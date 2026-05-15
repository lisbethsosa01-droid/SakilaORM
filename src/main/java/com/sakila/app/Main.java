package com.sakila.app;
import com.sakila.controllers.ActorController;
import com.sakila.controllers.FilmController;
import com.sakila.controllers.CustomerController;
import com.sakila.controllers.RentalController;
import com.sakila.models.Actor;
import com.sakila.utils.Menu;
import com.sakila.reports.CsvExport;
import com.sakila.reports.JsonExport;
import java.util.Scanner;

//Clase principal del sistema.
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

                    boolean inserted = controller.post(actor);
                    System.out.println();

                    if (inserted) {

                        System.out.println("Actor insertado correctamente.");

                    } else {

                        System.out.println("Error al insertar actor.");
                    }

                    break;

                case 2:

                    System.out.println("\n=== BUSCAR ACTOR ===\n");
                    System.out.print("ID Actor: ");

                    int idSearch = sc.nextInt();
                    Actor found = controller.get(idSearch);
                    System.out.println();

                    if (found != null) {

                        System.out.println("Actor encontrado:");
                        System.out.println(found);

                    } else {

                        System.out.println("Actor no encontrado.");
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
                    boolean updated = controller.put(updateActor);

                    System.out.println();

                    if (updated) {

                        System.out.println("Actor actualizado correctamente.");

                    } else {

                        System.out.println("No se pudo actualizar actor.");
                    }

                    break;

                case 4:

                    System.out.println("\n=== ELIMINAR ACTOR ===\n");
                    System.out.print("ID Actor: ");
                    int idDelete = sc.nextInt();
                    boolean deleted = controller.delete(idDelete);
                    System.out.println();

                    if (deleted) {

                        System.out.println("Actor eliminado correctamente.");

                    } else {

                        System.out.println("No se pudo eliminar actor.");
                    }

                    break;

                case 5:

                    System.out.println("\n=== LISTADO ACTORES ===\n");
                    controller.get().forEach(System.out::println);

                    break;

                case 6:

                    System.out.println("\n=== ESTADÍSTICAS ===\n");
                    int totalActors = controller.get().size();
                    System.out.println("Total actores registrados: " + totalActors);

                    break;

                case 7:

                    System.out.println("\n=== EXPORT CSV ===\n");
                    CsvExport.exportActors(controller.get());

                    break;

                case 8:

                    System.out.println("\n=== EXPORT JSON ===\n");
                    JsonExport.exportActors(controller.get());

                    break;

                case 9:

                    FilmController filmController = new FilmController();

                    System.out.println("\n=== PELÍCULAS ===\n");
                    filmController.get().forEach(System.out::println);

                    break;

                case 10:

                    CustomerController customerController = new CustomerController();
                    System.out.println("\n=== CLIENTES ===\n");
                    customerController.get().forEach(c -> System.out.println(c.getId() + " "
                                                    + c.getFirstName() + " "
                                                    + c.getLastName()));

                    break;

                case 11:

                    RentalController rentalController = new RentalController();
                    System.out.println("\n=== RENTAS ===\n");
                    rentalController.get().forEach(System.out::println);

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