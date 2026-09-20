/*Año Bisiesto: Diseña un programa que determine si un año es bisiesto. Un año lo es si es divisible entre 4, excepto
los que son divisibles entre 100, a menos que también sean divisibles entre 400. residuo cero
4(bien)=0
100(mal)=0 a menos que 400(bien)=0
*/
import java.util.Scanner;
import java.math.*;

public class tarea5_1
{
    public static void main(String[] args)
    {

            System.out.println("ingrese el año");
            Scanner ano = new Scanner (System.in);
            int ano_numero = ano.nextInt(); //lo convertimos en un numero entero


            if (ano_numero%4==0) //si es verdadero esta bien// no olvidar poner "==" a la hora de comparar con if un numero
            {
                if (ano_numero%100==0) //si es verdadero esta mal a menos que se pueda dividir en 400
                {
                    if (ano_numero%400==0) //si es verdero esta bien
                    {
                        System.out.println("es un año bisciesto");
                        System.exit(0); //esta linea de codigo hara que se salga del programa una vez muestre el resultado
                    }
                        System.out.println("no es un año bisciesto");
                    System.exit(0);
                }
                System.out.println("es un año bisciesto");
                System.exit(0);
            }
            System.out.println("no es un año bisciesto");
            System.exit(0);
    }
}
