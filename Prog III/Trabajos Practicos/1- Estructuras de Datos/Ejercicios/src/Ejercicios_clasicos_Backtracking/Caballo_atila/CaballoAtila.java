package Ejercicios_clasicos_Backtracking.Caballo_atila;

import java.util.*;

public class CaballoAtila {

    // Movimientos ortogonales: Arriba, Abajo, Izquierda, Derecha (Sin diagonales)
    private static final int[] DF = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    public static class Casilla {
        int f, c;
        public Casilla(int f, int c) {
            this.f = f;
            this.c = c;
        }

        @Override
        public String toString() {
            return "(" + f + ", " + c + ")";
        }
    }

    /**
     * Resuelve el recorrido del Caballo de Atila.
     * @param mapa Matriz donde true = sin pasto (pisado por el caballo), false = con pasto.
     */
    public static List<Casilla> obtenerRecorrido(boolean[][] mapa) {
        int n = mapa.length;
        int totalSinPasto = 0;
        int inicioF = -1, inicioC = -1;

        // Contamos cuántas casillas pisó el caballo y elegimos el origen
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (mapa[r][c]) {
                    totalSinPasto++;
                    if (inicioF == -1) {
                        inicioF = r;
                        inicioC = c;
                    }
                }
            }
        }

        if (totalSinPasto == 0) return Collections.emptyList();

        boolean[][] visitado = new boolean[n][n];
        List<Casilla> camino = new ArrayList<>();

        // Marcamos e iniciamos desde la primera casilla sin pasto hallada
        visitado[inicioF][inicioC] = true;
        camino.add(new Casilla(inicioF, inicioC));

        if (backtrack(mapa, visitado, inicioF, inicioC, inicioF, inicioC, 1, totalSinPasto, camino)) {
            camino.add(new Casilla(inicioF, inicioC)); // Cerramos el ciclo
            return camino;
        }

        return null; // No se encontró un recorrido válido
    }

    private static boolean backtrack(boolean[][] mapa, boolean[][] visitado,
                                     int actualF, int actualC,
                                     int origenF, int origenC,
                                     int pasos, int totalPisos,
                                     List<Casilla> camino) {
        int n = mapa.length;

        // CASO BASE: Si ya visitamos todas las casillas sin pasto
        if (pasos == totalPisos) {
            // Verificamos si podemos volver al origen (adyacencia ortogonal)
            return Math.abs(actualF - origenF) + Math.abs(actualC - origenC) == 1;
        }

        // Explorar los 4 vecinos ortogonales
        for (int i = 0; i < 4; i++) {
            int nf = actualF + DF[i];
            int nc = actualC + DC[i];

            // Validar límites, si fue pisada por Atila (sin pasto) y si no la visitamos aún
            if (esValido(mapa, visitado, nf, nc, n)) {
                visitado[nf][nc] = true;
                camino.add(new Casilla(nf, nc));

                if (backtrack(mapa, visitado, nf, nc, origenF, origenC, pasos + 1, totalPisos, camino)) {
                    return true;
                }

                // Backtrack (Deshacer)
                camino.remove(camino.size() - 1);
                visitado[nf][nc] = false;
            }
        }

        return false;
    }

    private static boolean esValido(boolean[][] mapa, boolean[][] visitado, int f, int c, int n) {
        return f >= 0 && f < n && c >= 0 && c < n && mapa[f][c] && !visitado[f][c];
    }
}