package TP_5_Backtracking.Ejercicio4;

import java.util.*;

public class Ejercicio4ParticionConjunto {

    public static void resolverParticion(int[] conjunto) {
        int sumaTotal = 0;
        for (int num : conjunto) {
            sumaTotal += num;
        }

        System.out.println("--- RESULTADO EJERCICIO 4 ---");
        System.out.println("Conjunto original: " + Arrays.toString(conjunto));
        System.out.println("Suma total: " + sumaTotal);

        // PODA MATEMÁTICA 1: Si la suma total es impar, es imposible partirlo
        if (sumaTotal % 2 != 0) {
            System.out.println("Imposible dividir: La suma total es IMPAR.");
            return;
        }

        int objetivo = sumaTotal / 2;
        System.out.println("Objetivo de cada subconjunto: " + objetivo);

        // Ordenamos para optimizar la poda
        Arrays.sort(conjunto);

        List<Integer> subconjunto1 = new ArrayList<>();
        boolean existe = backtracking(conjunto, objetivo, conjunto.length - 1, 0, subconjunto1);

        if (existe) {
            System.out.println("¡Existe partición válida!");
            System.out.println("Subconjunto 1: " + subconjunto1);

            // Construimos el Subconjunto 2 con los elementos restantes
            List<Integer> subconjunto2 = new ArrayList<>();
            List<Integer> copiaS1 = new ArrayList<>(subconjunto1);
            for (int num : conjunto) {
                if (copiaS1.contains(num)) {
                    copiaS1.remove(Integer.valueOf(num)); // Sacamos una ocurrencia
                } else {
                    subconjunto2.add(num);
                }
            }
            System.out.println("Subconjunto 2: " + subconjunto2);
        } else {
            System.out.println("No existe ninguna partición en dos subconjuntos de igual suma.");
        }
    }

    private static boolean backtracking(int[] conjunto, int objetivo, int indice,
                                        int sumaActual, List<Integer> actual) {

        // CASO BASE 1: ¡Llegamos exactamente al objetivo!
        if (sumaActual == objetivo) {
            return true;
        }

        // CASO BASE 2 / PODA POR EXCESO: Si nos pasamos o nos quedamos sin elementos
        if (sumaActual > objetivo || indice < 0) {
            return false;
        }

        for (int i = indice; i >= 0; i--) {

            // PODA POR SOBREPASO: Si agregar el elemento actual supera el objetivo
            if (sumaActual + conjunto[i] > objetivo) {
                continue;
            }

            // 1. Marcar (Incluir elemento)
            actual.add(conjunto[i]);

            // 2. Recursión: Si encontramos la solución más adelante, retornamos true para cortar el árbol
            if (backtracking(conjunto, objetivo, i - 1, sumaActual + conjunto[i], actual)) {
                return true;
            }

            // 3. Desmarcar / Backtracking (Excluir elemento)
            actual.remove(actual.size() - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        // Ejemplo 1: Par, con partición posible (Suma = 22, Objetivo = 11)
        int[] conjunto1 = {1, 5, 11, 5};
        resolverParticion(conjunto1);
        // S1: [11], S2: [5, 5, 1] -> Ambas suman 11.

        System.out.println("\n------------------------------------\n");

        // Ejemplo 2: Par, pero sin partición posible (Suma = 14, Objetivo = 7)
        int[] conjunto2 = {1, 2, 3, 8};
        resolverParticion(conjunto2);
    }
}
