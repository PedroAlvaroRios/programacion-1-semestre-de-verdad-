/*Sistema de Descuentos: Crea un sistema que aplique descuentos según el monto de compra: Más de
Bs. 500: 15% de descuento. Más de Bs. 200: 10% de descuento. Más de Bs.100: 5% de descuento.
*/
import java.util.Scanner;

public class tarea5_2
{
    public static void main(String[] args)
    {
        double monto_pagar,descuento;
        System.out.println("ingrese el monto de compra: ");
        Scanner monto = new Scanner (System.in);
        int monto_total = monto.nextInt(); //lo convertimos en un numero entero

        if (monto_total>500)
        {
            descuento = monto_total * 0.15;     //esto saca el 15% que vendria siendo el descuento
            monto_pagar = monto_total-descuento;
            System.out.println("su monto total es: "+monto_total);
            System.out.println("se aplicara un 15% de descuento a la compra");
            System.out.println("su monto a pagar es: "+monto_pagar);
            System.exit(0);
        }
        if (monto_total>200)
        {
            descuento = monto_total * 0.10;     //esto saca el 10% que vendria siendo el descuento
            monto_pagar = monto_total-descuento;
            System.out.println("su monto total es: "+monto_total);
            System.out.println("se aplicara un 10% de descuento a la compra");
            System.out.println("su monto a pagar es: "+monto_pagar);
            System.exit(0);
        }
        if (monto_total>100)
        {
            descuento = monto_total * 0.05;     //esto saca el 5% que vendria siendo el descuento
            monto_pagar = monto_total-descuento;
            System.out.println("su monto total es: "+monto_total);
            System.out.println("se aplicara un 5% de descuento a la compra");
            System.out.println("su monto a pagar es: "+monto_pagar);
            System.exit(0);
        }
        if (monto_total<100)
        {
            System.out.println("su monto total es: "+monto_total);
            System.out.println("no se le aplicara ningun descuento a la compra");
            System.out.println("su monto a pagar es: "+monto_total);
            System.exit(0);
        }
    }
}