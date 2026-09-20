/*4-	Geometría con Constantes: Calcular el área y el perímetro de un rectángulo.
 Definir el largo (8.5) y el ancho (4.2) como constantes usando la palabra "final".
 Mostrar resultados con dos decimales.
 */

    public class tarea1_4
    {
        public static void main(String[] args)
        {
            //definimos el largo y el ancho como constantes
            final float largo = 8.5F; //final hace que el valor no se pueda cambiar
            final float ancho = 4.2F;

            float rectangulo_area= ancho * largo; //se puede cambiar las variables derivadas de un constante

            float rectangulo_perimetro=(ancho*2)+(largo*2);

            System.out.printf("el area del rectangulo es igual a : %8.2f %n", rectangulo_area); //utilizamos %8.2F para que imprima 2 decimales
            System.out.printf("el perimetro del rectangulo es igual a: %8.2f %n", rectangulo_perimetro); //utilizamos %n para que imprima en otra linea
        }
    }