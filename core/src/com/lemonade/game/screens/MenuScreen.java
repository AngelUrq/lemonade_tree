package com.lemonade.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lemonade.game.MainGame;
import com.lemonade.game.elementos.Boton;
import com.lemonade.game.elementos.Fondo;
import com.lemonade.game.entidades.Receta;
import com.lemonade.game.entidades.Recursos;

public class MenuScreen extends AbstractScreen {

    private Stage stage;

    private Fondo fondo;

    private Boton botonJugar;
    private Boton botonIniciarSesion;

    private Recursos recursos;

    public MenuScreen(MainGame game, AssetManager manager) {
        super(game, manager);

        //Los recursos iniciales para una nueva partida
        recursos = new Recursos(20, 1.5f,35, 0, 0, 0, 0, 0, new Receta(2, 1,2), false, false, false, false, false, false, false, false, "Suburbios",0);
    }

    public MenuScreen(MainGame game, AssetManager manager,Recursos recursos) {
        super(game, manager);
        this.recursos = recursos;
    }

    @Override
    public void show() {
        stage = new Stage();

        fondo = new Fondo((Texture) manager.get("fondo.png"));

        botonJugar = new Boton((Texture) manager.get("play.png"), Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 2, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 4);
        botonIniciarSesion = new Boton((Texture) manager.get("iniciarsesion.png"), Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 6, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 4);

        Gdx.input.setInputProcessor(stage);

        stage.addActor(fondo);
        stage.addActor(botonJugar);
        stage.addActor(botonIniciarSesion);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 2, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        manejarEntrada();

        stage.act(delta);
        stage.draw();
    }

    private void manejarEntrada() {
        if (botonJugar.haSidoPresionado()) {
            Music cancion = manager.get("opening.mp3");
            cancion.stop();

            RecetaScreen recetaScreen = new RecetaScreen(game, manager);
            recetaScreen.setRecursos(recursos);
            botonJugar.setPresionado(false);
            game.setScreen(recetaScreen);
        }
        if (botonIniciarSesion.haSidoPresionado()) {
            game.setScreen(new CargarScreen(game,manager));
            botonIniciarSesion.setPresionado(false);
        }
    }

    @Override
    public void dispose() {
        fondo.getTextura().dispose();
        botonIniciarSesion.getTextura().dispose();
        botonJugar.getTextura().dispose();
        stage.dispose();
        game.dispose();
        manager.dispose();
    }

}