/*
* 1- Permitir el ingreso de una cadena de caracteres , de tal manra que devuelva la cadena invertida
*
* Ejemplo:
* Cadena original: "Juan Perez"
* cadena resultado= "zereP nauJ"
* idea: hacer un for que recorra desde el ultimo numero hacia atras (i--)
* */
import java.util.Scanner;

public class caracteres_cadena
{
    public static void main(String[] arg)
    {
        String cadena_original="";
        String cadena_resultado="";

        System.out.println("ingrese la cadena de caracteres que desea invertir");
        Scanner sc = new Scanner(System.in);
        cadena_original=sc.nextLine();

        int tamano =cadena_original.length(); //length cuenta desde el 1 en vez desde el 0
        char letra=' ';
        //-1 ayuda a que se ajuste el desajuste que tiene por iniciar desde el 1 en vez del 0 al buscar el tamaño
        for (int i = tamano-1 ; i>=0 ; i--) //uso i-- para que vaya decrementando,
        {
            letra = cadena_original.charAt(i);
            cadena_resultado += letra; //+= hace que se ponga cadena_resultado = cadena_resultado + letra
        }
        System.out.println("cadena original: "+cadena_original);
        System.out.println("cadena resultado: "+cadena_resultado);
    }
}
