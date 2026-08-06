package Ejercicios_clasicos_Greedy.Camino_Mas_Corto_BFS;

import java.util.*;

public class CaminoMasCortoBFS {

    /**
     * Encuentra el camino más corto entre 'origen' y 'destino' en un grafo no ponderado.
     *
     * @param grafo Lista de adyacencia (grafo.get(u) contiene los vecinos de u).
     * @param origen Nodo inicial.
     * @param destino Nodo final.
     * @return Lista con los nodos del camino ordenados de origen a destino, o null si no hay camino.
     */
    public static List<Integer> caminoMasCorto(List<List<Integer>> grafo, int origen, int destino) {
        int V = grafo.size();
        boolean[] visitados = new boolean[V];
        int[] padre = new int[V];
        Arrays.fill(padre, -1);

        Queue<Integer> cola = new LinkedList<>();

        // Inicializamos el recorrido en el nodo origen
        visitados[origen] = true;
        cola.add(origen);

        boolean alcanzado = false;

        // Bucle principal de BFS
        while (!cola.isEmpty()) {
            int actual = cola.poll();

            // Si llegamos al destino, detendremos la búsqueda
            if (actual == destino) {
                alcanzado = true;
                break;
            }

            // Exploramos todos los vecinos a distancia 1
            for (int vecino : grafo.get(actual)) {
                if (!visitados[vecino]) {
                    visitados[vecino] = true;
                    padre[vecino] = actual; // Guardamos la procedencia para reconstruir el camino
                    cola.add(vecino);
                }
            }
        }

        // Si la cola se vació sin encontrar el destino, no hay conexión
        if (!alcanzado) {
            return null;
        }

        // Reconstruimos la ruta desde 'destino' volviendo hacia 'origen' usando el arreglo 'padre'
        List<Integer> camino = new LinkedList<>();
        for (int at = destino; at != -1; at = padre[at]) {
            camino.add(0, at); // Insertamos siempre en la posición 0 para invertir el orden
        }

        return camino;
    }
}
