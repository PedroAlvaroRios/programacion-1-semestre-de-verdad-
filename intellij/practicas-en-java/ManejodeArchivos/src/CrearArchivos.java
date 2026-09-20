import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class CrearArchivos
{
    public static void main(String[] args)
    {
        Path ruta = Path.of("empresa.txt"); // Java 11+ Path.of()
        String contenido = """
                4   Empresa: AgroBolivia S.A.
                Ciudad: Santa Cruz de la Sierra
                NIT: 1234567890
                Rubro: Exportación de granos
                Capital: 2.500.000,00 BOB
                """; // Text Block (Java 15+)
        try {
            Files.writeString(ruta, contenido, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Archivo creado exitosamente: " +
                    ruta.toAbsolutePath());
            System.out.println("Tamaño: " + Files.size(ruta) + " bytes");
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }
}