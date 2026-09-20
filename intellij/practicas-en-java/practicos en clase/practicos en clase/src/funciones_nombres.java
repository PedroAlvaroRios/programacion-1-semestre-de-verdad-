import java.util.Scanner;

//Crear una funcion que dados el nombre y apellido por separado, devuelva apellidos y nombres juntos separados por una coma
public class funciones_nombres
{
    public static void main(String[] arg)
    {
        //identidad
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese su nombre");
        String nombre = "" ;
        nombre = sc.nextLine();

        System.out.println("ingrese su apellido");
        String apellido = "" ;
        apellido = sc.nextLine();

        Identidad(nombre,apellido);

        //mayor
        System.out.println("ingrese un numero");
        double numero1 ;
        numero1 = sc.nextDouble();

        System.out.println("ingrese un segundo numero");
        double numero2;
        numero2 = sc.nextDouble();

        Mayor(numero1,numero2);

        //signo
        sc.nextLine();

        System.out.println("Ingrese un signo (+, -, *, /):");
        String signo = sc.nextLine(); // ✅ ahora sí espera al usuario

        operacionAritmetica(numero1, numero2, signo);

    }
    public static void Identidad(String n, String a)//se puede recibir y enviar en otras variables
    {
        System.out.println(n+","+a);
    }

    public static Double Mayor(Double x, Double y) //el double representa que debe devolver un valor te tipo double
    {
        if (x>y)
        {
            System.out.println(x+" es mayor a "+y);
            return x; //solo para que devuelva algo y no salte errores
        }
        else
        {
            System.out.println(y+" es mayor a "+x);
            return y; //solo para que devuelva algo y no salte errores
            //tambien podrias hacer una funcion void para que salte errores y no tengas que usar un return, es mas eficiente
        }
    }
    public static Double operacionAritmetica(double x, double y, String s) //el double representa que debe devolver un valor te tipo double
    {
        double resultado = 0;
        switch (s)
        {
            case "+":
                resultado = x + y; break;

            case "-":
                resultado = x - y; break;

            case "*":
                resultado = x * y; break;

            case "/":
                if (y == 0)
                {
                    System.out.println("no se puede dividir entre 0");
                    return 0.0;//return 0.0 ayuda a que no devuelva nada
                }
                resultado = x / y;
                break;

            default://default funciona como un valor que no entra en los parametros definidos, que esta excluido
                System.out.println("el signo no es valido");
                return 0.0;
        }


        System.out.println(x + " " + s + " " + y + " = " + resultado);
        return resultado;

    }
}
