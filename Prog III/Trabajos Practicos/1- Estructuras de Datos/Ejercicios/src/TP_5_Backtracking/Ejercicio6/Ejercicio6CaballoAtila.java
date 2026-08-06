package TP_5_Backtracking.Ejercicio6;

import java.util.*;

public class Ejercicio6CaballoAtila {

    private int N;
    private int[][] tablero; // 0 = no pisado (pasto), 1 = pisado por el caballo
    private int totalPisadasOriginales;
    private List<int[]> mejorRecorrido = new ArrayList<>();

    public Ejercicio6CaballoAtila(int N, int[][] estadoFinalPasto) {
        this.N = N;
        this.tablero = new int[N][N];
        int sinPasto = 0;

        // Invertimos: si la casilla no tiene pasto (0), el caballo la pisó (1)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (estadoFinalPasto[i][j] == 0) {
                    this.tablero[i][j] = 1;
                    sinPasto++;
                } else {
                    this.tablero[i][j] = 0;
                }
            }
        }
        this.totalPisadasOriginales = sinPasto;
    }

    public List<int[]> resolver() {
        // Buscar una casilla pisada para iniciar
        int fInicio = -1, cInicio = -1;
        for (int i = 0; i < N && fInicio == -1; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    fInicio = i;
                    cInicio = j;
                    break;
                }
            }
        }

        if (fInicio == -1) return mejorRecorrido;

        boolean[][] visitados = new boolean[N][N];
        List<int[]> caminoActual = new ArrayList<>();

        visitados[fInicio][cInicio] = true;
        caminoActual.add(new int[]{fInicio, cInicio});

        backtracking(fInicio, cInicio, fInicio, cInicio, 1, visitados, caminoActual);
        return mejorRecorrido;
    }

    private boolean backtracking(int f, int c, int fInicio, int cInicio, int pisadas,
                                 boolean[][] visitados, List<int[]> caminoActual) {

        int[] df = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nf = f + df[i];
            int nc = c + dc[i];

            // Cierre del ciclo cerrado: volvió al inicio y visitó todas las casillas pisadas
            if (nf == fInicio && nc == cInicio && pisadas == totalPisadasOriginales) {
                mejorRecorrido = new ArrayList<>(caminoActual);
                return true;
            }

            if (nf >= 0 && nf < N && nc >= 0 && nc < N) {
                if (tablero[nf][nc] == 1 && !visitados[nf][nc]) {
                    visitados[nf][nc] = true;
                    caminoActual.add(new int[]{nf, nc});

                    if (backtracking(nf, nc, fInicio, cInicio, pisadas + 1, visitados, caminoActual)) {
                        return true;
                    }

                    caminoActual.remove(caminoActual.size() - 1);
                    visitados[nf][nc] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Matriz 3x3: 1 = hay pasto, 0 = no hay pasto (pisado)
        int[][] pasto = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        Ejercicio6CaballoAtila atila = new Ejercicio6CaballoAtila(3, pasto);
        List<int[]> recorrido = atila.resolver();

        System.out.println("--- RECORRIDO DEL CABALLO ---");
        for (int[] pos : recorrido) {
            System.out.println("(" + pos[0] + ", " + pos[1] + ")");
        }
    }
}