package com.lemonade.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.lemonade.game.MainGame;

//Esta clase sirve para crear nuevas Screen
public abstract class AbstractScreen implements Screen {

    
    protected MainGame game;
    protected AssetManager manager;

    public AbstractScreen(MainGame game, AssetManager manager) {
        this.game = game;
        this.manager = manager;
    }

    @Override
    public void show() {
        //Este método se ejecuta al mostrar el Screen
    }

    @Override
    public void render(float delta) {
        //Este  método se ejecuta 60 veces por segundo, delta es el tiempo
    }

    @Override
    public void resize(int width, int height) {
        //Este método se ejecuta al redimensionar la pantalla
    }

    @Override
    public void pause() {
        //Método que se ejecuta al pausar
    }

    @Override
    public void resume() {
        //Método que se ejecuta al quitar la pausa
    }

    @Override
    public void hide() {
        //Método que se ejecuta al esconder la pantalla
    }

    @Override
    public void dispose() {
        //Método para borrar los recursos que usamos
    }

}
