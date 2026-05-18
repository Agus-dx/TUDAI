package TP_1_Listas.Ejercicio_7;

import TP_1_Listas.Ejercicio_7.MyIterator;

import java.util.Iterator;

/**
 * Lista DOBLEMENTE vinculada (Ejercicio 7).
 * Cada nodo tiene puntero hacia adelante y hacia atrás.
 */
public class DoubleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private DoubleNode<T> cabeza;
    private DoubleNode<T> cola;     // ← nuevo: puntero al último nodo
    private int longitud;

    public DoubleLinkedList() {
        this.cabeza = null;
        this.cola = null;
        this.longitud = 0;
    }

    /**
     * Inserta al frente (O(1))
     */
    public void insertFront(T elem) {
        DoubleNode<T> nuevo = new DoubleNode<>(elem);
        nuevo.setSiguiente(cabeza);

        if (cabeza != null) {
            cabeza.setPrevio(nuevo);
        } else {
            cola = nuevo;               // si estaba vacía, cola también apunta al nuevo
        }

        cabeza = nuevo;
        longitud++;
    }

    /**
     * Extrae del frente (O(1))
     */
    public T extractFront() {
        if (isEmpty()) {
            throw new RuntimeException("La lista está vacía");
        }
        T dato = cabeza.getDato();

        cabeza = cabeza.getSiguiente();

        if (cabeza != null) {
            cabeza.setPrevio(null);
        } else {
            cola = null;                // lista quedó vacía
        }

        longitud--;
        return dato;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public int size() {
        return longitud;
    }

    // ... (podés copiar aquí get, indexOf, toString e iterator si los querés)

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this.cabeza);   // podés reutilizar o crear uno nuevo
    }

    // ====================== PREGUNTA DEL EJERCICIO ======================
    /**
     * ¿Podemos ahora revisar la implementación inicial y extenderla / bajar complejidad?
     *
     * RESPUESTA: SÍ
     *
     * Ventajas de la lista doblemente vinculada + cola:
     * - insertBack(T)     → ahora O(1)
     * - extractBack(T)    → ahora O(1)
     * - remove por índice → sigue O(n), pero más fácil si tuviéramos referencia al nodo
     * - recorrido hacia atrás (descendingIterator) → posible en O(n)
     * - La implementación original (SimpleLinkedList) solo permitía O(1) en el frente.
     *
     * Conclusión: La versión doblemente vinculada es mucho más versátil y permite
     * bajar la complejidad de operaciones en ambos extremos de la lista.
     */
}