package TP_5_Backtracking.Ejercicio5;

import java.util.*;

public class Ejercicio5Procesadores {

    private int m; // Cantidad de procesadores
    private Integer[] tareas; // Tiempos de las tareas
    private int mejorMakespan = Integer.MAX_VALUE;
    private int[] mejorAsignacion; // Guarda a qué procesador fue cada tarea

    public Ejercicio5Procesadores(int m, Integer[] tareas) {
        this.m = m;
        this.tareas = tareas;
        this.mejorAsignacion = new int[tareas.length];
    }

    public void resolver() {
        // PODA OPTIMIZACIÓN: Ordenar tareas de MAYOR a MENOR (LPT)
        Arrays.sort(tareas, Collections.reverseOrder());

        int[] cargaProcesadores = new int[m];
        int[] asignacionActual = new int[tareas.length];

        backtracking(0, cargaProcesadores, asignacionActual);

        // Mostrar resultados
        System.out.println("--- RESULTADO EJERCICIO 5 ---");
        System.out.println("Procesadores: " + m);
        System.out.println("Tareas ordenadas: " + Arrays.toString(tareas));
        System.out.println("Mínimo tiempo total de ejecución (Makespan): " + mejorMakespan);

        System.out.println("\nDetalle de la mejor asignación:");
        int[] cargaFinal = new int[m];
        for (int i = 0; i < tareas.length; i++) {
            int proc = mejorAsignacion[i];
            cargaFinal[proc] += tareas[i];
            System.out.println(" - Tarea " + i + " (Tiempo: " + tareas[i] + ") -> Procesador " + proc);
        }
        System.out.println("Cargas finales por procesador: " + Arrays.toString(cargaFinal));
    }

    private void backtracking(int tareaIndex, int[] cargaProcesadores, int[] asignacionActual) {

        // CASO BASE: Asignamos todas las tareas
        if (tareaIndex == tareas.length) {
            // Calculamos el Makespan actual (el procesador con mayor carga)
            int maxCarga = 0;
            for (int carga : cargaProcesadores) {
                maxCarga = Math.max(maxCarga, carga);
            }

            if (maxCarga < mejorMakespan) {
                mejorMakespan = maxCarga;
                mejorAsignacion = asignacionActual.clone(); // Guardamos copia de la mejor solución
            }
            return;
        }

        int tiempoTarea = tareas[tareaIndex];

        // Probamos asignar la tarea actual a cada uno de los m procesadores
        for (int i = 0; i < m; i++) {

            // PODA 1 (Cota): Si asignarle la tarea a este procesador supera o iguala al mejor Makespan, no sirve
            if (cargaProcesadores[i] + tiempoTarea >= mejorMakespan) {
                continue;
            }

            // 1. Marcar (Asignar tarea al procesador i)
            cargaProcesadores[i] += tiempoTarea;
            asignacionActual[tareaIndex] = i;

            // 2. Recursión (Pasar a la siguiente tarea)
            backtracking(tareaIndex + 1, cargaProcesadores, asignacionActual);

            // 3. Desmarcar / Backtracking
            cargaProcesadores[i] -= tiempoTarea;

            // PODA 2 (Simetría): Si este procesador quedó vacío (0),
            // no tiene sentido probar los siguientes procesadores vacíos
            if (cargaProcesadores[i] == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int m = 3; // 3 procesadores
        Integer[] tareas = {7, 12, 5, 3, 9, 4, 8}; // Tiempos de las 7 tareas

        Ejercicio5Procesadores solver = new Ejercicio5Procesadores(m, tareas);
        solver.resolver();
    }
}
