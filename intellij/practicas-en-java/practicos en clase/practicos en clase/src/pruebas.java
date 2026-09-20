import java.util.List;
import java.util.Scanner;
/*
public class pruebas
{
    // --- CONSTANTES Y ENUMS ---
    enum Color { BLANCO, NEGRO }
    enum Tipo { REY, REINA, TORRE, ALFIL, CABALLO, PEON }
    static class Pieza {
        Ajedrez.Tipo tipo;
        Ajedrez.Color color;

        Pieza(Ajedrez.Tipo tipo, Ajedrez.Color color) {
            this.tipo = tipo;
            this.color = color;
        }

        char simbolo() {
            char c = switch (tipo) {
                case REY -> 'R';
                case REINA -> 'D';
                case TORRE -> 'T';
                case ALFIL -> 'A';
                case CABALLO -> 'C';
                case PEON -> 'P';
            };
            return color == Ajedrez.Color.BLANCO ? Character.toUpperCase(c) : Character.toLowerCase(c);
        }

        // Símbolo Unicode para la GUI
        String simboloGUI() {
            return switch (tipo) {
                case REY -> color == Ajedrez.Color.BLANCO ? "♔" : "♚";
                case REINA -> color == Ajedrez.Color.BLANCO ? "♕" : "♛";
                case TORRE -> color == Ajedrez.Color.BLANCO ? "♖" : "♜";
                case ALFIL -> color == Ajedrez.Color.BLANCO ? "♗" : "♝";
                case CABALLO -> color == Ajedrez.Color.BLANCO ? "♘" : "♞";
                case PEON -> color == Ajedrez.Color.BLANCO ? "♙" : "♟";
            };
        }

        @Override
        public String toString() {
            return String.valueOf(simbolo());
        }
    }
}
    private static class Tablero {
        Ajedrez.Pieza piezaEn(int f, int c) {
            if (f < 0 || f > 7 || c < 0 || c > 7) return null;
            return casillas[f][c];
        }
        Pieza[][] casillas = new Ajedrez.Pieza[8][8];
        casillas[0][1] = new Pieza(Ajedrez.Tipo.CABALLO, Ajedrez.Color.NEGRO);
        casillas[0][2] = new Pieza(Ajedrez.Tipo.ALFIL, Ajedrez.Color.NEGRO);
                        case CABALLO -> agregarMovCaballo(f, c, destinos);
                case ALFIL -> agregarMovDeslizante(f, c, new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}}, destinos);
        void agregarMovCaballo(int f, int c, List<int[]> lista) {
            int[][] saltos = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
            for (int[] s : saltos) {
                int nf = f + s[0], nc = c + s[1];
                if (nf>=0 && nf<8 && nc>=0 && nc<8) {
                    Ajedrez.Pieza dest = piezaEn(nf, nc);
                    if (dest == null || dest.color != turno) lista.add(new int[]{nf, nc});
                }
            }
        }
        private Ajedrez.Movimiento crearMovimiento(int ff, int fc, int tf, int tc, Ajedrez.Pieza pieza) {
            Ajedrez.Pieza destino = piezaEn(tf, tc);
            if (destino != null && destino.color == pieza.color) return null;
            Ajedrez.Movimiento m = new Ajedrez.Movimiento(ff, fc, tf, tc, pieza, destino);
            return m;
        }

        /*
        // * Genera movimientos deslizantes en las direcciones `dirs` desde
        // * (f,c). Utilizado por alfiles, torres y reinas.

        void agregarMovDeslizante(int f, int c, int[][] dirs, List<int[]> lista) {
            for (int[] d : dirs) {
                int nf = f + d[0], nc = c + d[1];
                while (nf>=0 && nf<8 && nc>=0 && nc<8) {
                    Ajedrez.Pieza dest = piezaEn(nf, nc);
                    if (dest == null) {
                        lista.add(new int[]{nf, nc});
                    } else {
                        if (dest.color != turno) lista.add(new int[]{nf, nc});
                        break;
                    }
                    nf += d[0];
                    nc += d[1];
                }
            }
        }
}
*/
