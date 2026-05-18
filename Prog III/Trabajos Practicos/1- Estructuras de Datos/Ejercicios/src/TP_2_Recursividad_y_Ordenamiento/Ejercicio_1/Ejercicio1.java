package TP_2_Recursividad_y_Ordenamiento.Ejercicio_1;

public class Ejercicio1 {

    // Función recursiva que verifica si el arreglo está ordenado ascendentemente
    public static boolean estaOrdenado(int[] A, int i) {
        if (i == A.length - 1) {
            return true;                    // Caso base: llegamos al último elemento
        }
        if (A[i] > A[i + 1]) {
            return false;                   // No está ordenado
        }
        return estaOrdenado(A, i + 1);      // Avanzamos recursivamente
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {1, 3, 2, 7, 9};

        System.out.println("Arreglo 1 ordenado? " + estaOrdenado(arr1, 0));
        System.out.println("Arreglo 2 ordenado? " + estaOrdenado(arr2, 0));
    }

//    Respuestas:
//
//    Complejidad en el peor caso: O(N)
//    Problema de hacerlo recursivo: Puede causar StackOverflowError si el arreglo es muy grande (profundidad de recursión = N).
//    Si fuera una lista (LinkedList): El acceso por índice sería O(N), lo que empeoraría la eficiencia. Mejor usar un iterador o puntero recursivo sobre los nodos.
}
