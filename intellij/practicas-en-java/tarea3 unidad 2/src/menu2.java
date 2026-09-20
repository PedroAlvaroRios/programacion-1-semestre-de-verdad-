import java.util.Scanner;

public class menu2
{
    public static void main (String[] arg)
    {
            int opciones = 0;
            int opmenu = 0;
            /*
            desde aqui le dare el precio a mis COMIDAS
            */
            double c_primerplato=18.50;
            double c_segundoplato=18.50;
            double c_tercerplato=18.50;
            double c_cuartoplato=18.50;
            double c_quintoplato=18.50;
            double c_total=0;
            /*
            desde aqui le dare el precio a mis BEBIDAS
            */
            double c_primerbebida=5;
            double c_segundabebida=5;
            double c_tercerbebida=5;
            double c_cuartabebida=5;
            double c_quintabebida=5;
            /*
            desde aqui le dare el precio a mis POSTRES
            */
            double c_primerpostre=20;
            double c_segundopostre=20;
            double c_tercerpostre=20;
            double c_cuartopostre=20;
            double c_quintopostre=20;
            /*
            desde aqui le dare el precio a mis ENTRADAS
            */
            double c_primerentrada=10;
            double c_segundaentrada=10;
            double c_tercerentrada=10;
            double c_cuartaentrada=10;
            double c_quintaentrada=10;

            Scanner teclado = new Scanner(System.in);
            do {
                System.out.println("┌────────────────────────────────┐▒");
                System.out.println("│        MENÚ PRINCIPAL          │▒");
                System.out.println("├────────────────────────────────┤▒");
                System.out.println("│    1. COMIDAS                  │▒");
                System.out.println("│    2. BEBIDAS                  │▒");
                System.out.println("│    3. POSTRES                  │▒");
                System.out.println("│    4. ENTRADAS                 │▒");
                System.out.println("│    5. SALIR DEL SISTEMA        │▒");
                System.out.println("┴────────────────────────────────┴▒");
                System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                opciones = teclado.nextInt();
                if (opciones == 1)
                {
                    do {
                        System.out.println("┌────────────────────────────────┐▒");
                        System.out.println("│        MENÚ COMIDAS            │▒");
                        System.out.println("├────────────────────────────────┤▒");
                        System.out.printf( "│  1. MAJADITO        Bs. %5.2f  │▒%n", c_primerplato); //aqui puedo utilizar %5.2f para hacer que quepa bien en el recuadro
                        System.out.printf( "│  2. LOCRO           Bs. %5.2f  │▒%n", c_segundoplato);//5 significa el ancho total de caracteres enteros que puede recibir
                        System.out.printf( "│  3. FALSO CONEJO    Bs. %5.2f  │▒%n", c_tercerplato);//2 significa el ancho total de caracteres decimales que recibe
                        System.out.printf( "│  4. SILPANCHO       Bs. %5.2f  │▒%n", c_cuartoplato);// printf se utiliza para mostrar texto y variables formateadas en la consola
                        System.out.printf( "│  5. PIQUE MACHO     Bs. %5.2f  │▒%n", c_quintoplato);//printf tambien hacer que se imprima la variable como su valor designado
                        System.out.println("│  0. VOLVER                     │▒");
                        System.out.println("┴────────────────────────────────┴▒");
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                        opmenu = teclado.nextInt();

                        if (opmenu == 1) {
                            c_total = c_total + c_primerplato;
                        }
                        if (opmenu == 2) {
                            c_total = c_total +c_segundoplato;
                        }
                        if (opmenu == 3) {
                            c_total = c_total + c_tercerplato;
                        }
                        if (opmenu == 4) {
                            c_total = c_total + c_cuartoplato;
                        }
                        if (opmenu == 5) {
                            c_total = c_total + c_quintoplato;
                        }


                    }while (opmenu != 0);
                }
                if (opciones == 2)
                {

                    do {
                        System.out.println("┌────────────────────────────────┐▒");
                        System.out.println("│        MENÚ BEBIDAS            │▒");
                        System.out.println("├────────────────────────────────┤▒");
                        System.out.printf( "│   1. COCA COLA 1L    Bs. %5.2f │▒%n", c_primerbebida);
                        System.out.printf( "│   2. SPRITE 1L       Bs. %5.2f │▒%n", c_segundabebida);
                        System.out.printf( "│   3. LIMONADA JARRA  Bs. %5.2f │▒%n", c_tercerbebida);
                        System.out.printf( "│   4. FANTA  1L       Bs. %5.2f │▒%n", c_cuartabebida);
                        System.out.printf( "│   5. TAMARINDO JARRA Bs. %5.2f │▒%n", c_quintabebida);
                        System.out.println("│   0. VOLVER                    │▒");
                        System.out.println("┴────────────────────────────────┴▒");
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                        opmenu = teclado.nextInt();

                        if (opmenu == 1) {
                            c_total = c_total + c_primerbebida;
                        }
                        if (opmenu == 2) {
                            c_total = c_total + c_segundabebida;
                        }
                        if (opmenu == 3) {
                            c_total = c_total + c_tercerbebida;
                        }
                        if (opmenu == 4) {
                            c_total = c_total + c_cuartabebida;
                        }
                        if (opmenu == 5) {
                            c_total = c_total + c_quintabebida;
                        }
                    }while (opmenu != 0);

                }
                if (opciones == 3)
                {
                    do {
                        System.out.println("┌────────────────────────────────┐▒");
                        System.out.println("│        MENÚ POSTRES            │▒");
                        System.out.println("├────────────────────────────────┤▒");
                        System.out.printf( "│    1. PASTELILLOS    Bs. %5.2f │▒%n", c_primerpostre);
                        System.out.printf( "│    2. CUPCAKES       Bs. %5.2f │▒%n", c_segundopostre);
                        System.out.printf( "│    3. PANQUEQUES     Bs. %5.2f │▒%n", c_tercerpostre);
                        System.out.printf( "│    4. BROWNIES       Bs. %5.2f │▒%n", c_cuartopostre);
                        System.out.printf( "│    5. TRES LECHES    Bs. %5.2f │▒%n", c_quintopostre);
                        System.out.println("│    0. VOLVER                   │▒");
                        System.out.println("┴────────────────────────────────┴▒");
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                        opmenu = teclado.nextInt();

                        if (opmenu == 1) {
                            c_total = c_total + c_primerpostre;
                        }
                        if (opmenu == 2) {
                            c_total = c_total + c_segundopostre;
                        }
                        if (opmenu == 3) {
                            c_total = c_total + c_tercerpostre;
                        }
                        if (opmenu == 4) {
                            c_total = c_total + c_cuartopostre;
                        }
                        if (opmenu == 5) {
                            c_total = c_total + c_quintopostre;
                        }
                    }while (opmenu != 0);

                }
                if (opciones == 4)
                {
                    do {
                        System.out.println("┌────────────────────────────────┐▒");
                        System.out.println("│        MENÚ ENTRADAS           │▒");
                        System.out.println("├────────────────────────────────┤▒");
                        System.out.printf( "│    1. CEVICHE        Bs. %5.2f │▒%n", c_primerentrada);
                        System.out.printf( "│    2. SOPA DE MANI   Bs. %5.2f │▒%n", c_segundaentrada);
                        System.out.printf( "│    3. ENSALADA       Bs. %5.2f │▒%n", c_tercerentrada);
                        System.out.printf( "│    4. EMPANADAS      Bs. %5.2f │▒%n", c_cuartaentrada);
                        System.out.printf( "│    5. QUESO CREMA    Bs. %5.2f │▒%n", c_quintaentrada);
                        System.out.println("│    0. VOLVER                   │▒");
                        System.out.println("┴────────────────────────────────┴▒");
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                        opmenu = teclado.nextInt();

                        if (opmenu == 1) {
                            c_total = c_total + c_primerentrada;
                        }
                        if (opmenu == 2) {
                            c_total = c_total + c_segundaentrada;
                        }
                        if (opmenu == 3) {
                            c_total = c_total + c_tercerentrada;
                        }
                        if (opmenu == 4) {
                            c_total = c_total + c_cuartaentrada;
                        }
                        if (opmenu == 5) {
                            c_total = c_total + c_quintaentrada;
                        }
                    }while (opmenu != 0);

                }
                if (opciones == 5)
                {
                    System.out.println("┌────────────────────────────────┐▒");
                    System.out.println("│          TOTAL A COBRAR        │▒");
                    System.out.println("├────────────────────────────────┤▒");
                    System.out.printf( "│     TOTAL:  Bs. %8.2f       │▒%n", c_total); //aqui puedo utilizar %8.2f para hacer que quepa bien
                    System.out.println("┴────────────────────────────────┴▒");//8 significa el ancho total de caracteres enteros que puede recibir
                    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");//2 significa el ancho total de caracteres decimales que recibe
                    System.out.println("gracias, vuelva pronto");
                }
            }while (opciones != 5);
    }

}