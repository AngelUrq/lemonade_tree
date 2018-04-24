package com.lemonade.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.lemonade.game.MainGame;
import com.lemonade.game.elementos.Boton;
import com.lemonade.game.elementos.Cuadro;
import com.lemonade.game.elementos.CuadroPresionable;
import com.lemonade.game.elementos.Fondo;
import com.lemonade.game.elementos.Texto;
import com.lemonade.game.entidades.Recursos;

public class MejorasScreen extends AbstractScreen {

    private Stage stage;

    private Fondo fondo;

    private Boton receta, mejoras, finanzas, ingredientes;

    private Texto textoMaquinas, textoPuestosDeTrabajo, textoPersonal;
    private Texto textoTotal, textoDinero;
    private Texto descripcion;

    private CuadroPresionable exprimidora, maquinaDeHielo, cajero, sombrilla;
    private CuadroPresionable carritoPrincipal, carritoIncognita, carritoLimon;
    private CuadroPresionable payaso;
    private Cuadro sale;

    private Boton comprarMejoras;

    private float dinero;
    private float total, precioExprimidora, precioSombrilla, precioMaquina, precioCajero, precioPayaso, precioCarritoPrincipal, precioCarritoSorpresa, precioCarritoLimon;

    private Recursos recursos;

    public MejorasScreen(MainGame game, AssetManager manager) {
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

        textoMaquinas = new Texto("Compra mejoras: ", Gdx.graphics.getWidth() * 0.1f, Gdx.graphics.getHeight() * 0.575f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getWidth() / 4, Color.WHITE);

        exprimidora = new CuadroPresionable((Texture) manager.get("exprimidora.png"), Gdx.graphics.getWidth() * 0.13f, Gdx.graphics.getHeight() * 0.59f, Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);
        sombrilla = new CuadroPresionable((Texture) manager.get("sombrilla.png"), Gdx.graphics.getWidth() * 0.30f, Gdx.graphics.getHeight() * 0.59f, Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);
        maquinaDeHielo = new CuadroPresionable((Texture) manager.get("maquina.png"), Gdx.graphics.getWidth() * 0.47f, Gdx.graphics.getHeight() * 0.59f, Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);
        cajero = new CuadroPresionable((Texture) manager.get("cajero.png"), Gdx.graphics.getWidth() * 0.64f, Gdx.graphics.getHeight() * 0.59f, Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);

        comprarMejoras = new Boton((Texture) manager.get("comprar.png"), Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.05f, Gdx.graphics.getWidth() / 6, Gdx.graphics.getWidth() / 12);

        textoPuestosDeTrabajo = new Texto("Cambia tu puesto de trabajo: ", Gdx.graphics.getWidth() * 0.1f, Gdx.graphics.getHeight() * 0.26f, Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 4, Color.WHITE);

        carritoPrincipal = new CuadroPresionable((Texture) manager.get("carritoPrincipal.png"), Gdx.graphics.getWidth() * 0.13f, Gdx.graphics.getHeight() * 0.24f, Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);
        carritoIncognita = new CuadroPresionable((Texture) manager.get("interrogante.png"), Gdx.graphics.getWidth() * 0.3f, Gdx.graphics.getHeight() * 0.24f, Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);
        carritoLimon = new CuadroPresionable((Texture) manager.get("lemonadestand.png"), Gdx.graphics.getWidth() * 0.47f, Gdx.graphics.getHeight() * 0.24f, Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);

        textoPersonal = new Texto("Contrata personal: ", Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.575f, Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 4, Color.WHITE);

        payaso = new CuadroPresionable((Texture) manager.get("payaso.png"), Gdx.graphics.getWidth() * 0.835f, Gdx.graphics.getHeight() * 0.58f, Gdx.graphics.getWidth() / 12, Gdx.graphics.getWidth() / 12);

        sale = new Cuadro((Texture) manager.get("sale.png"), Gdx.graphics.getWidth() * 0.6f, Gdx.graphics.getHeight() * 0.15f, Gdx.graphics.getWidth() / 7, Gdx.graphics.getWidth() / 6);

        descripcion = new Texto("Elige una opción para ver su descripción.", Gdx.graphics.getWidth() * 0.1f, Gdx.graphics.getHeight() * 0.01f, Gdx.graphics.getWidth() / 1.5f, Gdx.graphics.getWidth() / 8, Color.WHITE);

        total = 0;
        dinero = recursos.getDinero();
        precioExprimidora = 0;
        precioSombrilla = 0;
        precioMaquina = 0;
        precioCajero = 0;
        precioPayaso = 0;
        precioCarritoPrincipal = 0;
        precioCarritoSorpresa = 0;
        precioCarritoLimon = 0;

        textoDinero = new Texto("Dinero actual: " + dinero, Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.27f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 10, Color.WHITE);
        textoTotal = new Texto("Total a pagar: " + total, Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.2f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 10, Color.WHITE);

        Gdx.input.setInputProcessor(stage);

        stage.addActor(fondo);
        stage.addActor(textoMaquinas);
        stage.addActor(comprarMejoras);
        stage.addActor(textoPuestosDeTrabajo);
        stage.addActor(carritoPrincipal);
        stage.addActor(carritoIncognita);
        stage.addActor(carritoLimon);
        stage.addActor(textoPersonal);
        stage.addActor(payaso);
        stage.addActor(textoTotal);
        stage.addActor(textoDinero);
        stage.addActor(descripcion);
        stage.addActor(sale);
        stage.addActor(exprimidora);
        stage.addActor(maquinaDeHielo);
        stage.addActor(cajero);
        stage.addActor(sombrilla);
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
        manejarPrecios();

        stage.act(delta);
        stage.draw();
    }

