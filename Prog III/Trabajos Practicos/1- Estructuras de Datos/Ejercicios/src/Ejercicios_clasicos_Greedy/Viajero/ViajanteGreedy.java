package Ejercicios_clasicos_Greedy.Viajero;

import java.util.*;

public class ViajanteGreedy {

    /**
     * Resuelve el TSP usando el enfoque Greedy (Vecino Más Cercano).
     * @param matrizDistancias Matriz N x N con las distancias entre ciudades.
     * @param origen Ciudad de inicio.
     * @return Lista con el recorrido y la distancia total en la posición final.
     */
    public static void resolverGreedy(int[][] matrizDistancias, int origen) {
        int n = matrizDistancias.length;
        boolean[] visitados = new boolean[n];
        List<Integer> ruta = new ArrayList<>();

        int actual = origen;
        visitados[actual] = true;
        ruta.add(actual);
        int distanciaTotal = 0;

        // Visitamos N-1 ciudades restantes
        for (int i = 0; i < n - 1; i++) {
            int vecinoMasCercano = -1;
            int menorDistancia = Integer.MAX_VALUE;

            // Buscamos la ciudad no visitada con menor distancia desde 'actual'
            for (int j = 0; j < n; j++) {
                if (!visitados[j] && matrizDistancias[actual][j] < menorDistancia) {
                    menorDistancia = matrizDistancias[actual][j];
                    vecinoMasCercano = j;
                }
            }

            // Nos desplazamos al vecino más cercano
            visitados[vecinoMasCercano] = true;
            ruta.add(vecinoMasCercano);
            distanciaTotal += menorDistancia;
            actual = vecinoMasCercano;
        }

        // Regresamos al punto de partida (cerrar el ciclo)
        distanciaTotal += matrizDistancias[actual][origen];
        ruta.add(origen);

        System.out.println("=== SOLUCIÓN GREEDY (Vecino Más Cercano) ===");
        System.out.println("Ruta: " + ruta);
        System.out.println("Distancia total: " + distanciaTotal);
    }
}