import java.util.Scanner;

public class Matriz001
{
    public static void main(String[] arg)
    {
        //dimensionar la matriz cuadrada
        int dimension =3;
        double[][] Pasajes = new double[dimension][dimension];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<dimension ; i++) //columnas
        {
            for (int j = 0; j<dimension ; j++) // filas
            {
                System.out.println(" ingrese M(("+j+")"+i+")");
                Pasajes[j][i]= sc.nextDouble();
                System.out.println();
            }
        }

        //imprimir matrices
        for (int i = 0; i<dimension ; i++) //columnas
        {
            for (int j = 0; j<dimension ; j++) // filas
            {
                System.out.println("M(("+j+")"+i+")=  "+ Pasajes[j][i]);

            }
        }
    }
}
