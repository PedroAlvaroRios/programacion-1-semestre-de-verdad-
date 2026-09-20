/*Ecuación Cuadrática: Dada la ecuación $ax^2 + bx + c = 0$,
solicita los valores de $a, b$ y $c$. Calcula las dos raíces posibles usando la fórmula general
y el método Math.sqrt(), asegurándote de que el discriminante no sea negativo.*/

//formula general
//x=-b +- raiz(b²- 4ac)/2a
import java.util.Scanner;
import java.math.*;
public class tarea4_3
{
    public static void main(String[] args)
    {
        double parte_1,parte_2_a,parte_2_b;

        System.out.println("bienvenido al resolvedor de ecuaciones cuadraticas");
        System.out.println("Ingrese el valor de la variable a");
        Scanner leer = new Scanner(System.in);
        int a = leer.nextInt();

        System.out.println("Ingrese el valor de la variable b");
        Scanner leer2 = new Scanner(System.in);
        int b = leer2.nextInt();

        System.out.println("Ingrese el valor de la variable c");
        Scanner leer3 = new Scanner(System.in);
        int c = leer3.nextInt();


        //lo que esta dentro de la raiz
        parte_1= Math.pow(b,2)-(4*a*c);

        //le sacamos cuadrado y lo dividimos en sub 1 y sub 2

        parte_2_a=(-b+Math.sqrt(parte_1))/(2*a); //se lo pone entre parentesis para que no intente mezclarze
        parte_2_b=(-b-Math.sqrt(parte_1))/(2*a); //evita que calcule algo que  falta resolver

        System.out.println("el valor de x sub 1 es igual a : "+parte_2_a);
        System.out.println("el valor de x sub 2 es igual a : "+parte_2_b);
    }
}
