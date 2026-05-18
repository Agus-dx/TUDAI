package TP_1_Listas.Ejercicio_5;

import java.util.Iterator;

/**
 * Clase iterador para la lista simplemente vinculada.
 * Recorre los elementos de la lista desde la cabeza hasta el final.
 */
public class MyIterator<T> implements Iterator<T> {

    private Node<T> cursor;   // Puntero que avanza por la lista

    /**
     * Constructor del iterador.
     * Recibe el nodo inicial desde donde comenzará el recorrido.
     */
    public MyIterator(Node<T> cursor) {
        this.cursor = cursor;
    }

    /**
     * Indica si todavía quedan elementos por recorrer.
     * @return true si hay más elementos, false si ya llegó al final.
     */
    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    /**
     * Devuelve el elemento actual y avanza al siguiente nodo.
     * @return el dato del nodo actual
     * @throws java.util.NoSuchElementException si no hay más elementos
     */
    @Override
    public T next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException("No hay más elementos en la lista");
        }

        T info = cursor.getDato();        // Guardamos el dato actual
        cursor = cursor.getSiguiente();   // Avanzamos al siguiente nodo
        return info;
    }
}
