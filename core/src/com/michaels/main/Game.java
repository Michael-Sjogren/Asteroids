package com.michaels.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.michaels.managers.GameInputProcessor;
import com.michaels.managers.GameStateManager;

public class Game extends ApplicationAdapter {
    SpriteBatch batch;

    public static final String TITLE = "Asteroids";
    public static final int V_WIDTH = 500;
    public static final int V_HEIGHT = 400;
    public static final int SCALE = 2;
    Texture img;

    // camera
    public static OrthographicCamera camera;
    // gamestate
    private GameStateManager gsm;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(V_WIDTH, V_HEIGHT);
        camera.translate(V_WIDTH / 2, V_HEIGHT / 2);
        camera.update();
        gsm = new GameStateManager();
        Gdx.input.setInputProcessor(new GameInputProcessor());
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void render() {
        checkKeyPressed();
        // clears screen to black
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // update game
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.draw();
    }

    @Override
    public void dispose() {

    }

    private void checkKeyPressed(){

    }
}

