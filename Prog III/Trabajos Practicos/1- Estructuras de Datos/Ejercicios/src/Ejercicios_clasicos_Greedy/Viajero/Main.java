package Ejercicios_clasicos_Greedy.Viajero;

public class Main {

    public static void main(String[] args) {
        // Matriz de distancias entre 4 ciudades (0, 1, 2, 3)
        // Ejemplo donde Greedy falla en dar el óptimo global:
        int[][] matrizDistancias = {
                { 0, 10, 15, 20 },
                { 10, 0, 35, 25 },
                { 15, 35, 0, 30 },
                { 20, 25, 30, 0 }
        };

        int origen = 0;

        // 1. Ejecutamos Greedy
        ViajanteGreedy.resolverGreedy(matrizDistancias, origen);

        // 2. Ejecutamos Backtracking
        ViajanteBacktracking.resolverBacktracking(matrizDistancias, origen);
    }
}
