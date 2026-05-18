package TP_2_Recursividad_y_Ordenamiento.Ejercicio_2;

public class Ejercicio2 {

    /**
     * Búsqueda binaria recursiva en arreglo ordenado ascendentemente
     * @param A arreglo ordenado
     * @param clave elemento a buscar
     * @param inicio índice inicial
     * @param fin índice final
     * @return índice donde se encuentra el elemento, o -1 si no existe
     */
    public static int busquedaBinariaRecursiva(int[] A, int clave, int inicio, int fin) {
        if (inicio > fin) {
            return -1;                          // Caso base: no encontrado
        }

        int medio = inicio + (fin - inicio) / 2; // Evita overflow

        if (A[medio] == clave) {
            return medio;                       // Elemento encontrado
        } else if (A[medio] < clave) {
            return busquedaBinariaRecursiva(A, clave, medio + 1, fin);  // Buscar en mitad derecha
        } else {
            return busquedaBinariaRecursiva(A, clave, inicio, medio - 1); // Buscar en mitad izquierda
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78};

        System.out.println("Posición de 23: " + busquedaBinariaRecursiva(arr, 23, 0, arr.length - 1));
        System.out.println("Posición de 5: " + busquedaBinariaRecursiva(arr, 5, 0, arr.length - 1));
        System.out.println("Posición de 99: " + busquedaBinariaRecursiva(arr, 99, 0, arr.length - 1));
    }
}
