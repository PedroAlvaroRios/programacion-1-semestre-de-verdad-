import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    static int MAXPRODUCTOS = 50;
    static int MAXVENTAS = 100;

    //definicion de tabla productos
    static int[] ID = new int[MAXPRODUCTOS];
    static String[] Nombres = new String[MAXPRODUCTOS];
    static double[] Precios = new double[MAXPRODUCTOS];
    static int[] Stock = new int[MAXPRODUCTOS];

    //definicion de tabla ventas
    static int[] numVentas = new int[MAXVENTAS];
    static int[] IdProducto = new int[MAXVENTAS];//este lo relacionaremos con el ID en tabla productos
    static String[] NombreProducto = new String[MAXVENTAS];//no se suele colocar en tablas de verdad
    static int[] Cantidad = new int[MAXVENTAS];
    static double[] PrecioVenta = new double[MAXVENTAS];

    //Variables de control
    static int CANTIDADPRODUCTOS = 0;
    static int CANTIDADVENTAS = 0;
    static Scanner sc = new Scanner(System.in);


    static File Archivo = new File("datos.txt");
    public static void main(String[] args)
    {
        System.out.println("Bienvenido al Sistema de Ventas!");
        cargarDatos();
        int opcion;
        do
        {

            System.out.println("\n--- SISTEMA DE VENTAS ---");
            System.out.println("1: Agregar Producto");
            System.out.println("2: Mostrar Productos");
            System.out.println("3: Registrar Venta");
            System.out.println("4: Mostrar Ventas");
            System.out.println("5. Almacenar en Archivos");
            System.out.println("0: Salir");
            System.out.println("Ingrese opcion: ");

            opcion = LeerEntero();
            switch(opcion)
            {
                case 1: agregarProducto();
                    break;
                case 2: mostarProducto();
                    break;
                case 3: registrarVentas();
                    break;
                case 4: mostrarVentas();
                    break;
                case 5: almacenarVentas();
                    break;
                case 0: System.out.println("Hasta Pronto !!!");
                    break;
                default:
                    System.out.println("Elija una opcion valida");
            }
        }while (opcion != 0);
        sc.close();
    }

    //Funciones
    public static void cargarDatos()
    {
        if (!Archivo.exists())
        {
            return;
        }
        try(DataInputStream dis = new DataInputStream(new FileInputStream("datos.dat")))
        {
            CANTIDADPRODUCTOS = dis.readInt();
            //cargado de productos del archivo a vectores
            for (int i = 0; i < CANTIDADPRODUCTOS; i++)
            {
                ID[i] = dis.readInt();
                Nombres[i] = dis.readUTF();
                Precios[i] = dis.readDouble();
                Stock[i] = dis.readInt();
            }
            CANTIDADVENTAS = dis.readInt();

            for (int i = 0; i < CANTIDADVENTAS; i++)
            {
                numVentas[i] = dis.readInt();
                IdProducto[i] = dis.readInt();
                NombreProducto[i] = dis.readUTF();
                Cantidad[i] = dis.readInt();
                PrecioVenta[i] = dis.readDouble();
            }
        }
        catch (IOException e)
        {
            System.out.println("Error al cargar: " + e.getMessage());
        }
    }
    public  static int LeerEntero()
    {
        while(true)
        {
            try
            {
                return Integer.parseInt(sc.nextLine());//este solo recibira enteros y si recibe otro salta un error
            }
            catch(NumberFormatException e) //error de excepcion de numero
            {
                System.out.println("Ingrese un numero entero correcto " + e.getMessage());
            }
        }
    }
    public  static double LeerDouble()
    {
        while(true)
        {
            try
            {
                return Double.parseDouble(sc.nextLine());//este solo recibira enteros y si recibe otro salta un error
            }
            catch(NumberFormatException e) //error de excepcion de numero
            {
                System.out.println("Ingrese un numero Double correcto " + e.getMessage());
            }
        }
    }

    public static void  agregarProducto()
    {
        System.out.println("Ingrese el ID del producto");
        ID[CANTIDADPRODUCTOS] = LeerEntero();
        System.out.println("Ingrese Nombre del producto");
        Nombres[CANTIDADPRODUCTOS] = sc.nextLine();
        System.out.println("Ingrese Precio del producto");
        Precios[CANTIDADPRODUCTOS] = LeerDouble();
        System.out.println("Ingrese Stock del producto");
        Stock[CANTIDADPRODUCTOS] = LeerEntero();
        CANTIDADPRODUCTOS++;

    }
    public static void  mostarProducto()
    {
        System.out.println("ID     | Nombre producto               | Precio Producto              | Stock Producto    ");
        for (int i = 0; i < CANTIDADPRODUCTOS; i++)
        {
            String nombre = Nombres[i] == null ? "" : Nombres[i];
            System.out.printf("%-6d | %-30s | %30.2f | %17d %n", ID[i], nombre, Precios[i], Stock[i]);
        }
    }
    public static void  registrarVentas()
    {

    }
    public static void  mostrarVentas()
    {

    }
    public static void  almacenarVentas()
    {

    }
}