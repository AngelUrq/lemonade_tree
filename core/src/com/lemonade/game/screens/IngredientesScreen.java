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
import com.lemonade.game.elementos.CuadroAdvertencia;
import com.lemonade.game.elementos.CuadroConfirmable;
import com.lemonade.game.elementos.Fondo;
import com.lemonade.game.elementos.Texto;
import com.lemonade.game.entidades.Recursos;

import java.util.Random;

public class IngredientesScreen extends AbstractScreen {

    private Stage stage;

    private Fondo fondo;

    private Boton receta, mejoras, finanzas, ingredientes;

    private Boton jugar, comprar;

    private Boton sumarLimones, restarLimones;
    private Boton sumarAzucar, restarAzucar;
    private Boton sumarHielo, restarHielo;
    private Boton sumarVasos, restarVasos;

    private CuadroAdvertencia cuadroAdvertencia;

    private Cuadro limon, hielo, azucar, vasos;

    private Cuadro marco1, marco2, marco3, marco4, marco5, marco6, marco7, marco8;

    private Texto titulo;
    private Texto descripcionLimon, descripcionHielo, descripcionAzucar, descripcionVasos;
    private Texto textoCantidadLimones, textoCantidadHielos, textoCantidadAzucar, textoCantidadVasos;
    private Texto textoDinero;
    private Texto textoTotal;
    private Texto textoIngredientesActuales;
    private Texto textoCantidadLimonesActuales, textoCantidadHielosActuales, textoCantidadAzucarActuales, textoCantidadVasosActuales;

    private int cantidadLimones, cantidadHielos, cantidadAzucar, cantidadVasos;
    private int cantidadLimonesActuales, cantidadHielosActuales, cantidadAzucarActuales, cantidadVasosActuales;

    private float dinero;
    private float total;
    private float precioLimon, precioHielo, precioAzucar, precioVaso;

    private Recursos recursos;

