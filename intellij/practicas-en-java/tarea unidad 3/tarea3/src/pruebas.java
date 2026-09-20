//16/04/2026: seguir con pruebas
import java.util.Scanner;

public class pruebas
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese un numero:");
        String entrada = teclado.nextLine(); // lee como String

        try
        {
            // String → int
            int numero = Integer.parseInt(entrada);
            System.out.println("El doble es: " + (numero * 2));

            // int → String
            String resultado = String.valueOf(numero * 2);
            System.out.println("Como texto tiene " + resultado.length() + " digitos");
        }
        catch (NumberFormatException e)
        {
            System.out.println("⚠ Eso no es un numero!");
        }
    }
}

//hjsakldfhlñ