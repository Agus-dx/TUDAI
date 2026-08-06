package TP_5_Backtracking.Ejercicio1;

import java.util.*;

public class Ejercicio1Salas {

    // Representación del Grafo con Lista de Adyacencia
    private Map<Integer, List<Integer>> grafo = new HashMap<>();
    private List<Integer> mejorCamino = new ArrayList<>();

    // Método principal para agregar puertas (aristas dirigidas)
    public void agregarPuerta(int origen, int destino) {
        grafo.computeIfAbsent(origen, k -> new ArrayList<>()).add(destino);
        grafo.computeIfAbsent(destino, k -> new ArrayList<>()); // Asegura que el nodo exista
    }

    // Método público
    public List<Integer> caminoMasLargo(int entrada, int salida) {
        mejorCamino.clear();
        Set<Integer> visitados = new HashSet<>();
        List<Integer> caminoActual = new ArrayList<>();

        // Inicializamos la búsqueda desde la entrada
        visitados.add(entrada);
        caminoActual.add(entrada);

        backtracking(entrada, salida, visitados, caminoActual);

        return mejorCamino;
    }

    // Algoritmo de Backtracking
    private void backtracking(int actual, int destino, Set<Integer> visitados, List<Integer> caminoActual) {
        // Caso Base: Llegamos a la salida
        if (actual == destino) {
            // Si el camino encontrado supera en longitud al mejor guardado hasta el momento
            if (caminoActual.size() > mejorCamino.size()) {
                mejorCamino = new ArrayList<>(caminoActual);
            }
            return;
        }

        // Explorar los vecinos (puertas salientes)
        List<Integer> vecinos = grafo.getOrDefault(actual, Collections.emptyList());
        for (int vecino : vecinos) {
            if (!visitados.contains(vecino)) {
                // 1. Marcar / Hacé la opción
                visitados.add(vecino);
                caminoActual.add(vecino);

                // 2. Recursión
                backtracking(vecino, destino, visitados, caminoActual);

                // 3. Backtracking / Desmarcar la opción
                caminoActual.remove(caminoActual.size() - 1);
                visitados.remove(vecino);
            }
        }
    }

    // Main para testing
    public static void main(String[] args) {
        Ejercicio1Salas laberinto = new Ejercicio1Salas();

        // Armamos el mapa de salas y puertas (Grafo Dirigido)
        // 0 (Entrada) -> 1, 2
        // 1 -> 3
        // 2 -> 1, 3
        // 3 -> 4 (Salida)
        laberinto.agregarPuerta(0, 1);
        laberinto.agregarPuerta(0, 2);
        laberinto.agregarPuerta(2, 1);
        laberinto.agregarPuerta(1, 3);
        laberinto.agregarPuerta(2, 3);
        laberinto.agregarPuerta(3, 4);

        int entrada = 0;
        int salida = 4;

        List<Integer> resultado = laberinto.caminoMasLargo(entrada, salida);

        System.out.println("--- RESULTADO EJERCICIO 1 ---");
        System.out.println("Camino que atraviesa la MÁXIMA cantidad de salas: " + resultado);
        System.out.println("Cantidad de salas atravesadas: " + resultado.size());
        // El camino máximo debería ser: [0, 2, 1, 3, 4] (5 salas)
    }
}
