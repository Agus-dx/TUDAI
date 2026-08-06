package TP_5_Backtracking.Ejercicio7;

import java.util.*;

public class Ejercicio7TableroMagico {

    private int n;
    private int k;
    private int S;
    private int[][] tablero;
    private boolean[] usados;

    public Ejercicio7TableroMagico(int n, int k, int S) {
        this.n = n;
        this.k = k;
        this.S = S;
        this.tablero = new int[n][n];
        this.usados = new boolean[k + 1];
    }

    public boolean resolver() {
        return backtracking(0, 0);
    }

    private boolean backtracking(int f, int c) {
        if (f == n) {
            // Verificar suma de columnas al finalizar
            for (int j = 0; j < n; j++) {
                int sumaCol = 0;
                for (int i = 0; i < n; i++) sumaCol += tablero[i][j];
                if (sumaCol != S) return false;
            }
            return true;
        }

        int sigF = (c == n - 1) ? f + 1 : f;
        int sigC = (c == n - 1) ? 0 : c + 1;

        for (int num = 1; num <= k; num++) {
            if (!usados[num]) {
                tablero[f][c] = num;
                usados[num] = true;

                // Poda 1: Suma parcial de fila
                int sumaFila = 0;
                for (int j = 0; j <= c; j++) sumaFila += tablero[f][j];

                // Poda 2: Suma parcial de columna
                int sumaCol = 0;
                for (int i = 0; i <= f; i++) sumaCol += tablero[i][c];

                boolean filaValida = (c == n - 1) ? (sumaFila == S) : (sumaFila < S);
                boolean colValida = (f == n - 1) ? (sumaCol == S) : (sumaCol < S);

                if (filaValida && colValida) {
                    if (backtracking(sigF, sigC)) return true;
                }

                usados[num] = false;
                tablero[f][c] = 0;
            }
        }
        return false;
    }

    public void imprimirTablero() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(tablero[i]));
        }
    }

    public static void main(String[] args) {
        int n = 3, k = 15, S = 15;
        Ejercicio7TableroMagico tm = new Ejercicio7TableroMagico(n, k, S);

        System.out.println("--- TABLERO MÁGICO ---");
        if (tm.resolver()) {
            tm.imprimirTablero();
        } else {
            System.out.println("Sin solución.");
        }
    }
}
