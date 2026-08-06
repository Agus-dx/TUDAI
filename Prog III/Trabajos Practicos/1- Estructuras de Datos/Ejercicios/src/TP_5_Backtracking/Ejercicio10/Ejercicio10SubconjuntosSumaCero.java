package TP_5_Backtracking.Ejercicio10;

import java.util.*;

public class Ejercicio10SubconjuntosSumaCero {

    public static List<List<Integer>> subconjuntosSumaCero(int[] conjunto, int N) {
        Arrays.sort(conjunto); // Ordenar optimiza las podas
        List<List<Integer>> resultados = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();

        backtracking(conjunto, N, 0, 0, actual, resultados);
        return resultados;
    }

    private static void backtracking(int[] conjunto, int N, int indice, int sumaActual,
                                     List<Integer> actual, List<List<Integer>> resultados) {

        // CASO BASE: Alcanzamos el tamaño N
        if (actual.size() == N) {
            if (sumaActual == 0) {
                resultados.add(new ArrayList<>(actual));
            }
            return;
        }

        // PODA 1: Si los elementos restantes no alcanzan para completar el tamaño N
        int elementosFaltantes = N - actual.size();
        int elementosDisponibles = conjunto.length - indice;
        if (elementosDisponibles < elementosFaltantes) {
            return;
        }

        for (int i = indice; i < conjunto.length; i++) {

            // PODA 2: Si los elementos ya son positivos y la suma actual > 0, no podrá bajar a 0
            if (conjunto[i] > 0 && sumaActual > 0) {
                // Poda por sobrepaso al estar ordenado
                if (sumaActual + conjunto[i] > 0) {
                    break;
                }
            }

            // 1. Marcar
            actual.add(conjunto[i]);

            // 2. Recursión
            backtracking(conjunto, N, i + 1, sumaActual + conjunto[i], actual, resultados);

            // 3. Desmarcar
            actual.remove(actual.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] conjunto = {-7, -3, -2, -1, 5, 8};
        int N = 3;

        List<List<Integer>> solucion = subconjuntosSumaCero(conjunto, N);

        System.out.println("--- RESULTADO EJERCICIO 10 ---");
        System.out.println("Subconjuntos de tamaño " + N + " que suman cero:");
        for (List<Integer> sub : solucion) {
            System.out.println(sub);
        }
    }
}
