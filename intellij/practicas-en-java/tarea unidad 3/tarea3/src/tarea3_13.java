/*13-	Tablas de Multiplicar: Usar ciclos anidados para imprimir las tablas de multiplicar
del 1 al 12 en un formato de columnas ordenadas. */


public class tarea3_13
{
    public static void main(String args[])
    {
        /*Un bucle anidado. Por cada vuelta del bucle exterior, el bucle interior se ejecuta completo.*/
        /*un bucle dentro de otro bucle*/

        for (int i = 1; i <= 12; i++)
        {
            System.out.println("tabla del: "+i);
            for (int f = 1; f <= 12; f++)
            {
                int resultado= i*f;
                System.out.println( i +" * "+ f +" = " +resultado);
            }
        }
    }
}