/*
*
* autor: Pedro Rios y Tatiana (como espectadora)
* Fecha: 30-Marzo-2026
*
* */
public class Main {
    public static void main (String[] args)
    {
        System.out.printf("Hola,bienvenido a mi primer programa");
        //declaracion de variables
        int edad; //declaracion de entero
        float precio = 154.85F; //cuando utilizamos float terminanos con F
        short piso = 15; //lee una cantidad de numeros pequeña
        double punto = 451221.857412; //lee una cantidad de numeros mas grande
        char letra = 'D'; //recibe solo una letra, se escribe con comillas simples
        String nombre = "Pedro Rios"; //lee el nombre, una cadena de caracteres leida por string
        edad = 55;
        System.out.print(edad+ "\n"); // "\n" se utiliza para dar un espacio, bajando de linea
        // "\n" tambien se puede utilizar si quieres imprimir mas de una variable en una linea de codigo
        System.out.print("Edad: "+edad+"\n Precio: "+precio+"\n Piso: "+piso); //utilizar "+" hacer que lea mas de una variable
        System.out.println(piso); //println a diferencia de print, le pondra un espacio, bajando una linea
        System.out.println(punto);
        System.out.println(nombre);
        System.out.println(letra);
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║   Hola mundo                   ║");
        System.out.println("╚════════════════════════════════╝");
        /*
        * ╔ = 201           * ═ = 205           ╗ = 187
        * ║ = 186           * ╚ = 200           ╝ = 188
        * */
    }
}