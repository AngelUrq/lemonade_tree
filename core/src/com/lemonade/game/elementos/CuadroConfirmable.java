package com.lemonade.game.elementos;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Angel on 22/1/2018.
 */

public class CuadroConfirmable extends Actor {

    private Texture fondo;

    private Texto texto;

    private Boton botonSi;
    private Boton botonNo;

    public CuadroConfirmable(Texture fondo, Texture botonSi, Texture botonNo, float x, float y, float width, float height, String texto){
        this.fondo = fondo;
        this.setBounds(x,y,width,height);
        this.texto = new Texto(texto, x + width / 4, y + height / 4, width / 2, height / 2, Color.WHITE);
        this.botonSi = new Boton(botonSi,x + width / 5,y,width /4,height /4);
        this.botonNo = new Boton(botonNo,x + width / 2,y,width /4,height /4);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(fondo, getX(), getY(), getWidth(), getHeight());
        botonSi.draw(batch,parentAlpha);
        botonNo.draw(batch,parentAlpha);
        texto.draw(batch,parentAlpha);
    }

    public Texture getTextura(){
        return fondo;
    }

    public Boton getBotonSi() {
        return botonSi;
    }

    public Boton getBotonNo() {
        return botonNo;
    }

}