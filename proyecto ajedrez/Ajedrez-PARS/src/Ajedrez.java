import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.List;
import java.util.*;
import javax.swing.SwingWorker;

//pagina de bot stockfish: https://github.com/official-stockfish/Stockfish

//nota: saco las piezas del mapa de caracteres de Windows en la fuente "Segoe UI Symbol"

//PIEZAS BLANCAS
// ♚♛♜♝♞♟
//PIEZAS NEGRAS
// ♔♕♖♗♘♙


/**
 * Clase principal que combina la GUI (Swing) y la lógica del juego.
 * Contiene clases anidadas que representan `Pieza`, `Movimiento` y `Tablero`.
 * Gestiona la interacción del usuario, la comunicación con Stockfish y
 * el flujo de la partida (turnos, historial, promociones y fin de juego).
 */
public class Ajedrez extends JFrame {

    // --- CONSTANTES Y ENUMS ---
    enum Color { BLANCO, NEGRO }
    enum Tipo { REY, REINA, TORRE, ALFIL, CABALLO, PEON }

    /** Representa una pieza de ajedrez con su tipo y color. */
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

        // Símbolo Unicode para la GUI
        String simboloGUI() {
            return switch (tipo) {
                case REY -> color == Color.BLANCO ? "♔" : "♚";
                case REINA -> color == Color.BLANCO ? "♕" : "♛";
                case TORRE -> color == Color.BLANCO ? "♖" : "♜";
                case ALFIL -> color == Color.BLANCO ? "♗" : "♝";
                case CABALLO -> color == Color.BLANCO ? "♘" : "♞";
                case PEON -> color == Color.BLANCO ? "♙" : "♟";
            };
        }

