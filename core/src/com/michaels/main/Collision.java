package com.michaels.main;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Timer;
import com.michaels.entities.Asteroid;
import com.michaels.entities.Bullet;
import com.michaels.entities.Player;
import com.michaels.entities.SpaceEntity;
import com.michaels.gamestates.PlayState;
import javafx.geometry.Dimension2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by Michael-Sjogren on 2016-07-21.
 */
public class Collision
{

    private Rectangle r1 ,r2;

    public Collision(float width , float height)
    {
        r1 = new Rectangle();
        r2 = new Rectangle();
        r1.setWidth(width);
        r1.setHeight(height);
    }
    /**
     * for moving collision objects such as bullets and other things
     **/
    public boolean checkCollision(float x, float y, float otherX , float otherY , float otherWidth , float otherHeight) {
        r2.setWidth(otherWidth);
        r2.setHeight(otherHeight);
        r1.setX(x);
        r1.setY(y);
        r2.setX(otherX);
        r2.setY(otherY);

        if(Intersector.overlaps(r1,r2))
        {
            return true;
        }
        return false;
    }


}
