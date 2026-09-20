/*

📝  Ejercicio Propuesto 7 [I] – Cuadrado mágico (verificación)

Un cuadrado mágico n x n es una matriz donde la suma de cada fila, cada columna

y ambas diagonales es igual a la misma constante (el 'número mágico').



Escribe un método: static boolean esMagico(int[][] m)

El método debe verificar:

  1. La misma suma en todas las filas.

  2. La misma suma en todas las columnas.

  3. La misma suma en las dos diagonales.



Pruébalo con el cuadrado mágico 3x3:

  2 7 6

  9 5 1

  4 3 8

  (Número mágico = 15)
 */

import java.util.Random;

public class ejercicio_7
{
    static int minValor = 1;
    static int maxValor = 20;
    static int tamanio = 3;//tamaño de la matriz random

    // metodo que verifica si una matriz cuadrada es un cuadrado magico
    public static boolean esMagico(int[][] m)
    {
        int tamano_matriz = m.length;

        // calculamos la suma de la primera fila como referencia (numero magico esperado)
        int suma = 0;
        for (int j = 0; j < tamano_matriz; j++)
        {
            suma += m[0][j];
        }

        // verificar todas las filas
        for (int i = 0; i < tamano_matriz; i++)
        {
            int sumaFila = 0;
            for (int j = 0; j < tamano_matriz; j++)
            {
                sumaFila += m[i][j];
            }
            if (sumaFila != suma)
                return false;
        }

        // verificar todas las columnas
        for (int j = 0; j < tamano_matriz; j++)
        {
            int sumaColumna = 0;
            for (int i = 0; i < tamano_matriz; i++)
            {
                sumaColumna += m[i][j];
            }
            if (sumaColumna != suma)
                return false;
        }

        // verificar diagonal principal (de izquierda a derecha)
        int sumaDiagonalPrincipal = 0;
        for (int i = 0; i < tamano_matriz; i++)
        {
            sumaDiagonalPrincipal += m[i][i];
        }
        if (sumaDiagonalPrincipal != suma)
            return false;

        // verificar diagonal secundaria (de derecha a izquierda)
        int sumaDiagonalSecundaria = 0;
        for (int i = 0; i < tamano_matriz; i++)
        {
            sumaDiagonalSecundaria += m[i][tamano_matriz - 1 - i];
        }
        if (sumaDiagonalSecundaria != suma)
            return false;

        return true;
    }

    // funcion para que se imprima de manera que si parece una matriz
    private static void imprimirMatriz(int[][] m)
    {
        for (int i = 0; i < m.length; i++)
        {
            for (int j = 0; j < m[i].length; j++)
            {
                System.out.printf("%4d", m[i][j]);
            }
            System.out.println();
        }
    }

    // matriz generada de mandera aleatoria
    public static int[][] matrizRandom(int tamanio, int min, int max)
    {
        Random random = new Random();
        int[][] matriz = new int[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++)
        {
            for (int j = 0; j < tamanio; j++)
            {
                matriz[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return matriz;
    }

    public static void main(String[] arg)
    {
        // Cuadrado magico 3x3 del ejemplo (numero magico = 15)
        int[][] cuadradoMagico = {
                {2, 7, 6},
                {9, 5, 1},
                {4, 3, 8}
        };

        System.out.println("matriz magica del ejemplo (Número mágico = 15) :");
        imprimirMatriz(cuadradoMagico);
        System.out.println("¿Es magico? " + (esMagico(cuadradoMagico) ? "SI" : "NO"));//prueba magica
        System.out.println();

        // Matriz NO magica (modificamos un valor)
        int[][] noMagico = {
                {2, 7, 6},
                {9, 5, 1},
                {4, 4, 8}   //cambie el 3 por el 4 para des-magisarlo
        };

        System.out.println("=== MATRIZ NO MAGICA ===");
        imprimirMatriz(noMagico);
        System.out.println("¿Es magico? " + (esMagico(noMagico) ? "SI" : "NO")); //operacion ternaria
        System.out.println();

        // ejemplo con matriz aleatoria, puede que salga de manera magica pero es poco probable que algo asi suceda

        int[][] matrizRandom = matrizRandom(tamanio, minValor, maxValor);

        System.out.println("=== MATRIZ ALEATORIA (" + tamanio + "x" + tamanio + ") valores entre " + minValor + " y " + maxValor + " ===");
        imprimirMatriz(matrizRandom);
        System.out.println("¿Es magico? " + (esMagico(matrizRandom) ? "SI (casualidad!)" : "NO (es lo normal)"));
    }
}