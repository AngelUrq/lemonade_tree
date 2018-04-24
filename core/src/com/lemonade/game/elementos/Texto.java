package com.lemonade.game.elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;


public class Texto extends Label {

    public Texto(String texto, float x, float y, float width, float height, Color color) {
        super(texto, new Label.LabelStyle(new BitmapFont(), color));
        setFontScale(Gdx.graphics.getHeight() / 360);
        setWrap(true);
        setSize(width, height);
        setPosition(x , y);
    }

}
