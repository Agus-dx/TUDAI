package Ejercicios_clasicos_Greedy.Seleccion_Actividades;

import java.util.*;

public class SeleccionActividades {

    public static class Actividad implements Comparable<Actividad> {
        String nombre;
        int inicio; // s_i
        int fin;    // f_i

        public Actividad(String nombre, int inicio, int fin) {
            this.nombre = nombre;
            this.inicio = inicio;
            this.fin = fin;
        }

        // Criterio Greedy: Ordenamos por tiempo de FINALIZACIÓN ascendente
        @Override
        public int compareTo(Actividad otra) {
            return Integer.compare(this.fin, otra.fin);
        }

        @Override
        public String toString() {
            return String.format("%-15s [Inicio: %2d | Fin: %2d]", nombre, inicio, fin);
        }
    }

    /**
     * Selecciona el subconjunto compatible de actividades de tamaño máximo.
     * @param actividades Lista de actividades disponibles.
     * @return Lista con el subconjunto óptimo de actividades compatibles.
     */
    public static List<Actividad> seleccionarMaximasActividades(List<Actividad> actividades) {
        // Step 1: Ordenar actividades por tiempo de fin (f_i)
        Collections.sort(actividades);

        List<Actividad> seleccionadas = new ArrayList<>();

        if (actividades.isEmpty()) {
            return seleccionadas;
        }

        // Step 2: La primera actividad siempre forma parte del conjunto óptimo
        Actividad ultimaSeleccionada = actividades.get(0);
        seleccionadas.add(ultimaSeleccionada);

        // Step 3: Recorrer las demás y verificar que no se solapen
        for (int i = 1; i < actividades.size(); i++) {
            Actividad actual = actividades.get(i);

            // Una actividad es compatible si empieza cuando/después de que termina la anterior
            if (actual.inicio >= ultimaSeleccionada.fin) {
                seleccionadas.add(actual);
                ultimaSeleccionada = actual; // Actualizamos la referencia de fin
            }
        }

        return seleccionadas;
    }
}