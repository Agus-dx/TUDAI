package Ejercicios_clasicos_Greedy.Viajero;

import java.util.*;

public class ViajanteBacktracking {

    private static int mejorDistancia;
    private static List<Integer> mejorRuta;

    public static void resolverBacktracking(int[][] matrizDistancias, int origen) {
        int n = matrizDistancias.length;
        mejorDistancia = Integer.MAX_VALUE;
        mejorRuta = new ArrayList<>();

        boolean[] visitados = new boolean[n];
        List<Integer> rutaActual = new ArrayList<>();

        // Inicializamos desde el origen
        visitados[origen] = true;
        rutaActual.add(origen);

        backtrack(matrizDistancias, origen, origen, 1, 0, visitados, rutaActual);

        System.out.println("\n=== SOLUCIÓN ÓPTIMA (Backtracking) ===");
        System.out.println("Ruta óptima: " + mejorRuta);
        System.out.println("Distancia mínima exacta: " + mejorDistancia);
    }

    private static void backtrack(int[][] matriz, int origen, int actual, int nivel,
                                  int distanciaActual, boolean[] visitados, List<Integer> rutaActual) {
        int n = matriz.length;

        // PODA POR COTA: Si el costo actual ya iguala o supera al récord, cortamos esta rama
        if (distanciaActual >= mejorDistancia) {
            return;
        }

        // CASO BASE: Visitamos todas las ciudades, ahora volvemos al origen
        if (nivel == n) {
            int distanciaFinal = distanciaActual + matriz[actual][origen];

            if (distanciaFinal < mejorDistancia) {
                mejorDistancia = distanciaFinal;
                mejorRuta = new ArrayList<>(rutaActual);
                mejorRuta.add(origen); // Cierre del circuito
            }
            return;
        }

        // Exploración recursiva de todas las ciudades no visitadas
        for (int v = 0; v < n; v++) {
            if (!visitados[v]) {
                visitados[v] = true;
                rutaActual.add(v);

                backtrack(matriz, origen, v, nivel + 1,
                        distanciaActual + matriz[actual][v], visitados, rutaActual);

                // Backtrack (deshacer decisión)
                rutaActual.remove(rutaActual.size() - 1);
                visitados[v] = false;
            }
        }
    }
}