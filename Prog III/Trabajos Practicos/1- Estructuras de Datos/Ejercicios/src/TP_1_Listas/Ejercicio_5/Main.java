package TP_1_Listas.Ejercicio_5;

public class Main {

        public static void main(String[] args) {

            System.out.println("=== PRUEBA EJERCICIO 5 - INTERSECCIÓN ===\n");

            // ====================== LISTAS DE PRUEBA ======================

            // Lista 1
            SimpleLinkedList<Integer> lista1 = new SimpleLinkedList<>();
            lista1.insertFront(10);
            lista1.insertFront(5);
            lista1.insertFront(20);
            lista1.insertFront(15);
            lista1.insertFront(8);
            System.out.println("Lista 1: " + lista1);

            // Lista 2
            SimpleLinkedList<Integer> lista2 = new SimpleLinkedList<>();
            lista2.insertFront(8);
            lista2.insertFront(25);
            lista2.insertFront(5);
            lista2.insertFront(30);
            lista2.insertFront(15);
            System.out.println("Lista 2: " + lista2);

            // Lista ordenada 1
            SimpleLinkedList<Integer> listaOrdenada1 = new SimpleLinkedList<>();
            listaOrdenada1.insertFront(500);
            listaOrdenada1.insertFront(100);
            listaOrdenada1.insertFront(20);
            listaOrdenada1.insertFront(15);
            listaOrdenada1.insertFront(10);
            System.out.println("Lista ord 1: " + listaOrdenada1);

            // Lista ordenada 2
            SimpleLinkedList<Integer> listaOrdenada2 = new SimpleLinkedList<>();
            listaOrdenada2.insertFront(800);
            listaOrdenada2.insertFront(100);
            listaOrdenada2.insertFront(15);
            listaOrdenada2.insertFront(10);
            listaOrdenada2.insertFront(5);
            System.out.println("Lista ord 2: " + listaOrdenada2);

            // ====================== PRUEBA PARTE a) ======================
            System.out.println("\n--- a) Listas DESORDENADAS → resultado ORDENADO ---");
            SimpleLinkedList<Integer> comunesDesordenadas =
                    SimpleLinkedList.interseccionDesordenada(lista1, lista2);

            System.out.println("Elementos comunes (ordenados): " + comunesDesordenadas);

            // ====================== PRUEBA PARTE b) ======================
            System.out.println("\n--- b) Listas ORDENADAS → resultado ORDENADO ---");

            System.out.println("Lista 1 ordenada: " + listaOrdenada1);
            System.out.println("Lista 2 ordenada: " + listaOrdenada2);

            SimpleLinkedList<Integer> comunesOrdenadas =
                    SimpleLinkedList.interseccionOrdenada(listaOrdenada1, listaOrdenada2);

            System.out.println("Elementos comunes (manteniendo orden): " + comunesOrdenadas);
        }
}
