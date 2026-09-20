import java.util.Scanner;

/*
* 2- ingrese una cadena de caracteres y valide si es un correo electronico valido
*
* juanperez@nur.com = valido
* juan.gmail.com = no valido
* juan@.net = no valido
* @gmail.com = no valido
* juan.perez@gmail.com = valido
*
* parametros:
* recorrer hasta que se tope con arroba
* despues recorrer hasta que se tope con el punto
* recorrer hasta que termine el string
*
*
* */
public class verificador_correo
{
    public static void main(String[] arg)
    {
        String cadena_original="";
        StringBuilder cadena0 = new StringBuilder();  //stringBuilder me ayudara a que se puedan juntar las cadenas mas fácilmente
        StringBuilder cadena1 = new StringBuilder();
        StringBuilder cadena2 = new StringBuilder();

        boolean encontroArroba = false;
        boolean encontroPunto  = false;

        System.out.println("ingrese el correo que quiere verificar");
        Scanner sc = new Scanner(System.in);
        cadena_original=sc.nextLine();

/*vamos a verificar primero que todo este correcto*/

        int primer_arroba = cadena_original.indexOf('@'); //indexOf buscara desde el inicio hasta el final la primer apararicion del caracter indicado
        int ultima_arroba = cadena_original.lastIndexOf('@'); //lastIndexOf buscara desde el final hasta el inicio la primer apararicion del caracter indicado

        if (primer_arroba ==-1) //verificamos si existe la arroba
        {
            System.out.println("correo invalido, no existe arroba");
            System.exit(0);
        }

        if (primer_arroba != ultima_arroba)
        {
            System.out.println("correo invalido, hay mas de una arroba"); //verificamos si hay mas de una arroba
            System.exit(0);
        }

        if (primer_arroba == 0)
        {
            System.out.println("Correo invalido, no hay usuario antes del @");
            System.exit(0);
        }

        int primer_punto = cadena_original.indexOf('.',primer_arroba); //verificamos que el punto exista despues de la ultima arroba

        if (primer_punto ==-1) //verificamos si existe algun punto
        {
            System.out.println("correo invalido, no existe ningún punto");
            System.exit(0);
        }

        if (primer_punto == ultima_arroba + 1) //verificamos que el punto no este justo despues de @
        {
            System.out.println("correo invalido, el punto esta justo despues del @");
            System.exit(0);
        }

        if (primer_punto == cadena_original.length() - 1) //verificamos que haya algo despues del punto
        {
            System.out.println("Correo invalido, no hay extension despues del punto"); //ejemplo .bo ; .com
            System.exit(0);
        }

        //procesamos el string
        //aqui intentamos evitar usar mas de una una vez la cadena original para evitar reescribir todo

        for (int i = 0; i < cadena_original.length(); i++)
        {
            char letra = cadena_original.charAt(i);

            if (!encontroArroba)
            {
                if (letra == '@')
                {
                    encontroArroba = true;
                    continue; // sale cuando se encuentre con un @
                }
                cadena0.append(letra);
            }
            else if (!encontroPunto)
            {
                if (letra == '.')
                {
                    encontroPunto = true;
                    continue; // sale cuando se tope con un punto(.)
                }
                cadena1.append(letra);
            }
            else
            {
                cadena2.append(letra);
            }
        }

        String correo_final = cadena0+"@"+cadena1+"."+cadena2;

        System.out.println("el correo ingresado "+correo_final+" es valido");
    }
}

