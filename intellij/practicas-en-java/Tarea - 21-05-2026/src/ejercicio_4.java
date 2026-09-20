/*

📝  Ejercicio Propuesto 4 [I] – Reemplazar elementos por su valor absoluto

Dada una matriz que puede contener valores negativos y positivos:

  a) Crear un método que reemplace cada elemento negativo por su valor absoluto.

  b) Imprimir la matriz antes y después de la operación.



Recuerda: el valor absoluto de -7 es 7. Puedes usar Math.abs(x).

Reflexiona: ¿el método modifica la matriz original o una copia?

respuesta: modificare la matriz original
 */
import java.util.Random;

public class ejercicio_4
{
    //limites para matrizes
    static int min = -50; //limine minimo
    static int max = 50;  //limite maximo

    public static int[][] matrizRandom(int filas, int columnas) {
        Random random = new Random();
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return matriz;
    }

    // esto reempalazara cada valor negativo por su valor absoluto
    public static void Absolutizador(int[][] matriz)
    {
        for (int i = 0; i < matriz.length; i++)
        {
            for (int j = 0; j < matriz[i].length; j++)
            {
                if (matriz[i][j] < 0)
                {
                    matriz[i][j] = Math.abs(matriz[i][j]);
                }
            }
        }
    }

    // metodo para imprimir la matriz
    private static void imprimirMatriz(int[][] m)
    {
        for (int i = 0; i < m.length; i++)
        {
            for (int j = 0; j < m[i].length; j++)
            {
                System.out.printf("%5d", m[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] arg)
    {
        // definimos el tamaño de la matriz
        int filas = 4;
        int columnas = 5;

        //lo mandamos a aleatorizarse
        int[][] matrizAleatoria = matrizRandom(filas, columnas);

        System.out.println("=== matriz original (valores aleatorios entre " + min + " y " + max + ") ===");
        imprimirMatriz(matrizAleatoria);

        // lo absolutizamos
        Absolutizador(matrizAleatoria);

        System.out.println("=== matriz absotulisada (negativos convertidos a absolutos) ===");
        imprimirMatriz(matrizAleatoria);
    }
}