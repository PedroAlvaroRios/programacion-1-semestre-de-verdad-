/*Registro de Compras: Solicita al usuario el precio de un producto y la cantidad comprada.
Calcula el subtotal, aplica un IVA del 13% y muestra el total a pagar formateado con dos decimales. */

import java.math.*;
import java.util.Scanner;

public class tarea4_1
{
    public static void main(String[] args)
    {
        int precio_numero;
        int cantidad_numero;

        System.out.println("ingrese el precio del producto");
        Scanner precio = new Scanner (System.in);
        precio_numero = precio.nextInt();

        System.out.println("ingrese la cantidad de unidades a comprar");
        Scanner cantidad = new Scanner (System.in);
        cantidad_numero = cantidad.nextInt(); //aqui se lo convierte en un numero entero a el numero ingresado


        double subtotal = precio_numero * cantidad_numero; //multiplicamos el precio por la cantidad
        double impuesto = subtotal * 0.13; //aqui hacemos la formula para sacarle impuestos primero poneindo cuanto impuesto le queremos sacar
        double total=subtotal+impuesto; //le metemos el impuesto IVA

        System.out.printf("su total es: "+"%5.2f",total);
    }
}