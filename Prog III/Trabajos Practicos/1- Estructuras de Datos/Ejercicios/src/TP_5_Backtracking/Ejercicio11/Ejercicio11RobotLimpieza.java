package TP_5_Backtracking.Ejercicio11;

import java.util.*;

//Poda por Cota Superior (Best So Far): Si longitudActual >= longitudMinima, se corta la rama inmediatamente.
//Poda por Distancia Manhattan (Cota Inferior)

public class Ejercicio11RobotLimpieza {

    private int[][] mapa; // 0 = libre, 1 = obstáculo
    private int filas, columnas;
    private int longitudMinima = Integer.MAX_VALUE;
    private List<int[]> mejorCamino = new ArrayList<>();

    public Ejercicio11RobotLimpieza(int[][] mapa) {
        this.mapa = mapa;
        this.filas = mapa.length;
        this.columnas = mapa[0].length;
    }

    public void buscarCaminoMasCorto(int fInicio, int cInicio, int fBase, int cBase) {
        if (mapa[fInicio][cInicio] == 1 || mapa[fBase][cBase] == 1) {
            System.out.println("Inicio o Base no válidos (hay un obstáculo).");
            return;
        }

        boolean[][] visitados = new boolean[filas][columnas];
        List<int[]> caminoActual = new ArrayList<>();

        visitados[fInicio][cInicio] = true;
        caminoActual.add(new int[]{fInicio, cInicio});

        backtracking(fInicio, cInicio, fBase, cBase, 1, visitados, caminoActual);

        System.out.println("--- RESULTADO EJERCICIO 11 ---");
        if (longitudMinima == Integer.MAX_VALUE) {
            System.out.println("No hay un camino disponible hacia la base de carga.");
        } else {
            System.out.println("Longitud del camino más corto: " + longitudMinima + " celdas.");
            System.out.print("Camino: ");
            for (int[] pos : mejorCamino) {
                System.out.print("(" + pos[0] + "," + pos[1] + ") ");
            }
            System.out.println();
        }
    }

    private void backtracking(int f, int c, int fBase, int cBase, int longitudActual,
                              boolean[][] visitados, List<int[]> caminoActual) {

        // PODA POR COTA SUPERIOR: Si la longitud actual ya supera o iguala la mejor encontrada
        if (longitudActual >= longitudMinima) {
            return;
        }

        // PODA POR DISTANCIA MANHATTAN: Cota inferior teórica restante
        int distanciaMinimaRestante = Math.abs(f - fBase) + Math.abs(c - cBase);
        if (longitudActual + distanciaMinimaRestante >= longitudMinima) {
            return;
        }

        // CASO BASE: Llegamos a la base de carga
        if (f == fBase && c == cBase) {
            longitudMinima = longitudActual;
            mejorCamino = new ArrayList<>(caminoActual);
            return;
        }

        int[] df = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nf = f + df[i];
            int nc = c + dc[i];

            if (nf >= 0 && nf < filas && nc >= 0 && nc < columnas) {
                if (mapa[nf][nc] == 0 && !visitados[nf][nc]) {

                    // 1. Marcar
                    visitados[nf][nc] = true;
                    caminoActual.add(new int[]{nf, nc});

                    // 2. Recursión
                    backtracking(nf, nc, fBase, cBase, longitudActual + 1, visitados, caminoActual);

                    // 3. Desmarcar
                    caminoActual.remove(caminoActual.size() - 1);
                    visitados[nf][nc] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mapa = {
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        Ejercicio11RobotLimpieza robot = new Ejercicio11RobotLimpieza(mapa);
        // Desde (0,0) hasta la base de carga en (4,4)
        robot.buscarCaminoMasCorto(0, 0, 4, 4);
    }
}