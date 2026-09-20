import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.List;

public class LecturaArchivo {
    public static void main(String[] args) {
        Path ruta = Path.of("empresa.txt");
        // Método 1: Leer todo como String (Java 11+)
        try {
            String contenido = Files.readString(ruta,
                    StandardCharsets.UTF_8);
            System.out.println("=== Contenido completo ===");
            System.out.println(contenido);
        } catch (IOException e) {
            System.err.println("Error lectura: " + e.getMessage());
        }
        // Método 2: Leer línea por línea como List<String>
        try {
            List<String> lineas = Files.readAllLines(ruta,
                StandardCharsets.UTF_8);
            System.out.println("Total líneas: " + lineas.size());
            for (int i = 0; i < lineas.size(); i++) {
                System.out.printf("[%2d] %s%n", i + 1, lineas.get(i));
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
