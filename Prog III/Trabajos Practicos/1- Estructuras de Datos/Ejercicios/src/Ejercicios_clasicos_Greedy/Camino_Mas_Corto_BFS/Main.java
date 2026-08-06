package Ejercicios_clasicos_Greedy.Camino_Mas_Corto_BFS;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int V = 6; // Nodos del 0 al 5
        List<List<Integer>> grafo = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            grafo.add(new ArrayList<>());
        }

        /*
         *   (0) --- (1) --- (2) --- (5)   <- Camino corto (3 aristas)
         *    |               |
         *   (3) ----------- (4)           <- Camino alternativo (3 aristas 0-3-4-2-5 = 4 aristas)
         */
        agregarArista(grafo, 0, 1);
        agregarArista(grafo, 1, 2);
        agregarArista(grafo, 2, 5);
        agregarArista(grafo, 0, 3);
        agregarArista(grafo, 3, 4);
        agregarArista(grafo, 4, 2);

        int origen = 0;
        int destino = 5;

        List<Integer> resultado = CaminoMasCortoBFS.caminoMasCorto(grafo, origen, destino);

        if (resultado != null) {
            System.out.println("Camino más corto encontrado (" + (resultado.size() - 1) + " aristas):");
            System.out.println(resultado); // Imprime: [0, 1, 2, 5]
        } else {
            System.out.println("No existe camino entre " + origen + " y " + destino);
        }
    }

    private static void agregarArista(List<List<Integer>> grafo, int u, int v) {
        grafo.get(u).add(v);
        grafo.get(v).add(u); // No dirigido
    }
}
