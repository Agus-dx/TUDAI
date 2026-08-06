package Ejercicios_clasicos_Greedy.Dijkstra;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int V = 6;
        List<List<Dijkstra.Arista>> grafo = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            grafo.add(new ArrayList<>());
        }

        /*
         *   Ruta 1 (Menos calles, pero más pesada):
         *   0 --- (Peso: 10) ---> 1 --- (Peso: 10) ---> 5    (Total = 20)
         *
         *   Ruta 2 (Más calles, pero más liviana):
         *   0 --- (Peso: 2) ---> 2 --- (Peso: 3) ---> 3 --- (Peso: 1) ---> 5   (Total = 6)
         */

        agregarArista(grafo, 0, 1, 10);
        agregarArista(grafo, 1, 5, 10);

        agregarArista(grafo, 0, 2, 2);
        agregarArista(grafo, 2, 3, 3);
        agregarArista(grafo, 3, 5, 1);

        int origen = 0;
        int destino = 5;

        System.out.println("Calculando el camino más corto con Dijkstra de " + origen + " a " + destino + "...\n");

        List<Integer> camino = Dijkstra.caminoMasCorto(grafo, origen, destino);

        if (camino != null) {
            System.out.println("Camino encontrado: " + camino);
        } else {
            System.out.println("No existe ruta entre " + origen + " y " + destino);
        }
    }

    private static void agregarArista(List<List<Dijkstra.Arista>> grafo, int u, int v, int peso) {
        grafo.get(u).add(new Dijkstra.Arista(v, peso));
        grafo.get(v).add(new Dijkstra.Arista(u, peso)); // No dirigido (bidireccional)
    }
}