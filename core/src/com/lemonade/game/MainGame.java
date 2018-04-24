package com.lemonade.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.lemonade.game.screens.InicioScreen;
import com.badlogic.gdx.audio.Sound;

public class MainGame extends Game {

	private AssetManager manager;

	@Override
	public void create () {
		cargarRecursos();
		setScreen(new InicioScreen(this,manager));
	}

	@Override
	public void render() {
		super.render();
	}

	private void cargarRecursos(){
		manager = new AssetManager();
		manager.load("icono.png", Texture.class);
		manager.load("iniciarsesion.png",Texture.class);
		manager.load("play.png", Texture.class);
		manager.load("comprar.png",Texture.class);
		manager.load("playa.png",Texture.class);
		manager.load("suburbios.png",Texture.class);
		manager.load("fondo.png",Texture.class);
		manager.load("pantallainicio.png",Texture.class);
		manager.load("mejoras.png",Texture.class);
		manager.load("boton-mejoras.png",Texture.class);
		manager.load("boton-recetas.png",Texture.class);
		manager.load("boton-ingredientes.png",Texture.class);
		manager.load("boton-finanzas.png",Texture.class);
		manager.load("signo-menos.png",Texture.class);
		manager.load("signo-mas.png",Texture.class);
		manager.load("persona1.png",Texture.class);
		manager.load("persona2.png",Texture.class);
		manager.load("persona3.png",Texture.class);
		manager.load("persona4.png",Texture.class);
		manager.load("persona5.png",Texture.class);
		manager.load("persona6.png",Texture.class);
		manager.load("persona7.png",Texture.class);
		manager.load("limon.png", Texture.class);
		manager.load("hielo.png",Texture.class);
		manager.load("azucar.png",Texture.class);
		manager.load("marco.png",Texture.class);
		manager.load("vasos.png",Texture.class);
		manager.load("jarra.png",Texture.class);
		manager.load("carrito1.png",Texture.class);
		manager.load("casamorada.png",Texture.class);
		manager.load("casaazul.png",Texture.class);
		manager.load("frame.png",Texture.class);
		manager.load("exprimidora.png",Texture.class);
		manager.load("maquina.png",Texture.class);
		manager.load("cajero.png",Texture.class);
		manager.load("sombrilla.png",Texture.class);
		manager.load("carritoPrincipal.png",Texture.class);
		manager.load("interrogante.png",Texture.class);
		manager.load("lemonadestand.png",Texture.class);
		manager.load("payaso.png",Texture.class);
		manager.load("sale.png",Texture.class);
		manager.load("payasop.png",Texture.class);
		manager.load("feliz.png", Texture.class);
		manager.load("triste.png", Texture.class);
		manager.load("si.png", Texture.class);
		manager.load("no.png", Texture.class);
		manager.load("sonidodinero.ogg",Sound.class);
		manager.load("opening.mp3", Music.class);
		manager.load("menu.mp3", Music.class);
		manager.load("overworld.mp3", Music.class);
		manager.finishLoading();
	}

	@Override
	public void dispose() {
		manager.dispose();
	}
}
