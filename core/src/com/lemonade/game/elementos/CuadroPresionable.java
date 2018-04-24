package com.lemonade.game.elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class CuadroPresionable extends Actor {

    private Texture textura;

    private float yOriginal;

    private boolean estaAbajo;

    public CuadroPresionable(Texture textura, float x, float y, float width, float height){
        this.textura = textura;
        setBounds(x,y,width,height);

        yOriginal = y;
        estaAbajo = false;

        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(!estaAbajo){
                    setY(getY() - 50);
                    estaAbajo = true;
                } else{
                    subir();
                }
                return false;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textura, getX(), getY(), getWidth(), getHeight());
    }

    public void subir(){
        setY(yOriginal);
        estaAbajo = false;
    }

    public boolean estaAbajo(){
        return estaAbajo;
    }

    public Texture getTextura(){
        return textura;
    }

}