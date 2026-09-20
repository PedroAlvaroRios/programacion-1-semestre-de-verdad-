/*
Adivina el Número: Crea un juego donde el programa tiene un "número secreto" (ej. 42)
y el usuario debe intentar adivinarlo en un bucle while. El programa debe dar pistas indicando si el intento es "muy alto" o "muy bajo".
*/

import java.util.Scanner;
import java.math.*;
public class tarea5_5
{
    public static void main(String[] args)
    {
        int numero_secreto = (int)(Math.random() * (100 + 1)) + 1;
        int numero_ingresado=0;


        System.out.println("ADIVINA EL NUMERO");
        System.out.println("objetivo: busca el numero de 1 al 100");

        while (numero_ingresado != numero_secreto)
        {
            System.out.println("ingrese su intento:");
            Scanner intento = new Scanner (System.in);
            numero_ingresado = intento.nextInt();

            if (numero_ingresado<numero_secreto)
            {
                System.out.println("el intento es muy bajo");
            }
            if (numero_ingresado>numero_secreto)
            {
                System.out.println("el intento es muy alto");
            }
            if (numero_ingresado==numero_secreto)
            {
                System.out.println("CORRECTO, el numero secreto es : "+numero_secreto);
            }
        }
    }
}
