/*

📝  Ejercicio Propuesto 1 [B] – Llenar y mostrar una matriz

Escribe un programa que:

  a) Solicite al usuario las dimensiones de una matriz (filas y columnas).

  b) La llene con los números del 1 hasta filas*columnas en orden de lectura

     (fila 0 de izquierda a derecha, luego fila 1, etc.).

  c) La imprima de forma tabular con printf para que las columnas estén alineadas.



Ejemplo para 3x4:

   1   2   3   4

   5   6   7   8

   9  10  11  12
 */
import java.util.Scanner;

public class ejercicio_1
{
    static int MAX_E = 30; //MAXIMO
    static int ELEMENTOS_FILA = 0;
    static int ELEMENTOS_COLUMNA = 0;
    static int[][] MatrizAlfa = new int[MAX_E][MAX_E]; //MATRIZ 1
    static Scanner entrada = new Scanner(System.in);

    public static void  main(String[] args)
    {
        IngresarDatos();
        ImprimirMatrices();
    }
    private static void IngresarDatos()
    {
        int secuencia = 1;
        System.out.println("Ingrese la cantidad de filas ");
        ELEMENTOS_FILA = entrada.nextInt();

        System.out.println("Ingrese la cantidad de columnas ");
        ELEMENTOS_COLUMNA = entrada.nextInt();

        //LLENAR DE ELEMENTOS LAS MATRICES
        for (int i = 0; i < ELEMENTOS_FILA; i++)
        {
            for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
            {
                MatrizAlfa[i][j] = secuencia;
                secuencia++;
            }
        }
    }
    private static void ImprimirMatrices()
    {
        for (int i = 0; i < ELEMENTOS_FILA; i++)
        {
            //Matriz Alfa
            for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
            {
                System.out.printf ("%5d", MatrizAlfa[i][j]);
            }
            System.out.println();
        }
    }
}