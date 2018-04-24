package com.lemonade.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lemonade.game.MainGame;
import com.lemonade.game.elementos.Boton;
import com.lemonade.game.elementos.Cuadro;
import com.lemonade.game.elementos.Fondo;
import com.lemonade.game.elementos.Texto;
import com.lemonade.game.entidades.Receta;
import com.lemonade.game.entidades.Recursos;

public class RecetaScreen extends AbstractScreen {

    private Stage stage;

    private Fondo fondo;

    private Texto titulo;

    private Texto textoCantidadLimones, textoCantidadHielos, textoCantidadAzucar;

    private Texto descripcion;

    private int cantidadLimones, cantidadAzucar, cantidadHielo;

    private Boton receta, mejoras, finanzas, ingredientes;

    private Boton sumarLimones, restarLimones;
    private Boton sumarAzucar, restarAzucar;
    private Boton sumarHielo, restarHielo;

    private Cuadro limon, azucar, hielo, cuadro1, cuadro2, cuadro3, jarra;

    private Recursos recursos;

    private Music musica;

    public RecetaScreen(MainGame game, AssetManager manager) {
        super(game, manager);
    }

    @Override
    public void show() {
        stage = new Stage();

        fondo = new Fondo((Texture) manager.get("fondo.png"));

        titulo = new Texto("Receta", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 1.45f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 4, Color.WHITE);
        descripcion = new Texto("Los ingredientes de una jarra de limonada, que alcanza para 5 vasos. Intenta no hacerla ni tan dulce ni tan agria y poner suficiente hielo los días calurosos.", Gdx.graphics.getWidth() /8, Gdx.graphics.getHeight() *0.0025f, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 6, Color.WHITE);

        receta = new Boton((Texture) manager.get("boton-recetas.png"), 0, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 8);
        mejoras = new Boton((Texture) manager.get("boton-mejoras.png"), Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 8);
        finanzas = new Boton((Texture) manager.get("boton-finanzas.png"), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 8);
        ingredientes = new Boton((Texture) manager.get("boton-ingredientes.png"), Gdx.graphics.getWidth() * 0.75f, Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 8, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 8);

        sumarLimones = new Boton((Texture) manager.get("signo-mas.png"), Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 1.7f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        sumarHielo = new Boton((Texture) manager.get("signo-mas.png"), Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 2.5f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        sumarAzucar = new Boton((Texture) manager.get("signo-mas.png"), Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() / 4.9f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);

        restarLimones = new Boton((Texture) manager.get("signo-menos.png"), Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 1.7f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        restarHielo = new Boton((Texture) manager.get("signo-menos.png"), Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 2.5f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        restarAzucar = new Boton((Texture) manager.get("signo-menos.png"), Gdx.graphics.getWidth() / 8, Gdx.graphics.getHeight() / 4.9f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);

        limon = new Cuadro((Texture) manager.get("limon.png"), Gdx.graphics.getWidth() / 4.3f, Gdx.graphics.getHeight() / 1.7f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        hielo = new Cuadro((Texture) manager.get("hielo.png"), Gdx.graphics.getWidth() / 4.3f, Gdx.graphics.getHeight() / 2.5f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        azucar = new Cuadro((Texture) manager.get("azucar.png"), Gdx.graphics.getWidth() / 4.3f, Gdx.graphics.getHeight() / 4.9f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);

        cuadro1 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() / 2.3f, Gdx.graphics.getHeight() / 1.7f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        cuadro2 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() / 2.3f, Gdx.graphics.getHeight() / 2.5f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        cuadro3 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() / 2.3f, Gdx.graphics.getHeight() / 4.9f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);

        cantidadLimones = recursos.getReceta().getLimones();
        cantidadAzucar = recursos.getReceta().getAzucar();
        cantidadHielo = recursos.getReceta().getHielo();

        textoCantidadLimones = new Texto(cantidadLimones + "", Gdx.graphics.getWidth() / 2.14f, Gdx.graphics.getHeight() / 1.7f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7, Color.BLACK);
        textoCantidadHielos = new Texto(cantidadHielo + "", Gdx.graphics.getWidth() / 2.14f, Gdx.graphics.getHeight() / 2.5f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7, Color.BLACK);
        textoCantidadAzucar = new Texto(cantidadAzucar + "", Gdx.graphics.getWidth() / 2.14f, Gdx.graphics.getHeight() / 4.9f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7, Color.BLACK);

        jarra = new Cuadro((Texture) manager.get("jarra.png"), Gdx.graphics.getWidth() * 0.6f, Gdx.graphics.getHeight() * 0.1f, Gdx.graphics.getWidth() / 3, Gdx.graphics.getHeight() * 0.7f);

        musica = manager.get("menu.mp3");
        musica.setLooping(true);
        musica.setVolume(1);
        musica.play();

        Gdx.input.setInputProcessor(stage);

        stage.addActor(fondo);
        stage.addActor(receta);
        stage.addActor(mejoras);
        stage.addActor(finanzas);
        stage.addActor(ingredientes);
        stage.addActor(sumarLimones);
        stage.addActor(sumarAzucar);
        stage.addActor(sumarHielo);
        stage.addActor(restarLimones);
        stage.addActor(restarAzucar);
        stage.addActor(restarHielo);
        stage.addActor(limon);
        stage.addActor(hielo);
        stage.addActor(azucar);
        stage.addActor(cuadro1);
        stage.addActor(cuadro2);
        stage.addActor(cuadro3);
        stage.addActor(textoCantidadLimones);
        stage.addActor(textoCantidadAzucar);
        stage.addActor(textoCantidadHielos);
        stage.addActor(jarra);
        stage.addActor(titulo);
        stage.addActor(descripcion);
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
        if (sumarLimones.haSidoPresionado()) {
            if (cantidadLimones + 1 != 10)
                textoCantidadLimones.setText(++cantidadLimones + "");
            sumarLimones.setPresionado(false);
        }
        if (sumarHielo.haSidoPresionado()) {
            if (cantidadHielo + 1 != 10)
                textoCantidadHielos.setText(++cantidadHielo + "");
            sumarHielo.setPresionado(false);
        }
        if (sumarAzucar.haSidoPresionado()) {
            if (cantidadAzucar + 1 != 10)
                textoCantidadAzucar.setText(++cantidadAzucar + "");
            sumarAzucar.setPresionado(false);
        }
        if (restarLimones.haSidoPresionado()) {
            if (cantidadLimones - 1 != 0)
                textoCantidadLimones.setText(--cantidadLimones + "");
            restarLimones.setPresionado(false);
        }
        if (restarHielo.haSidoPresionado()) {
            if (cantidadHielo - 1 != 0)
                textoCantidadHielos.setText(--cantidadHielo + "");
            restarHielo.setPresionado(false);
        }
        if (restarAzucar.haSidoPresionado()) {
            if (cantidadAzucar - 1 != 0)
                textoCantidadAzucar.setText(--cantidadAzucar + "");
            restarAzucar.setPresionado(false);
        }
        if (mejoras.haSidoPresionado()) {
            MejorasScreen mejorasScreen = new MejorasScreen(game, manager);
            recursos.setReceta(new Receta(cantidadLimones, cantidadHielo, cantidadAzucar));
            mejorasScreen.setRecursos(recursos);
            game.setScreen(mejorasScreen);
            mejoras.setPresionado(false);
        }
        if (finanzas.haSidoPresionado()) {
            FinanzasScreen finanzasScreen = new FinanzasScreen(game, manager);
            recursos.setReceta(new Receta(cantidadLimones, cantidadHielo, cantidadAzucar));
            finanzasScreen.setRecursos(recursos);
            game.setScreen(finanzasScreen);
            finanzas.setPresionado(false);
        }
        if (ingredientes.haSidoPresionado()) {
            IngredientesScreen ingredientesScreen = new IngredientesScreen(game, manager);
            recursos.setReceta(new Receta(cantidadLimones, cantidadHielo, cantidadAzucar));
            ingredientesScreen.setRecursos(recursos);
            game.setScreen(ingredientesScreen);
            ingredientes.setPresionado(false);
        }
    }

    @Override
    public void dispose() {
        fondo.getTextura().dispose();
        receta.getTextura().dispose();
        mejoras.getTextura().dispose();
        finanzas.getTextura().dispose();
        ingredientes.getTextura().dispose();
        sumarLimones.getTextura().dispose();
        sumarAzucar.getTextura().dispose();
        sumarHielo.getTextura().dispose();
        restarHielo.getTextura().dispose();
        restarAzucar.getTextura().dispose();
        restarLimones.getTextura().dispose();
        limon.getTextura().dispose();
        azucar.getTextura().dispose();
        hielo.getTextura().dispose();
        cuadro1.getTextura().dispose();
        cuadro2.getTextura().dispose();
        cuadro3.getTextura().dispose();
        jarra.getTextura().dispose();
        stage.dispose();
        manager.dispose();
        game.dispose();
    }

    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

}
