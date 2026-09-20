import java.util.Scanner;

/*
* Programa que muestra uso de funciones
* y uso de arreglo unidimensional
* */
public class Programa07052026
{
    public static int ELEMENTOS = 0;    //ELEMENTOS_FILA nos almacenara la cantidad de producotos que tenemos.

    static double precios[] = {12000.00, 3000.00, 5000.00, 500.00, 350.00, 700.00, 5000.00};//esto es un array estos son los precios de pendiendo la posicion con respecto al producto
    static String productos[] ={"REFRIGERADOR","COCINA","LAVADORA","PLANCHA","TOSTADORA","RADIO","TELEVISOR"};//esto es un array estos son los productos de pendiendo la posicion relacionado con el precio

    public static void main(String[] arg)//main indica el inicio del sistema
    {
        Scanner sc = new Scanner(System.in);

        double total = 0;//total de venta, total a cobrar
        int opcion = 0; //almacenar la opcion seleccionada

        do {
            ImprimirMenu();     //funcion para imprimir menu
            opcion= SeleccionOpcion(0,productos.length);//funcion que valida entre un rango de 0 a 5 como opciones
            // total = total + VentaProducto(opcion);    //funcion que recibe el valor de opcion y devuelve el valor del producto
            if (opcion!=0)
            {
                total = total + VentaProductoA(opcion);    //funcion que recibe el valor de opcion y devuelve el valor del producto
            }

        }while(opcion!=0);
        System.out.println("El total de articulos = "+ELEMENTOS);
        System.out.println("El total de la venta es = "+total);
        sc.close();

    }

    //FUNCIONES
    private static void ImprimirMenu()//private hace que solo funcione en este archivo
    //este es el menu que mostrara un menu para seleecionar productos
    {
        System.out.println("**************************************");
        System.out.println("        MENU PRINCIPAL DE VENTA");
        System.out.println("**************************************");
/*
        System.out.println("        1: REFRIGERADOR ");
        System.out.println("        2: COCINA ");
        System.out.println("        3: LAVADORA ");
        System.out.println("        4: PLANCHA ");
        System.out.println("        5: TOSTADORA ");
        System.out.println("        0: SALIR DEL MENU ");
        System.out.println("**************************************");
 */
        for (int i=0;i<productos.length;i++)
        {
            System.out.println("  "+ (i+1) +": "+ productos[i] + "  " + precios[i]+"Bs"); //esto es mucho mejor ya que se expande dependiendo de los articulos
            //mostrara el los productos y precios + numero de eleccion para hacer compras y sumar al total
        }
        System.out.println("0: SALIR");
        System.out.println("**************************************");
    }

    private static int SeleccionOpcion(int inicio, int fin)
    {
        Scanner sc = new Scanner(System.in);
        int op =0;
        do {

            System.out.println("Ingrese op entre " + inicio + " a " + fin);
            op =sc.nextInt();

        }while(op < inicio || op > fin);
        sc.close();
        return op;

    }
    /*
    private static Double VentaProducto(int op)
    {
        double precio = 0;
        switch (op)
        {
            case 1:
                precio=12000.00;//refrigerador
                ELEMENTOS_FILA++;
                break;
            case 2:
                precio=3000.00;//cocina
                ELEMENTOS_FILA++;
                break;
            case 3:
                precio=15000.00;//lavadora
                ELEMENTOS_FILA++;
                break;
            case 4:
                precio=300.00;//plancha
                ELEMENTOS_FILA++;
                break;
            case 5:
                precio=550.00;//tostadora
                ELEMENTOS_FILA++;
                break;
        }
        return precio;
    }
    */
    private static Double VentaProductoA(int op)
    {
        Double precio = precios[op-1];//-1 para justificar y que sea valido la opcion 0
        ELEMENTOS++;
        return precio;
    }
}
