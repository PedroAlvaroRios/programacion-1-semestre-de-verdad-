/*Simulador de Contador: Crea un programa que empiece con un valor de 100 y aplique secuencialmente:
sumar 50, multiplicar por 2, restar 75 y dividir entre 5. Muestra el resultado después de cada operación.
* */
public class tarea3_3
{
    public static void main(String args[])
    {
        int numero_inicial=100;
        System.out.println("numero inicial "+numero_inicial);

        double numero_suma=numero_inicial+50;
        System.out.println("numero despues de suma +50 : "+numero_suma);

        double numero_multiplicar=numero_suma*2;
        System.out.println("numero despues de multiplicar 2 : "+numero_multiplicar);

        double numero_restar=numero_multiplicar-75;
        System.out.println("numero despues de restar -75 : "+numero_restar);

        double numero_dividir=numero_multiplicar/5;
        System.out.println("numero despues de dividir en 5 : "+numero_dividir);
    }
}
