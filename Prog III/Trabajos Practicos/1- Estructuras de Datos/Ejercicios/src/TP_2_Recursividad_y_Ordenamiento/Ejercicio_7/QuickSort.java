package TP_2_Recursividad_y_Ordenamiento.Ejercicio_7;

import java.util.Arrays;

public class QuickSort {

    public static void quicksort(int[] arreglo) {
        if (arreglo == null || arreglo.length == 0) {
            return;
        }
        quicksortRecursivo(arreglo, 0, arreglo.length - 1);
    }

    private static void quicksortRecursivo(int[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indicePivote = particion(arreglo, izquierda, derecha);

            quicksortRecursivo(arreglo, izquierda, indicePivote - 1);
            quicksortRecursivo(arreglo, indicePivote + 1, derecha);
        }
    }

    private static int particion(int[] arreglo, int izquierda, int derecha) {
        int pivote = arreglo[derecha];
        int i = (izquierda - 1);

        for (int j = izquierda; j < derecha; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                int temporal = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temporal;
            }
        }

        int temporal = arreglo[i + 1];
        arreglo[i + 1] = arreglo[derecha];
        arreglo[derecha] = temporal;

        return i + 1;
    }

    // --- MÉTODO MAIN ---
    public static void main(String[] args) {
        int[] datos = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("--- Prueba de Quicksort ---");
        System.out.println("Antes del ordenamiento:  " + Arrays.toString(datos));
        quicksort(datos);
        System.out.println("Después del ordenamiento: " + Arrays.toString(datos));
    }
}
