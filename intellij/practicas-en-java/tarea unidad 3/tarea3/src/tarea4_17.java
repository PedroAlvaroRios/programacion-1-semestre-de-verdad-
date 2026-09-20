/*17-	Menú de Usuario: Crear un menú que se repita hasta que el usuario elija la opción "Salir".
Las opciones deben ser: 1) Saludar, 2) Calcular Factorial, 3) Número Aleatorio, 0) Salir. */

import java.util.Scanner;

public class tarea4_17 {
    public static void main(String[] args) {
        int opciones = 0;
        int opmenu = 0;
        long respuesta = 1;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("┌────────────────────────────────┐▒");
            System.out.println("│        MENÚ OPCIONES           │▒");
            System.out.println("├────────────────────────────────┤▒");
            System.out.println("│    1. SALUDAR                  │▒");
            System.out.println("│    2. CALCULAR FACTORIAL       │▒");
            System.out.println("│    3. NUMERO ALEATORIO         │▒");
            System.out.println("│    0. SALIR DEL SISTEMA        │▒");
            System.out.println("┴────────────────────────────────┴▒");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            opciones = teclado.nextInt();
            if (opciones == 1) {
                do {

                    System.out.println("Buenos dias, tardes o lo que proceda");
                    System.out.println("┌──────────────────────────────────────────────────┐▒");
                    System.out.println("│ INGRESE 0 PARA VOLVER                            │▒");
                    System.out.println("│ INGRESE CUALQUIER OTRO NUMERO PARA REPETIR OPCION│▒");
                    System.out.println("┴──────────────────────────────────────────────────┴▒");
                    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    opmenu = teclado.nextInt();

                } while (opmenu != 0);
            }
            if (opciones == 2) {
                do {

                    System.out.println("ingrese el numero que desea ver en factorial");
                    Scanner factorial = new Scanner(System.in);
                    int factorial_num = factorial.nextInt();


                    for (long i = 1; i <= factorial_num; i++) {
                        respuesta = respuesta * i;
                    }
                    System.out.println("el factorial de: " + factorial_num + " es: " + respuesta);
                    respuesta = 1;

                    System.out.println("┌──────────────────────────────────────────────────┐▒");
                    System.out.println("│ INGRESE 0 PARA VOLVER                            │▒");
                    System.out.println("│ INGRESE CUALQUIER OTRO NUMERO PARA REPETIR OPCION│▒");
                    System.out.println("┴──────────────────────────────────────────────────┴▒");
                    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    opmenu = teclado.nextInt();

                } while (opmenu != 0);

            }
            if (opciones == 3) {
                do {

                    int numero_random = (int) (Math.random() * 100);//Int se asegura que sea un entero
                    System.out.println(numero_random);//Random busca un número aleatorio en el rango dado(1 a 0) y lo sacamos por 100 para que sa un número del al 100
                    System.out.println("┌──────────────────────────────────────────────────┐▒");
                    System.out.println("│ INGRESE 0 PARA VOLVER                            │▒");
                    System.out.println("│ INGRESE CUALQUIER OTRO NUMERO PARA REPETIR OPCION│▒");
                    System.out.println("┴──────────────────────────────────────────────────┴▒");
                    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    opmenu = teclado.nextInt();

                } while (opmenu != 0);
            }
            if (opciones == 0) {
                System.out.println("saliendo del sistema...");
            }
        } while (opciones != 0);
    }
}