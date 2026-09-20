/*6-	Clasificador: Determinar si un número ingresado es positivo, negativo o cero.
Al final, mostrar siempre su valor absoluto usando la función Math.abs. */

import java.math.*;
import java.util.Scanner;

public class tarea2_6
{
    public static void main(String[]args)
    {
        System.out.println("bienvenido al clasificador");
        System.out.println("ingrese un numero para determinar si un numero es positivo, negativo o cero");
        Scanner numero= new Scanner(System.in);

        double variable = numero.nextDouble();

        if (variable>0)
        {
            Math.abs(variable);  //Math.abs ayuda a sacar el valor absoluto de cualquier numero sin tener en cuenta si es positivo o positivo
            System.out.println("el numero ingresado es positivo y el valor absoluto de numero ingresado es: "+variable);
        }
        else if (variable<0)
        {
            Math.abs(variable);
            System.out.println("el numero ingresado es negativo y el valor absoluto de numero ingresado es: "+variable);
        }
        else if (variable==0)
        {
            Math.abs(variable);
            System.out.println("el numero ingresado es neutro y el valor absoluto de numero ingresado es: "+variable);
        }
    }
}
