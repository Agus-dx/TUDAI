package Ejercicios_clasicos_Greedy.Dijkstra;

import java.util.*;

public class Dijkstra {

    // Representa una arista/calle dirigida con peso hacia un destino
    public static class Arista {
        int destino;
        int peso;

        public Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    // Par auxiliar para la PriorityQueue (nodo y distancia acumulada)
    private static class ElementoQueue implements Comparable<ElementoQueue> {
        int nodo;
        int distancia;

        public ElementoQueue(int nodo, int distancia) {
            this.nodo = nodo;
            this.distancia = distancia;
        }

        @Override
        public int compareTo(ElementoQueue otro) {
            return Integer.compare(this.distancia, otro.distancia); // Min-Heap
        }
    }

    /**
     * Calcula el camino más corto en un grafo ponderado usando Dijkstra.
     *
     * @param grafo Lista de adyacencia de Aristas.
     * @param origen Nodo inicial.
     * @param destino Nodo final.
     * @return Lista con los nodos del camino óptimo, o null si no hay camino.
     */
    public static List<Integer> caminoMasCorto(List<List<Arista>> grafo, int origen, int destino) {
        int V = grafo.size();

        int[] distancias = new int[V];
        int[] padre = new int[V];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        Arrays.fill(padre, -1);

        // Cola de prioridad que siempre entrega el nodo con menor distancia
        PriorityQueue<ElementoQueue> pq = new PriorityQueue<>();

        // Inicializamos origen
        distancias[origen] = 0;
        pq.add(new ElementoQueue(origen, 0));

        while (!pq.isEmpty()) {
            ElementoQueue actual = pq.poll();
            int u = actual.nodo;
            int d = actual.distancia;

            // Si llegamos al destino, ya encontramos el camino mínimo
            if (u == destino) {
                break;
            }

            // Si encontramos una distancia desactualizada en la cola, la ignoramos
            if (d > distancias[u]) {
                continue;
            }

            // Evaluamos relajación para cada vecino
            for (Arista arista : grafo.get(u)) {
                int v = arista.destino;
                int peso = arista.peso;

                // Paso de Relajación: ¿Llegar a 'v' pasando por 'u' es más corto?
                if (distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                    padre[v] = u;
                    pq.add(new ElementoQueue(v, distancias[v]));
                }
            }
        }

        // Si la distancia sigue siendo INFINITO, no hay camino posible
        if (distancias[destino] == Integer.MAX_VALUE) {
            return null;
        }

        // Reconstruimos el camino hacia atrás desde el destino
        List<Integer> camino = new LinkedList<>();
        for (int at = destino; at != -1; at = padre[at]) {
            camino.add(0, at);
        }

        System.out.println("Costo/Distancia total más corta: " + distancias[destino]);
        return camino;
    }
}
