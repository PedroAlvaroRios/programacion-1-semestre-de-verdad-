import java.util.Scanner;

//los 4 tipos de funciones en Java
//(E=entrada, S=salida)
public class funciones_java
{
    //Primera funciones es la principal
    //Tiene parametros, pero no devuelve nada
    public static void main(String[] arg)
    {
        //Sin entradas (parametros), ni salidas
        imprimirmenu();
        //Sin entradas, con salidas
        int opcion = leermenu();
        //Con entradas, sin salidas
        ImprimirArea(15.8,10.4);
        //Con entrada y salida
        //tambien se le podria definir variables para evitar poner directamente valores
        Double area = AreaRectangulo(15.8,10.4); //esto envia valores a una funcion, tambien podria enviar variables
        System.out.println("El area del rectangulo es "+area);
    }
    // E = si, S=no
    public static void imprimirmenu()
    {
        System.out.println("************************");
        System.out.println("    MENU PRINCIPAL");
        System.out.println("************************");
    }
    //funcion E=no, S=si
    public static int leermenu()
    {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        System.out.println("************************");
        System.out.println("    MENU PRINCIPAL");
        System.out.println("    1: opcion A");
        System.out.println("************************");
        opcion = sc.nextInt();
        return opcion; //salida
    }
    //funcion E=si S=no
    //no tiene salida or lo tanto se utiliza void
    //no hay salida en el main
    public static void ImprimirArea(Double x, Double y)
    {
        System.out.println(x*y);
    }
    //funcion E=si S=si
    public static Double AreaRectangulo(Double x1, Double y1)//se puede recibir y enviar en otras variables
    {
        return x1*y1; //un return representa una salida y que devuelve un valor que no esta vacio(void)
    }
}