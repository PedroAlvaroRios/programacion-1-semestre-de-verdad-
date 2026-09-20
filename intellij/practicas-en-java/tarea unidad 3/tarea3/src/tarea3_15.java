/*
15-	Serie Fibonacci: Pedir al usuario cuántos números de la serie de Fibonacci desea ver.
Validar con un ciclo "do-while" que el usuario ingrese un número mayor a 2.
*/
import java.util.Scanner;
import java.math.*;
public class tarea3_15
{
    public static void main(String[] args)
    {
        long F_1 = 1;
        long F_0 = 0;
        long F_2;


        System.out.println("ingrese el numero de numeros de la serie de Fibonnacci desea ver");
        Scanner veces = new Scanner(System.in);
        int veces_num = veces.nextInt();

        if(veces_num<=2){
            do {
                System.out.println("ingrese un numero mayor a dos");
                Scanner veces_2 = new Scanner(System.in);
                veces_num = veces_2.nextInt();
            } while (veces_num <= 2);
        }

        for (int i = 1; i <= veces_num; i++)
        {
            F_2 = F_1 + F_0;
            System.out.println(F_2);
            F_0 = F_1;
            F_1 = F_2;
        }
    }
}
