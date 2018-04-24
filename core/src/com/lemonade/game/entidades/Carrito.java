package com.lemonade.game.entidades;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Carrito extends Actor {

    private Texture texture;

    private Rectangle rectangulo;

    private float tiempoPreparacion;
    private float tiempoVentaLimonada;
    private float tiempo;

    private boolean prepararLimonada;
    private boolean limonadaLista;

    private boolean vendiendoLimonada;
    private boolean ventaRealizada;

    public Carrito(Texture texture, float x, float y, float width, float height){
        this.texture = texture;
        setBounds(x,y,width,height);
        //rectangulo = new Rectangle(x + width /4,y,width/16,height/16);
        rectangulo = new Rectangle(x + width /4,y,1,1);

        tiempoPreparacion = 3;
        tiempoVentaLimonada = 2;
        tiempo = 0;
        prepararLimonada = false;
        limonadaLista = false;
        vendiendoLimonada = false;
        ventaRealizada = false;
    }

    @Override
    public void act(float delta) {
        if(vendiendoLimonada){
            if(tiempo >= tiempoVentaLimonada){
                ventaRealizada = true;
                tiempo = 0;
            } else{
                tiempo += delta;
            }
        } else if(prepararLimonada){
            if(tiempo >= tiempoPreparacion){
                limonadaLista = true;
                tiempo = 0;
            } else{
                tiempo += delta;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        //batch.draw(new Texture("rectangulo.png"),rectangulo.getX(),rectangulo.getY(),rectangulo.getWidth(),rectangulo.getHeight());
    }

    public Texture getTexture() {
        return texture;
    }

    public boolean isPrepararLimonada() {
        return prepararLimonada;
    }

    public void setPrepararLimonada(boolean prepararLimonada) {
        this.prepararLimonada = prepararLimonada;
    }

    public boolean isLimonadaLista() {
        return limonadaLista;
    }

    public void setLimonadaLista(boolean limonadaLista) {
        this.limonadaLista = limonadaLista;
    }

    public Rectangle getRectangulo(){
        return rectangulo;
    }

    public boolean isVendiendoLimonada() {
        return vendiendoLimonada;
    }

    public void setVendiendoLimonada(boolean vendiendoLimonada) {
        this.vendiendoLimonada = vendiendoLimonada;
    }

    public boolean isVentaRealizada() {
        return ventaRealizada;
    }

    public void setVentaRealizada(boolean ventaRealizada) {
        this.ventaRealizada = ventaRealizada;
    }
}

