package TP_2_Recursividad_y_Ordenamiento.Ejercicio_7;

import java.util.Arrays;

public class MergeSort {

    public static void mergesort(int[] arreglo) {
        if (arreglo == null || arreglo.length < 2) {
            return;
        }
        mergesortRecursivo(arreglo, 0, arreglo.length - 1);
    }

    private static void mergesortRecursivo(int[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;

            mergesortRecursivo(arreglo, izquierda, medio);
            mergesortRecursivo(arreglo, medio + 1, derecha);

            fusionar(arreglo, izquierda, medio, derecha);
        }
    }

    private static void fusionar(int[] arreglo, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;

        int[] izqArray = new int[n1];
        int[] derArray = new int[n2];

        for (int i = 0; i < n1; ++i) izqArray[i] = arreglo[izquierda + i];
        for (int j = 0; j < n2; ++j) derArray[j] = arreglo[medio + 1 + j];

        int i = 0, j = 0;
        int k = izquierda;

        while (i < n1 && j < n2) {
            if (izqArray[i] <= derArray[j]) {
                arreglo[k] = izqArray[i];
                i++;
            } else {
                arreglo[k] = derArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arreglo[k] = izqArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arreglo[k] = derArray[j];
            j++;
            k++;
        }
    }

    // --- MÉTODO MAIN ---
    public static void main(String[] args) {
        int[] datos = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("--- Prueba de Mergesort ---");
        System.out.println("Antes del ordenamiento:  " + Arrays.toString(datos));
        mergesort(datos);
        System.out.println("Después del ordenamiento: " + Arrays.toString(datos));
    }
}