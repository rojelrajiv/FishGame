package game;

import city.cs.engine.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import org.jbox2d.common.Vec2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rojel
 */
public class Level4P2 extends GameLevel2 {

    private static final int NUM_FISHES = 6;
    private static final int NUM_BLUE = 50;
    private static final int NUM_ORANGE = 50;

    /**
     *
     * @param game
     */
    public void populate(Game2 game) {
        super.populate(game);

        {
            CyanPlatform cp = new CyanPlatform(this);
            cp.setPosition(new Vec2(-14, 5));
            cp.addCollisionListener(new Pickup(getPlayer()));
            cp.addCollisionListener(new Pickup2(getPlayer2()));
        }
        {
            RedPlatform cp2 = new RedPlatform(this);
            cp2.setPosition(new Vec2(18, -2.5f));
            cp2.addCollisionListener(new Pickup(getPlayer()));
            cp2.addCollisionListener(new Pickup2(getPlayer2()));

        }

        {
            OrangePlatform op = new OrangePlatform(this);
            op.setPosition(new Vec2(10, 6.4f));
            op.addCollisionListener(new Pickup2(getPlayer2()));
        }
        {
            RedPlatform rp = new RedPlatform(this);
            rp.setPosition(new Vec2(2, 1f));
            rp.addCollisionListener(new Pickup(getPlayer()));
            rp.addCollisionListener(new Pickup2(getPlayer2()));
        }
        {
            BluePlatform bp = new BluePlatform(this);
            bp.setPosition(new Vec2(-17, -2f));
            bp.addCollisionListener(new Pickup(getPlayer()));
        }

        {
            OrangePlatform op2 = new OrangePlatform(this);
            op2.setPosition(new Vec2(-17, -9f));
            op2.addCollisionListener(new Pickup2(getPlayer2()));
        }

        {
            BluePlatform bp2 = new BluePlatform(this);
            bp2.setPosition(new Vec2(10, -7f));
            bp2.addCollisionListener(new Pickup(getPlayer()));
        }
        {
            RedPlatform rp2 = new RedPlatform(this);
            rp2.setPosition(new Vec2(-5, -4f));
            rp2.addCollisionListener(new Pickup(getPlayer()));
            rp2.addCollisionListener(new Pickup2(getPlayer2()));
        }
        
                    JOptionPane.showMessageDialog(null, "Ready? Press okay to start level. ", "Level 4", JOptionPane.INFORMATION_MESSAGE);

        /**
         * A for Loop is used to create multiple instances of the class
         * FishFood, Poison and SpikeObject For every time i is increased by one
         * a new instance is created and the item is spawned in the game world A
         * collision listener has been added in which these item react with the
         * main class call Fish through the pickup class
         */
        {
            for (int i = 0; i < 6; i++) {
                Body poison = new Poison(this);
                poison.setPosition(new Vec2(i * 2 - 10, (float) Math.random() * 20.0f - 10.0f));
                poison.addCollisionListener(new Pickup(getPlayer()));
                poison.addCollisionListener(new Pickup2(getPlayer2()));
            }
        }

        {
            for (int i = 0; i < 4; i++) {
                Body grenade = new Grenade(this);
                grenade.setPosition(new Vec2(i * 2 - 10, (float) Math.random() * 20.0f - 10.0f));
                grenade.addCollisionListener(new Pickup(getPlayer()));
                grenade.addCollisionListener(new Pickup2(getPlayer2()));
            }
        }

        {
            for (int i = 0; i < NUM_FISHES; i++) {
                Body fishFood = new FishFood(this);
                fishFood.setPosition(new Vec2(i * 2 - 10, (float) Math.random() * 20.0f - 10.0f));
                fishFood.addCollisionListener(new Pickup(getPlayer()));
                fishFood.addCollisionListener(new Pickup2(getPlayer2()));
            }
        }

        {

            P1PowerUp pb1 = new P1PowerUp(this);
            pb1.setPosition(new Vec2(18, -2.5f));
            pb1.addCollisionListener(new Pickup(getPlayer()));

        }

        {

            P1PowerUp pb2 = new P1PowerUp(this);
            pb2.setPosition(new Vec2(10, 6.4f));
            pb2.addCollisionListener(new Pickup(getPlayer()));

        }
        {

            P1PowerUp pb3 = new P1PowerUp(this);
            pb3.setPosition(new Vec2(10, -7f));
            pb3.addCollisionListener(new Pickup(getPlayer()));

        }
        {

            P1PowerUp pb4 = new P1PowerUp(this);
            pb4.setPosition(new Vec2(-14, 5f));
            pb4.addCollisionListener(new Pickup(getPlayer()));

        }
        {

            P1PowerUp pb5 = new P1PowerUp(this);
            pb5.setPosition(new Vec2(2, 1f));
            pb5.addCollisionListener(new Pickup(getPlayer()));

        }

        {

            P2PowerUp po1 = new P2PowerUp(this);
            po1.setPosition(new Vec2(2, 1f));
            po1.addCollisionListener(new Pickup2(getPlayer2()));

        }
        {

            P2PowerUp po2 = new P2PowerUp(this);
            po2.setPosition(new Vec2(-15, -9f));
            po2.addCollisionListener(new Pickup2(getPlayer2()));

        }
        {

            P2PowerUp po3 = new P2PowerUp(this);
            po3.setPosition(new Vec2(-5, -4.5f));
            po3.addCollisionListener(new Pickup2(getPlayer2()));

        }
        {

            P2PowerUp po4 = new P2PowerUp(this);
            po4.setPosition(new Vec2(-14, 5f));
            po4.addCollisionListener(new Pickup2(getPlayer2()));

        }
        {

            P2PowerUp po5 = new P2PowerUp(this);
            po5.setPosition(new Vec2(-5, -4f));
            po5.addCollisionListener(new Pickup2(getPlayer2()));

        }

    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-24, 11);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getFishFoodCount() == NUM_FISHES
                && getPlayer2().getFishFoodCount2() == NUM_FISHES
                && getPlayer().getBlueScore() == NUM_BLUE
                && getPlayer2().getOrangeScore() == NUM_ORANGE;
    }

    /**
     *
     * @return
     */
    @Override
    public Vec2 startPosition2() {
        return new Vec2(-2, -10);
    }
}
