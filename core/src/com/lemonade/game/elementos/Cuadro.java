package com.lemonade.game.elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Cuadro extends Actor{

    private Texture textura;

    public Cuadro(Texture textura, float x, float y, float width, float height){
        this.textura = textura;
        setBounds(x,y,width,height);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textura, getX(), getY(), getWidth(), getHeight());
    }

    public Texture getTextura(){
        return textura;
    }

}
