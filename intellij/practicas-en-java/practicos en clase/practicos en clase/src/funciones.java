import java.util.Scanner;

public class funciones
{
    //declaracion de variables locales
    static String NOMBRE=""; //este se podra referir en cualquier parte del codigo
    static int EDAD=0;//util para evitar reescribir valores en varias funciones y llamarlo cuando sea
    public static void main(String[] args)
    {
        System.out.printf("Bievenido a las funciones");
        Scanner sc = new Scanner(System.in);
        String nombre;
        int edad=0;
        for (int i = 1; i<4;i++)
        {
            System.out.println("Ingrese nombre: ");
            nombre = sc.nextLine();//variable local
            System.out.println(nombre);
            System.out.println("Ingrese edad");
            edad = sc.nextInt();//variable local
            imprimir(nombre,edad);//imprimir se refiere a otra funcion para conectarlo
        }
    }
    // Funcion que no devuelve nada (void)
    public static void imprimir(String name, int age)
    {
        System.out.println("***************************************");
        System.out.println("Su nombre es =   "+name);
        System.out.println("Su edad es =     "+age);
        System.out.println("***************************************");
    }
}
