import java.util.Scanner;

/*
* Programa para identificar un valor par
*/

public class Numeros_pares {
        public static void main(String[] args)
        {
            int numero = 47;
            if (numero % 2 == 0)
                System.out.println("Numero par");
            else
                System.out.println("Numero impar");

            System.out.println("ingrese un numero");
            Scanner teclado = new Scanner (System.in);
            numero= teclado.nextInt();
            if (numero %2 == 0)
                System.out.println("Numero par");
            else
                System.out.println("Numero impar");
        }
    }