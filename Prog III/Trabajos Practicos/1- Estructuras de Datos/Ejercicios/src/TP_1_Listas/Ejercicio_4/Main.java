package TP_1_Listas.Ejercicio_4;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        // Creamos una nueva lista simplemente vinculada de enteros
        SimpleLinkedList<Integer> lista = new SimpleLinkedList<>();

        // Insertamos elementos al principio de la lista (insertFront)
        lista.insertFront(12);
        lista.insertFront(25);
        lista.insertFront(3);
        lista.insertFront(4);
        lista.insertFront(52);

        // La lista ahora queda en este orden (de adelante hacia atrás):
        // 52 -> 4 -> 3 -> 25 -> 12

        System.out.println("Contenido de la lista: " + lista);

        // ====================== USO DEL ITERADOR ======================

        System.out.println("\n--- Recorrido usando Iterator manualmente ---");

        // Obtenemos un iterador de la lista
        Iterator<Integer> it = lista.iterator();

        // Recorremos la lista mientras haya elementos
        while (it.hasNext()) {
            Integer numero = it.next();     // Obtenemos el siguiente elemento
            System.out.println("Elemento: " + numero);
        }

        // ====================== USO DEL FOR-EACH ======================

        System.out.println("\n--- Recorrido usando for-each (más sencillo) ---");

        // Gracias a que SimpleLinkedList implementa Iterable,
        // podemos usar el for-each directamente
        for (Integer i : lista) {
            System.out.println("Elemento: " + i);
        }
    }
}
