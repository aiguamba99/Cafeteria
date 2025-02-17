package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    public static void guardarHistorial(Orden orden) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("historial.txt", true))) {
            StringBuilder historial = new StringBuilder();
            historial.append("Mesa ").append(orden.getNumeroMesa()).append(": ");
            for (Item item : orden.getItems()) {
                historial.append(item.getNombre()).append(" ($").append(item.getPrecio()).append("), ");
            }
            historial.append("Total: $").append(orden.getPrecioTotal());
            writer.write(historial.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarHistorial() {
        try {
            Files.deleteIfExists(Paths.get("historial.txt")); // Eliminar el archivo de historial
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}