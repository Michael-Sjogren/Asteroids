package com.michaels.entities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.michaels.main.Game;
import com.michaels.managers.GameInputProcessor;

import java.util.ArrayList;


/**
 * Created by MichaelSjogren on 2016-08-21.
 */
public class Player extends SpaceEntity {

    private static final int MAX_BULLETS = 4;
    private float maxSpeed;
    private float accel;
    private float decel;
    private Sprite playerSprite;
    private int orginX , orginY;
    private float degrees = 90;
    private ArrayList<Bullet> bullets;

    public Player(ArrayList<Bullet> bullets){
        this.bullets = bullets;

        x = Game.V_WIDTH;
        y = Game.V_HEIGHT;

        maxSpeed = 300;
        accel = 230;
        decel = 15;
        rotSpeed = 3.f;
        
        // effect

        playerSprite = new Sprite(new Texture("space-ship.png"));
        orginX = playerSprite.getTexture().getWidth() / 2;
        orginY = playerSprite.getTexture().getHeight() / 2;
    }




    public void update(float dt){

            handleLInput();
            move(dt);
            wrap();
            // update player bullets
            for(Bullet b : bullets){
                b.update(dt);
            }

    }


    public void draw(SpriteBatch sb){
                sb.setColor(1,1,1,1);
                sb.begin();
                for(int i = 0; i < bullets.size(); i++){
                    bullets.get(i).draw(sb);

                    if(bullets.get(i).shouldRemove()){
                        bullets.remove(bullets.get(i));
                        i --;
                    }
                }
                sb.draw(playerSprite, x - orginX , y - orginY, orginX, orginY, 32, 32, 1, 1, playerSprite.getRotation());
                sb.end();

    }

    public void move(float dt){


        if(GameInputProcessor.up){
            dx += accel * Math.cos(MathUtils.degreesToRadians * degrees) * dt;
            dy += accel * Math.sin(MathUtils.degreesToRadians * degrees) * dt;
        }

        if(GameInputProcessor.right){
            playerSprite.rotate(-rotSpeed);
            degrees -= rotSpeed;

            if(degrees < 0){
                degrees = 360;
            }
        }
        if(GameInputProcessor.left){
            playerSprite.rotate(rotSpeed);
            degrees += rotSpeed;
            if(degrees > 360){
                degrees = 0;
            }
        }

        // deceleration
        float length = (float) Math.sqrt(dx*dx + dy* dy);
        if(length > 0){
            dx -= (dx / length) * decel * dt;
            dy -= (dy / length) * decel * dt;
        }
        if(length > maxSpeed){
            dx =  (dx/ length) * maxSpeed;
            dy =  (dy/ length) * maxSpeed;
        }
        x += dx * dt;
        y += dy * dt;
    }

    public void shoot(){
        if(bullets.size() < MAX_BULLETS){
            float radians = degrees* MathUtils.degreesToRadians;
            bullets.add(new Bullet(x,y,radians));
        }
    }

    public void handleLInput(){
      //  System.out.println(radians);
        if(Gdx.input.isKeyJustPressed(Input.Keys.W)){

        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.S)){

        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){

        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){

        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                shoot();
        }

    }

    @Override
    public float getW() {
        return width;
    }

    @Override
    public float getH() {
        return height;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void destroy() {

    }
}
