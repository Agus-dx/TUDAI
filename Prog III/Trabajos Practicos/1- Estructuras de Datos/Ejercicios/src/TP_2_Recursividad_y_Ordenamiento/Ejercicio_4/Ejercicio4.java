package TP_2_Recursividad_y_Ordenamiento.Ejercicio_4;

public class Ejercicio4 {

    /**
     * Fibonacci
     */
    // Método público que interactúa con el usuario
    public static void mostrarFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Por favor, ingrese un número mayor a 0.");
            return;
        }
        // Iniciamos la recursión: n términos, el primero es 0, el segundo es 1
        generarFibonacciRecursivo(n, 0, 1);
        System.out.println(); // Salto de línea al terminar
    }

    // Método auxiliar que hace la magia de forma recursiva
    private static void generarFibonacciRecursivo(int n, int a, int b) {
        // CASO BASE: Ya se mostraron los N términos solicitados
        if (n == 0) {
            return;
        }

        // Mostramos el término actual
        System.out.print(a + " ");

        // CASO RECURSIVO:
        // n - 1 -> Nos queda un término menos por mostrar
        // b     -> Pasa a ser el término actual en el siguiente paso
        // a + b -> Pasa a ser el término siguiente en el siguiente paso
        generarFibonacciRecursivo(n - 1, b, a + b);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Los primeros " + n + " términos de Fibonacci son:");
        mostrarFibonacci(n);
        // Debería imprimir exactamente: 0 1 1 2 3 5
    }
}
