package com.michaels.managers;
import com.michaels.gamestates.GameState;
import com.michaels.gamestates.MenuState;
import com.michaels.gamestates.PlayState;

/**
 * Created by MichaelSjogren on 2016-08-21.
 */
public class GameStateManager {

    // current gamestate
    private GameState gameState;

    public static final int MENU = 0;
    public static final int PLAY = 1;

    public GameStateManager()
    {
        setGameState(PLAY);
    }

    public void setGameState(int state)
    {
        if (gameState != null) {
            gameState.dispose();
        }

        switch (state)
        {
            case MENU:
                gameState = new MenuState(this);
                gameState.init();
                break;
            case PLAY:
                gameState = new PlayState(this);
                gameState.init();
                break;
        }
    }


    public void update(float dt)
    {
        gameState.update(dt);
    }

    public void draw(){
        gameState.draw();
    }
}


