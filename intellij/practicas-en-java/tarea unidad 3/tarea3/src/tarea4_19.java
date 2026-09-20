/*19-	Números Primos: Pedir un número límite N y mostrar todos los números primos que existan desde el 1 hasta ese número N. */

import java.util.Scanner;

public class tarea4_19 {
    public static void main(String[] args) {

        System.out.println("defina el limite para mostrar todos los numeros primos que existan hasta este");
        Scanner numero = new Scanner(System.in);
        int numero_ingresado = numero.nextInt();

        System.out.println("los numeros primos hasta el numero ingresado son: ");

        for (int i = 2; i <= numero_ingresado; i++) //el numero 1 no es primo asi que lo descartamos de cajon y empezamos del 2
        {
            boolean primo = true; //asumimos que cada valor es primo hasta que se lo niege
            for (int j = 2; j < i; j++) //aqui buscamos un divisor, saltandonos 1 porque lo obviamos que saldra residuo 0
            {
                if (i % j == 0) //aqui vamos a testear cada combinacion hasta la i-1, si alguno da 0 entonces tiene 1 divisor de mas
                {
                    primo = false;//si encuentra 1 divisor de mas se vuelve falso el valor de primo y lo descartamos
                    break;              //se rompe para dejar de buscar
                }
            }
            if (primo == true) {
                System.out.println(i);
            }
        }
    }
}