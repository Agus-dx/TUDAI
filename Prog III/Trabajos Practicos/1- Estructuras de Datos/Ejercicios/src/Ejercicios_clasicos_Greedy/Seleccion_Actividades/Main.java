package Ejercicios_clasicos_Greedy.Seleccion_Actividades;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<SeleccionActividades.Actividad> expo = new ArrayList<>();

        // Agregamos actividades desordenadas
        expo.add(new SeleccionActividades.Actividad("Charla IA", 1, 4));
        expo.add(new SeleccionActividades.Actividad("Taller Robotics", 3, 5));
        expo.add(new SeleccionActividades.Actividad("Demo Gaming", 0, 6));
        expo.add(new SeleccionActividades.Actividad("Keynote Cloud", 5, 7));
        expo.add(new SeleccionActividades.Actividad("Panel VR", 3, 9));
        expo.add(new SeleccionActividades.Actividad("Workshop DevOps", 5, 9));
        expo.add(new SeleccionActividades.Actividad("Show Final", 6, 10));
        expo.add(new SeleccionActividades.Actividad("Mesa Redonda", 8, 11));
        expo.add(new SeleccionActividades.Actividad("Cierre Expo", 8, 12));
        expo.add(new SeleccionActividades.Actividad("After Party", 2, 14));
        expo.add(new SeleccionActividades.Actividad("Networking", 12, 16));

        System.out.println("=== SELECCIÓN DE ACTIVIDADES EN LA EXPOSICIÓN ===\n");

        List<SeleccionActividades.Actividad> resultado =
                SeleccionActividades.seleccionarMaximasActividades(expo);

        System.out.println("Cantidad máxima de actividades compatibles: " + resultado.size() + "\n");
        System.out.println("Cronograma seleccionado:");
        for (SeleccionActividades.Actividad act : resultado) {
            System.out.println(" - " + act);
        }
    }
}
