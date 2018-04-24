package com.lemonade.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lemonade.game.MainGame;
import com.lemonade.game.elementos.Cuadro;
import com.lemonade.game.elementos.Fondo;
import com.lemonade.game.elementos.Texto;
import com.lemonade.game.entidades.Carrito;
import com.lemonade.game.entidades.Constantes;
import com.lemonade.game.entidades.Persona;
import com.lemonade.game.entidades.Recursos;

import java.util.ArrayList;
import java.util.Random;

public class SuburbiosScreen extends AbstractScreen {

    private static final int CANTIDAD_PERSONAS = 20;

    private Stage stage;

    private Fondo fondo;

    private Viewport viewport;
    private Camera camera;

    private Carrito carrito;

    private ArrayList<Persona> personas;
    private ArrayList<Vector2> spawn;

    private Texto coord;
    private Texto informacion;

    private Rectangle esquina1;
    private Rectangle esquina2;

    private Cuadro casaMorada;
    private Cuadro casaAzul;

    private Cuadro cuadroInformacion;
    private Cuadro cuadroDinero;
    private Cuadro cuadroLimon, cuadroHielo, cuadroAzucar, cuadroVasos, cuadroJarra;
    private Cuadro marco1, marco2, marco3, marco4, marco5;
    private Texto textoCantidadLimones, textoCantidadHielo, textoCantidadAzucar, textoCantidadVasos, textoCantidadJarras;

    private float dinero;
    private int cantidadLimones, cantidadHielos, cantidadAzucar, cantidadVasos, cantidadJarras;
    private int vasosLimonada;

    private float tiempo;

    private Recursos recursos;

    private Music musica;
    private Sound sonidoDinero;

    private ArrayList<Persona> fila;

    public SuburbiosScreen(MainGame game, AssetManager manager) {
        super(game, manager);
    }

