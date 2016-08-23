package com.michaels.managers;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;


/**
 * Created by MichaelSjogren on 2016-08-21.
 */
public class GameInputProcessor extends InputAdapter {

    public static boolean up  = false;
    public static boolean left   = false;
    public static boolean right = false ;
    public static boolean down  = false;

    public static boolean enter  =  false ;
    public static boolean escape = false;
    public static boolean space  = false;
    public static boolean shift  = false;

    @Override
    public boolean keyDown(int keycode) {

        /** sets variables that are continuously polled by render method **/
        if(Input.Keys.W == keycode){
            up = true;
        }
        if(Input.Keys.S == keycode){
            down = true;
        }
        if(Input.Keys.A == keycode){
            left = true;
        }
        if(Input.Keys.D == keycode){
            right = true;
        }
        if(Input.Keys.ENTER == keycode){
            enter = true;
        }
        if(Input.Keys.SPACE == keycode){
            space = true;
        }
        if(Input.Keys.ESCAPE == keycode){
            escape = true;
        }
        if(Input.Keys.SHIFT_LEFT == keycode){
            shift = true;
        }
        /** **/
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        /** sets variables that are continuously polled by render method **/
        if(Input.Keys.W == keycode){
             up  = false;
        }
        if(Input.Keys.S == keycode){
            down  = false;
        }
        if(Input.Keys.A == keycode){
            left  = false;
        }
        if(Input.Keys.D == keycode){
            right = false;
        }
        if(Input.Keys.ENTER == keycode){
            enter = false;
        }
        if(Input.Keys.SPACE == keycode){
            space = false;
        }
        if(Input.Keys.ESCAPE == keycode){
            escape = false;
        }
        if(Input.Keys.SHIFT_LEFT == keycode){
            shift = false;
        }
        /** **/
        return false;
    }

}
