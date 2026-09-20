/*Validador de Correo: Crea un programa que reciba una dirección de correo electrónico y verifique
si contiene el símbolo @. Si es válido, separa y muestra el nombre de usuario y el dominio. */

import java.util.Scanner;

public class tarea2_2
{
    public static void main (String[] arg)
    {

    /*primero verificamos si es contiene @ o no*/

    System.out.println("bienvendo al verificador de emails 3000");
    System.out.println("a continuacion, ingrese el correo electronico a verificar:");

    Scanner teclado = new Scanner(System.in);   //aqui se da la opcion de escribir el email
    String correo = teclado.nextLine();         //esta parte lee lo que se a escrito en el teclado linea por linea y lo convierte a string

    /* y aqui ya veficamos si de verdad tiene una @*/
    int correo_veficado = correo.indexOf("@");

    if (correo_veficado==-1) //si no existe el valor sera -1
        {
            System.out.println("No existe el correo electronico");
        }

    /*una vez verificado entra aqui con un valor mayor a 0 porque si existe en algun lugar del string*/
    if (correo_veficado>=0)
        {
            System.out.println(correo_veficado);
            System.out.println("el correo electronico es real");

            String nombre = correo.substring(0, correo_veficado);
            String dominio = correo.substring(correo_veficado+1);//esto hara que se imprima hasta que se acabe el string

            System.out.println("el nombre es: "+nombre);
            System.out.println("el dominio es: "+dominio);

        }

    }
}
