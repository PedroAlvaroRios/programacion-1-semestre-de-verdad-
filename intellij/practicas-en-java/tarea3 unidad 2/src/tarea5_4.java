/*
Caja de Tienda: Simula el cobro en una tienda usando un bucle do-while.
El programa debe pedir precios de productos uno por uno hasta que el usuario ingrese "0".
Al terminar, muestra el subtotal y el total con impuestos.
*/

import java.util.Scanner;

public class tarea5_4
{
    public static void main (String arg[])
    {
        int opciones = 0;
        int opmenu = 0;
        double sub_total=0;
            /*
            desde aqui le dare el precio a los productos de alimentos
            */
        double primer_alimento=1.5;
        double segundo_alimento=25;
        double tercer_alimento=30;
        double cuarto_alimento=20;
        double quinto_alimento=25;
            /*
            desde aqui le dare el precio a los productos de ropa
            */
        double primer_ropa=30;
        double segunda_ropa=30;
        double tercer_ropa=30;
        double cuarta_ropa=30;
        double quinta_ropa=30;
            /*
            desde aqui le dare el precio a los productos de higiene
            */
        double primer_higiene=10;
        double segunda_higiene=20;
        double tercer_higiene=15;
        double cuarta_higiene=30;
        double quinta_higiene =40;
            /*
            desde aqui le dare el precio a los productos de muebles
            */
        double primer_mueble =500;
        double segundo_mueble=200;
        double tercer_mueble =100;
        double cuarto_mueble =25;
        double quinto_mueble =10;

        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("┌────────────────────────────────┐▒");
            System.out.println("│            TIENDA              │▒");
            System.out.println("├────────────────────────────────┤▒");
            System.out.println("│    1. ALIMENTOS                │▒");
            System.out.println("│    2. ROPA                     │▒");
            System.out.println("│    3. HIGIENE                  │▒");
            System.out.println("│    4. MUEBLES                  │▒");
            System.out.println("│    0. SALIR DEL SISTEMA        │▒");
            System.out.println("┴────────────────────────────────┴▒");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            opciones = teclado.nextInt();
            if (opciones == 1)
            {
                do {
                    System.out.println("┌────────────────────────────────┐▒");
                    System.out.println("│        SECCION ALIMENTOS       │▒");
                    System.out.println("├────────────────────────────────┤▒");
                    System.out.printf( "│  1. PAN  (Unit.)    Bs. %5.2f  │▒%n", primer_alimento);//aqui puedo utilizar %5.2f para hacer que quepa bien en el recuadro
                    System.out.printf( "│  2. PAN MOLDE       Bs. %5.2f  │▒%n", segundo_alimento);//5 significa el ancho total de caracteres enteros que puede recibir
                    System.out.printf( "│  3. ZANAHORIAS (KG) Bs. %5.2f  │▒%n", tercer_alimento);//2 significa el ancho total de caracteres decimales que recibe
                    System.out.printf( "│  4. PAPA (KG)       Bs. %5.2f  │▒%n", cuarto_alimento);// printf se utiliza para mostrar texto y variables formateadas en la consola
                    System.out.printf( "│  5. CEBOLLA (KG)    Bs. %5.2f  │▒%n", quinto_alimento);//printf tambien hacer que se imprima la variable como su valor designado
                    System.out.println("│  0. VOLVER                     │▒");
                    System.out.println("┴────────────────────────────────┴▒");
                    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    opmenu = teclado.nextInt();

                    if (opmenu == 1) {
                        sub_total += primer_alimento;
                    }
                    if (opmenu == 2) {
                        sub_total += segundo_alimento;
                    }
                    if (opmenu == 3) {
                        sub_total += tercer_alimento;
                    }
                    if (opmenu == 4) {
                        sub_total += cuarto_alimento;
                    }
                    if (opmenu == 5) {
                        sub_total += quinto_alimento;
                    }


                }while (opmenu != 0);
            }
            if (opciones == 2)
            {

                do {
                    System.out.println("┌────────────────────────────────┐▒");
                    System.out.println("│        SECCION ROPA            │▒");
                    System.out.println("├────────────────────────────────┤▒");
                    System.out.printf( "│   1. PANTALON        Bs. %5.2f │▒%n", primer_ropa);
                    System.out.printf( "│   2. CAMISA          Bs. %5.2f │▒%n", segunda_ropa);
                    System.out.printf( "│   3. POLERA          Bs. %5.2f │▒%n", tercer_ropa);
                    System.out.printf( "│   4. SACO            Bs. %5.2f │▒%n", cuarta_ropa);
                    System.out.printf( "│   5. GORRA           Bs. %5.2f │▒%n", quinta_ropa);
                    System.out.println("│   0. VOLVER                    │▒");
                    System.out.println("┴────────────────────────────────┴▒");
                    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    opmenu = teclado.nextInt();

                    if (opmenu == 1) {
                        sub_total += primer_ropa;
                    }
                    if (opmenu == 2) {
                        sub_total += segunda_ropa;
                    }
                    if (opmenu == 3) {
                        sub_total += tercer_ropa;
                    }
                    if (opmenu == 4) {
                        sub_total += cuarta_ropa;
                    }
                    if (opmenu == 5) {
                        sub_total += quinta_ropa;
                    }
                }while (opmenu != 0);

            }
            if (opciones == 3)
            {
                do {
                    System.out.println("┌────────────────────────────────┐▒");
                    System.out.println("│        SECCION HIGIENE         │▒");
                    System.out.println("├────────────────────────────────┤▒");
                    System.out.printf( "│    1. PAPEL DE BAÑO  Bs. %5.2f │▒%n", primer_higiene);
                    System.out.printf( "│    2. DETERGENTE     Bs. %5.2f │▒%n", segunda_higiene);
                    System.out.printf( "│    3. ESPONJA        Bs. %5.2f │▒%n", tercer_higiene);
                    System.out.printf( "│    4. DESINFECTANTE  Bs. %5.2f │▒%n", cuarta_higiene);
                    System.out.printf( "│    5. TRAPEADOR      Bs. %5.2f │▒%n", quinta_higiene);
                    System.out.println("│    0. VOLVER                   │▒");
                    System.out.println("┴────────────────────────────────┴▒");
                    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    opmenu = teclado.nextInt();

                    if (opmenu == 1) {
                        sub_total += primer_higiene;
                    }
                    if (opmenu == 2) {
                        sub_total += segunda_higiene;
                    }
                    if (opmenu == 3) {
                        sub_total += tercer_higiene;
                    }
                    if (opmenu == 4) {
                        sub_total += cuarta_higiene;
                    }
                    if (opmenu == 5) {
                        sub_total += quinta_higiene;
                    }
                }while (opmenu != 0);

            }
            if (opciones == 4)
            {
                do {
                    System.out.println("┌────────────────────────────────┐▒");
                    System.out.println("│        SECCION MUEBLES         │▒");
                    System.out.println("├────────────────────────────────┤▒");
                    System.out.printf( "│ 1. MESA FAMILIAR Bs. %5.2f    │▒%n", primer_mueble);
                    System.out.printf( "│ 2. MESA PLEGABLE Bs. %5.2f    │▒%n", segundo_mueble);
                    System.out.printf( "│ 3. COLCHON       Bs. %5.2f    │▒%n", tercer_mueble);
                    System.out.printf( "│ 4. SILLA         Bs. %5.2f     │▒%n", cuarto_mueble);
                    System.out.printf( "│ 5. ALMOHADA      Bs. %5.2f     │▒%n", quinto_mueble);
                    System.out.println("│ 0. VOLVER                      │▒");
                    System.out.println("┴────────────────────────────────┴▒");
                    System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                    opmenu = teclado.nextInt();

                    if (opmenu == 1) {
                        sub_total += primer_mueble;
                    }
                    if (opmenu == 2) {
                        sub_total += segundo_mueble;
                    }
                    if (opmenu == 3) {
                        sub_total += tercer_mueble;
                    }
                    if (opmenu == 4) {
                        sub_total += cuarto_mueble;
                    }
                    if (opmenu == 5) {
                        sub_total += quinto_mueble;
                    }
                }while (opmenu != 0);

            }
            if (opciones == 0)
            {
                double impuesto=sub_total*0.13; //impuesto IVA 13%
                double total_pagar=sub_total+impuesto;//total despues de impuestos

                System.out.println("┌────────────────────────────────┐▒");
                System.out.println("│          TOTAL A COBRAR        │▒");
                System.out.println("├────────────────────────────────┤▒");
                System.out.printf( "│ SUBTOTAL:      Bs. %8.2f    │▒%n", sub_total); //aqui puedo utilizar %8.2f para hacer que quepa bien
                System.out.printf( "│ IMPUESTOS:     Bs. %8.2f    │▒%n", impuesto);
                System.out.printf( "│ TOTAL PAGAR:   Bs. %8.2f    │▒%n", total_pagar);
                System.out.println("┴────────────────────────────────┴▒");//8 significa el ancho total de caracteres enteros que puede recibir
                System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");//2 significa el ancho total de caracteres decimales que recibe
                System.out.println("gracias, vuelva pronto");
            }
        }while (opciones != 0);
    }
}