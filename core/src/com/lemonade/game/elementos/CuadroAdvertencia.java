package com.lemonade.game.elementos;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by Angel on 22/1/2018.
 */

public class CuadroAdvertencia extends Actor {

    private Texture fondo;

    private Texto texto;

    private boolean haSidoPresionado;
    private boolean haSidoDibujado;

    public CuadroAdvertencia(Texture fondo, float x, float y, float width, float height, String texto) {
        this.fondo = fondo;
        this.setBounds(x, y, width, height);
        this.texto = new Texto(texto, x + width / 4, y + height / 4, width / 2, height / 2, Color.WHITE);
        this.haSidoPresionado = false;
        this.haSidoDibujado = false;

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                haSidoPresionado = true;
                return false;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(fondo, getX(), getY(), getWidth(), getHeight());
        texto.draw(batch, parentAlpha);
    }

    public Texture getTextura() {
        return fondo;
    }

    public boolean haSidoPresionado() {
        return haSidoPresionado;
    }

    public boolean haSidoDibujado(){return haSidoDibujado;}

    public void setSidoDibujado(boolean dibujado){
        this.haSidoDibujado = dibujado;
    }

    public void setHaSidoPresionado(boolean haSidoPresionado) {
        this.haSidoPresionado = haSidoPresionado;
    }

    public void setTexto(String texto) {
        this.texto.setText(texto);
    }
}