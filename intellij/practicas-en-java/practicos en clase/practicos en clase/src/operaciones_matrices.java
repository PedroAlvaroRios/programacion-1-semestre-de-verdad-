import java.util.Scanner;

public class operaciones_matrices
{
    static int MAX_E = 30; //MAXIMO
    static int ELEMENTOS_FILA = 0;
    static int ELEMENTOS_COLUMNA = 0;
    static double[][] MatrizAlfa = new double[MAX_E][MAX_E]; //MATRIZ 1
    static double[][] MatrizBravo = new double[MAX_E][MAX_E]; //MATRIZ 2

    static double[][] MatrizSuma = new double[MAX_E][MAX_E]; //MATRIZ SUMA
    static double[][] MatrizResta = new double[MAX_E][MAX_E]; //MATRIZ RESTA
    static double[][] MatrizMultiplicacion = new double[MAX_E][MAX_E]; //MATRIZ MULTIPLICACION

    static double[][] MatrizInversaAlfa = new double[MAX_E][MAX_E]; //MATRIZ INVERSA
    static double[][] MatrizInversaBravo = new double[MAX_E][MAX_E];//MATRIZ INVERSA

    static double[][] MatrizRespaldoA = new double[MAX_E][MAX_E];//MATRIZ PARA ALMACENAR INVERSA
    static double[][] MatrizRespaldoB = new double[MAX_E][MAX_E];//MATRIZ PARA ALMACENAR INVERSA

    static Scanner entrada = new Scanner(System.in);

    public  static void main(String[] args)
    {
        IngresarDatos();
        SumaMatrices();
        RestaMatrices();
        MultiplicacionMatrices();
        InversaMatrices();
        IntercambiodeMatrices();
        ImprimirMatrices();
    }
    //funciones
    private static void IngresarDatos()
    {
        System.out.println("Ingrese la cantidad de filas ");
        ELEMENTOS_FILA = entrada.nextInt();

        System.out.println("Ingrese la cantidad de columnas ");
        ELEMENTOS_COLUMNA = entrada.nextInt();

        System.out.println("Ingrese la Matriz A ");
        for (int i = 0; i < ELEMENTOS_FILA; i++)
        {
            for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
            {
                System.out.print("A["+(i+1)+":"+(j+1)+"]");
                MatrizAlfa[i][j] = entrada.nextInt();
                System.out.println();
            }
        }

        System.out.println("Ingrese la Matriz B ");
        for (int i = 0; i < ELEMENTOS_FILA; i++)
        {
            for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
            {
                System.out.print("A["+(i+1)+":"+(j+1)+"]");
                MatrizBravo[i][j] = entrada.nextInt();
                System.out.println();
            }
        }
    }
    private static void SumaMatrices()
    {
        for (int i = 0; i < ELEMENTOS_FILA; i++)
        {
            for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
            {
                MatrizSuma[i][j] = MatrizAlfa[i][j] + MatrizBravo[i][j];
            }
        }
    }
    private static void RestaMatrices()
    {

        for (int i = 0; i < ELEMENTOS_FILA; i++)
        {
            for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
            {
                MatrizResta[i][j] = MatrizAlfa[i][j] - MatrizBravo[i][j];
            }
        }
    }
    private static void MultiplicacionMatrices()
    {

        for (int i = 0; i < ELEMENTOS_FILA; i++)
        {
            for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
            {
                MatrizMultiplicacion[i][j] = MatrizAlfa[i][j] * MatrizBravo[i][j];
            }
        }
    }
    //segun lo que entendi, la inversa es la potencia en -1 del numero ingresado
    private static void InversaMatrices()
    {

        for (int i = 0; i < ELEMENTOS_FILA; i++)
        {
            for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
            {
                MatrizInversaAlfa[i][j] = 1/MatrizAlfa[i][j];
            }
        }
        for (int i = 0; i < ELEMENTOS_FILA; i++)
        {
            for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
            {
                MatrizInversaBravo[i][j] = 1/MatrizBravo[i][j]; // -1/numero es el mismo que hacer la potencia de -1
            }
        }
    }

    //otro tipo de inversa podria ser el que la matriz A sea la matriz B y la Matriz B sea la Matriz A
    private static void  IntercambiodeMatrices()
    {
        for (int i = 0; i < ELEMENTOS_FILA; i++)
        {
            for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
            {
                MatrizRespaldoA[i][j] = MatrizAlfa[i][j]; //respaldoA = A
                MatrizRespaldoB[i][j] = MatrizBravo[i][j]; //respaldoB = B
            }
        }
    }


        private static void ImprimirMatrices()
        {
            //intento de ponerle titulos a las matrices
            //System.out.println("    Matriz Alfa     Matriz Bravo        Matriz Suma     Matriz Resta     Matriz Multiplicacion        Matriz Inversa Alfa          Matriz Inversa Bravo           Matriz Intercambiado Alfa           Matriz Intercambiado Bravo");
            for (int i = 0; i < ELEMENTOS_FILA; i++)
            {
                //Matriz Alfa
                System.out.print("I   ");
                for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
                {
                    System.out.printf("%5.0f", MatrizAlfa[i][j]); //%f puede utilizarse para double
                }
                System.out.print("   I     I   ");

                //Matriz Bravo
                for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
                {
                    System.out.printf("%5.0f", MatrizBravo[i][j]);//%d se utiliza para enteros
                }
                System.out.print("   I     I   ");

                //Matriz Suma
                for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
                {
                    System.out.printf("%5.0f", MatrizSuma[i][j]);
                }
                System.out.print("   I     I   ");

                //Matriz Resta
                for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
                {
                    System.out.printf("%5.0f", MatrizResta[i][j]);
                }
                System.out.print("   I     I   ");


                //Matriz Multiplicacion
                for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
                {
                    System.out.printf("%5.0f", MatrizMultiplicacion[i][j]);
                }
                System.out.print("   I     I   ");


                //Matriz Inversa Alfa
                for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
                {
                    System.out.printf("%5f", MatrizInversaAlfa[i][j]);
                    System.out.print("      ");
                }
                System.out.print("   I     I   ");


                //Matriz Inversa Bravo
                for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
                {
                    System.out.printf("%5f", MatrizInversaBravo[i][j]);
                    System.out.print("      ");
                }
                System.out.print("   I     I   ");


                //Intercambio de Matrices (A=B   B=A)
                //Matriz intercambio A
                for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
                {
                    System.out.printf("%5.0f", MatrizRespaldoB[i][j]);
                }
                System.out.print("   I     I   ");

                //Matriz intercambio B
                for (int j = 0; j < ELEMENTOS_COLUMNA; j++)
                {
                    System.out.printf("%5.0f", MatrizRespaldoA[i][j]);
                }
                System.out.print("     I");
                System.out.println(" ");
            }
        }
}
