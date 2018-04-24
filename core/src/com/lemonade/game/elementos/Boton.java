package com.lemonade.game.elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Boton extends Actor {

    private Texture textura;

    private float yOriginal;
    private float pixelesAbajo;

    private boolean presionado;

    public Boton(Texture textura, float x, float y, float width, float height) {
        this.textura = textura;
        this.setBounds(x, y, width, height);
        this.yOriginal = y;
        this.pixelesAbajo = 10;
        this.presionado = false;

        iniciarEscuchador();
    }

    private void iniciarEscuchador(){
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                setY(getY() - pixelesAbajo);
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                setY(yOriginal);
                presionado = true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textura, getX(), getY(), getWidth(), getHeight());
    }

    public void setPresionado(boolean presionado){
        this.presionado = presionado;
    }

    public boolean haSidoPresionado(){
        return presionado;
    }

    public Texture getTextura(){
        return textura;
    }

}
