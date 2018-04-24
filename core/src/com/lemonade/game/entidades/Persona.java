package com.lemonade.game.entidades;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.lemonade.game.elementos.Cuadro;

import java.util.ArrayList;

public class Persona extends Actor {

    private ArrayList<TextureRegion> texturas;
    private int cantidad;

    private Vector2 velocidad;
    private int direccion;

    private Rectangle rectangulo;

    private boolean haColisionado;

    private float tiempo;
    private float tiempoInicio;
    private float tiempoEnFila;

    private float dinero;

    private boolean sediento;

    private boolean haCompradoLimonada;
    private boolean estaComprandoLimonada;

    private boolean estaQuieto;

    public Persona(TextureRegion region, float x, float y, float width, float height, int direccion, Vector2 velocidad) {
        texturas = new ArrayList<TextureRegion>();
        cantidad = 4;
        setBounds(x, y, width, height);

        int frameWidth = region.getRegionWidth() / 4;
        for (int i = 0; i < 4; i++) {
            texturas.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }

        this.rectangulo = new Rectangle(x, y, width, height);
        this.direccion = direccion;
        this.haColisionado = false;
        this.tiempoInicio = Float.parseFloat(String.valueOf(Math.random() * 75));
        this.tiempo = 0;
        this.tiempoEnFila = 0;
        this.estaComprandoLimonada = false;
        this.haCompradoLimonada = false;
        this.dinero = Float.parseFloat(String.valueOf(Math.random() * 20));
        this.velocidad = velocidad;
        this.estaQuieto = false;

        if (Math.random() <= 0.60f) {
            this.sediento = true;
        } else {
            this.sediento = false;
        }
    }

    private void cambiarVelocidad() {
        switch (direccion) {
            case 0:
                velocidad.set(-Math.abs(velocidad.x), -Math.abs(velocidad.y));
                break;
            case 1:
                velocidad.set(Math.abs(velocidad.x), -Math.abs(velocidad.y));
                break;
            case 2:
                velocidad.set(-Math.abs(velocidad.x), Math.abs(velocidad.y));
                break;
            case 3:
                velocidad.set(Math.abs(velocidad.x), Math.abs(velocidad.y));
                break;
            default:
                break;
        }
    }

    @Override
    public void act(float delta) {
        //Tiempo de espera para caminar por las calles
        if (tiempo >= tiempoInicio && !estaQuieto) {
            setX(getX() + velocidad.x);
            setY(getY() + velocidad.y);
            rectangulo.setPosition(getX(),getY());
        } else {
            tiempo += delta;
        }

        //Tiempo de espera en fila
        if (estaQuieto) {
            if (tiempoEnFila >= 5) {
                if (Math.random() > 0.5) {
                    setDireccion(1);
                } else {
                    setDireccion(2);
                }
                setEstaQuieto(false);
                tiempoEnFila = 0;
            } else {
                tiempoEnFila += delta;
            }
        }
    }

    //private Texture bounds = new Texture("rectangulo.png");

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texturas.get(direccion), getX(), getY(), getWidth(), getHeight());
        //batch.draw(bounds,rectangulo.getX(),rectangulo.getY(),rectangulo.getWidth(),rectangulo.getHeight());
    }

    public Rectangle getRectangulo() {
        return rectangulo;
    }

    public Vector2 getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Vector2 velocidad) {
        this.velocidad = velocidad;
    }

    public void setHaColisionado(boolean haColisionado) {
        this.haColisionado = haColisionado;
    }

    public boolean haColisionado() {
        return haColisionado;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
        cambiarVelocidad();
    }

    public void setTiempoInicio(int tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getDireccion() {
        return direccion;
    }

    public boolean isSediento() {
        return sediento;
    }

    public float getDinero() {
        return dinero;
    }

    public void setHaCompradoLimonada(boolean haCompradoLimonada) {
        this.haCompradoLimonada = haCompradoLimonada;
    }

    public boolean getHaCompradoLimonada() {
        return haCompradoLimonada;
    }

    public boolean estaComprandoLimonada() {
        return estaComprandoLimonada;
    }

    public void setEstaComprandoLimonada(boolean estaComprandoLimonada) {
        this.estaComprandoLimonada = estaComprandoLimonada;
    }

    public void setSediento(boolean sediento) {
        this.sediento = sediento;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public ArrayList<TextureRegion> getTexturas() {
        return texturas;
    }

    public boolean estaQuieto() {
        return estaQuieto;
    }

    public void setEstaQuieto(boolean estaQuieto) {
        this.estaQuieto = estaQuieto;
    }

}
