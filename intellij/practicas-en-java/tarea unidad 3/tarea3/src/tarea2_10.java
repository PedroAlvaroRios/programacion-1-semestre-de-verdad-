/*
10-	Acceso de Edad: Pedir la edad del usuario.
Usar el operador ternario para guardar en una variable si la persona tiene "Acceso Permitido"
(mayor o igual a 18) o "Acceso Denegado".
*/

import java.util.Scanner;

public class tarea2_10
{
    public static void main(String[]args)
    {
        System.out.println("ingrese su edad");
        Scanner leer = new Scanner(System.in);
        int edad = leer.nextInt();

        //operador ternario
        String acceso = (edad >= 18) ? "Acceso permitido" : "Acceso denegado"; //Variable = (condicion) ? valor_si_verdadero : valor_si_falso;
        System.out.println(acceso);
    }
}