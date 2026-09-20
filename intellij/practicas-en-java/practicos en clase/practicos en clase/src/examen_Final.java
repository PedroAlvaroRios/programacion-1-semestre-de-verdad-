public class examen_Final
{
    public static void main (String[] arg)
    {
        //a) Calculo de la posicion
        String nombre = "Pedro";
        String apellido = "Rios";

        int fila = nombre.length();
        int columna = apellido.length();
        int fila_procesada = 0;
        int columna_procesada = 0;

        if (fila > 6)
        {
            fila_procesada = fila/2;
        }
        else fila_procesada = fila;

        if (columna > 6)
        {
            columna_procesada = fila/2;
        }
        else columna_procesada = fila;

        final int filaProcesada1 = fila_procesada;
        System.out.println("columna: "+columna_procesada+" fila: "
                +
                fila_procesada);

        //b) construccion del tablero
        String[][] tablero_ajedrez = new String[8][8];

        //c) ubicacion de la poscion inicial

        tablero_ajedrez [fila_procesada][columna_procesada] = "C";
        for (int i = 0; i<9 ; i++) //columnas
        {
            System.out.println("x¼kþÿ¨♥ÄAÄƒ");
            System.out.println("= = = = =");
        }

    }
}
