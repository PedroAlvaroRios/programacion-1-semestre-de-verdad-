/*

📝  Ejercicio Propuesto 2 [B] – Suma de cada columna

Dada una matriz de enteros de dimensión 4x5 inicializada con valores aleatorios

entre 1 y 50:

  a) Calcular e imprimir la suma de cada columna.

  b) Indicar cuál columna tiene la mayor suma.



Pista: Guarda las sumas de cada columna en un arreglo auxiliar de una dimensión.
 */
import java.util.Random;

public class ejercicio_2
{
    static int MAX_E = 30; //MAXIMO
    //matriz 4*5 como se había especificado
    static int ELEMENTOS_FILA = 4;
    static int ELEMENTOS_COLUMNA = 5;
    static int[][] MatrizAlfa = new int[MAX_E][MAX_E];
    static int[] arregloColumna = new int[MAX_E];//aqui colocaremos el resultado de la suma de columnas


    public static void main(String[] args)
    {
        IngresarDatos();
        SumaMatrices();
        ImprimirMatrices();
        ValorMaximo();
    }

    private static void IngresarDatos()
    {
        Random random = new Random();

        //LLENAR DE ELEMENTOS LAS MATRICES
        for (int i = 0; i < ELEMENTOS_FILA; i++)
        {
            for (int j = 0; j < ELEMENTOS_COLUMNA; j++) {
                MatrizAlfa[i][j] = random.nextInt(1, 50);//definimos el inicio y el fin de el random
            }
        }
    }

    private static void SumaMatrices()
    {

        for (int i = 0; i < ELEMENTOS_COLUMNA; i++)
        {
            int suma = 0;
            for (int j = 0; j < ELEMENTOS_FILA; j++)
            {
                suma += MatrizAlfa[j][i]; //
            }
            arregloColumna[i] = suma;
        }
    }

    private static void ImprimirMatrices()
    {
        for (int i = 0; i < ELEMENTOS_FILA; i++)
        {
            //Matriz Alfa
            for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
            {
                System.out.printf("%5d", MatrizAlfa[i][j]);
            }
            System.out.println();
        }
        System.out.println("suma columna:");

        for (int i = 0; i < ELEMENTOS_COLUMNA; i++) {
            System.out.printf("%5d", arregloColumna[i]);
        }


    }

    private static void ValorMaximo()
    {
        //esto buscara el numero mas alto en el arreglo de las sumas por columnas que hicimos
        int numeroMaximo = 0;
        for (int i = 0; i < ELEMENTOS_COLUMNA; i++)
        {
            if (arregloColumna[i] > numeroMaximo)
            {
                numeroMaximo = arregloColumna[i];
            }
        }
        System.out.println(" ");
        System.out.println("EL NUMERO MAS ALTO DE LA SUMA DE COLUMNAS ES:" + numeroMaximo);
    }
}