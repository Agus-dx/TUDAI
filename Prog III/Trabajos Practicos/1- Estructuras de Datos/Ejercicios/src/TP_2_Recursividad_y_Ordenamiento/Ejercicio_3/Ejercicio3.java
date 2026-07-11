package TP_2_Recursividad_y_Ordenamiento.Ejercicio_3;

public class Ejercicio3 {

    /**
     * Implemente un algoritmo recursivo que convierta un número en notación decimal a su
     * equivalente en notación binaria
     */
    public static String decimalABinario(int n) {
        // CASO BASE: Si el número es 0 o 1, su binario es el mismo en texto.
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }
        // CASO RECURSIVO:
        // En Java la división entre enteros (int) descarta los decimales automáticamente (hace el truncado).
        int cociente = n / 2;
        int resto = n % 2;

        // Llamada recursiva + el resto convertido a texto
        return decimalABinario(cociente) + String.valueOf(resto);
    }

    public static void main(String[] args) {

        System.out.println("23 a binario: " + decimalABinario(23));
    }
}
