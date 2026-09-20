/*11-	Filtro de Números: Usar un ciclo "for" para mostrar los números del 1 al 50 que sean divisibles entre 3 o entre 5,
pero que no sean divisibles entre ambos a la vez. */

public class tarea3_11
{
    public static void main(String[] args)
    {
        int i;
        for (i=1;i<=50;i++)
        {
            boolean div3  = (i % 3 == 0);//aqui aplicare algo de algebra
            boolean div5  = (i % 5 == 0);
            boolean div15 = (i % 15 == 0); // este si o si es divisible entre ambos por lo que vamos a descartarlo de cajon

            if ((div3 || div5) && !div15) //si todo es verdadero entonces imprimira el mensaje
            {
                System.out.println(i);
            }
        }
    }
}