package com.lemonade.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lemonade.game.MainGame;
import com.lemonade.game.elementos.Fondo;
import com.lemonade.game.elementos.Texto;
import com.lemonade.game.entidades.Receta;
import com.lemonade.game.entidades.Recursos;

import java.util.ArrayList;

public class CargarScreen extends AbstractScreen {

    private Stage stage;

    private Fondo fondo;

    private Recursos recursos;

    public CargarScreen(MainGame game, AssetManager manager) {
        super(game, manager);
    }

    @Override
    public void show() {
        stage = new Stage();

        fondo = new Fondo((Texture) manager.get("fondo.png"));

        recursos = new Recursos(0,0,0,0,0,0,0,0,new Receta(2,1,2),false,false,false,false,false,false,false,false,"",0);

        stage.addActor(fondo);

        cargarArchivo();
    }

    private void cargarArchivo() {
        FileHandle file = Gdx.files.internal("Lemonade_Tree.txt");
        String cadena = file.readString();
        ArrayList<String> palabras = new ArrayList<String>();
        String palabra = "";

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                palabras.add(palabra.toLowerCase());
                palabra = "";
            } else {
                palabra += cadena.charAt(i);
                if(i == cadena.length()-1){
                    palabras.add(palabra);
                }
            }
        }

        Texto texto = new Texto("Transferencia realizada.", Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, Color.WHITE);

        recursos.setDinero(Float.parseFloat(palabras.get(0)));
        recursos.setLimones(Integer.parseInt(palabras.get(1)));
        recursos.setAzucar(Integer.parseInt(palabras.get(2)));
        recursos.setHielo(Integer.parseInt(palabras.get(3)));
        recursos.setVasos(Integer.parseInt(palabras.get(4)));
        recursos.setSombrilla(Boolean.parseBoolean(palabras.get(5)));
        recursos.setPayaso(Boolean.parseBoolean(palabras.get(6)));
        recursos.setCarritoLimon(Boolean.parseBoolean(palabras.get(7)));
        recursos.setDeudas(Float.parseFloat(palabras.get(8)));

        stage.addActor(texto);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 2, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.justTouched()) {
            MenuScreen menuScreen = new MenuScreen(game, manager, recursos);
            game.setScreen(menuScreen);
        }

        stage.draw();
    }

}
