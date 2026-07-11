package TP_2_Recursividad_y_Ordenamiento.Ejercicio_5;

public class Ejercicio5 {
//    Dado un arreglo ordenado de números distintos A se desea construir un algoritmo que
//    determine si alguno de los elementos de dicho arreglo contiene un valor igual a la posición en la
//    cuál se encuentra, es decir, A[i] = i

    // Método público principal
    public static int buscarPuntoFijo(int[] A) {
        return buscarPuntoFijoRecursivo(A, 0, A.length - 1);
    }

    // Método recursivo tipo búsqueda binaria
    private static int buscarPuntoFijoRecursivo(int[] A, int izquierda, int derecha) {
        // CASO BASE 1: Rango inválido, no se encontró ningún elemento A[i] == i
        if (izquierda > derecha) {
            return -1;
        }

        int medio = (izquierda + derecha) / 2;

        // CASO BASE 2: ¡Encontrado!
        if (A[medio] == medio) {
            return medio;
        }

        // CASOS RECURSIVOS
        if (A[medio] > medio) {
            // Descartamos la derecha, buscamos en la mitad izquierda
            return buscarPuntoFijoRecursivo(A, izquierda, medio - 1);
        } else {
            // Descartamos la izquierda, buscamos en la mitad derecha
            return buscarPuntoFijoRecursivo(A, medio + 1, derecha);
        }
    }

    public static void main(String[] args) {
        int[] arregloPrueba = {-3, -1, 0, 2, 4, 6, 10};
        int indiceEncontrado = buscarPuntoFijo(arregloPrueba);

        System.out.println("El índice donde A[i] == i es: " + indiceEncontrado);
    }
}
