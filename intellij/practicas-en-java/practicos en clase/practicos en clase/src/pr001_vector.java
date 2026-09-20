import java.util.Scanner;

public class pr001_vector
{
    public static void main(String[] arg)
    {
        // Construimos el vector de ciudades
        String[] ciudades = {"La Paz", "Santa Cruz", "Cochabamba", "Oruro", "Potosi", "Tarija", "Pando", "Beni", "Chuquisaca"};
        // Ponemos el tamaño del vector
        System.out.println("Tamaño " + ciudades.length);
        for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Ciudad " + (i + 1) + " = " + ciudades[i]); //i+1 es para que lo muestre desde el 1  y no desde el 0
        }
        // Construir el vector dimensionando apriori
        // Apriori se refiere al proceso de establecer parámetros críticos (umbrales)
        // antes de ejecutar el análisis para identificar reglas de asociación frecuentes en un conjunto de datos.
        int elementos = 10;
        double[] precios = new double[elementos];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < elementos; i++) {
            System.out.println("Precio [" + (i + 1) + "] = ");
            precios[i] = sc.nextDouble();
        }
        for (int i = 0; i < elementos; i++) {
            System.out.println("Precio " + (i + 1) + " = " + precios[i]);
        }

        // 1: Dimensionar 5 valores para instruducir nombres de personas
        int cantidad = 5;
        String[] nombres = new String[cantidad];
        Scanner nombre = new Scanner(System.in);
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Nombre [" + (i+1) + "] = ");
            nombres[i] = nombre.nextLine();
        }
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Nombre " + (i + 1) + " = " + nombres[i]);
        }

        // 2: Encontrar un nombre en el vector y mostrar la posicion (indice)
        String nombre_buscar = "Pedro";
        int indice = -1;
        for (int i = 0; i < nombres.length; i++) {
            buscar:
            if (nombres[i].equals(nombre_buscar)) {
                indice = i;
                break buscar;
            }
        }
        if (indice != -1)
        {
            System.out.println("la poscion en la que se encuentra es :" + (indice+1));

            // 3: Reemplazar el nombre de la posicion encontrada por otro nombre

            nombres[indice] = "xd";

            for (int i = 0; i < cantidad; i++) {
                System.out.println("Nombre " + (i + 1) + " = " + nombres[i]);
            }
        }

        // 4: valor alto



        int numeros = 10;
        double[] valores= new double[numeros];
        Scanner numero_ingresado = new Scanner(System.in);
        System.out.println("ingrese a continuacion numero varios para determinar el mayor y el menor");

        for (int i = 0; i < numeros; i++) {
            System.out.println("numero [" + (i + 1) + "] = ");
            valores[i] = numero_ingresado.nextDouble(); //recibe los numero en un double
        }

        double numero_mayor = valores[0]; //asumo que el primer valor ingresado es el mayor
        double numero_menor = valores[0]; //este valor se manendra hasta que se demuestre lo contrario
        for (int i = 0; i < numeros; i++) {

                if (valores[i] > numero_mayor) //utilizamos nota_mayor y no 0 para que pueda leer multiples veces y reempalazar si encuentra un mejor candidato
                    numero_mayor = valores[i];

        // 5: valor bajo
                if (valores[i] < numero_menor)
                    numero_menor = valores[i];
        }
        System.out.println("La numero es mayor es: " + numero_mayor);
        System.out.println("La numero es menor es: " + numero_menor);
    }
}

