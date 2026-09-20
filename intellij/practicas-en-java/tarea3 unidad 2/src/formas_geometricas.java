import java.util.Scanner;

public class formas_geometricas
{
    public static void main (String[] arg)
    {
    double triangulo, rectangulo, cuadrado, circulo, pentagono, perimetro;
    int opciones=0;
    Scanner teclado = new Scanner(System.in);
        do {
                System.out.println("bienvenido a la calculadora del area de formas geometricas");
                System.out.println("┌────────────────────────────────┐▒");
                System.out.println("│        MENÚ PRINCIPAL          │▒");
                System.out.println("├────────────────────────────────┤▒");
                System.out.println("│    1. triangulo                │▒");
                System.out.println("│    2. rectangulo               │▒");
                System.out.println("│    3. cuadrado                 │▒");
                System.out.println("│    4. circulo                  │▒");
                System.out.println("│    5. pentagono                │▒");
                System.out.println("│    99. SALIR DEL SISTEMA       │▒");
                System.out.println("┴────────────────────────────────┴▒");
                System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                opciones = teclado.nextInt();
            switch (opciones)
            {
                case 1:
                    //triangulo

                        System.out.println("ingrese la base del triangulo");
                        Scanner base = new Scanner (System.in);
                        double base_numero = base.nextDouble(); //lo convertimos en un numero double

                        System.out.println("ingrese la altura del triangulo");
                        Scanner altura = new Scanner (System.in);
                        double altura_numero = altura.nextDouble(); //lo convertimos en un numero double

                        triangulo=(base_numero*altura_numero)/2;

                        System.out.println("el area del triangulo es igual a : "+triangulo);

                    break;

                case 2:
                    //rectangulo

                    System.out.println("ingrese la base del rectangulo");
                    Scanner base_rectangulo = new Scanner (System.in);
                    double base_numero_rectangulo = base_rectangulo.nextDouble(); //lo convertimos en un numero double

                    System.out.println("ingrese la altura del rectangulo");
                    Scanner altura_rectangulo = new Scanner (System.in);

                    double altura_numero_rectangulo = altura_rectangulo.nextDouble(); //lo convertimos en un numero double

                    rectangulo= base_numero_rectangulo * altura_numero_rectangulo;

                    System.out.println("el area del rectangulo es igual a : "+rectangulo);

                    break;

                case 3:
                    //cuadrado

                    System.out.println("ingrese la medida de un lado del cuadrado");
                    Scanner lado = new Scanner (System.in);
                    double lado_numero = lado.nextDouble(); //lo convertimos en un numero double

                    cuadrado=lado_numero*lado_numero;

                    System.out.println("el area del cuadrado es igual a : "+cuadrado);

                    break;

                case 4:
                    //circulo

                    System.out.println("ingrese el radio del circulo");
                    Scanner radio = new Scanner (System.in);
                    double radio_numero = radio.nextDouble(); //lo convertimos en un numero double

                    circulo= Math.PI* Math.pow (radio_numero,2);//radio_numero representa el radio y 2 representa la potencia

                    System.out.println("el area del circulo es igual a : "+circulo);

                    break;

                case 5:
                    //pentagono

                    System.out.println("ingrese la medida de un lado del pentagono");
                    Scanner un_lado = new Scanner (System.in);
                    double un_lado_numero = un_lado.nextDouble(); //lo convertimos en un numero double

                    perimetro=un_lado_numero*5;//5 representa la cantidad de lados, en este caso es 5

                    System.out.println("ingrese el apotema del pentagono");
                    Scanner apotema = new Scanner (System.in);
                    double apotema_numero = apotema.nextDouble(); //el apotema representa la distancia del centro a el medio de un lado

                    pentagono=(perimetro*apotema_numero)/2;

                    System.out.println("el area del pentagono es igual a : "+pentagono);

                    break;
            }
        }while (opciones != 99);
    }
}
