package TP_1_Listas.Ejercicio_1;

public class SimpleLinkedList<T> {
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
}