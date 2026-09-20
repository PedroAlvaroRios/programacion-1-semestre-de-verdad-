import java.util.Scanner;

public class caracteres
{
    public static void main (String arg[])
    {

        //Declaracion de una cadena
        String nombre;
        nombre = "Juan Perez";
        System.out.println(nombre);
        int tamanio = nombre.length(); //importante poner int para que pueda recibir un numero
        System.out.println("Tamaño = "+tamanio);
        System.out.println("Letra en posicion 3 = "+nombre.charAt(3));//vemos que caracter se encuentra en la posicion 3
        String parte = nombre.substring(0,5);
        System.out.println("la parte de 0 a 5 es = { "+parte+"}");
        System.out.println("todo minuscula = "+nombre.toLowerCase());
        System.out.println("todo minuscula = "+nombre.toUpperCase());
        /* Encontrar cuantas vocales hay en una palabra que
        * digita el usuario:
        * Ej: Maria Panoso  -->  6 vocales*/

        Scanner usuario = new Scanner(System.in);
        System.out.println("a continuacion ingrese su usuario: ");
        String texto = usuario.nextLine();

        texto=texto.toLowerCase();
        char letra;
        int contador = 0;

        for (int i = 0; i < texto.length(); i++) //evitar usar un = para hace rque se rompa cuando llegue al final del string
        {
            letra=texto.charAt(i);
            if (letra=='a' || letra=='e' || letra=='i' || letra=='o' || letra=='u')
            {
                contador++;
            }
        }
        System.out.println("Tienes "+contador+" vocales");
    }
}
//