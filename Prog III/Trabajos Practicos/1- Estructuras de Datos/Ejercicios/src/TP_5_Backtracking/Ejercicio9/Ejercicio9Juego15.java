package TP_5_Backtracking.Ejercicio9;

import java.util.*;

public class Ejercicio9Juego15 {

    private static final int N = 4;
    private int[][] tableroInicial;
    private List<String> mejorSolucion = null;
    private int limiteProfundidad;

    public Ejercicio9Juego15(int[][] tablero) {
        this.tableroInicial = tablero;
    }

    public List<String> resolver() {
        // Encontrar posición inicial del hueco (0)
        int fHueco = -1, cHueco = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tableroInicial[i][j] == 0) {
                    fHueco = i;
                    cHueco = j;
                }
            }
        }

        // Búsqueda con Profundidad Iterativa (IDDFS) para garantizar el camino más corto
        for (limiteProfundidad = 1; limiteProfundidad <= 50; limiteProfundidad++) {
            List<String> movimientos = new ArrayList<>();
            if (backtracking(tableroInicial, fHueco, cHueco, 0, -1, movimientos)) {
                return mejorSolucion;
            }
        }
        return Collections.emptyList();
    }

    private boolean backtracking(int[][] tab, int f, int c, int pasos, int ultimoMov, List<String> movs) {
        if (esObjetivo(tab)) {
            mejorSolucion = new ArrayList<>(movs);
            return true;
        }

        // PODA: Cota de profundidad
        if (pasos >= limiteProfundidad) {
            return false;
        }

        // Direcciones: 0: Arriba, 1: Abajo, 2: Izquierda, 3: Derecha
        int[] df = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        String[] nombres = {"ARRIBA", "ABAJO", "IZQUIERDA", "DERECHA"};

        for (int i = 0; i < 4; i++) {
            // PODA: Evitar deshacer inmediatamente el movimiento anterior
            if ((i == 0 && ultimoMov == 1) || (i == 1 && ultimoMov == 0) ||
                    (i == 2 && ultimoMov == 3) || (i == 3 && ultimoMov == 2)) {
                continue;
            }

            int nf = f + df[i];
            int nc = c + dc[i];

            if (nf >= 0 && nf < N && nc >= 0 && nc < N) {
                // Intercambiar celda con el hueco
                int val = tab[nf][nc];
                tab[f][c] = val;
                tab[nf][nc] = 0;
                movs.add(nombres[i] + " (" + val + ")");

                if (backtracking(tab, nf, nc, pasos + 1, i, movs)) {
                    return true;
                }

                // Deshacer intercambio (Backtracking)
                movs.remove(movs.size() - 1);
                tab[nf][nc] = val;
                tab[f][c] = 0;
            }
        }
        return false;
    }

    private boolean esObjetivo(int[][] tab) {
        int esperado = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) {
                    return tab[i][j] == 0;
                }
                if (tab[i][j] != esperado++) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Tablero casi ordenado para prueba
        int[][] tab = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13, 14, 0, 15}
        };

        Ejercicio9Juego15 solver = new Ejercicio9Juego15(tab);
        List<String> pasos = solver.resolver();

        System.out.println("--- PASOS PARA RESOLVER EL JUEGO DEL 15 ---");
        System.out.println("Cantidad de movimientos: " + pasos.size());
        for (String paso : pasos) {
            System.out.println("-> " + paso);
        }
    }
}
