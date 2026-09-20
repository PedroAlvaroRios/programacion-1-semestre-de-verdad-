import java.util.Scanner;

public class Trabajo_Caracteres
{
    public static void main(String[] arg)
    {
        //tamaño de una cadena
        System.out.println("ingrese una cadena");
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine(); //la deferencia entre next y nextLine esque next line aguanta espacios mientras que next no
        System.out.println("La cadena tiene un largo de "+cadena.length()+" caracteres"); //devuelve el largo de la cadena
        // Uso de CharAt()
        //esto hara que imprima 1 cosa por caracter que cuente
        int tamano = cadena.length();
        for(int i = 0;i<tamano;i++)
        {
            System.out.print(cadena.charAt(i) + "*"); //esto va ir recorriendo letra por letra agregandole asterisco (*)
        }

        // Comparacion entre cadenas
        System.out.println("Ingrese la nueva cadena");
        String nuevacadena = sc.nextLine();
        System.out.println("Comparando: "+cadena.compareTo(nuevacadena)); // esto comparara el valor de las dos cadenas
        System.out.println("Comparando iguales: "+cadena.equals(nuevacadena)); // devolvera falso(si no son iguales) o verdadero (si son iguales)
        System.out.println("Comparando iguales M/m: "+cadena.equalsIgnoreCase(nuevacadena)); // devolvera falso(si no son iguales) o verdadero(si son iguales) sin tomas en cuenta la mayuscla y minuscula

        // contains() si la cadena contiene un caracter
        System.out.println("Cadena contiene la cadena s? " + cadena.contains("s"));//devolvera falso(si no encuentra) y verdadero(si encuentra), toma en cuenta mayusculas y minusculas

        // IndexOf()
        // cambia la letra n por un asterisco
        // universidad --> u*iversidad
        int posicion = cadena.indexOf("n"); //busca la posicion de n
        cadena= cadena.replace("n","*");  //se lo reemplaza por un *
        System.out.println("la nueva cadena es: "+cadena);
        System.out.println("Encontre la letra en la posicion: "+posicion); //imprime -1 si no encuentra nada

    }
}
