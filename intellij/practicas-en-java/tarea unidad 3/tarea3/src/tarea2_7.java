/*7-	Notas y Estado: Leer el nombre de un alumno y tres notas.
Calcular el promedio. Mostrar "Aprobado" si es mayor o igual a 51,
"Segunda Instancia" si está entre 40 y 50, o "Reprobado" si es menor a 40. */

import java.util.Scanner;

public class tarea2_7
{
    public static void main(String[]args)
    {
        String alumno = "Pedro";

        System.out.println("ingrese la nota 1 del estudiante");
        Scanner numero_1= new Scanner(System.in);
        double nota_1 = numero_1.nextDouble();

        System.out.println("ingrese la nota 2 del estudiante");
        Scanner numero_2 = new Scanner(System.in);
        double nota_2 = numero_2.nextDouble();

        System.out.println("ingrese la nota 3 del estudiante");
        Scanner numero_3 = new Scanner(System.in);
        double nota_3 = numero_3.nextDouble();

        double promedio = (nota_1 + nota_2 + nota_3)/3;

        if (promedio >= 51)
        {
            System.out.println("el promedio de "+alumno+" es: "+promedio);
            System.out.println("Estado: Aprobado");
            System.exit(0);
        }
        if (promedio >= 40)
        {
            System.out.println("el promedio de "+alumno+" es: "+promedio);
            System.out.println("Estado: Segunda Instancia");
            System.exit(0);
        }
        if (promedio < 40)
        {
            System.out.println("el promedio de "+alumno+" es: "+promedio);
            System.out.println("Estado: Reprobado");
        }
    }
}
