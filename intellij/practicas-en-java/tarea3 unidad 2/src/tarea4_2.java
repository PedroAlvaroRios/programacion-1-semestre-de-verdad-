/*
 * Interés Compuesto: Un banco ofrece una tasa del 8% anual.
 *  Calcula el monto final tras invertir un capital inicial durante 5 años
 * usando la fórmula $M = Capital \times (1 + tasa)^{años}$. Utiliza Math.pow() para el cálculo.
 */
import java.util.Scanner;
import java.math.*;

public class tarea4_2
{
    public static void main(String[] args)
    {
        double capital_numero,anos_numero,profit;
        double tasa_interes=0.08; //8% de intereses

        System.out.println("ingrese el capital inicial");
        Scanner capital = new Scanner (System.in);
        capital_numero = capital.nextInt(); //lo convertimos en un entero

        System.out.println("ingrese la cantidad de años que desea dejar este capital");
        Scanner anos = new Scanner (System.in);
        anos_numero = anos.nextInt(); //lo convertimos en un entero

        double numero_interes=1+tasa_interes;
        double potenciacion=Math.pow(numero_interes,anos_numero);

        profit= capital_numero*potenciacion;

        System.out.println("el monto final es igual a : "+profit);
    }
}