    @Override
    public void show() {

        stage = new Stage();

        fondo = new Fondo((Texture) manager.get("suburbios.png"));
        casaMorada = new Cuadro((Texture) manager.get("casamorada.png"), Gdx.graphics.getWidth() / 1.46567f, Gdx.graphics.getHeight() / 3, Gdx.graphics.getWidth() / 3.06875f, Gdx.graphics.getHeight() / 1.46341f);
        casaAzul = new Cuadro((Texture) manager.get("casaazul.png"), 0, 0, Gdx.graphics.getWidth() / 2.28372f, Gdx.graphics.getHeight() / 2);

        if (recursos.isCarritoLimon()) {
            carrito = new Carrito((Texture) manager.get("lemonadestand.png"), Gdx.graphics.getWidth() / 1.60984f, Gdx.graphics.getHeight() / 2.70f, Gdx.graphics.getWidth() / 9.82f, Gdx.graphics.getHeight() / 7f);
        } else {
            carrito = new Carrito((Texture) manager.get("carritoPrincipal.png"), Gdx.graphics.getWidth() / 1.60984f, Gdx.graphics.getHeight() / 2.8f, Gdx.graphics.getWidth() / 9.82f, Gdx.graphics.getHeight() / 6f);
        }

        spawn = new ArrayList<Vector2>();
        spawn.add(new Vector2(Gdx.graphics.getWidth() / -21.8f, Gdx.graphics.getHeight() / 2.3f)); //Lado izquierdo de la calle superior
        spawn.add(new Vector2(Gdx.graphics.getWidth() / 1.2f, Gdx.graphics.getHeight())); //Lado derecho de la calle superior
        spawn.add(new Vector2(Gdx.graphics.getWidth() * 1.1f, Gdx.graphics.getHeight() * -0.001f)); //Lado inferior de la pantalla
        spawn.add(new Vector2(Gdx.graphics.getWidth() / 1.05f, Gdx.graphics.getHeight() / 1.31f)); //Lado derecho de la calle inferior

        generarPersonas();

        fila = new ArrayList<Persona>();

        dinero = recursos.getDinero();

        cuadroInformacion = new Cuadro((Texture) manager.get("fondo.png"), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() * 0.17f);

        cuadroLimon = new Cuadro((Texture) manager.get("limon.png"), Gdx.graphics.getWidth() * 0.05f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9);
        cuadroHielo = new Cuadro((Texture) manager.get("hielo.png"), Gdx.graphics.getWidth() * 0.2f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9);
        cuadroAzucar = new Cuadro((Texture) manager.get("azucar.png"), Gdx.graphics.getWidth() * 0.4f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9);
        cuadroVasos = new Cuadro((Texture) manager.get("vasos.png"), Gdx.graphics.getWidth() * 0.6f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9);
        cuadroJarra = new Cuadro((Texture) manager.get("jarra.png"), Gdx.graphics.getWidth() * 0.8f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9);

        cantidadLimones = recursos.getLimones();
        cantidadHielos = recursos.getHielo();
        cantidadAzucar = recursos.getAzucar();
        cantidadVasos = recursos.getVasos();
        cantidadJarras = recursos.getJarras();

        vasosLimonada = 0;
        tiempo = 0;

        marco1 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() * 0.12f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9);
        marco2 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() * 0.3f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9);
        marco3 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9);
        marco4 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() * 0.7f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9);
        marco5 = new Cuadro((Texture) manager.get("marco.png"), Gdx.graphics.getWidth() * 0.9f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9);

        textoCantidadLimones = new Texto(cantidadLimones + "", Gdx.graphics.getWidth() * 0.14f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9, Color.BLACK);
        textoCantidadHielo = new Texto(cantidadHielos + "", Gdx.graphics.getWidth() * 0.32f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9, Color.BLACK);
        textoCantidadAzucar = new Texto(cantidadAzucar + "", Gdx.graphics.getWidth() * 0.52f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9, Color.BLACK);
        textoCantidadVasos = new Texto(cantidadVasos + "", Gdx.graphics.getWidth() * 0.72f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9, Color.BLACK);
        textoCantidadJarras = new Texto(cantidadJarras + "", Gdx.graphics.getWidth() * 0.92f, Gdx.graphics.getHeight() * 0.03f, Gdx.graphics.getHeight() / 9, Gdx.graphics.getHeight() / 9, Color.BLACK);

        coord = new Texto(" x: 0 ,y: 0", 0, Gdx.graphics.getHeight() / 4, Gdx.graphics.getWidth() * 4.91f, Gdx.graphics.getHeight() / 3, Color.WHITE);

        dinero = Float.parseFloat(String.valueOf(Math.round(dinero * 100d) / 100d));

        cuadroDinero = new Cuadro((Texture) manager.get("fondo.png"), 0, Gdx.graphics.getHeight() * 0.88f, Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() * 0.25f);
        informacion = new Texto("Dinero: " + dinero + "$\nTemperatura: " + recursos.getTemperatura(), Gdx.graphics.getWidth() * 0.03f, Gdx.graphics.getHeight() * 0.80f, cuadroDinero.getWidth(), cuadroDinero.getHeight(),Color.WHITE);

        //esquina1 = new Rectangle(Gdx.graphics.getWidth() / 2.2f, Gdx.graphics.getHeight() / 2.32f, Gdx.graphics.getWidth() * 0.01f, Gdx.graphics.getHeight() * 0.03f);
        //esquina2 = new Rectangle(Gdx.graphics.getWidth() / 4.4f, Gdx.graphics.getHeight() / 1.6f, Gdx.graphics.getWidth() * 0.01f, Gdx.graphics.getHeight() * 0.03f);
        esquina1 = new Rectangle(Gdx.graphics.getWidth() / 2.2f, Gdx.graphics.getHeight() / 2.32f, 1, Gdx.graphics.getHeight() * 0.015f);
        esquina2 = new Rectangle(Gdx.graphics.getWidth() / 4.4f, Gdx.graphics.getHeight() / 1.6f, 1, 1);

        musica = manager.get("overworld.mp3");
        musica.setVolume(1);
        musica.setLooping(true);
        musica.play();
        sonidoDinero = manager.get("sonidodinero.ogg");

        Gdx.input.setInputProcessor(stage);

        agregarActores();
    }

    private void agregarActores() {
        stage.clear();

        stage.addActor(fondo);
        stage.addActor(carrito);
        if (recursos.isPayaso()) {
            Cuadro payaso = new Cuadro((Texture) manager.get("payasop.png"), Gdx.graphics.getWidth() / 1.4f, Gdx.graphics.getHeight() / 3f, Gdx.graphics.getWidth() / 17f, Gdx.graphics.getHeight() / 8f);
            stage.addActor(payaso);
        }
        ordenarPersonas();
        for (int i = personas.size() - 1; i >= 0; i--) {
            stage.addActor(personas.get(i));
        }
        stage.addActor(casaMorada);
        stage.addActor(casaAzul);
        stage.addActor(cuadroDinero);
        stage.addActor(informacion);
        stage.addActor(coord);
        stage.addActor(cuadroInformacion);
        stage.addActor(cuadroLimon);
        stage.addActor(cuadroHielo);
        stage.addActor(cuadroAzucar);
        stage.addActor(cuadroVasos);
        stage.addActor(cuadroJarra);
        stage.addActor(marco1);
        stage.addActor(marco2);
        stage.addActor(marco3);
        stage.addActor(marco4);
        stage.addActor(marco5);
        stage.addActor(textoCantidadLimones);
        stage.addActor(textoCantidadHielo);
        stage.addActor(textoCantidadAzucar);
        stage.addActor(textoCantidadVasos);
        stage.addActor(textoCantidadJarras);
        ////////////////////////////////////////////////////////
        /*Texture bounds = new Texture("frame.png");
        stage.addActor(new Cuadro(bounds, esquina1.getX(), esquina1.getY(), esquina1.getWidth(), esquina1.getHeight()));
        stage.addActor(new Cuadro(bounds, esquina2.getX(), esquina2.getY(), esquina2.getWidth(), esquina2.getHeight()));*/
        ///////////////////////////////////////////////////////
    }

    private void generarPersonas() {
        personas = new ArrayList<Persona>();

        for (int i = 0; i < SuburbiosScreen.CANTIDAD_PERSONAS; i++) {
            int direccion = 3;
            int indice = 0;
            double random = Math.random();

            if (random >= 0.25 && random <= 0.5) {
                direccion = 0;
                indice = 1;
            } else if (random >= 0.5 && random <= 0.7) {
                direccion = 2;
                indice = 2;
            } else if (random >= 0.7) {
                direccion = 0;
                indice = 3;
            }

            TextureRegion textureRegion = null;
            int opcion = new Random().nextInt(7);
            switch (opcion) {
                case 0:
                    textureRegion = new TextureRegion((Texture) manager.get("persona1.png"));
                    break;
                case 1:
                    textureRegion = new TextureRegion((Texture) manager.get("persona2.png"));
                    break;
                case 2:
                    textureRegion = new TextureRegion((Texture) manager.get("persona3.png"));
                    break;
                case 3:
                    textureRegion = new TextureRegion((Texture) manager.get("persona4.png"));
                    break;
                case 4:
                    textureRegion = new TextureRegion((Texture) manager.get("persona5.png"));
                    break;
                case 5:
                    textureRegion = new TextureRegion((Texture) manager.get("persona6.png"));
                    break;
                case 6:
                    textureRegion = new TextureRegion((Texture) manager.get("persona7.png"));
                    break;
                default:
                    break;
            }

            personas.add(new Persona(textureRegion, spawn.get(indice).x, spawn.get(indice).y, Gdx.graphics.getWidth() / 19.64f, Gdx.graphics.getHeight() / 8.57143f, direccion, new Vector2(Constantes.VELOCIDAD_X_SUBURBIOS, Constantes.VELOCIDAD_Y_SUBURBIOS)));
        }
    }

    private int conteo = 0;
    private float tiempoFPS = 0;

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 2, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Para ver los fotogramas por segundo en el juego
        if (tiempoFPS >= 1) {
            int fps = conteo;
            coord.setText("FPS: " + fps);
            conteo = 0;
            tiempoFPS = 0;
        }

        //Para reordernar las personas
        if(tiempoFPS >= 0.65f){
            ordenarPersonas();
            agregarActores();
        }

        conteo++;
        tiempoFPS += delta;

        manejarJuego();
        manejarColisiones();
        manejarEntrada();
        manejarTiempo(delta);

        stage.act(delta);
        stage.draw();
    }

    private void manejarTiempo(float delta) {
        //Si el tiempo supera los 100 segundos el día termina
        if (tiempo >= 100) {
            musica.stop();
            RecetaScreen recetaScreen = new RecetaScreen(game, manager);
            recursos.setLimones(cantidadLimones);
            recursos.setAzucar(cantidadAzucar);
            recursos.setHielo(0);
            recursos.setDinero(dinero);
            recursos.setVasos(cantidadVasos);
            recetaScreen.setRecursos(recursos);
            game.setScreen(recetaScreen);
        } else {
            tiempo += delta;
        }
    }

    private void manejarJuego() {
        controlarVentaLimonada();
    }

    private void ordenarPersonas() {
        //Algoritmo de ordenamiento
        Persona aux;
        int min;
        for (int i = 0; i < personas.size(); i++) {
            min = i;
            for (int j = i + 1; j < personas.size(); j++) {
                if (personas.get(j).getY() < personas.get(min).getY()) {
                    min = j;
                }
            }
            aux = personas.get(i);
            personas.set(i, personas.get(min));
            personas.set(min, aux);
        }
    }

    private void controlarVentaLimonada() {
        if (cantidadJarras == 0) {
            //Si ya no tenemos jarras de limonada hay que prepararla
            if (carrito.isPrepararLimonada()) {
                //Si estamos preparando limonada comprobamos si ya está lista
                if (carrito.isLimonadaLista()) {
                    //Si está aumentamos a 1 la cantidad de jarras
                    carrito.setPrepararLimonada(false);
                    carrito.setLimonadaLista(false);
                    textoCantidadJarras.setText(++cantidadJarras + "");
                    vasosLimonada = 5;
                }
            } else {
                //Si tenemos los recursos necesarios creamos una nueva jarra de limonada
                if (cantidadLimones - recursos.getReceta().getLimones() >= 0 && cantidadAzucar - recursos.getReceta().getAzucar() >= 0 && cantidadHielos - recursos.getReceta().getHielo() >= 0) {
                    carrito.setPrepararLimonada(true);
                    cantidadLimones -= recursos.getReceta().getLimones();
                    cantidadAzucar -= recursos.getReceta().getAzucar();
                    cantidadHielos -= recursos.getReceta().getHielo();
                    cantidadVasos -= 5;

                    textoCantidadLimones.setText(cantidadLimones + "");
                    textoCantidadHielo.setText(cantidadHielos + "");
                    textoCantidadAzucar.setText(cantidadAzucar + "");
                    textoCantidadVasos.setText(cantidadVasos + "");
                }
            }
        } else {
            //Si hay al menos una persona haciendo fila empezamos la venta
            if (fila.size() != 0) {
                //Comprobamos si tenemos limonada disponible
                if (vasosLimonada > 0) {
                    //Aqui vendemos una limonada
                    if (carrito.isVentaRealizada() && !fila.get(0).getHaCompradoLimonada()) {
                        sonidoDinero.play();

                        carrito.setVentaRealizada(false);
                        carrito.setVendiendoLimonada(false);

                        //La persona que ya compró elige una dirección nueva por la que irse
                        double probabilidad = Math.random();
                        int direccion;

                        if (probabilidad < 0.25) {
                            direccion = 2;
                        } else if (probabilidad < 0.5) {
                            direccion = 1;
                        } else if (probabilidad < 0.7) {
                            direccion = 0;
                        } else {
                            direccion = 0;
                        }

                        fila.get(0).setDireccion(direccion);
                        fila.get(0).setEstaQuieto(false);

                        dinero += recursos.getPrecioVasoLimonada();

                        //Sacamos a la persona de la fila
                        fila.get(0).setHaCompradoLimonada(true);
                        fila.remove(fila.get(0));

                        informacion.setText("Dinero: " + String.format("%.2f", dinero) + "$ Temperatura: " + recursos.getTemperatura() + " ºC");
                        vasosLimonada--;
                    } else {
                        carrito.setVendiendoLimonada(true);
                    }
                } else {
                    cantidadJarras = 0;
                    textoCantidadJarras.setText("0");
                    carrito.setVendiendoLimonada(false);
                }
            }
        }

        //Si la persona espera mucho se va
        for (int i = 0; i < fila.size(); i++) {
            if (!fila.get(i).estaQuieto()) {
                carrito.setVentaRealizada(false);
                carrito.setVendiendoLimonada(false);

                if (Math.random() > 0.5) {
                    fila.get(i).setDireccion(1);
                } else {
                    fila.get(i).setDireccion(2);
                }
                fila.get(i).setEstaQuieto(false);

                fila.get(i).setHaCompradoLimonada(true);
                fila.remove(fila.get(i));
            }
        }
    }

    private void manejarColisiones() {
        for (int i = 0; i < personas.size(); i++) {
            //Para que si una persona ha chocado con una esquina cambie su dirección
            if (!personas.get(i).haColisionado() && esquina1.overlaps(personas.get(i).getRectangulo())) {
                int direccion = 0;

                //Para cambiar de dirección y evitar que la persona vuelva por donde vino
                do {
                    double probabilidad = Math.random();
                    if (probabilidad < 0.25) {
                        direccion = 3;
                    } else if (probabilidad < 0.5) {
                        direccion = 1;
                    } else if (probabilidad < 0.7) {
                        direccion = 2;
                    } else {
                        direccion = 0;
                    }
                } while ((personas.get(i).getDireccion() == 0 && direccion == 3) || (personas.get(i).getDireccion() == 1 && direccion == 2) || (personas.get(i).getDireccion() == 2 && direccion == 1) ||(personas.get(i).getDireccion() == 3 && direccion == 0));

                personas.get(i).setDireccion(direccion);
                personas.get(i).setHaColisionado(true);
            }//Por si choca con la otra esquina
            else if (!personas.get(i).haColisionado() && esquina2.overlaps(personas.get(i).getRectangulo())) {

                int direccion = 0;

                //Para cambiar de dirección y evitar que la persona vuelva por donde vino
                do {
                    double probabilidad = Math.random();
                    if (probabilidad < 0.25) {
                        direccion = 3;
                    } else if (probabilidad < 0.5) {
                        direccion = 1;
                    } else if (probabilidad < 0.7) {
                        direccion = 3;
                    } else {
                        direccion = 0;
                    }
                } while ((personas.get(i).getDireccion() == 0 && direccion == 3) || (personas.get(i).getDireccion() == 2 && direccion == 1) ||(personas.get(i).getDireccion() == 3 && direccion == 0));

                personas.get(i).setDireccion(direccion);
                personas.get(i).setHaColisionado(true);
            } else if (!(esquina1.overlaps(personas.get(i).getRectangulo()) || esquina2.overlaps(personas.get(i).getRectangulo()))) {
                //Si no está chocando con ninguna esquina ponemos su atributo haColisionado en falso para evitar errores
                personas.get(i).setHaColisionado(false);
            }

            //Para que si una persona salió de la pantalla se reinicie su posición y sus atributos
            if ((personas.get(i).getX() > Gdx.graphics.getWidth() * 1.3 || personas.get(i).getX() < Gdx.graphics.getWidth() * -0.3) || (personas.get(i).getY() > Gdx.graphics.getHeight() * 1.3 || personas.get(i).getY() < Gdx.graphics.getHeight() * -0.3)) {
                int indice = new Random().nextInt(spawn.size());
                int direccion = 0;
                if (indice == 2) {
                    direccion = 2;
                }

                personas.get(i).setDinero(Float.parseFloat(String.valueOf(Math.random() * 20)));
                if (Math.random() <= 0.60f) {
                    personas.get(i).setSediento(true);
                } else {
                    personas.get(i).setSediento(false);
                }
                personas.get(i).setHaCompradoLimonada(false);
                personas.get(i).setPosition(spawn.get(indice).x, spawn.get(indice).y);
                personas.get(i).setDireccion(direccion);
                personas.get(i).setHaColisionado(false);
                personas.get(i).setTiempoInicio((int) Math.random() * 20);
                personas.get(i).setTiempo(0);
            }

            //Para que una persona compre limonada si está colisionando con el carrito y cumple los requisitos
            if (personas.get(i).getRectangulo().overlaps(carrito.getRectangulo()) && !personas.get(i).estaComprandoLimonada()) {
                if (personas.get(i).isSediento() && personas.get(i).getDinero() >= recursos.getPrecioVasoLimonada()) {
                    personas.get(i).setDireccion(3);
                    personas.get(i).setEstaQuieto(true);
                    personas.get(i).setEstaComprandoLimonada(true);
                    personas.get(i).setX(personas.get(i).getX() - fila.size() * 15 * personas.get(i).getVelocidad().x);
                    personas.get(i).setY(personas.get(i).getY() - fila.size() * 15 * personas.get(i).getVelocidad().y);
                    fila.add(personas.get(i));
                }
            }
        }
    }

    private void manejarEntrada() {
        if (Gdx.input.isTouched()) {
            coord.setText("X: " + Gdx.input.getX() + "\nY: " + (Gdx.graphics.getHeight() - Gdx.input.getY()) + "\nAncho: " + Gdx.graphics.getWidth() + "\nAlto: " + Gdx.graphics.getHeight());
        }
    }

    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
    }

    @Override
    public void dispose() {
        stage.dispose();
        game.dispose();
        manager.dispose();
        fondo.getTextura().dispose();
        carrito.getTexture().dispose();
        casaMorada.getTextura().dispose();
        casaAzul.getTextura().dispose();
        musica.dispose();
        sonidoDinero.dispose();
        cuadroInformacion.getTextura().dispose();
        cuadroDinero.getTextura().dispose();
        cuadroLimon.getTextura().dispose();
        cuadroHielo.getTextura().dispose();
        cuadroAzucar.getTextura().dispose();
        cuadroVasos.getTextura().dispose();
        cuadroJarra.getTextura().dispose();
        marco1.getTextura().dispose();
        marco2.getTextura().dispose();
        marco3.getTextura().dispose();
        marco4.getTextura().dispose();
        marco5.getTextura().dispose();
    }

}