package Ejercicios_clasicos_Greedy.Mochila_Fraccionaria;

import java.util.*;

public class MochilaFraccionaria {

    public static class Objeto implements Comparable<Objeto> {
        String nombre;
        double peso;
        double valor;

        public Objeto(String nombre, double peso, double valor) {
            this.nombre = nombre;
            this.peso = peso;
            this.valor = valor;
        }

        // Calcula el valor por unidad de peso
        public double getRatio() {
            return valor / peso;
        }

        // Ordenamos de MAYOR a MENOR ratio (orden descendente)
        @Override
        public int compareTo(Objeto otro) {
            return Double.compare(otro.getRatio(), this.getRatio());
        }
    }

    /**
     * Resuelve el problema de la mochila fraccionaria.
     * @param objetos Lista de elementos disponibles.
     * @param capacidad Capacidad máxima de la mochila.
     * @return El valor total máximo obtenido.
     */
    public static double resolverMochila(List<Objeto> objetos, double capacidad) {
        // Step 1: Ordenar los objetos por ratio (valor/peso) descendente
        Collections.sort(objetos);

        double valorTotal = 0.0;
        double capacidadRestante = capacidad;

        System.out.println("--- Proceso de Selección Greedy ---");

        // Step 2: Iterar sobre los objetos ya ordenados
        for (Objeto obj : objetos) {
            if (capacidadRestante == 0) {
                break; // Mochila llena
            }

            if (obj.peso <= capacidadRestante) {
                // Caso A: El objeto entra completo
                capacidadRestante -= obj.peso;
                valorTotal += obj.valor;

                System.out.printf("Tomado entero: %-10s | Peso: %.2f | Valor ganado: %.2f\n",
                        obj.nombre, obj.peso, obj.valor);
            } else {
                // Caso B: Tomamos solo una FRACCIÓN del objeto
                double fraccion = capacidadRestante / obj.peso;
                double valorGanado = obj.valor * fraccion;

                valorTotal += valorGanado;

                System.out.printf("Tomado fraccionado (%.1f%%): %-10s | Peso usado: %.2f | Valor ganado: %.2f\n",
                        fraccion * 100, obj.nombre, capacidadRestante, valorGanado);

                capacidadRestante = 0; // La mochila se llena por completo
            }
        }

        return valorTotal;
    }
}
