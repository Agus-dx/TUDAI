package TP_1_Listas.Ejercicio_6;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== PRUEBA EJERCICIO 6 - DIFERENCIA ===\n");

        // ====================== LISTAS DE PRUEBA ======================

        // Lista 1 (la que usaremos como base)
        SimpleLinkedList<Integer> lista1 = new SimpleLinkedList<>();
        lista1.insertFront(10);
        lista1.insertFront(5);
        lista1.insertFront(20);
        lista1.insertFront(15);
        lista1.insertFront(8);
        lista1.insertFront(25);
        System.out.println("Lista 1: " + lista1);

        // Lista 2 (los elementos que vamos a "restar")
        SimpleLinkedList<Integer> lista2 = new SimpleLinkedList<>();
        lista2.insertFront(8);
        lista2.insertFront(25);
        lista2.insertFront(5);
        lista2.insertFront(30);
        lista2.insertFront(15);
        System.out.println("Lista 2: " + lista2);

        // ====================== PRUEBA DIFERENCIA ======================
        System.out.println("\n--- Elementos que están en Lista1 pero NO en Lista2 ---");

        SimpleLinkedList<Integer> diferencia =
                SimpleLinkedList.diferencia(lista1, lista2);

        System.out.println("Resultado diferencia: " + diferencia);

        // ====================== PRUEBA EXTRA (para comparar) ======================
        System.out.println("\n--- Comparación con intersección (Ejercicio 5) ---");

        SimpleLinkedList<Integer> comunes =
                SimpleLinkedList.interseccionDesordenada(lista1, lista2);

        System.out.println("Intersección (elementos comunes): " + comunes);
    }
}
