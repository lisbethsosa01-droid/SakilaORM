package com.sakila.reports;
import com.sakila.models.Actor;
import java.io.FileWriter;
import java.util.List;

/* Exportador CSV
   Genera archivo CSV con datos de actores */
public class CsvExport {

    /* Exportar listado de actores a CSV */
    public static void exportActors(List<Actor> list) {

        try {

            FileWriter writer = new FileWriter("actors.csv");
            writer.append("ID,FirstName,LastName\n");

            for (Actor actor : list) {

                writer.append(actor.getId() + ","
                              + actor.getFirstName() + ","
                              + actor.getLastName() + "\n");
            }

            writer.close();

            System.out.println("CSV exportado correctamente.");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}