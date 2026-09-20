/*

📝  Ejercicio Propuesto 3 [B] – Contar elementos negativos

Diseña un método estático 'contarNegativos(int[][] m)' que reciba una matriz

y retorne cuántos elementos son estrictamente negativos (menores que cero).

Pruébalo con al menos dos matrices de diferente tamaño.
 */
import java.util.Random;

public class ejercicio_3 {

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

    // contar negativos (que sea menor a 0)
    public static int contarNegativos(int[][] matrizEntregada) {
        int contador = 0;
        for (int i = 0; i < matrizEntregada.length; i++) {
            for (int j = 0; j < matrizEntregada[i].length; j++) {
                if (matrizEntregada[i][j] < 0) {
                    contador++;
                }
            }
        }
        return contador;
    }

    // imprimir matriz
    private static void imprimirMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%4d", m[i][j]);
            }
            System.out.println();
        }
    }
    //nota: es mejor hacer el main al final y las funciones antes para evitar inconsistencia en valores repetidos y tener todo declarado
    public static void main(String[] args) {

        int[][] matriz1 = matrizRandom(3, 3);//en el primer numero definimos la cantidad de filas
        int[][] matriz2 = matrizRandom(2, 4);//en el segundo numero definimos la cantidad de columnas

        System.out.println("*** Matriz 1 (3x3) ***");
        imprimirMatriz(matriz1);
        int negativos1 = contarNegativos(matriz1);
        System.out.println("Cantidad de negativos: " + negativos1);
        System.out.println();

        System.out.println("*** Matriz 2 (2x4) ***");
        imprimirMatriz(matriz2);
        int negativos2 = contarNegativos(matriz2);
        System.out.println("Cantidad de negativos: " + negativos2);
    }
}

