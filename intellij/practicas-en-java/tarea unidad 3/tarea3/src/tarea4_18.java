import java.util.Scanner;

public class tarea4_18 {
    public static void main(String[] args) {
        final double euros = 8.09;
        final double dolares = 6.90;
        final double pesos_argentinos = 0.0050;

        System.out.println("ingrese la cantidad de bolivianos que desea convertir");
        Scanner numero = new Scanner(System.in);
        double numero_ingresado = numero.nextDouble();

        double euros_resultado = numero_ingresado / euros;
        double dolares_resultado = numero_ingresado / dolares;
        double pesos_argentinos_resultado = numero_ingresado / pesos_argentinos;

        System.out.println("los bolivianos que ingreso son: " + numero_ingresado);
        System.out.println("sus bolivianos en euros es: " + euros_resultado);
        System.out.println("sus bolivianos en dolares es: " + dolares_resultado);
        System.out.println("sus bolivianos en pesos_argentinos es: " + pesos_argentinos_resultado);
    }
}