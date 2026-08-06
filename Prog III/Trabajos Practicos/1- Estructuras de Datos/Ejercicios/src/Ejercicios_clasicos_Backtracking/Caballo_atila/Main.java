package Ejercicios_clasicos_Backtracking.Caballo_atila;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Matriz 4x4: 'true' indica casillas por donde pasó el caballo (sin pasto)
        // Dibujamos un circuito de 8 casillas pisadas formando un anillo externo
        boolean[][] jardin = {
                { true,  true,  true,  true  },
                { true,  false, false, true  },
                { true,  false, false, true  },
                { true,  true,  true,  true  }
        };

        /*
         *   Visualmente el jardín (T = pisado/sin pasto, F = con pasto):
         *   (0,0)T ── (0,1)T ── (0,2)T ── (0,3)T
         *     │                             │
         *   (1,0)T     (1,1)F    (1,2)F   (1,3)T
         *     │                             │
         *   (2,0)T     (2,1)F    (2,2)F   (2,3)T
         *     │                             │
         *   (3,0)T ── (3,1)T ── (3,2)T ── (3,3)T
         */

        List<CaballoAtila.Casilla> recorrido = CaballoAtila.obtenerRecorrido(jardin);

        if (recorrido != null && !recorrido.isEmpty()) {
            System.out.println("¡Recorrido cerrado encontrado!");
            System.out.println("Pasos del caballo: " + recorrido);
        } else {
            System.out.println("No fue posible deducir un recorrido cerrado válido.");
        }
    }
}
