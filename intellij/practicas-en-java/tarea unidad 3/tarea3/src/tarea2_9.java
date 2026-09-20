/*9-	Tipos de Triángulos: Pedir tres lados (a, b y c).
Verificar si forman un triángulo válido. Si es así, indicar si es Equilátero (lados iguales),
Isósceles (dos iguales) o Escaleno (todos distintos).*/

import java.util.Scanner;

public class tarea2_9
{
    public static void main(String[]args)
    {
        System.out.println("bienvenido al determinador de triangulos");
        System.out.println("ingrese el lado a");
        Scanner a = new Scanner(System.in);
        double a_numero = a.nextDouble();

        System.out.println("ingrese el lado b");
        Scanner b = new Scanner(System.in);
        double b_numero = b.nextDouble();

        System.out.println("ingrese el lado c");
        Scanner c = new Scanner(System.in);
        double c_numero = c.nextDouble();

        if (a_numero==b_numero && a_numero==c_numero)//usar == para converirlo en un valor booleano
        {
            System.out.println("es un triangulo Equilátero");
        }
        else if (a_numero==b_numero || a_numero==c_numero)
        {
            System.out.println("es un triangulo Isósceles");
        }
        else
        {
            System.out.println("es un triangulo Escaleno");
        }
    }
}
