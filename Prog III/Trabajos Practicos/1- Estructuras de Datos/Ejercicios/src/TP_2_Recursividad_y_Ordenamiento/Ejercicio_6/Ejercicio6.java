package TP_2_Recursividad_y_Ordenamiento.Ejercicio_6;

import java.util.Arrays;

public class Ejercicio6 {
    // --- 1. ORDENAMIENTO POR SELECCIÓN ---
    public static void ordenamientoSeleccion(int[] arreglo) {
        int n = arreglo.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            // Buscamos el elemento más chico en el resto desordenado
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            // Intercambio
            int temporal = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = temporal;
        }
    }

    // --- 2. ORDENAMIENTO POR BURBUJEO ---
    public static void ordenamientoBurbujeo(int[] arreglo) {
        int n = arreglo.length;
        boolean intercambiado;

        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambio
                    int temporal = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temporal;
                    intercambiado = true;
                }
            }

            // Si no hubo cambios en toda la pasada, ya está ordenado
            if (!intercambiado) {
                break;
            }
        }
    }

    // --- MÉTODO MAIN PARA PRUEBAS ---
    public static void main(String[] args) {
        // Creamos dos arreglos desordenados idénticos para probar ambos algoritmos
        int[] datosParaSeleccion = {64, 34, 25, 12, 22, 11, 90};
        int[] datosParaBurbujeo = {15, 34, 25, 12, 22, 11, 90};

        System.out.println("--- Prueba de Ordenamiento por Selección ---");
        System.out.println("Antes: " + Arrays.toString(datosParaSeleccion));
        ordenamientoSeleccion(datosParaSeleccion);
        System.out.println("Después: " + Arrays.toString(datosParaSeleccion));

        System.out.println("\n--- Prueba de Ordenamiento por Burbujeo ---");
        System.out.println("Antes: " + Arrays.toString(datosParaBurbujeo));
        ordenamientoBurbujeo(datosParaBurbujeo);
        System.out.println("Después: " + Arrays.toString(datosParaBurbujeo));
    }
}
