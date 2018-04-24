package com.lemonade.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lemonade.game.MainGame;
import com.lemonade.game.elementos.Boton;
import com.lemonade.game.elementos.Fondo;
import com.lemonade.game.entidades.Receta;
import com.lemonade.game.entidades.Recursos;

public class FinanzasScreen extends AbstractScreen{

    private Stage stage;

    private Fondo fondo;

    private Boton receta, mejoras, finanzas, ingredientes;

    private Recursos recursos;

    public FinanzasScreen(MainGame game, AssetManager manager) {
        super(game, manager);
    }

    @Override
    public void show() {
        stage = new Stage();

        fondo = new Fondo((Texture) manager.get("fondo.png"));

        receta = new Boton((Texture) manager.get("boton-recetas.png"), 0, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 8);
        mejoras = new Boton((Texture) manager.get("boton-mejoras.png"), Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 8);
        finanzas = new Boton((Texture) manager.get("boton-finanzas.png"), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 8);
        ingredientes = new Boton((Texture) manager.get("boton-ingredientes.png"), Gdx.graphics.getWidth() * 0.75f, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 8);

        Gdx.input.setInputProcessor(stage);

        stage.addActor(fondo);
        stage.addActor(receta);
        stage.addActor(mejoras);
        stage.addActor(finanzas);
        stage.addActor(ingredientes);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 2, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        manejarEntrada();

        stage.act(delta);
        stage.draw();
    }

    private void manejarEntrada(){
        if(receta.haSidoPresionado()){
            RecetaScreen recetaScreen = new RecetaScreen(game,manager);
            recetaScreen.setRecursos(recursos);
            game.setScreen(recetaScreen);
            receta.setPresionado(false);
        }
        if(mejoras.haSidoPresionado()){
            MejorasScreen mejorasScreen = new MejorasScreen(game,manager);
            mejorasScreen.setRecursos(recursos);
            game.setScreen(mejorasScreen);
            mejoras.setPresionado(false);
        }
        if(ingredientes.haSidoPresionado()){
            IngredientesScreen ingredientesScreen = new IngredientesScreen(game,manager);
            ingredientesScreen.setRecursos(recursos);
            game.setScreen(ingredientesScreen);
            ingredientes.setPresionado(false);
        }
    }

    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

}
