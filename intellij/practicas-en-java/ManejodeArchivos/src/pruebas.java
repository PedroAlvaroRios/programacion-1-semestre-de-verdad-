import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.*;

public class pruebas {
    public static void main(String[] args) {
        //nombres para los txt
        Path rutaEstudiantes = Path.of("Estudiantes.txt");
        Path rutaMaterias = Path.of("Materias.txt");

        String contenidoEstudiantes = """
                541241,Maria Eugenia Panoso,mariapanoso@gmail.com,101
                542586,Rodrigo Quinteros Sanchez,quinteros@gmail.com,202""";

        String contenidoMaterias = """
                101,Matemáticas
                202,Programación
                303,Física""";



        // --------------------------------------------------------
        // Leer materias y guardarlas en arreglos paralelos
        String[] codigosMaterias = new String[50];  // tamaño suficiente para el ejemplo
        String[] nombresMaterias = new String[50];
        int totalMaterias = 0;

        try {
            List<String> lineasMaterias = Files.readAllLines(rutaMaterias, StandardCharsets.UTF_8);
            for (String linea : lineasMaterias) {
                String[] partes = linea.split(",");
                if (partes.length >= 2) {
                    codigosMaterias[totalMaterias] = partes[0].trim();
                    nombresMaterias[totalMaterias] = partes[1].trim();
                    totalMaterias++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer materias: " + e.getMessage());
            return;
        }

        // --------------------------------------------------------
        // Leer estudiantes y mostrar junto con la materia
        System.out.println("Código Est | Nombre Completo               | Correo                     | Código Mat | Materia");
        try {
            List<String> lineas = Files.readAllLines(rutaEstudiantes, StandardCharsets.UTF_8);
            for (int i = 0; i < lineas.size(); i++) {
                String contenido = lineas.get(i);
                String[] datos = contenido.split(",");
                if (datos.length < 4) continue;  // necesitamos código, nombre, correo y código de materia

                String codigoEst = datos[0].trim();
                String nombreEst = datos[1].trim();
                String correoEst = datos[2].trim();
                String codigoMat = datos[3].trim();

                // Buscar el nombre de la materia en los arreglos
                String nombreMat = "Desconocida";
                for (int j = 0; j < totalMaterias; j++) {
                    if (codigosMaterias[j].equals(codigoMat)) {
                        nombreMat = nombresMaterias[j];
                        break;
                    }
                }

                // Imprimir la línea completa
                System.out.printf("%10s | %30s | %27s | %10s | %s%n",
                        codigoEst, nombreEst, correoEst, codigoMat, nombreMat);
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }

//hago una funcion para no tener que repetir codigo
    private static void contenido(Path est, Path mat, String contEst ,String contMat) {//lo definimos como un Path, importante porque lo que nos llega es un Path
        //estudiantes
        try
        {
            Files.writeString(est, contEst, StandardCharsets.UTF_8, //formato de archivo
                    StandardOpenOption.CREATE,//crea el archivo
                    StandardOpenOption.TRUNCATE_EXISTING);//si existiera lo elimina
            System.out.println("Archivo est creado exitosamente" + est.toAbsolutePath());
            System.out.println("Tamanio: " + Files.size(est) + " bytes");
        }
        catch (IOException e)
        {
            System.err.println("Error al escribir" + e.getMessage());
        }
        //materias
        try {
            Files.writeString(mat, contMat, StandardCharsets.UTF_8, //formato de archivo
                    StandardOpenOption.CREATE,//crea el archivo
                    StandardOpenOption.TRUNCATE_EXISTING);//si existiera lo elimina
            System.out.println("Archivo mat creado exitosamente" + mat.toAbsolutePath());
            System.out.println("Tamanio: " + Files.size(mat) + " bytes");
        }
        catch (IOException e)
        {
            System.err.println("Error al escribir" + e.getMessage());
        }
    }
}