        @Override
        public String toString() {
            return String.valueOf(simbolo());
        }
    }

    /**
     * Representa un movimiento en el tablero.
     * Guarda posición origen/destino, pieza movida/capturada y flags
     * (enroque, promoción, captura al paso) y coordenadas del peón
     * capturado en caso de en-passant.
     */
    static class Movimiento
    {
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
    /**
     * Modelo del tablero y reglas del juego (generación de movimientos,
     * verificación de jaque, ejecución de movimientos y estado de enroque
     * y peón doble para captura al paso).
     */
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
            for (int j = 0; j < 8; j++) casillas[1][j] = new Pieza(Tipo.PEON, Color.NEGRO); //loop para fila peones

            // Piezas blancas (fila 6,7)
            for (int j = 0; j < 8; j++) casillas[6][j] = new Pieza(Tipo.PEON, Color.BLANCO);//loop para fila peones
            casillas[7][0] = new Pieza(Tipo.TORRE, Color.BLANCO);
            casillas[7][1] = new Pieza(Tipo.CABALLO, Color.BLANCO);
            casillas[7][2] = new Pieza(Tipo.ALFIL, Color.BLANCO);
            casillas[7][3] = new Pieza(Tipo.REINA, Color.BLANCO);
            casillas[7][4] = new Pieza(Tipo.REY, Color.BLANCO);
            casillas[7][5] = new Pieza(Tipo.ALFIL, Color.BLANCO);
            casillas[7][6] = new Pieza(Tipo.CABALLO, Color.BLANCO);
            casillas[7][7] = new Pieza(Tipo.TORRE, Color.BLANCO);
        }

        /**
         * Devuelve la pieza en la casilla indicada o `null` si está fuera
         * del tablero o la casilla está vacía.
         */
        Pieza piezaEn(int f, int c) {
            if (f < 0 || f > 7 || c < 0 || c > 7) return null;
            return casillas[f][c];
        }

        /**
         * Genera la lista de movimientos legales para la pieza en (f,c).
         * Aplica reglas de movimiento por tipo y filtra movimientos que
         * dejarían al rey en jaque mediante `esLegal`.
         */
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

        /**
         * Construye un objeto `Movimiento` para el desplazamiento desde
         * (ff,fc) a (tf,tc). Maneja detección de captura al paso y devuelve
         * `null` si el destino contiene pieza propia o si un movimiento
         * diagonal de peón no corresponde a una captura válida.
         */
        private Movimiento crearMovimiento(int ff, int fc, int tf, int tc, Pieza pieza) {
            Pieza destino = piezaEn(tf, tc);
            if (destino != null && destino.color == pieza.color) return null;
            Movimiento m = new Movimiento(ff, fc, tf, tc, pieza, destino);
            // Peón al paso
            if (pieza.tipo == Tipo.PEON && fc != tc && destino == null) {
                // captura al paso: el objetivo (casilla pasada) debe coincidir con el destino (tf,tc)
                if (filaPeonDoble == tf && colPeonDoble == tc) {
                    int dir = (pieza.color == Color.BLANCO) ? -1 : 1;
                    // CORRECCIÓN: el peón enemigo está en tf - dir
                    Pieza peonEnemigo = piezaEn(tf - dir, tc);
                    if (peonEnemigo != null && peonEnemigo.tipo == Tipo.PEON && peonEnemigo.color != pieza.color) {
                        m.piezaCapturada = peonEnemigo;
                        m.capturaAlPaso = true;
                        m.filaPeonCapturado = tf - dir;
                        m.colPeonCapturado = tc;
                    } else {
                        return null; // no es captura al paso válida
                    }
                } else {
                    return null; // movimiento diagonal sin captura
                }
            }
            return m;
        }

        /**
         * Simula `m` de forma temporal y devuelve true si, tras el movimiento,
         * el rey del color de `m.piezaMovida` no queda en jaque. Se encarga
         * de simular correctamente capturas al paso y enroques para la
         * evaluación.
         */
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

        /**
         * Comprueba si el rey del color `colorRey` está en jaque.
         */
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

        /**
         * Determina si la casilla (f,c) está atacada por alguna pieza del
         * color `atacante`. Utilizado por la detección de jaque y para
         * validar enroques.
         */
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

        /**
         * Comprueba que el camino entre (fi,fj) y (ti,tj) esté libre de
         * piezas (excluyendo los extremos). Utilizado por movimientos
         * deslizantes: torres, alfiles y reinas.
         */
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

        /**
         * Aplica `m` al tablero: mueve piezas, elimina capturas (incluyendo
         * en-passant con detección robusta), maneja enroques y promociones,
         * y actualiza el estado de `filaPeonDoble` para el siguiente turno.
         */
        void ejecutarMovimiento(Movimiento m) {
            // Guardamos el estado actual del peón al paso ANTES de modificarlo
            int filaPD = this.filaPeonDoble;
            int colPD = this.colPeonDoble;

            // --- Ejecutar el movimiento ---
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

                // --- DETECCIÓN ROBUSTA DE CAPTURA AL PASO ---
                // Si es un peón que se mueve en diagonal y la casilla intermedia coincide
                // con el peón al paso registrado, eliminamos el peón enemigo.
                if (m.piezaMovida.tipo == Tipo.PEON && m.desdeCol != m.hastaCol) {
                    if (filaPD == m.hastaFila && colPD == m.hastaCol) {
                        int dir = (m.piezaMovida.color == Color.BLANCO) ? -1 : 1;
                        // CORRECCIÓN: el peón enemigo está en tf - dir
                        int filaPeon = m.hastaFila - dir; // fila donde está el peón enemigo
                        if (filaPeon >= 0 && filaPeon < 8) {
                            casillas[filaPeon][m.hastaCol] = null;
                        }
                    }
                }

                // Promoción
                if (m.promocion) {
                    casillas[m.hastaFila][m.hastaCol] = new Pieza(m.piezaPromocion, m.piezaMovida.color);
                }
            }

            // --- Actualizar estados de enroque ---
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

            // --- Actualizar peón al paso (para el próximo turno) ---
            filaPeonDoble = -1;
            colPeonDoble = -1;
            if (m.piezaMovida.tipo == Tipo.PEON && Math.abs(m.hastaFila - m.desdeFila) == 2) {
                filaPeonDoble = (m.desdeFila + m.hastaFila) / 2;
                colPeonDoble = m.hastaCol;
            }

            // Cambiar turno
            turno = (turno == Color.BLANCO) ? Color.NEGRO : Color.BLANCO;
        }

        // Métodos auxiliares para generar movimientos
        /**
         * Genera movimientos básicos para un peón en (f,c): avance simple,
         * avance doble (si aplica), capturas normales y casilla de captura
         * al paso si corresponde. Añade destinos a `lista`.
         */
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

        /** Genera movimientos de salto para el caballo en (f,c). */
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

        /**
         * Genera movimientos deslizantes en las direcciones `dirs` desde
         * (f,c). Utilizado por alfiles, torres y reinas.
         */
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

        /** Genera movimientos de rey (un paso en cualquier dirección). */
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

        /**
         * Recorre el tablero y devuelve true si el jugador `turno` tiene
         * al menos un movimiento legal. Utilizado para detectar mate/ahogado.
         */
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

    // --- VARIABLES DE LA GUI ---
    private static Tablero tablero;
    private TableroPanel panelTablero;
    private int filaSeleccionada = -1;
    private int colSeleccionada = -1;
    private List<Movimiento> movimientosPosibles = new ArrayList<>();
    private boolean esperandoPromocion = false;
    /** Movimiento pendiente cuando se solicita elección de promoción. */
    private Movimiento movimientoPendiente = null;
    private boolean juegoTerminado = false;

    // --- STOCKFISH ---
    static Process motorStockfish = null;
    static PrintWriter aMotor = null;
    static BufferedReader delMotor = null;
    static int profundidadStockfish = 10;
    static boolean contraBot;

    /**
     * Constructor de la ventana principal.
     * Configura el tablero, el panel de dibujo y el manejador de clics.
     */
    public Ajedrez() {
        tablero = new Tablero();
        setTitle("Ajedrez con Stockfish");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelTablero = new TableroPanel();
        panelTablero.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                manejarClick(e.getX(), e.getY());
            }
        });
        add(panelTablero);
        setSize(600, 630);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Maneja cada clic del usuario sobre el tablero.
     * Selecciona piezas, calcula movimientos legales, ejecuta el movimiento
     * elegido y gestiona promociones o el turno del bot.
     */
    private void manejarClick(int x, int y) {
        if (esperandoPromocion) return;
        if (juegoTerminado) return;

        int col = x / 75;
        int fila = y / 75;
        if (fila < 0 || fila > 7 || col < 0 || col > 7) return;

        if (filaSeleccionada == -1) {
            // Seleccionar pieza propia
            Pieza pieza = tablero.piezaEn(fila, col);
            if (pieza != null && pieza.color == tablero.turno) {
                filaSeleccionada = fila;
                colSeleccionada = col;
                movimientosPosibles = tablero.movimientosLegales(fila, col);
            }
        } else {
            // Intentar mover a destino
            Movimiento elegido = null;
            for (Movimiento m : movimientosPosibles) {
                if (m.hastaFila == fila && m.hastaCol == col) {
                    elegido = m;
                    break;
                }
            }
            if (elegido != null) {
                // Si es promoción, preguntar
                if (elegido.piezaMovida.tipo == Tipo.PEON && (fila == 0 || fila == 7)) {
                    esperandoPromocion = true;
                    movimientoPendiente = elegido;
                    String[] opciones = {"Reina", "Torre", "Alfil", "Caballo"};
                    int seleccion = JOptionPane.showOptionDialog(this,
                            "¿A qué pieza promociona?",
                            "Promoción",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opciones,
                            opciones[0]);
                    Tipo tipoProm;
                    switch (seleccion) {
                        case 0: tipoProm = Tipo.REINA; break;
                        case 1: tipoProm = Tipo.TORRE; break;
                        case 2: tipoProm = Tipo.ALFIL; break;
                        case 3: tipoProm = Tipo.CABALLO; break;
                        default: tipoProm = Tipo.REINA;
                    }
                    elegido.promocion = true;
                    elegido.piezaPromocion = tipoProm;
                    esperandoPromocion = false;
                }
                ejecutarYGuardar(elegido);
                filaSeleccionada = -1;
                colSeleccionada = -1;
                movimientosPosibles.clear();

                // Verificar fin de juego tras el movimiento
                verificarFinJuego();

                // Si es modo bot y turno de negras, llamar a Stockfish (si no terminó)
                if (!juegoTerminado && contraBot && tablero.turno == Color.NEGRO) {
                    hacerMovimientoBot();
                }
            } else {
                // Si clic en otra pieza propia, cambiar selección
                Pieza pieza = tablero.piezaEn(fila, col);
                if (pieza != null && pieza.color == tablero.turno) {
                    filaSeleccionada = fila;
                    colSeleccionada = col;
                    movimientosPosibles = tablero.movimientosLegales(fila, col);
                } else {
                    // Clic inválido, limpiar selección
                    filaSeleccionada = -1;
                    colSeleccionada = -1;
                    movimientosPosibles.clear();
                }
            }
        }
        panelTablero.repaint();
    }

    /**
     * Solicita al motor Stockfish el mejor movimiento y lo ejecuta en segundo plano.
     * Si Stockfish falla, usa un movimiento aleatorio de respaldo.
     */
    private void hacerMovimientoBot() {
        // Ejecutar en hilo aparte para no congelar la GUI
        SwingWorker<Movimiento, Void> worker = new SwingWorker<>() {
            @Override
            protected Movimiento doInBackground() {
                String fen = tableroAFEN();
                String uci = obtenerMejorMovimiento(fen);
                if (uci == null || uci.length() < 4) return elegirMovimientoAleatorio();
                // Parsear UCI
                int colDesde = uci.charAt(0) - 'a';
                int filaDesde = 8 - (uci.charAt(1) - '0');
                int colHasta = uci.charAt(2) - 'a';
                int filaHasta = 8 - (uci.charAt(3) - '0');
                boolean prom = uci.length() == 5;
                Tipo tipoProm = Tipo.REINA;
                if (prom) {
                    char promChar = uci.charAt(4);
                    tipoProm = switch (Character.toUpperCase(promChar)) {
                        case 'Q' -> Tipo.REINA;
                        case 'R' -> Tipo.TORRE;
                        case 'B' -> Tipo.ALFIL;
                        case 'N' -> Tipo.CABALLO;
                        default -> Tipo.REINA;
                    };
                }
                Pieza piezaM = tablero.piezaEn(filaDesde, colDesde);
                Movimiento mov = new Movimiento(filaDesde, colDesde, filaHasta, colHasta, piezaM, null);
                // Detectar captura al paso: destino vacío, movimiento diagonal de peón
                if (piezaM != null && piezaM.tipo == Tipo.PEON && colDesde != colHasta
                        && tablero.filaPeonDoble == filaHasta && tablero.colPeonDoble == colHasta) {
                    int dir = (piezaM.color == Color.BLANCO) ? -1 : 1;
                    mov.capturaAlPaso = true;
                    // CORRECCIÓN: usar filaHasta - dir
                    mov.filaPeonCapturado = filaHasta - dir;
                    mov.colPeonCapturado = colHasta;
                    mov.piezaCapturada = tablero.piezaEn(mov.filaPeonCapturado, mov.colPeonCapturado);
                } else {
                    mov.piezaCapturada = tablero.piezaEn(filaHasta, colHasta);
                }
                if (prom) {
                    mov.promocion = true;
                    mov.piezaPromocion = tipoProm;
                }
                return mov;
            }

            @Override
            protected void done() {
                try {
                    Movimiento mov = get();
                    if (mov != null) {
                        ejecutarYGuardar(mov);
                        panelTablero.repaint();
                        verificarFinJuego();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        worker.execute();
    }

    /**
     * Verifica si el juego ha terminado por jaque mate o ahogado.
     * Muestra un diálogo de fin de partida y deshabilita la entrada de usuario.
     */
    private void verificarFinJuego() {
        if (!tablero.hayMovimientosLegales()) {
            if (tablero.reyEnJaque(tablero.turno)) {
                String ganador = (tablero.turno == Color.BLANCO ? "negras" : "blancas");
                JOptionPane.showMessageDialog(this,
                        "¡Jaque mate! Gana " + ganador,
                        "Fin de la partida",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "¡Ahogado! (Tablas)",
                        "Fin de la partida",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            juegoTerminado = true;
            if (contraBot) cerrarStockfish();
        }
    }




    /**
     * Inicia el proceso de Stockfish usando UCI.
     * Configura la dificultad y espera a que el motor esté listo.
     */
    private static void iniciarStockfish(String rutaEjecutable, int skillLevel) {
        try {
            ProcessBuilder pb = new ProcessBuilder(rutaEjecutable);
            pb.redirectErrorStream(true);
            motorStockfish = pb.start();
            aMotor = new PrintWriter(new OutputStreamWriter(motorStockfish.getOutputStream()), true);
            delMotor = new BufferedReader(new InputStreamReader(motorStockfish.getInputStream()));

            // Configurar UCI
            aMotor.println("uci");
            String linea;
            while ((linea = delMotor.readLine()) != null) {
                if (linea.equals("uciok")) break;
            }
            // Ajustar dificultad
            aMotor.println("setoption name Skill Level value " + skillLevel);
            aMotor.println("isready");
            while ((linea = delMotor.readLine()) != null) {
                if (linea.equals("readyok")) break;
            }
            System.out.println("Stockfish iniciado (Skill Level " + skillLevel + ")");
        } catch (IOException e) {
            System.err.println("Error al iniciar Stockfish: " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Convierte el estado actual del tablero a una cadena FEN.
     * Stockfish utiliza esta notación para evaluar la posición.
     */
    private static String tableroAFEN() {
        StringBuilder fen = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int vacias = 0;
            for (int j = 0; j < 8; j++) {
                Pieza p = tablero.casillas[i][j];
                if (p == null) {
                    vacias++;
                } else {
                    if (vacias > 0) {
                        fen.append(vacias);
                        vacias = 0;
                    }
                    char c = switch (p.tipo) {
                        case PEON -> 'P';
                        case CABALLO -> 'N';
                        case ALFIL -> 'B';
                        case TORRE -> 'R';
                        case REINA -> 'Q';
                        case REY -> 'K';
                    };
                    fen.append(p.color == Color.BLANCO ? Character.toUpperCase(c) : Character.toLowerCase(c));
                }
            }
            if (vacias > 0) fen.append(vacias);
            if (i < 7) fen.append('/');
        }
        // Turno
        fen.append(' ').append(tablero.turno == Color.BLANCO ? 'w' : 'b');
        // Enroques (simplificado: si están disponibles se ponen, sino '-')
        String enroques = "";
        if (tablero.puedeEnrocarCortoBlanco) enroques += "K";
        if (tablero.puedeEnrocarLargoBlanco) enroques += "Q";
        if (tablero.puedeEnrocarCortoNegro) enroques += "k";
        if (tablero.puedeEnrocarLargoNegro) enroques += "q";
        if (enroques.isEmpty()) enroques = "-";
        fen.append(' ').append(enroques);
        // Peón al paso (simplificado)
        if (tablero.filaPeonDoble != -1) {
            fen.append(' ').append((char)('a' + tablero.colPeonDoble));
            fen.append(8 - tablero.filaPeonDoble);
        } else {
            fen.append(" -");
        }
        // Medio movimientos y número de jugada (no importantes para el motor)
        fen.append(" 0 1");
        return fen.toString();
    }


    /**
     * Pregunta a Stockfish por el mejor movimiento para la posición FEN dada.
     * Devuelve el movimiento en formato UCI, por ejemplo "e2e4".
     */
    private static String obtenerMejorMovimiento(String fen) {
        if (motorStockfish == null) return null;
        aMotor.println("ucinewgame");
        aMotor.println("position fen " + fen);
        aMotor.println("go depth " + profundidadStockfish);
        try {
            String linea;
            while ((linea = delMotor.readLine()) != null) {
                if (linea.startsWith("bestmove")) {
                    // Formato: "bestmove e7e5 ponder ..."
                    String[] partes = linea.split(" ");
                    return partes[1];  // ej: "e7e5"
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer de Stockfish: " + e.getMessage());
        }
        return null;
    }

    /**
     * Cierra el motor Stockfish al terminar la partida o al salir.
     */
    private static void cerrarStockfish() {
        if (aMotor != null) {
            aMotor.println("quit");
        }
        try {
            if (motorStockfish != null) {
                motorStockfish.waitFor();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }




    /**
     * Selecciona un movimiento legal al azar para el turno de negras.
     * Se usa como respaldo si Stockfish no devuelve un movimiento válido.
     */
    private static Movimiento elegirMovimientoAleatorio() {
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
        return todos.get((int)(Math.random() * todos.size()));
    }

    /**
     * Devuelve un valor heurístico simple para una pieza.
     * Utilizado para cálculos o evaluaciones de material si es necesario.
     */
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

    /**
     * Ejecuta un movimiento en el tablero y lo guarda en el historial y archivo.
     */
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

    /**
     * Panel de Swing encargado de dibujar el tablero, las piezas y las
     * casillas de selección/destino.
     */
    // --- PANEL QUE DIBUJA EL TABLERO ---
    class TableroPanel extends JPanel {
        private final int TAM = 75;
        private final java.awt.Color COLOR_CLARO = new java.awt.Color(240, 217, 181);
        private final java.awt.Color COLOR_OSCURO = new java.awt.Color(181, 136, 99);
        private final java.awt.Color COLOR_SELECCION = new java.awt.Color(255, 255, 0, 100);
        private final java.awt.Color COLOR_DESTINO = new java.awt.Color(0, 255, 0, 100);
        private final java.awt.Color COLOR_PIEZA_BLANCA = new java.awt.Color(245, 245, 245);
        private final java.awt.Color COLOR_PIEZA_NEGRA = new java.awt.Color(20, 20, 20);
        private final Font FUENTE = new Font("Segoe UI Symbol", Font.PLAIN, 48);

        @Override
        protected void paintComponent(Graphics g) {
            // Dibuja el tablero completo, las casillas de selección y los
            // destinos posibles, y luego pinta las piezas con su símbolo.
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            for (int f = 0; f < 8; f++) {
                for (int c = 0; c < 8; c++) {
                    // color base
                    g2.setColor((f + c) % 2 == 0 ? COLOR_CLARO : COLOR_OSCURO);
                    g2.fillRect(c * TAM, f * TAM, TAM, TAM);

                    // resaltar selección
                    if (f == filaSeleccionada && c == colSeleccionada) {
                        g2.setColor(COLOR_SELECCION);
                        g2.fillRect(c * TAM, f * TAM, TAM, TAM);
                    }

                    // resaltar destinos posibles
                    for (Movimiento m : movimientosPosibles) {
                        if (m.hastaFila == f && m.hastaCol == c) {
                            g2.setColor(COLOR_DESTINO);
                            g2.fillRect(c * TAM, f * TAM, TAM, TAM);
                            break;
                        }
                    }

                    // pieza
                    Pieza p = tablero.piezaEn(f, c);
                    if (p != null) {
                        String simbolo = p.simboloGUI();
                        FontMetrics fm = g2.getFontMetrics(FUENTE);
                        int x = c * TAM + (TAM - fm.stringWidth(simbolo)) / 2;
                        int y = f * TAM + (TAM - fm.getHeight()) / 2 + fm.getAscent();

                        if (p.color == Color.BLANCO) {
                            g2.setColor(java.awt.Color.BLACK);
                            g2.drawString(simbolo, x + 1, y + 1);
                            g2.setColor(COLOR_PIEZA_BLANCA);
                        } else {
                            g2.setColor(java.awt.Color.WHITE);
                            g2.drawString(simbolo, x + 1, y + 1);
                            g2.setColor(COLOR_PIEZA_NEGRA);
                        }
                        g2.setFont(FUENTE);
                        g2.drawString(simbolo, x, y);
                    }
                }
            }
        }
    }

public static void main(String[] args) {
    // Pedir modo y dificultad con diálogos
    String[] modos = {"Dos jugadores", "Contra Stockfish"};
    int modoElegido = JOptionPane.showOptionDialog(null,
            "Elige modo de juego", "Ajedrez",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, modos, modos[0]);
    if (modoElegido == -1) return; // Cancelar
    contraBot = (modoElegido == 1);

    int skillLevel = 10;
    if (contraBot) {
        String dificultadStr = JOptionPane.showInputDialog("Dificultad (1-20, 1=fácil, 20=máxima):");
        if (dificultadStr == null) return;
        try {
            skillLevel = Integer.parseInt(dificultadStr.trim());
            skillLevel = Math.max(1, Math.min(20, skillLevel));
        } catch (NumberFormatException e) {
            skillLevel = 10;
        }
        profundidadStockfish = Math.min(skillLevel + 2, 20);
        String ruta = JOptionPane.showInputDialog("Ruta del ejecutable de Stockfish (ej: stockfish.exe):");
        if (ruta == null) return;
        iniciarStockfish(ruta.trim(), skillLevel);
    }

    // Crear archivo de movimientos
    try (PrintWriter pw = new PrintWriter(new FileWriter(archivoMovs))) {
        pw.println("Movimientos de la partida:");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "No se pudo crear archivo de movimientos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Iniciar GUI
    SwingUtilities.invokeLater(() -> new Ajedrez());

    // Al cerrar la ventana, cerrar Stockfish
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        if (contraBot) cerrarStockfish();
    }));
}

static String archivoMovs = "movimientos.txt";
static List<Movimiento> historial = new ArrayList<>();
}