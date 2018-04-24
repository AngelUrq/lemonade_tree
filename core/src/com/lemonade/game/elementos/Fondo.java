package com.lemonade.game.elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Fondo extends Actor {

    private Texture textura;

    public Fondo(Texture textura) {
        this.textura = textura;
        this.setBounds(0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textura, getX(), getY(), getWidth(), getHeight());
    }

    public Texture getTextura(){
        return textura;
    }

}
