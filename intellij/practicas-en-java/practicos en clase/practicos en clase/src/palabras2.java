import java.util.Scanner;
public class palabras2 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int inicio = 0;
        int fin = 0;

        // inicio cadena
        do {
            System.out.println("Ingrese numero entre 1 y 25 para la primera letra:");
            System.out.println("Digite 0 para salir");
            inicio = sc.nextInt();

            if (inicio == 0) {
                System.out.println("Saliendo...");
                System.exit(0);
            }
            if (inicio > 25 || inicio < 1) {
                System.out.println("Digite un numero entre 1 y 26");
            }
        } while (inicio > 25 || inicio < 1);

        // fin cadena
        do {
            System.out.println("Ingrese numero entre " + (inicio + 1) + " y 26 para la ultima letra:");
            System.out.println("Digite 0 para salir");
            fin = sc.nextInt();
            if (fin == 0) {
                System.out.println("Saliendo...");
                System.exit(0);
            }
            if (fin > 26 || fin <= inicio) //aqui obligamos a que el fin sea mayor que el inicio
            {
                System.out.println("Digite un numero mayor a " + inicio + " y hasta 26");
            }
        } while (fin > 26 || fin <= inicio);
        imprimirletras(inicio, fin); //se lo llama solo una vez
    }

    public static void imprimirletras(int ini, int fi) {
        String cadena = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String resultado = cadena.substring(ini - 1, fi); // -1 para poder ajustarlo al substring (A=0)
        System.out.println("resultado de cadena : " + resultado);
    }
}