/*20-	Palíndromos: Leer una palabra y determinar si se lee igual de izquierda a derecha
que de derecha a izquierda (ejemplo: "reconocer"), ignorando mayúsculas y espacios. 	*/

import java.util.Scanner;

public class tarea4_20
{
    public static void main(String[] args)
    {
        Scanner palabra = new Scanner(System.in);

        System.out.println("Ingrese una palabra para probar si es un palindromo:");
        String palabra_string = palabra.next();

        palabra_string=palabra_string.toLowerCase();//este convertira toda mayuscula en minuscula

        String palabra_limpia = palabra_string.replace(" ", "");//esto eliminara cada espacio en el string

        StringBuilder Alreves = new StringBuilder(palabra_limpia);//StingBuilder a comparacion de un String normal es mas flexible pero mas pesado y dificil de usar
        Alreves.reverse();       // esto hara que se ponga al reves el string
        String palabra_alreves = Alreves.toString();

        System.out.println("Al reves: " + Alreves.toString()); //imprimiremos la palabra al reves

        if(palabra_string.equals(palabra_alreves)) //.equals es una funcion que funciona como =, pero este funciona con strings, este cheacara que sea igual
        {
            System.out.println("es un palindromo");
        }
        else
        {
            System.out.println("no es un palindromo");
        }
    }
}