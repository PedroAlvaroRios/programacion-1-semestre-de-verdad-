/*
📝  Ejercicio Propuesto 5 [I] – Verificar si una matriz es diagonal

Una matriz cuadrada es DIAGONAL si todos los elementos fuera de la diagonal

principal son cero (pero los de la diagonal pueden ser cualquier valor).

Escribe el método: static boolean esDiagonal(double[][] m)

Pruébalo con:

  Matriz A = {{5,0,0},{0,3,0},{0,0,7}}  (DIAGONAL)

  Matriz B = {{5,1,0},{0,3,0},{0,0,7}}  (NO diagonal)
  */


import java.util.Random;

public class ejercicio_5
{
    //limites para matrizes
    static int min = -50; //limine minimo
    static int max = 50;  //limite maximo



    // metodo que verifica si una matriz cuadrada es diagonal
    public static boolean esDiagonal(int[][] m) //m = matriz
    {
        for (int i = 0; i < m.length; i++)
        {
            for (int j = 0; j < m[i].length; j++)
            {
                // si estamos fuera de la diagonal principal y el valor no es cero
                if (i != j && m[i][j] != 0.0)
                {
                    return false; // encontramos un elemento no cero fuera de diagonal
                }
            }
        }
        return true; // todos los elementos fuera de diagonal son cero
    }

    // metodo para imprimir una matriz de doubles (con formato)
    private static void imprimirMatriz(int[][] matriz)
    {
        for (int i = 0; i < matriz.length; i++)
        {
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++)
            {
                System.out.printf("%6d", matriz[i][j]);//d para numero enteros int
            }
            System.out.println("   |");
        }
    }

    // metodo que genera una matriz aleatoria (con valores entre min y max)
    public static int[][] matrizRandom(int tamanio)
    {
        Random random = new Random();
        int[][] matriz = new int[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++)
        {
            for (int j = 0; j < tamanio; j++)
            {
                matriz[i][j] = random.nextInt(max - min + 1) + min; //numero aleatorio entre los rangos que definimos arriba
            }
        }
        return matriz;
    }

    // metodo que genera una matriz diagonal aleatoria (valores en diagonal, ceros fuera)
    public static int[][] generarMatrizDiagonalAleatoria(int tamanio)
    {
        Random random = new Random();
        int[][] matriz = new int[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++)
        {
            for (int j = 0; j < tamanio; j++)
            {
                if (i == j)//verificamos que este en diagonal
                {
                    matriz[i][j] =  random.nextInt(max - min + 1) + min;//numero aleatorio entre los rangos que definimos arriba
                }
                else
                {
                    matriz[i][j] = 0; //nos aseguramos todo lo que no este en la diagonal lo cambiamos a un valor 0
                }
            }
        }
        return matriz;
    }

    public static void main(String[] arg)
    {
        // Matriz A (diagonal) del ejemplo
        int[][] matrizA = {
                {5, 0, 0},
                {0, 3, 0},
                {0, 0, 7}
        };

        // Matriz B (NO diagonal) del ejemplo
        int[][] matrizB = {
                {5, 1, 0},
                {0, 3, 0},
                {0, 0, 7}
        };

        //matriz A del ejemplo
        System.out.println("matriz de ejemplo:");
        System.out.println("Matriz A:");
        imprimirMatriz(matrizA);

                                                                                   //operador ternario para acortar el ejercicio
        System.out.println("¿Es diagonal? " + (esDiagonal(matrizA) ? "SI" : "NO"));//variable = (condición) ? valorSiVerdadero : valorSiFalso;
        System.out.println();

        //matriz B del ejemplo
        System.out.println("Matriz B:");
        imprimirMatriz(matrizB);

        System.out.println("¿Es diagonal? " + (esDiagonal(matrizB) ? "SI" : "NO"));
        System.out.println();

        // MATRICES ALEATORIAS
        System.out.println("matrices aleatorias");

        // Matriz aleatoria normal
        int[][] matrizRandom = matrizRandom(4);
        System.out.println("Matriz aleatoria para comprobar:");
        imprimirMatriz(matrizRandom);
        System.out.println("¿Es diagonal? " + (esDiagonal(matrizRandom) ? "SI" : "NO"));
        System.out.println();

        // Matriz diagonal aleatoria
        int[][] matrizDiagonalRandom = generarMatrizDiagonalAleatoria(4);
        System.out.println("Matriz diagonal:");
        imprimirMatriz(matrizDiagonalRandom);
        System.out.println("¿Es diagonal? " + (esDiagonal(matrizDiagonalRandom) ? "SI" : "NO"));
    }
}