/*
* Contador de Caracteres: Escribe un programa que cuente cuántas veces aparece la letra 'a'
*  (minúscula) en la frase "La programación en Java es fascinante" usando un bucle y el método charAt().
*/

//charAt() solo devolvera un caracter en vez de una linea de caracteres
// se requiere un bucle para ir buscando hasta que se acabe el string

public class tarea2_3
{
    public static void main (String[] arg)
    {
        int a=0;
        int i=0;
        String texto = "La programación en Java es fascinante";

        for(i=0 ; i<texto.length() ; i++) //esto hara que recorra con el resto del tamaño de el string gracias a length()
        {
            if(texto.charAt(i)=='a') //usamos comillas simples ('') para un Char SIEMPRE y no las comillas dobles
            {
                System.out.println(texto.charAt(i)); //esto imprimira todas las letras a que encuentre
                a++;
            }
        }
    System.out.println("el total de a's encontradas es: "+a); //esto imprimira el total de "a"'s encontradas dentro del string un un numero
    }
}
