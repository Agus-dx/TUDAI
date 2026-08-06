package Ejercicios_clasicos_Greedy.Mochila_Fraccionaria;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Definimos la capacidad de la mochila
        double capacidadMochila = 50.0;

        // Creamos la lista de objetos disponibles (Nombre, Peso, Valor)
        List<MochilaFraccionaria.Objeto> objetos = new ArrayList<>();
        objetos.add(new MochilaFraccionaria.Objeto("Oro", 10.0, 60.0));     // Ratio = 6.0
        objetos.add(new MochilaFraccionaria.Objeto("Plata", 20.0, 100.0));  // Ratio = 5.0
        objetos.add(new MochilaFraccionaria.Objeto("Bronce", 30.0, 120.0)); // Ratio = 4.0

        System.out.println("Capacidad de la mochila: " + capacidadMochila + " kg\n");

        // Ejecutamos la solución
        double valorMaximo = MochilaFraccionaria.resolverMochila(objetos, capacidadMochila);

        System.out.println("\n==================================");
        System.out.printf("VALOR MÁXIMO OBTENIDO: %.2f\n", valorMaximo);
        System.out.println("==================================");
    }
}
