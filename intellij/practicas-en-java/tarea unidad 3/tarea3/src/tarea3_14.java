/*14-	Adivina el Número: El programa elige un número al azar entre 1 y 100.
El usuario tiene 7 intentos. El programa debe decir si el número secreto es "mayor" o "menor"
después de cada intento fallido. */
import java.util.Scanner;

public class tarea3_14
{
    public static void main(String[] args)
    {
        int numero_secreto = (int)(Math.random() * (100 + 1)) + 1;
        int numero_ingresado=0;
        int intentos=7;


        System.out.println("ADIVINA EL NUMERO EN MENOS DE 7 INTENTOS");
        System.out.println("objetivo: busca el numero de 1 al 100");

        while (numero_ingresado != numero_secreto && intentos != 0)
        {
            System.out.println("ingrese su intento:");
            Scanner intento = new Scanner (System.in);
            numero_ingresado = intento.nextInt();

            if (numero_ingresado<numero_secreto)
            {
                System.out.println("el intento es muy bajo");
                intentos=intentos-1;
                System.out.println("le quedan "+intentos+" intentos");
            }
            if (numero_ingresado>numero_secreto)
            {
                System.out.println("el intento es muy alto");
                intentos=intentos-1;
                System.out.println("le quedan "+intentos+" intentos");
            }
            if (numero_ingresado==numero_secreto)
            {
                System.out.println("CORRECTO, el numero secreto es : "+numero_secreto);
                System.out.println("te sobraron "+intentos+" intentos");
            }
        }
    }
}