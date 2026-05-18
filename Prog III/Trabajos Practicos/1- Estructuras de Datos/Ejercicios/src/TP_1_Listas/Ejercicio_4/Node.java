package TP_1_Listas.Ejercicio_4;

public class Node<T> {
    private T dato;
    private Node<T> siguiente;

    public Node(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Node<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Node<T> siguiente) {
        this.siguiente = siguiente;
    }
}
