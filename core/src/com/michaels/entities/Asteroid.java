package com.michaels.entities;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.michaels.gamestates.PlayState;
import com.michaels.main.Collision;


/**
 * Created by MichaelSjogren on 2016-08-23.
 */
public class Asteroid extends SpaceEntity {

    public static final int LARGE = 0;
    public static final int MEDIUM = 1;
    public static final int SMALL = 3;


    private final int randomDir;
    private final int size;
    private final Collision collision;
    private int orginX , orginY;
    private Sprite asteroid;
    private Player player;




    public Asteroid(float x, float y, int size, Player player){
        this.x = x;
        this.y = y;
        this.size = size;
        this.player = player;

        switch (size)
        {
            case LARGE: asteroid = new Sprite(new Texture("asteroid-large.png"));
                speed = MathUtils.random(30,75);
                break;
            case MEDIUM: asteroid = new Sprite(new Texture("asteroid-medium.png"));
                speed = MathUtils.random(75,130);
                break;

            case SMALL:  asteroid = new Sprite(new Texture("asteroid_small.png"));
                speed = MathUtils.random(130,150);
                break;
            default: break;
        }

        width = asteroid.getWidth();
        height = asteroid.getHeight();

        rotSpeed = MathUtils.random(-5f,5f);
        orginX = asteroid.getTexture().getWidth() / 2;
        orginY = asteroid.getTexture().getHeight() / 2;
        randomDir = MathUtils.random(360);

        dx =  speed * MathUtils.cos(MathUtils.degreesToRadians *  randomDir );
        dy =  speed * MathUtils.sin(MathUtils.degreesToRadians *  randomDir );
        collision = new Collision(width , height);
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

            asteroid.setRotation(asteroid.getRotation() + rotSpeed);
            x += dx * dt;
            y += dy * dt;
            asteroidOnAsteroidCol();
    }

    private void asteroidOnAsteroidCol(){
        for (int i = 0; i < PlayState.asteroids.size(); i++)
        {
            Asteroid asteroid = PlayState.asteroids.get(i);
            if(this != asteroid){
                if(collision.checkCollision(x,y,asteroid.getX(), asteroid.getY() ,
                        asteroid.getW(),asteroid.getH()))
                {
                    System.out.println("asteroid on asteroid");


                }
            }

        }
    }

    public void destroy() {
        player = null;
        asteroid.getTexture().dispose();
        switch (size){
            case LARGE:

                for (int i = 0; i < 2; i ++){

                    PlayState.asteroids.add(new Asteroid(x,y,MEDIUM,player));
                }
                break;
            case MEDIUM:
                for (int i = 0; i < 2; i ++){
                    PlayState.asteroids.add(new Asteroid(x,y,SMALL,player));
                }
                break;

            case SMALL:

                break;
            default: break;
        }
    }
}

