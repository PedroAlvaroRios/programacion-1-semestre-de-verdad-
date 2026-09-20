
import java.util.Scanner;
public class Palabras
{
    public static void main(String[] arg)
    {
        int cantidad=0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese numero entre 1 a 26");
            System.out.println("Digite 0 para salir");
            cantidad = sc.nextInt();
            if (cantidad >26)
            {
                System.out.println("Digite un numero correcto");
            }
            else if (cantidad >=1 && cantidad <=26)
            {
                //aqui deberia entrar si se cumplen los parametros
                imprimirletras(cantidad);
            }

        }while (cantidad!=0);
    }
    public static void imprimirletras(int cant)
    {
        String cadena = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("la cadena es = ");
        System.out.println(cadena.substring(0,cant));
    }
}
