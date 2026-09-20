import java.io.*;
import java.util.*;

public class chess {

    // --- CONSTANTES Y ENUMS ---
    enum Color { BLANCO, NEGRO }
    enum Tipo { REY, REINA, TORRE, ALFIL, CABALLO, PEON }

    static class Pieza {
        Tipo tipo;
        Color color;

        Pieza(Tipo tipo, Color color) {
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
            return color == Color.BLANCO ? Character.toUpperCase(c) : Character.toLowerCase(c);
        }

        @Override
        public String toString() {
            return String.valueOf(simbolo());
        }
    }

    static class Movimiento {
        int desdeFila, desdeCol;
        int hastaFila, hastaCol;
        Pieza piezaMovida;
        Pieza piezaCapturada;
        boolean enroqueCorto, enroqueLargo;
        boolean promocion;
        Tipo piezaPromocion;
        boolean capturaAlPaso = false;
        int filaPeonCapturado = -1, colPeonCapturado = -1;

        Movimiento(int df, int dc, int hf, int hc, Pieza pm, Pieza pc) {
            this.desdeFila = df;
            this.desdeCol = dc;
            this.hastaFila = hf;
            this.hastaCol = hc;
            this.piezaMovida = pm;
            this.piezaCapturada = pc;
        }

        String aNotacion() {
            return "" + (char)('a' + desdeCol) + (8 - desdeFila) +
                    (char)('a' + hastaCol) + (8 - hastaFila) +
                    (promocion ? Character.toUpperCase(simboloPromocion()) : "");
        }

        private char simboloPromocion() {
            return switch (piezaPromocion) {
                case REINA -> 'D';
                case TORRE -> 'T';
                case ALFIL -> 'A';
                case CABALLO -> 'C';
                default -> '?';
            };
        }
    }

    // --- TABLERO ---
    static class Tablero {
        Pieza[][] casillas = new Pieza[8][8];
        Color turno = Color.BLANCO;
        boolean puedeEnrocarCortoBlanco = true, puedeEnrocarLargoBlanco = true;
        boolean puedeEnrocarCortoNegro = true, puedeEnrocarLargoNegro = true;
        int filaPeonDoble = -1, colPeonDoble = -1; // para captura al paso

        Tablero() {
            // Piezas negras (fila 0,1)
            casillas[0][0] = new Pieza(Tipo.TORRE, Color.NEGRO);
            casillas[0][1] = new Pieza(Tipo.CABALLO, Color.NEGRO);
            casillas[0][2] = new Pieza(Tipo.ALFIL, Color.NEGRO);
            casillas[0][3] = new Pieza(Tipo.REINA, Color.NEGRO);
            casillas[0][4] = new Pieza(Tipo.REY, Color.NEGRO);
            casillas[0][5] = new Pieza(Tipo.ALFIL, Color.NEGRO);
            casillas[0][6] = new Pieza(Tipo.CABALLO, Color.NEGRO);
            casillas[0][7] = new Pieza(Tipo.TORRE, Color.NEGRO);
            for (int j = 0; j < 8; j++) casillas[1][j] = new Pieza(Tipo.PEON, Color.NEGRO);

            // Piezas blancas (fila 6,7)
            for (int j = 0; j < 8; j++) casillas[6][j] = new Pieza(Tipo.PEON, Color.BLANCO);
            casillas[7][0] = new Pieza(Tipo.TORRE, Color.BLANCO);
            casillas[7][1] = new Pieza(Tipo.CABALLO, Color.BLANCO);
            casillas[7][2] = new Pieza(Tipo.ALFIL, Color.BLANCO);
            casillas[7][3] = new Pieza(Tipo.REINA, Color.BLANCO);
            casillas[7][4] = new Pieza(Tipo.REY, Color.BLANCO);
            casillas[7][5] = new Pieza(Tipo.ALFIL, Color.BLANCO);
            casillas[7][6] = new Pieza(Tipo.CABALLO, Color.BLANCO);
            casillas[7][7] = new Pieza(Tipo.TORRE, Color.BLANCO);
        }

        Pieza piezaEn(int f, int c) {
            if (f < 0 || f > 7 || c < 0 || c > 7) return null;
            return casillas[f][c];
        }

