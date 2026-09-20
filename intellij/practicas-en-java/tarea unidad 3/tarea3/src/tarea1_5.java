/*5-	Caracteres ASCII: Declarar una variable tipo char con la inicial de su nombre.
Mostrar el carácter, su valor numérico en la tabla ASCII y el carácter que le sigue en el abecedario. */

public class tarea1_5
{
    public  static void main(String[] args)
    {
        char inicial ='P';

        System.out.println("la inicial es: "+inicial);

        int ascii = (int) inicial;

        int ascii_recorrido = ascii+1;

        char letra = (char)ascii_recorrido;

        System.out.println("su valor en ASCII es: "+ascii);
        System.out.println("y el caracter que le sigue es: "+letra+" con el valor en ASCII de: "+ascii_recorrido);
    }
}