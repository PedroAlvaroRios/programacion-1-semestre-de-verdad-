/*12-	Suma de Rango: Pedir al usuario dos números (A y B).
Sumar todos los números que hay entre ellos e informar cuántos números se sumaron en total. */

import java.util.Scanner;
import java.math.*;
public class tarea3_12
{
    public static void main(String[] args)
    {
        long numero_total = 0;
        int i;
        System.out.println("ingrese el numero de inicio");
        Scanner inicio = new Scanner(System.in);
        int inicio_num = inicio.nextInt();

        System.out.println("ingrese el numero de final");
        Scanner fin = new Scanner(System.in);
        int fin_num = fin.nextInt();

        for (i = inicio_num; i <= fin_num; i++)
        {
             numero_total = numero_total + i; //suma el numero del primer resultado y se lo suma por la cantidad de repeticiones ya hechas
            //1+2+3+4+5...
        }
        int cantidad = fin_num - inicio_num + 1; //+1 para incluir el numero con el que se inicia
        System.out.println("se sumaron en total " + cantidad + " numeros");
        System.out.println("la suma de todos los numeros entre "+inicio_num+" y "+fin_num+" es:");
        System.out.println(numero_total);
    }
}