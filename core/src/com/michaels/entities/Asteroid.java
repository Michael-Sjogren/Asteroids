package com.michaels.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.michaels.gamestates.PlayState;
import com.michaels.main.BBox;

/**
 * Created by MichaelSjogren on 2016-08-23.
 */
public class Asteroid extends SpaceEntity {

    public static final int LARGE = 0;
    public static final int MEDIUM = 1;
    public static final int SMALL = 3;


    private final int randomDir;
    private final int size;
    private int orginX , orginY;
    private double degrees;
    private Sprite asteroid;
    private Player player;


    public Asteroid(float x, float y, int size, Player player){
        this.x = x;
        this.y = y;
        this.size = size;
        this.player = player;

        switch (size)
        {
            case LARGE: asteroid = new Sprite(new Texture("asteroid-large.png")); break;
            case MEDIUM: asteroid = new Sprite(new Texture("asteroid-medium.png")); break;
            case SMALL:  asteroid = new Sprite(new Texture("asteroid_small.png")); break;
            default: break;
        }




        width = asteroid.getWidth();
        height = asteroid.getHeight();
        System.out.println("Asteroid with: " + width);
        System.out.println("Asteroid height: " + height);

        rotSpeed = MathUtils.random(-5f,5f);
        orginX = asteroid.getTexture().getWidth() / 2;
        orginY = asteroid.getTexture().getHeight() / 2;
        randomDir = MathUtils.random(360);
        speed = MathUtils.random(50,230);

        dx =  speed * MathUtils.cos(MathUtils.degreesToRadians *  randomDir );
        dy =  speed * MathUtils.sin(MathUtils.degreesToRadians *  randomDir );
    }

    public void update(float dt){
        // handleLInput();
        move(dt);
        wrap();

    }


    public void draw(SpriteBatch sb){
        sb.setColor(1,1,1,1);
        sb.begin();
        sb.draw(asteroid, x , y , orginX, orginY, width, height, 1, 1, asteroid.getRotation());
        sb.end();
    }

    public void move(float dt){
        // deceleration
            BBox.checkProjectileCollision(x , x + width , y , y + height , this);
            asteroid.setRotation(asteroid.getRotation() + rotSpeed);
            x += dx * dt;
            y += dy * dt;
    }

    public void destroy() {
        switch (size){
            case LARGE:
                for (int i = 0; i < 2; i ++){
                    PlayState.asteroids.add(new Asteroid(x,y,MEDIUM,player));
                    System.out.println("TO MEDIUM");
                }
                break;
            case MEDIUM:
                for (int i = 0; i < 2; i ++){
                    PlayState.asteroids.add(new Asteroid(x,y,SMALL,player));
                    System.out.println("TO SMALL");
                }
                break;

            case SMALL: break;
            default: break;
        }
    }
}

