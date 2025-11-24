import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class CSVLoader {

    public static List<String> cargarLineas(String fileName) {
        try {
            // Intenta leer desde la raíz del proyecto (donde suelen estar los CSV)
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            // Si falla, intenta buscar en src (por si acaso)
            try {
                return Files.readAllLines(Paths.get("src/" + fileName));
            } catch (IOException ex) {
                throw new RuntimeException("Error crítico: No se encuentra el archivo " + fileName +
                        ". Asegúrate de que esté en la carpeta del proyecto.", ex);
            }
        }
    }
}