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
public class DoorListener2 implements CollisionListener {

    private Game2 game2;

    /**
     *
     * @param game2
     */
    public DoorListener2(Game2 game2) {

        this.game2 = game2;
    }

    /**
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        Player2 player2 = game2.getPlayer2();
        Fish fish = game2.getPlayer();

        if ((e.getOtherBody() == fish || e.getOtherBody() == player2) && game2.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game2.goNextLevel();
        }
    }
}
