package TP_1_Listas.Ejercicio_7;

/**
 * Nodo para lista doblemente vinculada.
 */
public class DoubleNode<T> {
    private T dato;
    private DoubleNode<T> siguiente;
    private DoubleNode<T> previo;

    public DoubleNode(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.previo = null;
    }

    // Getters y setters
    public T getDato() { return dato; }
    public void setDato(T dato) { this.dato = dato; }

    public DoubleNode<T> getSiguiente() { return siguiente; }
    public void setSiguiente(DoubleNode<T> siguiente) { this.siguiente = siguiente; }

    public DoubleNode<T> getPrevio() { return previo; }
    public void setPrevio(DoubleNode<T> previo) { this.previo = previo; }
}
