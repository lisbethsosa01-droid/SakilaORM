package com.sakila.reports;
import com.google.gson.Gson;
import com.sakila.models.Actor;
import java.io.FileWriter;
import java.util.List;

//Exportador JSON.
public class JsonExport {

    /* Exportar actores a JSON.
       @param list lista actores */
    public static void exportActors(List<Actor> list) {

        try {

            Gson gson = new Gson();
            String json = gson.toJson(list);
            FileWriter writer = new FileWriter("actors.json");
            writer.write(json);
            writer.close();
            System.out.println("JSON exportado correctamente.");

        } catch (Exception e) {

            System.out.println("Error exportando JSON:");
            System.out.println(e.getMessage());
        }
    }
}