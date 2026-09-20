import java.util.Scanner;

public class MatricesRegistroDeEstudiantes
{
    static int ELEMENTOS = 0;
    static int MAXELEMENTOS = 20; // dimension del vector/matriz
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] arg)
    {
        int[] registro = new int[MAXELEMENTOS];
        String[] nombres = new String[MAXELEMENTOS];
        double[][] notas = new double[MAXELEMENTOS][5];
        int opcion = 0;
        do {
            opcion = MostrarMenu();

            switch (opcion)
            {
                case 2: IngresarDatos(registro,nombres);
                    break;
                case 3: MostrarDatos(registro,nombres);
                    break;
                case 4: IngresarNotas(registro,nombres,notas);
                    break;
                case 5: MostrarNotas(registro,nombres,notas);
                    break;
                case 6: PlanillaNotas(registro,nombres,notas);
                    break;
            }
        }while (opcion !=0);
    }
    // Funciones
    private static int MostrarMenu()
    {
        int seleccion = 0;
        do {
            System.out.println("╔════════════════════════════╗");
            System.out.println("║       MENU PRINCIPAL       ║");
            System.out.println("╠════════════════════════════╣");
            System.out.println("║ 1. Inicializar             ║");
            System.out.println("║ 2. Ingresar estudiantes    ║");
            System.out.println("║ 3. Mostrar estudiantes     ║");
            System.out.println("║ 4. Ingresar notas          ║");
            System.out.println("║ 5. Mostrar notas           ║");
            System.out.println("║ 6. Mostrar planilla        ║");
            System.out.println("║ 0. Salir                   ║");
            System.out.println("╚════════════════════════════╝");
            System.out.print("Elija una opcion: ");
            seleccion = sc.nextInt();
        }while (seleccion <0 && seleccion>6);
        return seleccion;
    }
    private static void IngresarDatos(int[] registro, String[] nombres)
    {
        int numeroDatos = 0; //cantidad de datos a ingresar
        System.out.println("Cuantos estudiantes desea ingresar? :");
        numeroDatos = sc.nextInt();
        sc.nextLine();
        for (int i = ELEMENTOS; i<ELEMENTOS+numeroDatos;i++)
        {
            System.out.println("ingrese estudiante: " +(i+1));
            nombres[i] = sc.nextLine();
            registro[i] = i+1;
        }
        ELEMENTOS  =  ELEMENTOS  +  numeroDatos;
    }
    private static void MostrarDatos(int[] registro, String[] nombres)
    {
        for (int i = 0; i < ELEMENTOS; i++)
        {
            System.out.println("estudiante:" + registro[i] + "  " + nombres[i]);
        }
    }
    private static void IngresarNotas(int[] registro,String[] nombres,double[][] notas)
    {
        int seleccion = 0;
        do {
            System.out.println("╔════════════════════════════╗");
            System.out.println("║       MENU PRINCIPAL       ║");
            System.out.println("╠════════════════════════════╣");
            System.out.println("║ 1. PRIMER PARCIAL          ║");
            System.out.println("║ 2. SEGUNDO PARCIAL         ║");
            System.out.println("║ 3. CONTROL DE LECTURA      ║");
            System.out.println("║ 4. TRABAJOS PRACTICOS      ║");
            System.out.println("║ 5. EXAMEN FINAL            ║");
            System.out.println("║ 0. Salir                   ║");
            System.out.println("╚════════════════════════════╝");
            System.out.print("Elija una opcion: ");
            seleccion = sc.nextInt();
        }while (seleccion <0 && seleccion>5);
        if (seleccion !=0)
        {
            RegistrarNotas(registro,nombres,notas,seleccion-1);
        }
    }
    private static void RegistrarNotas(int[] registro,String[] nombres,double[][] notas,int columna)
    {
       for (int i = 0; i<ELEMENTOS;i++)
       {
           System.out.print("ingrese nota de: " + registro[i] + " " + nombres[i] + " = ");
           notas[i][columna] = sc.nextDouble();
       }
    }
    private static void MostrarNotas(int[] registro, String[] nombres, double[][] notas)
    {
        System.out.println("******************************************************************************************************************");
        System.out.println("*REGISTRO      NOMBRES       1°PARCIAL        2°PARCIAL        CTR. LECTURA        TAREAS        EX.FINAL");
        System.out.println("******************************************************************************************************************");
        for (int i = 0; i < ELEMENTOS; i++)
        {
            System.out.printf("%d %20s %10.2f %10.2f %10.2f %10.2f %10.2f \n", registro[i], nombres[i], notas[i][0], notas[i][1], notas[i][2], notas[i][3], notas[i][4]);
            System.out.println();
        }// "%s" es para cadena de texto, "%d" es para una cadena de enteros, "%f" es para decimales
        System.out.println("******************************************************************************************************************");
    }
    private  static  void  PlanillaNotas(int[] registro, String[] nombres, double[][] notas)
    {
        System.out.println("*************************************************************************************************************************************");
        System.out.println("*REGISTRO      NOMBRES       1°PARCIAL        2°PARCIAL        CTR. LECTURA        TAREAS        EX.FINAL        OBSERVACION");
        System.out.println("*************************************************************************************************************************************");
        double primero, segundo, control, tarea, efinal, ntotal;
        String observacion;
        for (int i = 0; i < ELEMENTOS; i++)
        {
            primero = notas [i][0] * 15 / 100;
            segundo = notas [i][1] * 15 / 100;
            control = notas [i][2] * 20 / 100;
            tarea = notas [i][3] * 20 / 100;
            efinal = notas [i][4] * 30 / 100;
            ntotal = primero + segundo + control + tarea + efinal;
            observacion = ntotal>51 ? "APROBADO":"REPROBADO"; //operacion ternaria

            System.out.printf("%d %20s %15.2f %10.2f %10.2f %10.2f %10.2f %10.2f %10s \n", registro[i], nombres[i], primero, segundo, control, tarea, efinal, ntotal, observacion);
            System.out.println();
        }// "%s" es para cadena de texto, "%d" es para una cadena de enteros, "%f" es para decimales
        System.out.println("*************************************************************************************************************************************");
    }
}
