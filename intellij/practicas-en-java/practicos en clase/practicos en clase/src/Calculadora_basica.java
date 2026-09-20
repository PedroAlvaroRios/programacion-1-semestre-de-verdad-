/*autor: Pedro Rios
* Fecha: 9/4/2026
* comentario: aplicacion baica que simula una claculadora, operaciones:
* suma, resta, multiplicacion y division
* */
import java.util.Scanner;
import java.math.*;

public class Calculadora_basica
{
    public static void main (String[] arg)
    {
        double a = 0, b=0;
        byte op = 9;//variable para determinar que tipo de operacion realizar
        double total = 0; //esta variable almacena el resultado de cualquier operacion
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("bienvenido a la calculadora del area de formas geometricas");
            System.out.println("┌────────────────────────────────┐▒");
            System.out.println("│        MENÚ PRINCIPAL          │▒");
            System.out.println("├────────────────────────────────┤▒");
            System.out.println("│    1. SUMA                     │▒");
            System.out.println("│    2. RESTA                    │▒");
            System.out.println("│    3. MULTIPLICACIÓN           │▒");
            System.out.println("│    4. DIVISIÓN                 │▒");
            System.out.println("│    5. RESIDUO DIVISION         │▒");
            System.out.println("│    6. RAIZ                     │▒");
            System.out.println("│    0. SALIR                    │▒");
            System.out.println("┴────────────────────────────────┴▒");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            op = sc.nextByte(); // obtenemos la opcion de usuario

            if (op == 0)
            {
                System.out.println("saliendo del sistema...");
                System.exit(0);
            }
            else  //b diferente de cero en la division
            {

                switch (op)
                {
                    case 1: //suma
                        System.out.println("ingrese a= ");
                        a= sc.nextDouble();

                        System.out.println("ingrese b= ");
                        b= sc.nextDouble();

                        total = a + b;
                        System.out.println("la suma es: "+total);
                        break;

                    case 2: //resta
                        System.out.println("ingrese a= ");
                        a= sc.nextDouble();

                        System.out.println("ingrese b= ");
                        b= sc.nextDouble();

                        total = a - b;
                        System.out.println("la resta es: "+total);
                        break;

                    case 3: //multiplicacion
                        System.out.println("ingrese a= ");
                        a= sc.nextDouble();

                        System.out.println("ingrese b= ");
                        b= sc.nextDouble();

                        total = a * b;
                        System.out.println("la multiplicacion es: "+total);
                        break;

                    case 4: //division
                        System.out.println("ingrese a= ");
                        a= sc.nextDouble();

                        System.out.println("ingrese b= ");
                        b= sc.nextDouble();

                        if (b == 0)
                        {
                            // Es b=0 y es operacion de division
                            System.out.println("b debe ser mayor o diferente a cero");
                        }

                        total = a / b;
                        System.out.println("la division es: "+total);
                        break;

                    case 5: //residuo
                        System.out.println("ingrese a= ");
                        a= sc.nextDouble();

                        System.out.println("ingrese b= ");
                        b= sc.nextDouble();

                        total = a % b;
                        System.out.println("la residuo es: "+total);
                        break;

                    case 6: //raiz
                        System.out.println("ingrese a= ");
                        a= sc.nextDouble();

                        total = Math.sqrt(a);
                        System.out.println("la raiz de (a) es: "+total);
                        break;

                    default:
                        System.out.println("debe elegir un numero entre 0 a 6");
                }
            }
        }while (op!=0);
        sc.close();
    }
}