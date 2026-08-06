package TP_5_Backtracking.Ejercicio8;

import java.util.*;

public class Ejercicio8Piramide {

    private int B; // Base de la pirámide
    private int K; // Límite máximo para los números (1 <= num < K)
    private int[][] piramide; // piramide[f][c]
    private boolean[] usados;

    public Ejercicio8Piramide(int B, int K) {
        this.B = B;
        this.K = K;
        this.piramide = new int[B][];
        for (int i = 0; i < B; i++) {
            this.piramide[i] = new int[i + 1]; // La fila 0 tiene 1 celda, la fila B-1 tiene B celdas
        }
        this.usados = new boolean[K];
    }

    public boolean resolver() {
        // Asignamos primero la base (fila B-1) de izquierda a derecha
        return backtrackingBase(0);
    }

    // Paso 1: Generar valores para la base de la pirámide
    private boolean backtrackingBase(int col) {
        int filaBase = B - 1;

        if (col == B) {
            // Una vez completa la base, calculamos las filas superiores y verificamos validez
            return calcularYVerificarPiramide(B - 2);
        }

        for (int num = 1; num < K; num++) {
            if (!usados[num]) {
                piramide[filaBase][col] = num;
                usados[num] = true;

                if (backtrackingBase(col + 1)) {
                    return true;
                }

                usados[num] = false;
                piramide[filaBase][col] = 0;
            }
        }
        return false;
    }

    // Paso 2: Construir hacia arriba sumando las celdas inferiores y validar unicidad y límite K
    private boolean calcularYVerificarPiramide(int fila) {
        if (fila < 0) {
            return true; // Pirámide construida exitosamente
        }

        for (int col = 0; col <= fila; col++) {
            // Cada casilla es la suma de las dos sobre las que se apoya
            int suma = piramide[fila + 1][col] + piramide[fila + 1][col + 1];

            // PODA: Debe ser menor a K y no haber sido usado en la pirámide
            if (suma >= K || usados[suma]) {
                // Deshacer las asignaciones parciales de esta fila
                for (int c = 0; c < col; c++) {
                    usados[piramide[fila][c]] = false;
                    piramide[fila][c] = 0;
                }
                return false;
            }

            piramide[fila][col] = suma;
            usados[suma] = true;
        }

        if (calcularYVerificarPiramide(fila - 1)) {
            return true;
        }

        // Backtracking: liberar los números asignados en esta fila
        for (int col = 0; col <= fila; col++) {
            usados[piramide[fila][col]] = false;
            piramide[fila][col] = 0;
        }

        return false;
    }

    public void imprimir() {
        for (int i = 0; i < B; i++) {
            for (int k = 0; k < B - i - 1; k++) System.out.print("  ");
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", piramide[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int B = 3; // Base de 3 casillas
        int K = 50; // Números menores a 50

        Ejercicio8Piramide p = new Ejercicio8Piramide(B, K);
        System.out.println("--- PIRÁMIDE DE SUMAS ---");
        if (p.resolver()) {
            p.imprimir();
        } else {
            System.out.println("No hay solución para la base B=" + B + " y K=" + K);
        }
    }
}
