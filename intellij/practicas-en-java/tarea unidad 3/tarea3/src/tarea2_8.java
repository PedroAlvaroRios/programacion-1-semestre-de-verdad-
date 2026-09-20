/*8-	Impuestos al Sueldo: Leer el salario de un empleado.
Si es hasta 5000 Bs el impuesto es 0%. De 5001 a 10000 es 10%. De 10001 a 20000 es 20%.
Más de 20000 es 30%. Mostrar el sueldo final tras el descuento. */

import java.util.Scanner;

public class tarea2_8
{
    public static void main(String[] args)
    {
        double impuesto;
        System.out.println("ingrese su salario");
        Scanner numero_1= new Scanner(System.in);
        double salario = numero_1.nextDouble();

        if (salario<=5000)
        {
            System.out.println("su salario es menor o igual a 5000");
            System.out.println("no se aplicara ningun impuesto");
            System.exit(0);
        }
        else if (salario<=10000)
        {
            System.out.println("su salario es mayor a 5000");
            System.out.println("se le aplicara un impuesto del 10%");

            impuesto = salario * 0.10;
            salario = salario - impuesto;

            System.out.print("su salario sera: "+salario);
            System.exit(0);
        }
        else if (salario<=20000)
        {
            System.out.println("su salario es mayor a 10000");
            System.out.println("se le aplicara un impuesto del 20%");

            impuesto = salario * 0.20;
            salario = salario - impuesto;

            System.out.print("su salario sera: "+salario);
            System.exit(0);
        }
        else
        {
            System.out.println("su salario es mayor a 20000");
            System.out.println("se le aplicara un impuesto del 30%");

            impuesto = salario * 0.30;
            salario = salario - impuesto;

            System.out.print("su salario sera: "+salario);
        }
    }
}