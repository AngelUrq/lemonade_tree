package com.lemonade.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lemonade.game.MainGame;

public class InicioScreen extends AbstractScreen {

    private SpriteBatch batch;

    private Music cancion;

    public InicioScreen(MainGame game, AssetManager manager) {
        super(game, manager);

        //Instanciar el que va a dibujar los gráficos
        batch = new SpriteBatch();

        //Iniciar la música
        cancion = manager.get("opening.mp3");
        cancion.setLooping(true);
        cancion.setVolume(1);
        cancion.play();
    }

    @Override
    public void render(float delta) {
        //Limpia la pantalla y el buffer de la GPU
        Gdx.gl.glClearColor(0, 2, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        manejarEntrada();

        //Dibujar el fondo
        batch.begin();
        batch.draw((Texture) manager.get("pantallainicio.png"), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }

    private void manejarEntrada() {
        //Cambiamos de pantalla si se toca
        if (Gdx.input.justTouched()) {
            game.setScreen(new MenuScreen(game, manager));
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        game.dispose();
        manager.dispose();
    }

}
