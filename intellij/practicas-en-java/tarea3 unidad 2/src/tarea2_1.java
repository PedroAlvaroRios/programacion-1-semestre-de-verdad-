/*
* Descomposición de Nombres: Dado un nombre completo en una sola variable (ej. "Ana María Pérez López"),
* extrae y muestra por separado el primer nombre, el segundo nombre y los apellidos utilizando exclusivamente
* los métodos substring() e indexOf().
* */

public class tarea2_1
{
    public static void main(String[] args)
    {

        String nombre_completo = "Ana María Pérez López";//se lo declara la variable en string que queremos sacar un substring y index
//las posiciones en numeros     : 0123456789...
        int nombre_1 = nombre_completo.indexOf("Ana");  //para sacar el indice para buscar una palabra primero se declara el string, este esta en 0
        int nombre_2 = nombre_completo.indexOf("María");//la enumeracion comienza en 0 y recorre un numero cada letra, este esta en 4
        int apellido_1 = nombre_completo.indexOf("Pérez");//este esta en la posicion 10 en cha
        int apellido_2 = nombre_completo.indexOf("López");//este esta en la posicion 16 en char

        System.out.println(nombre_1+" "+nombre_2+" "+apellido_1+" "+apellido_2);

        String nombre_sub_1 = nombre_completo.substring(0, 3); //colocamos los coordenadas que nos imprimio en consola anteriormente como un legth
        String nombre_sub_2 = nombre_completo.substring(4, 9); //el primer numero representa el incio de esta palabra
        String apellido_sub_1 = nombre_completo.substring(10, 15);//el segundo numero representa el final de esta palabra
        String apellido_sub_2 = nombre_completo.substring(16, 21);//la coma la utilizamos para definir el inicio y el final separandolos

        System.out.println(nombre_sub_1+" "+nombre_sub_2+" "+apellido_sub_1+" "+apellido_sub_2);

    }
}
