package TP_5_Backtracking.Ejercicio2;

public class Casilla {
    private int valor;
    private boolean norte;
    private boolean este;
    private boolean sur;
    private boolean oeste;

    public Casilla(int valor, boolean norte, boolean este, boolean sur, boolean oeste) {
        this.valor = valor;
        this.norte = norte;
        this.este = este;
        this.sur = sur;
        this.oeste = oeste;
    }

    public int getValor() { return valor; }
    public boolean puedeNorte() { return norte; }
    public boolean puedeEste() { return este; }
    public boolean puedeSur() { return sur; }
    public boolean puedeOeste() { return oeste; }
}