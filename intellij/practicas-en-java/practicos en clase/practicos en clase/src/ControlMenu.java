import java.util.Scanner;

/*
* array dinamico, crecion de un menu dinamico, se hara 3 bloques de vectores ,
* uno que maneje el id del objeto, el segundo que maneje el nombre del objeto y
* el tercero que maneje el valor de origen y hacer que se relacionen  como un menu
* */
public class ControlMenu
{
    static Scanner sc = new Scanner(System.in);
    static int ELEMENTOSMENU = 0; //este es el nmero de elementos en el menu
    static int MAXELEMENTOS = 25; //numero maximo de elementos en un vector
    public static void main(String[] arg)
    {
        int id[]= new int[MAXELEMENTOS];//control vector ID
        String nombre[]= new String[MAXELEMENTOS]; // control vector nombres
        int padre[]= new int[MAXELEMENTOS];//control vector Padre

        llenarVector(id,nombre,padre);//esta funcion llenara de valores los vectores
        mostraMenu(id,nombre,padre);//muestra los valores llenados
        navegarMenu(id,nombre,padre);//esto es lo que vera el usuario en orden y jerarquia
        // Navegacion es la funcion del cliente que sirve para navegar entre el menu
    }
    // FUNCIONES
    private static void llenarVector(int[] id,String[] nombre,int[] padre)
    {
        boolean salir=false;
        String opcion ;


        do{
            System.out.println("Elemento *" + (ELEMENTOSMENU+1) + "* ");
            id[ELEMENTOSMENU] = ELEMENTOSMENU+1;

            System.out.println("ingrese nombre *" + (ELEMENTOSMENU+1) + "* ");
            nombre[ELEMENTOSMENU]= sc.nextLine();

            System.out.println("ingrese padre *" + (ELEMENTOSMENU+1) + "* ");
            padre[ELEMENTOSMENU] = sc.nextInt();

            sc.nextLine();// esto ayuda a que pase a otra linea
            System.out.println("¿Desea continuar? (S : Salir)");
            opcion= sc.next();

            if (opcion.compareTo("S") == 0)
            {
                salir = !salir;
            }
            ELEMENTOSMENU++;
            sc.nextLine();
        }while(!salir);
    }
    private static void mostraMenu(int[] id,String[] nombre,int[] padre)
    {
        System.out.println("  ID        NOMBRE                  PADRE");
        System.out.println("*****************************************");
        for (int i=0 ; i<ELEMENTOSMENU; i++)
        {
            System.out.println(id[i]+"      "+nombre[i]+"       "+padre[i]);
        }
        System.out.println("*****************************************");
    }
    private static void navegarMenu(int[] id,String[] nombre,int[] padre)
    {
        // Exclusiva del cliente
        // primero mostrar el menu de todos los que son padres
        // al seleccionar un padre que entre den sus valores hijos(sus valores que son sus derivados)
        int opcion = 0;
        do {
            mostrarMenuNivel0(id,nombre,padre);

            if (opcion != 0)
            {
                mostrarMenuNivel1(id, nombre, padre, opcion);
            }
        }while (opcion != 0);

        mostrarMenuNivel0(id,nombre,padre);

        if (opcion != 0)
        {
            mostrarMenuNivel1(id, nombre, padre, opcion);
        }
    }
    private static int mostrarMenuNivel0 (int[] id,String[] nombre,int[] padre)
    {
        int opcion = 0 ;
        System.out.println("  ID        NOMBRE                  PADRE");
        System.out.println("*****************************************");
        for (int i=0 ; i<ELEMENTOSMENU; i++)
        {
            if (padre[i]==0)
            {
                System.out.println(id[i] + "      " + nombre[i] + "       " + padre[i]);
            }
        }
        System.out.println("*****************************************");
        opcion= sc.nextInt();
        return opcion;
    }
    private static void mostrarMenuNivel1 (int[] id,String[] nombre,int[] padre, int opcion)
    {
        System.out.println("*****************************************");
        for (int i=0 ; i<ELEMENTOSMENU; i++)
        {
            if (padre[i] ==opcion)
            {
                System.out.println(id[i] + "      " + nombre[i] + "       " + padre[i]);
            }
        }
        System.out.println("*****************************************");
    }
}