    public IngredientesScreen(MainGame game, AssetManager manager) {
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

        jugar = new Boton((Texture) manager.get("play.png"), Gdx.graphics.getWidth() * 0.70f, Gdx.graphics.getHeight() / 10f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 7);
        comprar = new Boton((Texture) manager.get("comprar.png"), Gdx.graphics.getWidth() * 0.70f, Gdx.graphics.getHeight() / 3.5f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 7);

        sumarLimones = new Boton((Texture) manager.get("signo-mas.png"), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 1.6f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        sumarHielo = new Boton((Texture) manager.get("signo-mas.png"), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2.2f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        sumarAzucar = new Boton((Texture) manager.get("signo-mas.png"), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 3.5f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        sumarVasos = new Boton((Texture) manager.get("signo-mas.png"), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 9f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);

        restarLimones = new Boton((Texture) manager.get("signo-menos.png"), Gdx.graphics.getWidth() / 2.5f, Gdx.graphics.getHeight() / 1.6f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        restarHielo = new Boton((Texture) manager.get("signo-menos.png"), Gdx.graphics.getWidth() / 2.5f, Gdx.graphics.getHeight() / 2.2f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        restarAzucar = new Boton((Texture) manager.get("signo-menos.png"), Gdx.graphics.getWidth() / 2.5f, Gdx.graphics.getHeight() / 3.5f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        restarVasos = new Boton((Texture) manager.get("signo-menos.png"), Gdx.graphics.getWidth() / 2.5f, Gdx.graphics.getHeight() / 9f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);

        limon = new Cuadro((Texture) manager.get("limon.png"), Gdx.graphics.getWidth() / 6f, Gdx.graphics.getHeight() / 1.6f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        hielo = new Cuadro((Texture) manager.get("hielo.png"), Gdx.graphics.getWidth() / 6f, Gdx.graphics.getHeight() / 2.2f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        azucar = new Cuadro((Texture) manager.get("azucar.png"), Gdx.graphics.getWidth() / 6f, Gdx.graphics.getHeight() / 3.5f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        vasos = new Cuadro((Texture) manager.get("vasos.png"), Gdx.graphics.getWidth() / 6f, Gdx.graphics.getHeight() / 9f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);

        cuadroAdvertencia = new CuadroAdvertencia((Texture) manager.get("fondo.png"), Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/2 - Gdx.graphics.getHeight()/4,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,"");

        titulo = new Texto("Ingredientes", Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 16, Gdx.graphics.getHeight() * 0.77f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 7, Color.WHITE);

        textoIngredientesActuales = new Texto("Cantidad actual", Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.77f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 7, Color.WHITE);

        descripcionLimon = new Texto("Limones", Gdx.graphics.getWidth() / 3.6f, Gdx.graphics.getHeight() / 1.6f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 7f, Color.WHITE);
        descripcionHielo = new Texto("Hielos", Gdx.graphics.getWidth() / 3.6f, Gdx.graphics.getHeight() / 2.2f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 7f, Color.WHITE);
        descripcionAzucar = new Texto("Azúcar", Gdx.graphics.getWidth() / 3.6f, Gdx.graphics.getHeight() / 3.5f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 7f, Color.WHITE);
        descripcionVasos = new Texto("Vasos", Gdx.graphics.getWidth() / 3.6f, Gdx.graphics.getHeight() / 9.7f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 7f, Color.WHITE);

        marco1 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() / 1.65f, Gdx.graphics.getHeight() / 1.6f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        marco2 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() / 1.65f, Gdx.graphics.getHeight() / 2.2f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        marco3 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() / 1.65f, Gdx.graphics.getHeight() / 3.5f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        marco4 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() / 1.65f, Gdx.graphics.getHeight() / 9f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);

        marco5 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() / 1.6f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        marco6 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() / 2.2f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        marco7 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() / 3.5f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);
        marco8 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() / 9f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7);

        precioLimon = 0.4f;
        precioHielo = 0.02f;
        precioAzucar = 0.4f;
        precioVaso = 0.1f;

        cantidadLimones = 0;
        cantidadHielos = 0;
        cantidadAzucar = 0;
        cantidadVasos = 0;

        cantidadLimonesActuales = recursos.getLimones();
        cantidadHielosActuales = recursos.getHielo();
        cantidadAzucarActuales = recursos.getAzucar();
        cantidadVasosActuales = recursos.getVasos();

        dinero = recursos.getDinero();
        total = 0;

        textoCantidadLimones = new Texto(cantidadLimones + "", Gdx.graphics.getWidth() / 1.565f, Gdx.graphics.getHeight() / 1.6f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7, Color.BLACK);
        textoCantidadHielos = new Texto(cantidadHielos + "", Gdx.graphics.getWidth() / 1.565f, Gdx.graphics.getHeight() / 2.2f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7, Color.BLACK);
        textoCantidadAzucar = new Texto(cantidadAzucar + "", Gdx.graphics.getWidth() / 1.565f, Gdx.graphics.getHeight() / 3.5f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7, Color.BLACK);
        textoCantidadVasos = new Texto(cantidadVasos + "", Gdx.graphics.getWidth() / 1.565f, Gdx.graphics.getHeight() / 9.7f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7, Color.BLACK);

        textoCantidadLimonesActuales = new Texto(cantidadLimonesActuales + "", Gdx.graphics.getWidth() * 0.08f, Gdx.graphics.getHeight() / 1.6f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7, Color.BLACK);
        textoCantidadHielosActuales = new Texto(cantidadHielosActuales + "", Gdx.graphics.getWidth() * 0.08f, Gdx.graphics.getHeight() / 2.2f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7, Color.BLACK);
        textoCantidadAzucarActuales = new Texto(cantidadAzucarActuales + "", Gdx.graphics.getWidth() * 0.08f, Gdx.graphics.getHeight() / 3.5f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7, Color.BLACK);
        textoCantidadVasosActuales = new Texto(cantidadVasosActuales + "", Gdx.graphics.getWidth() * 0.08f, Gdx.graphics.getHeight() / 9.7f, Gdx.graphics.getHeight() / 7, Gdx.graphics.getHeight() / 7, Color.BLACK);

        textoDinero = new Texto("Dinero actual: " + dinero + "$", Gdx.graphics.getWidth() * 0.73f, Gdx.graphics.getHeight() / 1.6f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 7, Color.WHITE);
        textoTotal = new Texto("Total compra: " + total + "$", Gdx.graphics.getWidth() * 0.73f, Gdx.graphics.getHeight() / 2.2f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 7, Color.WHITE);

        Gdx.input.setInputProcessor(stage);

        agregarActores();
    }

    private void agregarActores(){
        stage.clear();
        stage.addActor(fondo);
        stage.addActor(receta);
        stage.addActor(mejoras);
        stage.addActor(finanzas);
        stage.addActor(ingredientes);
        stage.addActor(jugar);
        stage.addActor(comprar);
        stage.addActor(limon);
        stage.addActor(hielo);
        stage.addActor(azucar);
        stage.addActor(vasos);
        stage.addActor(titulo);
        stage.addActor(textoIngredientesActuales);
        stage.addActor(marco1);
        stage.addActor(marco2);
        stage.addActor(marco3);
        stage.addActor(marco4);
        stage.addActor(marco5);
        stage.addActor(marco6);
        stage.addActor(marco7);
        stage.addActor(marco8);
        stage.addActor(textoDinero);
        stage.addActor(textoTotal);
        stage.addActor(textoCantidadLimones);
        stage.addActor(textoCantidadHielos);
        stage.addActor(textoCantidadAzucar);
        stage.addActor(textoCantidadVasos);
        stage.addActor(textoCantidadLimonesActuales);
        stage.addActor(textoCantidadHielosActuales);
        stage.addActor(textoCantidadAzucarActuales);
        stage.addActor(textoCantidadVasosActuales);
        stage.addActor(descripcionLimon);
        stage.addActor(descripcionHielo);
        stage.addActor(descripcionAzucar);
        stage.addActor(descripcionVasos);
        stage.addActor(sumarLimones);
        stage.addActor(sumarAzucar);
        stage.addActor(sumarHielo);
        stage.addActor(sumarVasos);
        stage.addActor(restarLimones);
        stage.addActor(restarAzucar);
        stage.addActor(restarHielo);
        stage.addActor(restarVasos);
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
        if (receta.haSidoPresionado()) {
            RecetaScreen recetaScreen = new RecetaScreen(game, manager);
            recetaScreen.setRecursos(recursos);
            game.setScreen(recetaScreen);
            receta.setPresionado(false);
        }
        if (mejoras.haSidoPresionado()) {
            MejorasScreen mejorasScreen = new MejorasScreen(game, manager);
            mejorasScreen.setRecursos(recursos);
            game.setScreen(mejorasScreen);
            mejoras.setPresionado(false);
        }
        if (finanzas.haSidoPresionado()) {
            FinanzasScreen finanzasScreen = new FinanzasScreen(game, manager);
            finanzasScreen.setRecursos(recursos);
            game.setScreen(finanzasScreen);
            finanzas.setPresionado(false);
        }
        if (jugar.haSidoPresionado()) {
            if (cantidadLimonesActuales <= 0 || cantidadAzucarActuales <= 0 || cantidadHielosActuales <= 0 || cantidadVasosActuales <= 0) {
                cuadroAdvertencia.setTexto("No tienes ingredientes sufientes para iniciar el día");
                cuadroAdvertencia.setSidoDibujado(true);
                stage.addActor(cuadroAdvertencia);
            } else {
                Music musica = manager.get("menu.mp3");
                musica.stop();

                recursos.setTemperatura(new Random().nextInt(20) + 15);

                SuburbiosScreen suburbiosScreen = new SuburbiosScreen(game, manager);
                suburbiosScreen.setRecursos(recursos);
                game.setScreen(suburbiosScreen);
            }
            jugar.setPresionado(false);
        }
        if (comprar.haSidoPresionado()) {
            if (dinero >= total) {
                dinero -= total;
                dinero = Float.parseFloat(String.valueOf(Math.round(dinero * 100d) / 100d));
                textoDinero.setText("Dinero actual: " + dinero + "$");

                cantidadLimonesActuales += cantidadLimones;
                cantidadHielosActuales += cantidadHielos;
                cantidadAzucarActuales += cantidadAzucar;
                cantidadVasosActuales += cantidadVasos;

                recursos.setDinero(dinero);

                recursos.setLimones(cantidadLimonesActuales);
                recursos.setHielo(cantidadHielosActuales);
                recursos.setAzucar(cantidadAzucarActuales);
                recursos.setVasos(cantidadVasosActuales);

                textoCantidadLimonesActuales.setText(cantidadLimonesActuales + "");
                textoCantidadAzucarActuales.setText(cantidadAzucarActuales + "");
                textoCantidadHielosActuales.setText(cantidadHielosActuales + "");
                textoCantidadVasosActuales.setText(cantidadVasosActuales + "");

                cantidadLimones = 0;
                cantidadAzucar = 0;
                cantidadVasos = 0;
                cantidadHielos = 0;

                textoCantidadLimones.setText(cantidadLimones + "");
                textoCantidadAzucar.setText(cantidadAzucar + "");
                textoCantidadHielos.setText(cantidadHielos + "");
                textoCantidadVasos.setText(cantidadVasos + "");

                total = 0;
                textoTotal.setText("Total compra: " + total + "$");
            } else{
                cuadroAdvertencia.setTexto("No tienes dinero sufiente para realizar la compra.");
                cuadroAdvertencia.setSidoDibujado(true);
                stage.addActor(cuadroAdvertencia);
            }
            comprar.setPresionado(false);
        }
        //Presionando el cuadro se quita
        if(cuadroAdvertencia.haSidoDibujado() && cuadroAdvertencia.haSidoPresionado()){
            cuadroAdvertencia.setSidoDibujado(false);
            cuadroAdvertencia.setHaSidoPresionado(false);
            agregarActores();
        }
        if (total < 1) {
            total = 0;
            textoTotal.setText("Total compra: " + total + "$");
        }
        if (sumarLimones.haSidoPresionado()) {
            if (cantidadLimones + 12 < 1000) {
                cantidadLimones += 12;
                if (cantidadLimones >= 10) {
                    textoCantidadLimones.setX(Gdx.graphics.getWidth() / 1.58f);
                    if (cantidadLimones >= 100) {
                        textoCantidadLimones.setX(Gdx.graphics.getWidth() / 1.595f);
                    }
                }
                textoCantidadLimones.setText(cantidadLimones + "");
                total += 12 * precioLimon;
                total = Float.parseFloat(String.valueOf(Math.round(total * 100d) / 100d));
                textoTotal.setText("Total compra: " + total + "$");
            }
            sumarLimones.setPresionado(false);
        }
        if (sumarHielo.haSidoPresionado()) {
            if (cantidadHielos + 50 < 1000) {
                cantidadHielos += 50;
                if (cantidadHielos >= 10) {
                    textoCantidadHielos.setX(Gdx.graphics.getWidth() / 1.58f);
                    if (cantidadHielos >= 100) {
                        textoCantidadHielos.setX(Gdx.graphics.getWidth() / 1.595f);
                    }
                }
                total += 50 * precioHielo;
                total = Float.parseFloat(String.valueOf(Math.round(total * 100d) / 100d));
                textoTotal.setText("Total compra: " + total + "$");
                textoCantidadHielos.setText(cantidadHielos + "");
            }
            sumarHielo.setPresionado(false);
        }
        if (sumarAzucar.haSidoPresionado()) {
            if (cantidadAzucar + 12 < 1000) {
                cantidadAzucar += 12;
                if (cantidadAzucar >= 10) {
                    textoCantidadAzucar.setX(Gdx.graphics.getWidth() / 1.58f);
                    if (cantidadAzucar >= 100) {
                        textoCantidadAzucar.setX(Gdx.graphics.getWidth() / 1.595f);
                    }
                }
                total += 12 * precioAzucar;
                total = Float.parseFloat(String.valueOf(Math.round(total * 100d) / 100d));
                textoTotal.setText("Total compra: " + total + "$");
                textoCantidadAzucar.setText(cantidadAzucar + "");
            }
            sumarAzucar.setPresionado(false);
        }
        if (sumarVasos.haSidoPresionado()) {
            if (cantidadVasos + 75 < 1000) {
                cantidadVasos += 75;
                if (cantidadVasos >= 10) {
                    textoCantidadVasos.setX(Gdx.graphics.getWidth() / 1.58f);
                    if (cantidadVasos >= 100) {
                        textoCantidadVasos.setX(Gdx.graphics.getWidth() / 1.595f);
                    }
                }
                total += 75 * precioVaso;
                total = Float.parseFloat(String.valueOf(Math.round(total * 100d) / 100d));
                textoTotal.setText("Total compra: " + total + "$");
                textoCantidadVasos.setText(cantidadVasos + "");
            }
            sumarVasos.setPresionado(false);
        }
        if (restarLimones.haSidoPresionado()) {
            if (cantidadLimones - 12 >= 0) {
                cantidadLimones -= 12;
                textoCantidadLimones.setX(Gdx.graphics.getWidth() / 1.565f);
                if (cantidadLimones >= 10) {
                    textoCantidadLimones.setX(Gdx.graphics.getWidth() / 1.58f);
                    if (cantidadLimones >= 100) {
                        textoCantidadLimones.setX(Gdx.graphics.getWidth() / 1.595f);
                    }
                }
                total -= 12 * precioLimon;
                total = Float.parseFloat(String.valueOf(Math.round(total * 100d) / 100d));
                textoTotal.setText("Total compra: " + total + "$");
                textoCantidadLimones.setText(cantidadLimones + "");
            }
            restarLimones.setPresionado(false);
        }
        if (restarHielo.haSidoPresionado()) {
            if (cantidadHielos - 50 >= 0) {
                cantidadHielos -= 50;
                textoCantidadHielos.setX(Gdx.graphics.getWidth() / 1.565f);
                if (cantidadHielos >= 10) {
                    textoCantidadHielos.setX(Gdx.graphics.getWidth() / 1.58f);
                    if (cantidadHielos >= 100) {
                        textoCantidadHielos.setX(Gdx.graphics.getWidth() / 1.595f);
                    }
                }
                total -= 50 * precioHielo;
                total = Float.parseFloat(String.valueOf(Math.round(total * 100d) / 100d));
                textoTotal.setText("Total compra: " + total + "$");
                textoCantidadHielos.setText(cantidadHielos + "");
            }
            restarHielo.setPresionado(false);
        }
        if (restarAzucar.haSidoPresionado()) {
            if (cantidadAzucar - 12 >= 0) {
                cantidadAzucar -= 12;
                textoCantidadAzucar.setX(Gdx.graphics.getWidth() / 1.565f);
                if (cantidadAzucar >= 10) {
                    textoCantidadAzucar.setX(Gdx.graphics.getWidth() / 1.58f);
                    if (cantidadAzucar >= 100) {
                        textoCantidadAzucar.setX(Gdx.graphics.getWidth() / 1.595f);
                    }
                }
                total -= 12 * precioAzucar;
                total = Float.parseFloat(String.valueOf(Math.round(total * 100d) / 100d));
                textoTotal.setText("Total compra: " + total + "$");
                textoCantidadAzucar.setText(cantidadAzucar + "");
            }
            restarAzucar.setPresionado(false);
        }
        if (restarVasos.haSidoPresionado()) {
            if (cantidadVasos - 75 >= 0) {
                cantidadVasos -= 75;
                textoCantidadVasos.setX(Gdx.graphics.getWidth() / 1.565f);
                if (cantidadVasos >= 10) {
                    textoCantidadVasos.setX(Gdx.graphics.getWidth() / 1.58f);
                    if (cantidadVasos >= 100) {
                        textoCantidadVasos.setX(Gdx.graphics.getWidth() / 1.595f);
                    }
                }
                total -= 75 * precioVaso;
                total = Float.parseFloat(String.valueOf(Math.round(total * 100d) / 100d));
                textoTotal.setText("Total compra: " + total + "$");
                textoCantidadVasos.setText(cantidadVasos + "");
            }
            restarVasos.setPresionado(false);
        }
    }

    @Override
    public void dispose() {
        stage.dispose();
        manager.dispose();
        game.dispose();
        receta.getTextura().dispose();
        mejoras.getTextura().dispose();
        finanzas.getTextura().dispose();
        ingredientes.getTextura().dispose();
        jugar.getTextura().dispose();
        comprar.getTextura().dispose();
        sumarLimones.getTextura().dispose();
        restarLimones.getTextura().dispose();
        sumarAzucar.getTextura().dispose();
        restarAzucar.getTextura().dispose();
        sumarHielo.getTextura().dispose();
        restarHielo.getTextura().dispose();
        sumarVasos.getTextura().dispose();
        restarVasos.getTextura().dispose();
        limon.getTextura().dispose();
        hielo.getTextura().dispose();
        azucar.getTextura().dispose();
        vasos.getTextura().dispose();
        marco1.getTextura().dispose();
        marco2.getTextura().dispose();
        marco3.getTextura().dispose();
        marco4.getTextura().dispose();
        marco5.getTextura().dispose();
        marco6.getTextura().dispose();
        marco7.getTextura().dispose();
        marco8.getTextura().dispose();
    }

    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

}