        // Generar movimientos legales para la pieza en (f,c) (incluye reglas de jaque)
        List<Movimiento> movimientosLegales(int f, int c) {
            List<Movimiento> lista = new ArrayList<>();
            Pieza pieza = piezaEn(f, c);
            if (pieza == null || pieza.color != turno) return lista;

            // Movimientos básicos según tipo
            List<int[]> destinos = new ArrayList<>();
            switch (pieza.tipo) {
                case PEON -> agregarMovPeon(f, c, pieza.color, destinos);
                case CABALLO -> agregarMovCaballo(f, c, destinos);
                case ALFIL -> agregarMovDeslizante(f, c, new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}}, destinos);
                case TORRE -> agregarMovDeslizante(f, c, new int[][]{{1,0},{-1,0},{0,1},{0,-1}}, destinos);
                case REINA -> {
                    agregarMovDeslizante(f, c, new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}}, destinos);
                    agregarMovDeslizante(f, c, new int[][]{{1,0},{-1,0},{0,1},{0,-1}}, destinos);
                }
                case REY -> agregarMovRey(f, c, destinos);
            }

            for (int[] d : destinos) {
                Movimiento m = crearMovimiento(f, c, d[0], d[1], pieza);
                if (m != null && esLegal(m)) lista.add(m);
            }

            // Agregar enroques
            if (pieza.tipo == Tipo.REY) {
                if (pieza.color == Color.BLANCO) {
                    if (puedeEnrocarCortoBlanco && casillas[7][5]==null && casillas[7][6]==null && !estaAtacada(7,4,Color.NEGRO) && !estaAtacada(7,5,Color.NEGRO) && !estaAtacada(7,6,Color.NEGRO)) {
                        Movimiento m = new Movimiento(7,4,7,6,pieza,null);
                        m.enroqueCorto = true;
                        if (esLegal(m)) lista.add(m);
                    }
                    if (puedeEnrocarLargoBlanco && casillas[7][3]==null && casillas[7][2]==null && casillas[7][1]==null && !estaAtacada(7,4,Color.NEGRO) && !estaAtacada(7,3,Color.NEGRO) && !estaAtacada(7,2,Color.NEGRO)) {
                        Movimiento m = new Movimiento(7,4,7,2,pieza,null);
                        m.enroqueLargo = true;
                        if (esLegal(m)) lista.add(m);
                    }
                } else {
                    if (puedeEnrocarCortoNegro && casillas[0][5]==null && casillas[0][6]==null && !estaAtacada(0,4,Color.BLANCO) && !estaAtacada(0,5,Color.BLANCO) && !estaAtacada(0,6,Color.BLANCO)) {
                        Movimiento m = new Movimiento(0,4,0,6,pieza,null);
                        m.enroqueCorto = true;
                        if (esLegal(m)) lista.add(m);
                    }
                    if (puedeEnrocarLargoNegro && casillas[0][3]==null && casillas[0][2]==null && casillas[0][1]==null && !estaAtacada(0,4,Color.BLANCO) && !estaAtacada(0,3,Color.BLANCO) && !estaAtacada(0,2,Color.BLANCO)) {
                        Movimiento m = new Movimiento(0,4,0,2,pieza,null);
                        m.enroqueLargo = true;
                        if (esLegal(m)) lista.add(m);
                    }
                }
            }

            return lista;
        }

        private Movimiento crearMovimiento(int ff, int fc, int tf, int tc, Pieza pieza) {
            Pieza destino = piezaEn(tf, tc);
            if (destino != null && destino.color == pieza.color) return null;
            Movimiento m = new Movimiento(ff, fc, tf, tc, pieza, destino);
            // Peón al paso?
            if (pieza.tipo == Tipo.PEON && fc != tc && destino == null) {
                if (filaPeonDoble == tf && colPeonDoble == tc) {
                    int dir = (pieza.color == Color.BLANCO) ? -1 : 1;
                    // CORRECCIÓN: la pieza capturada está en tf + dir
                    Pieza peonEnemigo = piezaEn(tf + dir, tc);
                    if (peonEnemigo != null && peonEnemigo.tipo == Tipo.PEON && peonEnemigo.color != pieza.color) {
                        m.piezaCapturada = peonEnemigo;
                        m.capturaAlPaso = true;
                        m.filaPeonCapturado = tf + dir;
                        m.colPeonCapturado = tc;
                    }
                }
            }
            return m;
        }

        boolean esLegal(Movimiento m) {
            // Realiza el movimiento temporalmente y verifica que el rey propio no quede en jaque
            Pieza originalCasillaDestino = casillas[m.hastaFila][m.hastaCol];
            Pieza capturadaAlPaso = null;
            casillas[m.hastaFila][m.hastaCol] = casillas[m.desdeFila][m.desdeCol];
            casillas[m.desdeFila][m.desdeCol] = null;

            if (m.piezaMovida.tipo == Tipo.PEON && m.desdeCol != m.hastaCol && originalCasillaDestino == null) {
                // Al paso: eliminar peón capturado desde la posición registrada
                if (m.capturaAlPaso) {
                    capturadaAlPaso = casillas[m.filaPeonCapturado][m.colPeonCapturado];
                    casillas[m.filaPeonCapturado][m.colPeonCapturado] = null;
                } else {
                    capturadaAlPaso = casillas[m.desdeFila][m.hastaCol];
                    casillas[m.desdeFila][m.hastaCol] = null;
                }
            }

            if (m.enroqueCorto) {
                // Mover torre
                int fila = m.desdeFila;
                casillas[fila][5] = casillas[fila][7];
                casillas[fila][7] = null;
            } else if (m.enroqueLargo) {
                int fila = m.desdeFila;
                casillas[fila][3] = casillas[fila][0];
                casillas[fila][0] = null;
            }

            boolean reySeguro = !reyEnJaque(m.piezaMovida.color);

            // Revertir
            casillas[m.desdeFila][m.desdeCol] = m.piezaMovida;
            casillas[m.hastaFila][m.hastaCol] = originalCasillaDestino;
            if (capturadaAlPaso != null) {
                if (m.capturaAlPaso) casillas[m.filaPeonCapturado][m.colPeonCapturado] = capturadaAlPaso;
                else casillas[m.desdeFila][m.hastaCol] = capturadaAlPaso;
            }
            if (m.enroqueCorto) {
                int fila = m.desdeFila;
                casillas[fila][7] = casillas[fila][5];
                casillas[fila][5] = null;
            } else if (m.enroqueLargo) {
                int fila = m.desdeFila;
                casillas[fila][0] = casillas[fila][3];
                casillas[fila][3] = null;
            }

            return reySeguro;
        }

        boolean reyEnJaque(Color colorRey) {
            // Encontrar rey
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Pieza p = casillas[i][j];
                    if (p != null && p.tipo == Tipo.REY && p.color == colorRey) {
                        return estaAtacada(i, j, colorRey == Color.BLANCO ? Color.NEGRO : Color.BLANCO);
                    }
                }
            }
            return false;
        }

        boolean estaAtacada(int f, int c, Color atacante) {
            // Verifica si alguna pieza del color atacante puede moverse a (f,c)
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Pieza p = casillas[i][j];
                    if (p != null && p.color == atacante) {
                        if (p.tipo == Tipo.PEON) {
                            int dir = (p.color == Color.BLANCO) ? -1 : 1;
                            if ((f == i + dir) && (c == j - 1 || c == j + 1)) return true;
                        } else if (p.tipo == Tipo.CABALLO) {
                            if ((Math.abs(f - i) == 2 && Math.abs(c - j) == 1) ||
                                    (Math.abs(f - i) == 1 && Math.abs(c - j) == 2)) return true;
                        } else if (p.tipo == Tipo.REY) {
                            if (Math.abs(f - i) <= 1 && Math.abs(c - j) <= 1) return true;
                        } else if (p.tipo == Tipo.ALFIL) {
                            if (Math.abs(f - i) == Math.abs(c - j) && caminoLibre(i,j,f,c)) return true;
                        } else if (p.tipo == Tipo.TORRE) {
                            if ((f == i || c == j) && caminoLibre(i,j,f,c)) return true;
                        } else if (p.tipo == Tipo.REINA) {
                            if ((f == i || c == j || Math.abs(f - i) == Math.abs(c - j)) && caminoLibre(i,j,f,c)) return true;
                        }
                    }
                }
            }
            return false;
        }

        boolean caminoLibre(int fi, int fj, int ti, int tj) {
            int incF = Integer.compare(ti, fi);
            int incC = Integer.compare(tj, fj);
            int i = fi + incF, j = fj + incC;
            while (i != ti || j != tj) {
                if (casillas[i][j] != null) return false;
                i += incF;
                j += incC;
            }
            return true;
        }

        void ejecutarMovimiento(Movimiento m) {
            // Actualiza el tablero y los estados de enroque/al paso
            if (m.enroqueCorto) {
                int fila = m.desdeFila;
                casillas[fila][m.hastaCol] = casillas[fila][m.desdeCol];
                casillas[fila][m.desdeCol] = null;
                casillas[fila][5] = casillas[fila][7];
                casillas[fila][7] = null;
            } else if (m.enroqueLargo) {
                int fila = m.desdeFila;
                casillas[fila][m.hastaCol] = casillas[fila][m.desdeCol];
                casillas[fila][m.desdeCol] = null;
                casillas[fila][3] = casillas[fila][0];
                casillas[fila][0] = null;
            } else {
                // Movimiento normal
                casillas[m.hastaFila][m.hastaCol] = m.piezaMovida;
                casillas[m.desdeFila][m.desdeCol] = null;
                // Captura al paso
                if (m.capturaAlPaso) {
                    casillas[m.filaPeonCapturado][m.colPeonCapturado] = null;
                } else if (m.piezaMovida.tipo == Tipo.PEON && m.desdeCol != m.hastaCol && m.piezaCapturada != null &&
                        m.piezaCapturada.tipo == Tipo.PEON) {
                    casillas[m.desdeFila][m.hastaCol] = null;
                }
                // Promoción
                if (m.promocion) {
                    casillas[m.hastaFila][m.hastaCol] = new Pieza(m.piezaPromocion, m.piezaMovida.color);
                }
            }

            // Actualizar enroques
            if (m.piezaMovida.tipo == Tipo.REY) {
                if (m.piezaMovida.color == Color.BLANCO) {
                    puedeEnrocarCortoBlanco = false;
                    puedeEnrocarLargoBlanco = false;
                } else {
                    puedeEnrocarCortoNegro = false;
                    puedeEnrocarLargoNegro = false;
                }
            }
            if (m.piezaMovida.tipo == Tipo.TORRE) {
                if (m.desdeFila == 7 && m.desdeCol == 0) puedeEnrocarLargoBlanco = false;
                if (m.desdeFila == 7 && m.desdeCol == 7) puedeEnrocarCortoBlanco = false;
                if (m.desdeFila == 0 && m.desdeCol == 0) puedeEnrocarLargoNegro = false;
                if (m.desdeFila == 0 && m.desdeCol == 7) puedeEnrocarCortoNegro = false;
            }

            // Peón doble paso (para al paso): almacenar la casilla "pasada" (midpoint)
            filaPeonDoble = -1; colPeonDoble = -1;
            if (m.piezaMovida.tipo == Tipo.PEON && Math.abs(m.hastaFila - m.desdeFila) == 2) {
                filaPeonDoble = (m.desdeFila + m.hastaFila) / 2; // casilla "pasada"
                colPeonDoble = m.hastaCol;
            }

            turno = (turno == Color.BLANCO) ? Color.NEGRO : Color.BLANCO;
        }

        // Métodos auxiliares para generar movimientos
        void agregarMovPeon(int f, int c, Color color, List<int[]> lista) {
            int dir = (color == Color.BLANCO) ? -1 : 1;
            int inicio = (color == Color.BLANCO) ? 6 : 1;
            // Avance simple
            if (piezaEn(f+dir, c) == null) {
                lista.add(new int[]{f+dir, c});
                // Avance doble
                if (f == inicio && piezaEn(f+2*dir, c) == null) lista.add(new int[]{f+2*dir, c});
            }
            // Capturas
            if (c > 0) {
                Pieza diagIzq = piezaEn(f+dir, c-1);
                if (diagIzq != null && diagIzq.color != color) lista.add(new int[]{f+dir, c-1});
                else if (f+dir == filaPeonDoble && c-1 == colPeonDoble) lista.add(new int[]{f+dir, c-1}); // al paso
            }
            if (c < 7) {
                Pieza diagDer = piezaEn(f+dir, c+1);
                if (diagDer != null && diagDer.color != color) lista.add(new int[]{f+dir, c+1});
                else if (f+dir == filaPeonDoble && c+1 == colPeonDoble) lista.add(new int[]{f+dir, c+1}); // al paso
            }
        }

        void agregarMovCaballo(int f, int c, List<int[]> lista) {
            int[][] saltos = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
            for (int[] s : saltos) {
                int nf = f + s[0], nc = c + s[1];
                if (nf>=0 && nf<8 && nc>=0 && nc<8) {
                    Pieza dest = piezaEn(nf, nc);
                    if (dest == null || dest.color != turno) lista.add(new int[]{nf, nc});
                }
            }
        }

        void agregarMovDeslizante(int f, int c, int[][] dirs, List<int[]> lista) {
            for (int[] d : dirs) {
                int nf = f + d[0], nc = c + d[1];
                while (nf>=0 && nf<8 && nc>=0 && nc<8) {
                    Pieza dest = piezaEn(nf, nc);
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

        void agregarMovRey(int f, int c, List<int[]> lista) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    int nf = f + i, nc = c + j;
                    if (nf>=0 && nf<8 && nc>=0 && nc<8) {
                        Pieza dest = piezaEn(nf, nc);
                        if (dest == null || dest.color != turno) lista.add(new int[]{nf, nc});
                    }
                }
            }
        }

        boolean hayMovimientosLegales() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Pieza p = casillas[i][j];
                    if (p != null && p.color == turno) {
                        if (!movimientosLegales(i, j).isEmpty()) return true;
                    }
                }
            }
            return false;
        }
    }

    // --- JUEGO PRINCIPAL ---
    static Scanner sc = new Scanner(System.in);
    static Tablero tablero;
    static List<Movimiento> historial = new ArrayList<>();
    static String archivoMovs = "movimientos.txt";
    static boolean contraBot;

    public static void main(String[] args) {
        System.out.println("=== AJEDREZ EN CONSOLA ===");
        System.out.println("1. Dos jugadores");
        System.out.println("2. Un jugador (contra bot)");
        System.out.print("Elige modo (1 o 2): ");
        String modo = sc.nextLine().trim();
        contraBot = modo.equals("2");

        tablero = new Tablero();
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoMovs))) {
            pw.println("Movimientos de la partida:");
        } catch (IOException e) {
            System.err.println("No se pudo crear archivo de movimientos.");
            return;
        }

        while (true) {
            imprimirTablero();
            if (tablero.reyEnJaque(tablero.turno)) {
                System.out.println("¡Jaque al rey " + (tablero.turno == Color.BLANCO ? "blanco" : "negro") + "!");
            }
            if (!tablero.hayMovimientosLegales()) {
                if (tablero.reyEnJaque(tablero.turno)) {
                    System.out.println("¡Jaque mate! Gana " + (tablero.turno == Color.BLANCO ? "negro" : "blanco"));
                } else {
                    System.out.println("¡Ahogado! (Tablas)");
                }
                break;
            }

            System.out.println("Turno de " + (tablero.turno == Color.BLANCO ? "blancas" : "negras"));
            if (contraBot && tablero.turno == Color.NEGRO) {
                // Movimiento del bot
                Movimiento botMove = elegirMovimientoBot();
                System.out.println("Bot mueve: " + botMove.aNotacion());
                ejecutarYGuardar(botMove);
            } else {
                // Humano
                Movimiento mov = pedirMovimientoHumano();
                if (mov == null) continue; // reintentar
                ejecutarYGuardar(mov);
            }
        }
        System.out.println("Partida terminada. Movimientos guardados en " + archivoMovs);
    }

    static Movimiento pedirMovimientoHumano() {
        while (true) {
            System.out.print("Ingrese la pieza a mover (ej: e2): ");
            String origen = sc.nextLine().trim().toLowerCase();
            if (origen.length() != 2) { System.out.println("Formato inválido. Use letra+número."); continue; }
            int col = origen.charAt(0) - 'a';
            int fila = 8 - (origen.charAt(1) - '0');
            if (fila < 0 || fila > 7 || col < 0 || col > 7) { System.out.println("Casilla fuera del tablero."); continue; }
            Pieza pieza = tablero.piezaEn(fila, col);
            if (pieza == null || pieza.color != tablero.turno) {
                System.out.println("No hay pieza propia en esa casilla.");
                continue;
            }

            // Mostrar movimientos posibles
            List<Movimiento> posibles = tablero.movimientosLegales(fila, col);
            if (posibles.isEmpty()) {
                System.out.println("Esa pieza no tiene movimientos legales.");
                continue;
            }
            System.out.println("Movimientos posibles:");
            imprimirTableroConMarcas(fila, col, posibles);
            System.out.println("Lista de destinos:");
            for (Movimiento m : posibles) {
                System.out.print("  " + (char)('a'+m.hastaCol) + (8-m.hastaFila));
                if (m.promocion) System.out.print(" (promoción a " + m.piezaPromocion + ")");
                System.out.println();
            }

            System.out.print("Ingrese destino (ej: e4), o 'c' para cancelar: ");
            String destino = sc.nextLine().trim().toLowerCase();
            if (destino.equals("c")) continue;
            if (destino.length() != 2) { System.out.println("Destino inválido."); continue; }
            int colDest = destino.charAt(0) - 'a';
            int filaDest = 8 - (destino.charAt(1) - '0');
            if (filaDest < 0 || filaDest > 7 || colDest < 0 || colDest > 7) { System.out.println("Destino fuera del tablero."); continue; }

            Movimiento elegido = null;
            for (Movimiento m : posibles) {
                if (m.hastaFila == filaDest && m.hastaCol == colDest) {
                    elegido = m;
                    break;
                }
            }
            if (elegido == null) {
                System.out.println("Movimiento no válido.");
                continue;
            }

            // Promoción
            if (elegido.piezaMovida.tipo == Tipo.PEON && (filaDest == 0 || filaDest == 7)) {
                System.out.print("¿A qué pieza promociona? (D=Reina, T=Torre, A=Alfil, C=Caballo): ");
                String prom = sc.nextLine().trim().toUpperCase();
                elegido.promocion = true;
                switch (prom) {
                    case "D": elegido.piezaPromocion = Tipo.REINA; break;
                    case "T": elegido.piezaPromocion = Tipo.TORRE; break;
                    case "A": elegido.piezaPromocion = Tipo.ALFIL; break;
                    case "C": elegido.piezaPromocion = Tipo.CABALLO; break;
                    default:
                        System.out.println("Opción no válida, se asigna Reina.");
                        elegido.piezaPromocion = Tipo.REINA;
                }
            }

            return elegido;
        }
    }

    static Movimiento elegirMovimientoBot() {
        List<Movimiento> todos = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pieza p = tablero.piezaEn(i, j);
                if (p != null && p.color == Color.NEGRO) {
                    todos.addAll(tablero.movimientosLegales(i, j));
                }
            }
        }
        if (todos.isEmpty()) return null;
        // Prioridad: capturar pieza de mayor valor, sino aleatorio
        todos.sort((a, b) -> {
            int va = valorPieza(a.piezaCapturada);
            int vb = valorPieza(b.piezaCapturada);
            return vb - va; // descendente
        });
        // Tomamos el primero (mejor captura) o aleatorio si todas iguales
        return todos.get(0);
    }

    static int valorPieza(Pieza p) {
        if (p == null) return 0;
        return switch (p.tipo) {
            case PEON -> 1;
            case CABALLO, ALFIL -> 3;
            case TORRE -> 5;
            case REINA -> 9;
            default -> 0;
        };
    }

    static void ejecutarYGuardar(Movimiento m) {
        tablero.ejecutarMovimiento(m);
        historial.add(m);
        try (FileWriter fw = new FileWriter(archivoMovs, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            pw.println(historial.size() + ". " + m.aNotacion());
        } catch (IOException e) {
            System.err.println("Error al escribir en archivo de movimientos.");
        }
    }

    // --- IMPRESIÓN DEL TABLERO ---
    static void imprimirTablero() {
        System.out.println("  +------------------------+");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " | ");
            for (int j = 0; j < 8; j++) {
                Pieza p = tablero.casillas[i][j];
                if (p == null) System.out.print(". ");
                else System.out.print(p.simbolo() + " ");
            }
            System.out.println("|");
        }
        System.out.println("  +------------------------+");
        System.out.println("    a b c d e f g h");
    }

    static void imprimirTableroConMarcas(int filaOrigen, int colOrigen, List<Movimiento> posibles) {
        Set<String> destinos = new HashSet<>();
        for (Movimiento m : posibles) destinos.add(m.hastaFila + "," + m.hastaCol);
        System.out.println("  +------------------------+");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " | ");
            for (int j = 0; j < 8; j++) {
                if (i == filaOrigen && j == colOrigen) {
                    System.out.print(tablero.casillas[i][j].simbolo() + " ");
                } else if (destinos.contains(i + "," + j)) {
                    Pieza p = tablero.casillas[i][j];
                    if (p == null) System.out.print("* ");
                    else System.out.print(Character.toLowerCase(p.simbolo()) + " ");
                } else {
                    Pieza p = tablero.casillas[i][j];
                    if (p == null) System.out.print(". ");
                    else System.out.print(p.simbolo() + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  +------------------------+");
        System.out.println("    a b c d e f g h   (* = posible destino)");
    }
}