    private void manejarPrecios() {
        if (exprimidora.estaAbajo()) {
            precioExprimidora = 100;
        } else {
            precioExprimidora = 0;
        }
        if (sombrilla.estaAbajo()) {
            precioSombrilla = 60;
        } else {
            precioSombrilla = 0;
        }
        if (maquinaDeHielo.estaAbajo()) {
            precioMaquina = 200;
        } else {
            precioMaquina = 0;
        }
        if (cajero.estaAbajo()) {
            precioCajero = 250;
        } else {
            precioCajero = 0;
        }
        if (payaso.estaAbajo()) {
            precioPayaso = 500;
        } else {
            precioPayaso = 0;
        }
        if (carritoIncognita.estaAbajo()) {
            precioCarritoSorpresa = 2000;
        } else {
            precioCarritoSorpresa = 0;
        }
        if (carritoLimon.estaAbajo()) {
            precioCarritoLimon = 3000;
        } else {
            precioCarritoLimon = 0;
        }

        total = precioExprimidora + precioSombrilla + precioMaquina + precioCajero + precioPayaso + precioCarritoPrincipal + precioCarritoSorpresa + precioCarritoLimon;
        textoTotal.setText("Total a pagar: " + total + "$");
    }

    private void manejarEntrada() {
        if (receta.haSidoPresionado()) {
            RecetaScreen recetaScreen = new RecetaScreen(game, manager);
            recetaScreen.setRecursos(recursos);
            game.setScreen(recetaScreen);
            receta.setPresionado(false);
        }
        if (finanzas.haSidoPresionado()) {
            FinanzasScreen finanzasScreen = new FinanzasScreen(game, manager);
            finanzasScreen.setRecursos(recursos);
            game.setScreen(finanzasScreen);
            finanzas.setPresionado(false);
        }
        if (ingredientes.haSidoPresionado()) {
            IngredientesScreen ingredientesScreen = new IngredientesScreen(game, manager);
            ingredientesScreen.setRecursos(recursos);
            game.setScreen(ingredientesScreen);
            ingredientes.setPresionado(false);
        }
        if (comprarMejoras.haSidoPresionado()) {
            if (dinero >= total) {
                if (precioExprimidora != 0 && !recursos.isExprimidora()) {
                    recursos.setExprimidora(true);
                } else{
                    exprimidora.subir();
                }
                if (precioSombrilla != 0 && !recursos.isSombrilla()) {
                    recursos.setSombrilla(true);
                }else{
                    sombrilla.subir();
                }
                if (precioMaquina != 0 && !recursos.isMaquinaHielo()) {
                    recursos.setMaquinaHielo(true);
                } else{
                    maquinaDeHielo.subir();
                }
                if (precioCajero != 0 && !recursos.isCajero()) {
                    recursos.setCajero(true);
                } else{
                    cajero.subir();
                }
                if (precioPayaso != 0 && !recursos.isPayaso()) {
                    recursos.setPayaso(true);
                } else{
                    payaso.subir();
                }
                if (precioCarritoSorpresa != 0 && !recursos.isCarritoSorpresa()) {
                    recursos.setCarritoSorpresa(true);
                } else{
                    carritoIncognita.subir();
                }
                if (precioCarritoLimon != 0 && !recursos.isCarritoLimon()) {
                    recursos.setCarritoLimon(true);
                } else{
                    carritoLimon.subir();
                }
                dinero -= total;
                textoDinero.setText("Dinero actual: " + dinero + "$");
                recursos.setDinero(dinero);
                comprarMejoras.setPresionado(false);
            }
        }
    }

    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

}
