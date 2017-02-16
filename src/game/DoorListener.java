/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *
 * @author Rojel
 */
public class DoorListener implements CollisionListener {

    private Game game;

    /**
     *
     * @param game
     */
    public DoorListener(Game game) {
        this.game = game;
    }

    /**
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        Fish player = game.getPlayer();

        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }
}
