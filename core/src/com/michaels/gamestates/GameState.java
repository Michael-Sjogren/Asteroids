package com.michaels.gamestates;

import com.michaels.managers.GameStateManager;

/**
 * Created by MichaelSjogren on 2016-08-21.
 */
public abstract class GameState {

    protected GameStateManager gsm;

    protected GameState(GameStateManager gsm){
        this.gsm = gsm;
    }
    // initialize state
    public abstract void init();
    // update state
    public abstract void update(float dt);
    // draw state
    public abstract void draw();
    // updates game keys
    // this gets called when we cant to get rid of this gameState
    public abstract void dispose();


}
