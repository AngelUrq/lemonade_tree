package com.lemonade.game.entidades;

public class Receta {

    private int limones;
    private int azucar;
    private int hielo;

    public Receta(int limones, int hielo, int azucar) {
        this.limones = limones;
        this.azucar = azucar;
        this.hielo = hielo;
    }

    public int getLimones() {
        return limones;
    }

    public void setLimones(int limones) {
        this.limones = limones;
    }

    public int getAzucar() {
        return azucar;
    }

    public void setAzucar(int azucar) {
        this.azucar = azucar;
    }

    public int getHielo() {
        return hielo;
    }

    public void setHielo(int hielo) {
        this.hielo = hielo;
    }

}
