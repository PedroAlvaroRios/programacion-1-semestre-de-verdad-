/*
2- Operaciones Aritméticas: Crear un programa que pida dos números enteros (a y b).
Mostrar la suma, resta, producto, cociente, el residuo de la división y el resultado de elevar
el primer número al segundo.
*/

import java.util.Scanner;
import java.math.*;

public class tarea1_2
{
    public static void main(String[] args)
    {

        double suma,resta,producto,cociente,residuo,potencia;

        System.out.println("ingrese el valor del numero entero de la variable a");
        Scanner numero_1 = new Scanner(System.in);
        double variable_1 = numero_1.nextInt(); //lo convertimos a double para que pueda procesar mas decimales

        System.out.println("ingrese el valor del numero entero de la variable b");
        Scanner numero_2 = new Scanner(System.in);
        double variable_2 = numero_2.nextInt();

        suma = variable_1+variable_2;
        System.out.println("la suma de los dos valores ingresados es: "+suma);

        resta = variable_1-variable_2;
        System.out.println("la resta de los dos valores ingresados es: "+resta);

        producto = variable_1*variable_2;
        System.out.println("el producto de los dos valores ingresados es: "+producto);

        cociente = variable_1/variable_2;
        System.out.println("el cociente de los dos valores ingresados es: "+cociente);

        residuo = variable_1%variable_2;
        System.out.println("el residuo de la division de los dos valores ingresados es: "+residuo);

        potencia = Math.pow(variable_1,variable_2);
        System.out.println("el resultado de 'a' elevado a 'b' es: "+potencia);

    }
}