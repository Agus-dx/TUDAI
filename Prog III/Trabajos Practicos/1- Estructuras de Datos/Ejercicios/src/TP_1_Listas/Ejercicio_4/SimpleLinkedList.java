package TP_1_Listas.Ejercicio_4;

import java.util.Iterator;

public class SimpleLinkedList<T> implements Iterable<T>{
    private Node<T> cabeza;
    private int longitud;

    public SimpleLinkedList() {
        this.cabeza = null;
        this.longitud = 0;
    }

    // 1. Insertar al frente
    public void insertFront(T elem) {
        Node<T> nuevoNodo = new Node<>(elem);
        nuevoNodo.setSiguiente(cabeza);
        cabeza = nuevoNodo;
        longitud++;
    }

    // 2. Extraer del frente
    public T extractFront() {
        if (isEmpty()) {
            throw new RuntimeException("La lista está vacía");
        }
        T dato = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        longitud--;
        return dato;
    }

    // 3. ¿Está vacía?
    public boolean isEmpty() {
        return cabeza == null;
    }

    // 4. Tamaño de la lista
    public int size() {
        return longitud;
    }

    // 5. toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) {
                sb.append(", ");
            }
            actual = actual.getSiguiente();
        }
        sb.append("]");
        return sb.toString();
    }

    // 6. Método adicional: get(index) - índice comienza en 0
    public T get(int index) {
        if (index < 0 || index >= longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        Node<T> actual = cabeza;
        for (int i = 0; i < index; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    /**
     * Retorna el índice de la primera aparición del elemento,
     * o -1 si el elemento no se encuentra en la lista.
     */
    public int indexOf(T elem) {
        if (elem == null) {
            // Caso especial: buscamos null
            Node<T> actual = cabeza;
            int indice = 0;
            while (actual != null) {
                if (actual.getDato() == null) {
                    return indice;
                }
                actual = actual.getSiguiente();
                indice++;
            }
            return -1;
        }

        // Caso normal: elemento no null (usamos equals)
        Node<T> actual = cabeza;
        int indice = 0;
        while (actual != null) {
            if (elem.equals(actual.getDato())) {
                return indice;
            }
            actual = actual.getSiguiente();
            indice++;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this.cabeza);
    }

    //¿Existe alguna ventaja computacional al recorrer la lista de principio a fin usando el iterador?
    //No, no hay ventaja de complejidad.
    //Tanto con un while manual como con el for-each (iterador), el recorrido sigue siendo O(n).

    //La ventaja es de diseño y comodidad:
    //Código más limpio y legible.
    //Compatible con el for-each y otras estructuras de Java.
    //Menos probabilidad de errores al recorrer.

    // ====================== PATRÓN ITERATOR ======================

}