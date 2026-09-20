import java.util.Scanner;

public class vectores_nombres_examen
{
    public static void main(String[] arg)
    {
        Scanner numero = new Scanner(System.in);

        System.out.println("ingrese a continuacion su cantidad de nombres que desea ingresar");
        int cantidad = numero.nextInt();
        String[] nombres = new String[cantidad];
        char[] iniciales = new char[cantidad];

        Scanner ingreso_nombres = new Scanner(System.in);

        System.out.println("ingrese a continuacion su cantidad de nombres que pidio");
      for (int i = 0; i < cantidad; i++) {
            System.out.println("Nombre [" + (i + 1) + "] = ");
            nombres[i] = ingreso_nombres.nextLine();
        }

        for (int i = 0; i < cantidad; i++) {
             iniciales[i] = nombres[i].charAt(0); //  esto extraera las iniciales
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println("inicial" + (i + 1) + " = " + iniciales[i]); //  esto extraera las iniciales
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Nombre " + (i + 1) + " = " + nombres[i]); //  esto imprimira todoss los valores de el array
        }
        System.out.println("los nombres que contienen mi inicial");
        for (int i = 0; i < cantidad; i++) {
            if (nombres[i].startsWith("P"))
            {
                System.out.println("Nombre " + (i + 1) + " = " + nombres[i]); //eso imprimira los que tengan mi inicial
            }
        }
        System.out.println("los nombres que contienen la palabra ( io ) en su nombre");
        for (int i = 0; i < cantidad; i++) {
            if (nombres[i].contains("io"))
            {
                System.out.println("Nombre " + (i + 1) + " = " + nombres[i]); //eso imprimira los que tengan mi io
            }
        }
        System.out.println("los nombres que terminan con la letra (a)");
        for (int i = 0; i < cantidad; i++) {
            if (nombres[i].endsWith("a"))
            {
                System.out.println("Nombre " + (i + 1) + " = " + nombres[i]); //eso imprimira los que tengan al final "a"
            }
        }
    }
}
