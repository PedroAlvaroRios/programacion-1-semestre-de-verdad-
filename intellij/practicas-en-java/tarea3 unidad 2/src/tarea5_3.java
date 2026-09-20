/*Cálculo de Factorial: Solicita un número $N$ y, mediante un bucle for, calcula su factorial ($N!$) y muestra el resultado.*/

import java.util.Scanner;

public class tarea5_3
{
        public static void main(String args[])
        {
            long factorial=1;
            System.out.println("un numero positivo a sacar su factorial");
            Scanner numero = new Scanner (System.in);

            long numero_ingresado  = numero.nextLong(); //lo convertimos en un numero long

            for (int i = 1; i <= numero_ingresado; i++)
            {
                factorial = factorial * i;
            }
            System.out.println("el factorial de : "+numero_ingresado+" es igual a: "+factorial);
        }
}