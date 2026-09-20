/*3-	Conversor de Clima: Escribir un programa que convierta grados Celsius a Fahrenheit.
La fórmula es: F = (C multiplicado por 9/5) + 32. Probar con el valor 37.5. */

import java.util.Scanner;

public class tarea1_3
{
    public static void main(String[] args)
    {
        System.out.println("bienvenido al convertidor de grados Celsius a Fahrenheit ");

        System.out.println("ingrese los grados Celsius que desea convertir a grados Fahrenheit ");
        Scanner celsius = new Scanner(System.in); //ingresa el numero por teclado
        double celsius_numero = celsius.nextDouble(); //lo convertimos a double para que pueda procesar mas decimales

        double fahrenheit = (celsius_numero * 9/5) +32;

        System.out.println( "sus grados Celsius en Fahrenheit serian: " + fahrenheit);
    }
}
