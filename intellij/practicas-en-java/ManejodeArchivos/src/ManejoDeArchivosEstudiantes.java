import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.List;

public class ManejoDeArchivosEstudiantes
{
    //integrar una parte que lo relacione con materias : codigo de materia, materia
    public static void  main(String[] args)
    {
            Path rutaEstudiantes = Path.of("Estudiantes.txt");
        String contenido = """
                541241,Maria Eugenia Panoso,mariapanoso@gmail.com
                542586,Rodrigo Quinteros Sanchez,quinteros@gmail.com""";
        try
        {
            Files.writeString(rutaEstudiantes, contenido, StandardCharsets.UTF_8, //formato de archivo
                    StandardOpenOption.CREATE,//crea el archivo
                    StandardOpenOption.TRUNCATE_EXISTING);//si existiera lo elimina
            System.out.println("Archivo creado exitosamente" + rutaEstudiantes.toAbsolutePath());
            System.out.println("Tamanio: " + Files.size(rutaEstudiantes) + " bytes");
        }
        catch (IOException e)
        {
            System.err.println("Error al escribir" + e.getMessage());
        }

        //Lectura de los datos en formato especial metodo 1
        try {
            //String[] datos = new String[3];
            List<String> lineas = Files.readAllLines(rutaEstudiantes,StandardCharsets.UTF_8);//crea una lista de lineas
            System.out.println("Codigo     | Nombre Completo               | Correo  ");
            for (int i=0; i<lineas.size(); i++)
            {
                contenido = lineas.get(i);
                String[] datos = contenido.split(",z"); //separa los datos por el simbolo dado
                // System.out.println(datos[0]+datos[1]+datos[2]);
                System.out.printf("%10s | %30s| %30s \n", datos[0], datos[1], datos[2]);
            }
        } catch (IOException e) {
            System.err.println("Error de lectura" + e.getMessage());
        }
    }
}
