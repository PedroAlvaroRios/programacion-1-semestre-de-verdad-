/*
Geometría Rectangular: Calcula el área y el perímetro de un rectángulo con una base de 12.5 y una altura de 7.3.
 Usa variables de tipo double y muestra los resultados con 2 decimales usando printf.
*/

public class tarea3_2
{
    public static void main(String[] args)
    {
        double base=12.5;
        double altura=7.3;

        double area=base*altura;
        double perimetro=2*(base+altura);

        System.out.println("area:");
        System.out.printf("%5.2f",area);
        System.out.print("\n"); //le metemos un espacio
        System.out.println("perimetro:");
        System.out.printf("%5.2f",perimetro);

    }
}
