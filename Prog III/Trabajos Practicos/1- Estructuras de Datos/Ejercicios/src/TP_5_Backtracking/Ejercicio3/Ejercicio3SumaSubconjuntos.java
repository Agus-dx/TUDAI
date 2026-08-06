package TP_5_Backtracking.Ejercicio3;

import java.util.*;

public class Ejercicio3SumaSubconjuntos {

    public static void buscarSubconjuntos(int[] conjunto, int M) {
        // Ordenamos para poder aplicar la poda de forma más agresiva
        Arrays.sort(conjunto);

        List<List<Integer>> soluciones = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();

        backtracking(conjunto, M, 0, 0, actual, soluciones);

        // Imprimir resultados
        System.out.println("--- RESULTADO EJERCICIO 3 (Suma = " + M + ") ---");
        if (soluciones.isEmpty()) {
            System.out.println("No se encontraron subconjuntos que sumen " + M);
        } else {
            System.out.println("Subconjuntos encontrados (" + soluciones.size() + "):");
            for (List<Integer> subconjunto : soluciones) {
                System.out.println(subconjunto);
            }
        }
    }

    private static void backtracking(int[] conjunto, int M, int indice, int sumaActual,
                                     List<Integer> actual, List<List<Integer>> soluciones) {

        // CASO BASE 1: ¡Encontramos un subconjunto válido!
        if (sumaActual == M) {
            soluciones.add(new ArrayList<>(actual)); // Guardamos copia
            return;
        }

        // Explorar opciones desde el 'indice' actual en adelante
        for (int i = indice; i < conjunto.length; i++) {

            // PODA HÁBIL: Si el elemento i supera lo que falta para llegar a M,
            // como el arreglo está ordenado, los elementos siguientes también superarán M.
            if (sumaActual + conjunto[i] > M) {
                break; // Cortamos todas las llamadas restantes de este nivel
            }

            // 1. Incluir el elemento (Marcar)
            actual.add(conjunto[i]);

            // 2. Recursión (Pasamos i + 1 para avanzar en el arreglo)
            backtracking(conjunto, M, i + 1, sumaActual + conjunto[i], actual, soluciones);

            // 3. Excluir el elemento (Desmarcar / Backtracking)
            actual.remove(actual.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] conjunto = {10, 7, 5, 18, 12, 20, 15};
        int M = 35;

        buscarSubconjuntos(conjunto, M);
        // Debería encontrar combinaciones como:
        // [10, 7, 18] -> 35
        // [20, 15] -> 35
        // [10, 5, 20] -> 35
        // [8, 12, 15] -> (si estuvieran esos números)
    }
}