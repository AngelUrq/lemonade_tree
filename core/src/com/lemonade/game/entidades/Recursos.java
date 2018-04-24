package com.lemonade.game.entidades;

public class Recursos {

    private float dinero;
    private float precioVasoLimonada;

    private int temperatura;

    private int limones, azucar, hielo, vasos, jarras;

    private Receta receta;

    private boolean exprimidora;
    private boolean sombrilla;
    private boolean maquinaHielo;
    private boolean cajero;
    private boolean payaso;
    private boolean carritoPrincipal;
    private boolean carritoSorpresa;
    private boolean carritoLimon;
    private String lugar;

    private float deudas;

    public Recursos(float dinero, float precioVasoLimonada, int temperatura, int limones, int azucar, int hielo, int vasos, int jarras, Receta receta, boolean exprimidora, boolean sombrilla, boolean maquinaHielo, boolean cajero, boolean payaso, boolean carritoPrincipal, boolean carritoSorpresa, boolean carritoLimon, String lugar, float deudas) {
        this.dinero = dinero;
        this.precioVasoLimonada = precioVasoLimonada;
        this.temperatura = temperatura;
        this.limones = limones;
        this.azucar = azucar;
        this.hielo = hielo;
        this.vasos = vasos;
        this.jarras = jarras;
        this.receta = receta;
        this.exprimidora = exprimidora;
        this.sombrilla = sombrilla;
        this.maquinaHielo = maquinaHielo;
        this.cajero = cajero;
        this.payaso = payaso;
        this.carritoPrincipal = carritoPrincipal;
        this.carritoSorpresa = carritoSorpresa;
        this.carritoLimon = carritoLimon;
        this.lugar = lugar;
        this.deudas = deudas;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public float getPrecioVasoLimonada() {
        return precioVasoLimonada;
    }

    public void setPrecioVasoLimonada(float precioVasoLimonada) {
        this.precioVasoLimonada = precioVasoLimonada;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
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

    public int getVasos() {
        return vasos;
    }

    public void setVasos(int vasos) {
        this.vasos = vasos;
    }

    public int getJarras() {
        return jarras;
    }

    public void setJarras(int jarras) {
        this.jarras = jarras;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public boolean isExprimidora() {
        return exprimidora;
    }

    public void setExprimidora(boolean exprimidora) {
        this.exprimidora = exprimidora;
    }

    public boolean isSombrilla() {
        return sombrilla;
    }

    public void setSombrilla(boolean sombrilla) {
        this.sombrilla = sombrilla;
    }

    public boolean isMaquinaHielo() {
        return maquinaHielo;
    }

    public void setMaquinaHielo(boolean maquinaHielo) {
        this.maquinaHielo = maquinaHielo;
    }

    public boolean isCajero() {
        return cajero;
    }

    public void setCajero(boolean cajero) {
        this.cajero = cajero;
    }

    public boolean isPayaso() {
        return payaso;
    }

    public void setPayaso(boolean payaso) {
        this.payaso = payaso;
    }

    public boolean isCarritoPrincipal() {
        return carritoPrincipal;
    }

    public void setCarritoPrincipal(boolean carritoPrincipal) {
        this.carritoPrincipal = carritoPrincipal;
    }

    public boolean isCarritoSorpresa() {
        return carritoSorpresa;
    }

    public void setCarritoSorpresa(boolean carritoSorpresa) {
        this.carritoSorpresa = carritoSorpresa;
    }

    public boolean isCarritoLimon() {
        return carritoLimon;
    }

    public void setCarritoLimon(boolean carritoLimon) {
        this.carritoLimon = carritoLimon;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public float getDeudas() {
        return deudas;
    }

    public void setDeudas(float deudas) {
        this.deudas = deudas;
    }
    
}
