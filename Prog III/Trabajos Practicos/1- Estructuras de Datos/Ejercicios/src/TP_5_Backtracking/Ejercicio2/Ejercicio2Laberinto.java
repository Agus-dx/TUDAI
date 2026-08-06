package TP_5_Backtracking.Ejercicio2;

import java.util.*;

public class Ejercicio2Laberinto {

    private int N;
    private Casilla[][] laberinto;
    private int menorCosto = Integer.MAX_VALUE;
    private List<String> mejorCamino = new ArrayList<>();

    public Ejercicio2Laberinto(Casilla[][] laberinto) {
        this.laberinto = laberinto;
        this.N = laberinto.length;
    }

    public void buscarCaminoMinimo(int fOrigen, int cOrigen, int fDestino, int cDestino) {
        menorCosto = Integer.MAX_VALUE;
        mejorCamino.clear();

        boolean[][] visitados = new boolean[N][N];
        List<String> caminoActual = new ArrayList<>();

        // Marcamos la casilla inicial
        visitados[fOrigen][cOrigen] = true;
        int costoInicial = laberinto[fOrigen][cOrigen].getValor();
        caminoActual.add("(" + fOrigen + "," + cOrigen + ")");

        backtracking(fOrigen, cOrigen, fDestino, cDestino, costoInicial, visitados, caminoActual);

        System.out.println("--- RESULTADO EJERCICIO 2 ---");
        if (menorCosto == Integer.MAX_VALUE) {
            System.out.println("No existe ningún camino entre las casillas dadas.");
        } else {
            System.out.println("Menor costo total: " + menorCosto);
            System.out.println("Camino recorrido: " + mejorCamino);
        }
    }

    private void backtracking(int f, int c, int fDest, int cDest, int costoActual,
                              boolean[][] visitados, List<String> caminoActual) {

        // PODA POR COSTO: Si el costo actual ya iguala o supera al mejor encontrado, no seguimos.
        if (costoActual >= menorCosto) {
            return;
        }

        // CASO BASE: Llegamos al destino
        if (f == fDest && c == cDest) {
            menorCosto = costoActual;
            mejorCamino = new ArrayList<>(caminoActual);
            return;
        }

        Casilla celda = laberinto[f][c];

        // Matriz de desplazamientos para [Norte, Este, Sur, Oeste]
        int[] df = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        boolean[] sePuede = {celda.puedeNorte(), celda.puedeEste(), celda.puedeSur(), celda.puedeOeste()};

        for (int i = 0; i < 4; i++) {
            if (sePuede[i]) {
                int nf = f + df[i];
                int nc = c + dc[i];

                // Verificamos que esté dentro de los límites de la matriz y no visitado
                if (nf >= 0 && nf < N && nc >= 0 && nc < N && !visitados[nf][nc]) {
                    int nuevoCosto = costoActual + laberinto[nf][nc].getValor();

                    // 1. Marcar
                    visitados[nf][nc] = true;
                    caminoActual.add("(" + nf + "," + nc + ")");

                    // 2. Recursión
                    backtracking(nf, nc, fDest, cDest, nuevoCosto, visitados, caminoActual);

                    // 3. Desmarcar (Backtracking)
                    caminoActual.remove(caminoActual.size() - 1);
                    visitados[nf][nc] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Ejemplo simple de matriz 2x2
        // Casilla(valor, Norte, Este, Sur, Oeste)
        Casilla[][] tab = new Casilla[2][2];
        tab[0][0] = new Casilla(3, false, true, true, false);  // (0,0) va a Este y Sur
        tab[0][1] = new Casilla(1, false, false, true, true);  // (0,1) va a Sur y Oeste
        tab[1][0] = new Casilla(8, true, true, false, false);  // (1,0) va a Norte y Este
        tab[1][1] = new Casilla(2, true, false, false, true);  // (1,1) va a Norte y Oeste

        Ejercicio2Laberinto solver = new Ejercicio2Laberinto(tab);
        // Buscar camino desde (0,0) a (1,1)
        solver.buscarCaminoMinimo(0, 0, 1, 1);
    }
}
