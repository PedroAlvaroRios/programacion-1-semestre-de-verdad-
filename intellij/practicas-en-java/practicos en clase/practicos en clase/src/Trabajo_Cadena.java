/*
    Dado 3 nombres ordenar
    y mostrar en el orden de mayor a menor.
    ej: Maria, Jose, Ana
    resultado; Ana, Jose, Maria
*/

import java.util.Scanner;

public class Trabajo_Cadena
{
    public static void main(String[] arg)
    {
        String nombre1, nombre2, nombre3;

        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese el 1er nombre");
        nombre1=sc.nextLine();
        System.out.println("ingrese el 2er nombre");
        nombre2=sc.nextLine();
        System.out.println("ingrese el 3er nombre");
        nombre3=sc.nextLine();

        String temp;

        if (nombre1.toLowerCase().compareTo(nombre2.toLowerCase()) > 0)
        {
            temp    = nombre1;  // guardamos nombre1 temporalmente
            nombre1 = nombre2;  // nombre1 toma el valor de nombre2
            nombre2 = temp;     // nombre2 toma el valor guardado
        }

        if (nombre1.toLowerCase().compareTo(nombre3.toLowerCase()) > 0)
        {
            temp    = nombre1;
            nombre1 = nombre3;
            nombre3 = temp;
        }

        if (nombre2.toLowerCase().compareTo(nombre3.toLowerCase()) > 0)
        {
            temp    = nombre2;
            nombre2 = nombre3;
            nombre3 = temp;
        }
        
        System.out.println("Orden de menor a mayor: " + nombre1 + ", " + nombre2 + ", " + nombre3);
    }
}