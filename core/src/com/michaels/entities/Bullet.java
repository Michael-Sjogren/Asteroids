package com.michaels.entities;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.collision.BoundingBox;
import com.michaels.main.BBox;
import javafx.geometry.Bounds;

/**
 * Created by MichaelSjogren on 2016-08-23.
 */
public class Bullet extends SpaceEntity {


    private float radians;
    private float lifeTime;
    private float lifeTimer;
    private boolean remove = false;
    private Sprite bullet;

    public Bullet(float x , float y , float radians ){
        this.x = x;
        this.y = y;
        this.radians = radians;

        float speed = 400;
        dx = MathUtils.cos(radians) * speed;
        dy = MathUtils.sin(radians) * speed;

        width = 2;
        height = 2;


        lifeTimer = 0;
        lifeTime = 1;

        bullet = new Sprite(new Texture("bullet.png"));
    }

    public boolean shouldRemove(){return remove;}

    public void draw(SpriteBatch sb){
        sb.draw(bullet,x  ,y);

    }

    public void update(float dt){
        x += dx * dt;
        y += dy * dt;
        BBox.checkProjectileCollision(x,x+width,y,y+height,this);
        wrap();
        lifeTimer += dt;
        if(lifeTimer > lifeTime){
            remove = true;
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
