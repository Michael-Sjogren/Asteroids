package com.michaels.main;

import com.badlogic.gdx.math.MathUtils;
import com.michaels.entities.Asteroid;
import com.michaels.entities.Bullet;
import com.michaels.entities.Player;
import com.michaels.entities.SpaceEntity;
import com.michaels.gamestates.PlayState;
import javafx.geometry.Dimension2D;

import java.util.ArrayList;

/**
 * Created by Michael-Sjogren on 2016-07-21.
 */
public class BBox {

    /** for moving collision objects such as bullets and other things**/
    public static boolean checkProjectileCollision(double minX, double maxX, double minY, double maxY , SpaceEntity entity){

        // checks for asteroid on asteroid collision
        for (Asteroid e : PlayState.asteroids){
            // prevent checking of itself if its an asteroid
            if(entity != e){
                // basic rectangular collision check
                if(maxX >= e.getX() && minX <= e.getX() + e.getW() && maxY >= e.getY() && minY <= e.getY() + e.getH() )
                {
                    if(!(entity instanceof  Asteroid )){
                        e.destroy();
                    }
                        // get prev direction
                        float prevDx = entity.getDx();
                        float prevDy = entity.getDy();
                        // we don't want player to affect asteroid


                            entity.setDx(e.getDx());
                            entity.setDy(e.getDy());
                            e.setDx(prevDx);
                            e.setDy(prevDy);

                            // if collide change speed of the object
                            entity.setSpeed(MathUtils.random(entity.getSpeed()  , entity.getSpeed() - 50));
                            // if collide change speed of the other object
                            e.setSpeed(MathUtils.random(e.getSpeed()  , e.getSpeed() - 50));
                            // change rotation speed
                        return true;
                }
            }
        }

        return false;
    }

}
