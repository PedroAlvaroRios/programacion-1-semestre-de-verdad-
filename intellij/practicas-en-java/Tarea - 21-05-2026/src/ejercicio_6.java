/*
📝  Ejercicio Propuesto 6 [I] – Espiral de una matriz cuadrada

        Dada una matriz cuadrada n x n, imprimir sus elementos en orden espiral

        (desde el borde exterior hacia el centro, en sentido horario).

        Para la matriz:

        1  2  3

        4  5  6

        7  8  9

        La salida en espiral sería: 1 2 3 6 9 8 7 4 5

        Pista: Mantén cuatro límites variables (top, bottom, left, right) y

        ve recortándolos conforme terminas cada capa.
        */

import java.util.Random;

public class ejercicio_6
{
    public static void imprimirEspiral(int[][] matriz)
    {
        int n = matriz.length; // la matriz es cuadrada n x n
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right)
        {
            // recorrer fila superior (de izquierda a derecha)
            for (int i = left; i <= right; i++)
            {
                System.out.print(matriz[top][i] + " ");
            }
            top++;

            // recorrer columna derecha (de arriba hacia abajo)
            for (int i = top; i <= bottom; i++)
            {
                System.out.print(matriz[i][right] + " ");
            }
            right--;

            // recorrer fila inferior (de derecha a izquierda) si aun hay filas
            if (top <= bottom)
            {
                for (int i = right; i >= left; i--)
                {
                    System.out.print(matriz[bottom][i] + " ");
                }
                bottom--;
            }

            // recorrer columna izquierda (de abajo hacia arriba) si aun hay columnas
            if (left <= right)
            {
                for (int i = bottom; i >= top; i--)
                {
                    System.out.print(matriz[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println(); // salto de linea al final
    }

    // metodo para imprimir la matriz con formato de cuadro
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

    // metodo que genera una matriz cuadrada aleatoria con valores entre min y max
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
        // matriz del ejemplo
        int[][] matrizEjemplo = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("=== MATRIZ DEL EJEMPLO (3x3) ===");
        imprimirMatriz(matrizEjemplo);
        System.out.print("Orden espiral: ");
        imprimirEspiral(matrizEjemplo);
        System.out.println();

        // matriz aleatoria 4x4
        int tamanio = 4;
        int minValor = 1;
        int maxValor = 20;
        int[][] matrizRandom = matrizRandom(tamanio, minValor, maxValor);

        System.out.println("=== MATRIZ ALEATORIA (" + tamanio + "x" + tamanio + ") con valores entre " + minValor + " y " + maxValor + " ===");
        imprimirMatriz(matrizRandom);
        System.out.print("Orden espiral: ");
        imprimirEspiral(matrizRandom);
    }
}