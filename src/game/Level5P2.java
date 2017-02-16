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
public class Level5P2 extends GameLevel2 {

    private static final int NUM_FISHES = 6;
    private static final int NUM_BLUE = 40;
    private static final int NUM_ORANGE = 40;


    /**
     *
     * @param game
     */
    public void populate(Game2 game) {
        super.populate(game);
        { // make platforms
            Shape shape = new BoxShape(20, 0.2f);
            Body platform1 = new StaticBody(this, shape);
            platform1.setPosition(new Vec2(-14, 5));
            platform1.setFillColor(Color.blue);
            platform1.setLineColor(Color.blue);
        }
        {
            CyanPlatform cp = new CyanPlatform(this);
            cp.setPosition(new Vec2(18, 3.0f));
            cp.addCollisionListener(new Pickup(getPlayer()));
            cp.addCollisionListener(new Pickup2(getPlayer2()));

        }

        {

            BluePlatform bp = new BluePlatform(this);
            bp.setPosition(new Vec2(2, 1f));
            bp.addCollisionListener(new Pickup(getPlayer()));

        }
        {
            BluePlatform bp2 = new BluePlatform(this);
            bp2.setPosition(new Vec2(-17, -2f));
            bp2.addCollisionListener(new Pickup(getPlayer()));

        }

        {
            OrangePlatform op = new OrangePlatform(this);
            op.setPosition(new Vec2(-15, -9f));
            op.addCollisionListener(new Pickup2(getPlayer2()));

        }

        {
            RedPlatform rp = new RedPlatform(this);
            rp.setPosition(new Vec2(10, -6f));
            rp.addCollisionListener(new Pickup(getPlayer()));
            rp.addCollisionListener(new Pickup2(getPlayer2()));
        }
        {
            OrangePlatform op2 = new OrangePlatform(this);
            op2.setPosition(new Vec2(-5, -4f));
            op2.addCollisionListener(new Pickup2(getPlayer2()));

        }
        
                    JOptionPane.showMessageDialog(null, "Ready? Press okay to start level. ", "Level 5", JOptionPane.INFORMATION_MESSAGE);

        /**
         * A for Loop is used to create multiple instances of the class
         * FishFood, Poison and SpikeObject For every time i is increased by one
         * a new instance is created and the item is spawned in the game world A
         * collision listener has been added in which these item react with the
         * main class call Fish through the pickup class
         */
        {
            for (int i = 0; i < 12; i++) {
                Body poison = new Poison(this);
                poison.setPosition(new Vec2(i * 2 - 10, (float) Math.random() * 20.0f - 10.0f));
                poison.addCollisionListener(new Pickup(getPlayer()));
                poison.addCollisionListener(new Pickup2(getPlayer2()));
            }
        }

        {
            for (int i = 0; i < 6; i++) {
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
        for (int i = 0; i < 4; i++) {
            {
                Shark shark1 = new Shark(this);
                shark1.setPosition(new Vec2(2 - 10, (float) Math.random() * 20.0f - 10.0f));
                shark1.addCollisionListener(new Pickup(getPlayer()));
                shark1.addCollisionListener(new Pickup2(getPlayer2()));
                shark1.startWalking(2);
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
