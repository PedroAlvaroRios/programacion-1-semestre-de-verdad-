/*
Crear una funcion que devuelva el area de un circulo
A = Pi * r * r
 */
import java.util.Scanner;
public class CalculoArea
{
    static double PI=3.1416;// variable global de pi
    public static void main(String[] args)
    {
        double radio = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el radio = ");
        radio = sc.nextDouble();
        imprimirarea(radio);
        radio=78.32;
        imprimirarea(radio);
        imprimirarea(10);
    }
    //Funcion de impresion del area
    public static void imprimirarea(double r)
    {
        double area = PI * r *r;
        System.out.println("el area es: "+area);
    }
}
