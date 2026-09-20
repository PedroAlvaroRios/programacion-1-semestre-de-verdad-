import java.util.Scanner;

public class tarea3_1
{
    public static void main(String[] args)
    {
        int numero;
        System.out.println("ingrese un numero");
        Scanner teclado = new Scanner (System.in);
        numero= teclado.nextInt();
        if (numero %2 == 0)
            System.out.println("el numero es par");
        else
            System.out.println("el numero es impar");
    }
}
