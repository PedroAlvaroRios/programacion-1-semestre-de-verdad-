import java.util.Scanner;

public class menu {
    public static void main (String arg[])
    {
        int opciones = 0;
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
                System.out.println("usted eligio comidas");
            }
            if (opciones == 2)
            {
                System.out.println("usted eligio bebidas");
            }
            if (opciones == 3)
            {
                System.out.println("usted eligio postres");
            }
            if (opciones == 4)
            {
                System.out.println("usted eligio entradas");
            }
            if (opciones == 5)
            {
                System.out.println("Muchas gracias");
            }
        }while (opciones != 5);

        /*
         * ╔ = 201            ═ = 205           ╗ = 187
         * ║ = 186            ╚ = 200           ╝ = 188
         * ┌ = 218            ─ = 196           ┐ = 191
         * ├ = 195            ┤ = 180           │ = 179
         *  ┴ = 193           ▒ = 177
         * */
    }
}