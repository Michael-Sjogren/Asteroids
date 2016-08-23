package com.michaels.entities;


import com.badlogic.gdx.Gdx;
import com.michaels.main.Game;

/**
 * Created by MichaelSjogren on 2016-08-21.
 */
public abstract class SpaceEntity {

   protected float x;
   protected float y;

   protected float dx;
   protected float dy;

   protected float speed;
   protected float rotSpeed;

   protected float width;
   protected float height;

    protected void wrap() {
        if(x < 0) x = Gdx.graphics.getWidth();
        if(x > Gdx.graphics.getWidth()) x = 0;

        if(y < 0) y = Gdx.graphics.getHeight();
        if(y > Gdx.graphics.getHeight()) y = 0;
    }

    public float getW(){
        return width;
    }

    public float getH(){
        return height;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public float getDx(){
        return dx;
    }

    public float getDy(){
        return dy;
    }

    public float getSpeed(){return speed;}

    public void setSpeed(float speed){this.speed = speed;}

    public void setDx(float dx){
        this.dx = dx;
    }

    public void setDy(float dy){
        this.dy = dy;
    }


    public void setRotSpeed(float rotSpeed) {
        this.rotSpeed = rotSpeed;
    }


    public abstract void destroy();
}
