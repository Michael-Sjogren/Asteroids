package com.michaels.gamestates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.michaels.entities.Asteroid;
import com.michaels.entities.Bullet;
import com.michaels.entities.Player;

import com.michaels.managers.GameStateManager;

import java.util.ArrayList;

/**
 * Created by MichaelSjogren on 2016-08-21.
 */
public class PlayState extends GameState {

    private SpriteBatch sb;
    private Player player;

    private int level;
    private int totalAsteroids;
    private int numAsteroidsLeft;


    public static ArrayList<Asteroid> asteroids = new ArrayList<>();
    private ArrayList<Bullet> enemyBullets = new ArrayList<>();

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        level = 1;
        sb = new SpriteBatch();
        ArrayList<Bullet> bullets = new ArrayList<>();
        player = new Player(bullets);
        spawnAsteroids();
    }

    private void spawnAsteroids() {
        asteroids.clear();
        int numberToSpawn = 4 + level - 1;
        for (int i = 0; i < numberToSpawn; i++) {

            float x = MathUtils.random(Gdx.graphics.getWidth());
            float y = MathUtils.random(Gdx.graphics.getHeight());

            float dx = x - player.getX();
            float dy = y - player.getY();

            float dist = (float) Math.sqrt(dx * dx + dy * dy);

            do {
                x = MathUtils.random(Gdx.graphics.getWidth());
                y = MathUtils.random(Gdx.graphics.getHeight());

            } while (dist < 100);

            asteroids.add(new Asteroid(x, y, Asteroid.LARGE, player));
        }
    }

    @Override
    public void update(float dt) {
        player.update(dt);
        for (Asteroid e : asteroids){
            e.update(dt);
        }

    }

    @Override
    public void draw() {
        player.draw(sb);

        for (Asteroid e : asteroids){
            e.draw(sb);
        }
    }


    @Override
    public void dispose() {

    }
}
