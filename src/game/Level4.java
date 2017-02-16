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
public class Level4 extends GameLevel {

    private static final int NUM_FISHES = 6;

    /**
     *
     * @param game
     */
    public void populate(Game game) {
        super.populate(game);

        { // make platforms
            Shape shape = new BoxShape(4, 0.2f);
            Body platform1 = new StaticBody(this, shape);
            platform1.setPosition(new Vec2(-14, 5));
            platform1.setFillColor(Color.blue);
            platform1.setLineColor(Color.blue);
        }
        {
            //AddImage allows me to use an image for the platform
            Shape shape = new BoxShape(4, 0.2f);
            Body platform2 = new StaticBody(this, shape);
            platform2.setPosition(new Vec2(18, -2.5f));
            platform2.setFillColor(Color.blue);
            platform2.setLineColor(Color.blue);
        }

        {
            Shape shape = new BoxShape(4, 0.2f);
            Body platform3 = new StaticBody(this, shape);
            platform3.setPosition(new Vec2(10, 6.4f));
            platform3.setFillColor(Color.blue);
            platform3.setLineColor(Color.blue);
        }
        {
            Shape shape = new BoxShape(4, 0.2f);
            Body platform4 = new StaticBody(this, shape);
            platform4.setPosition(new Vec2(2, 1f));
            platform4.setFillColor(Color.blue);
            platform4.setLineColor(Color.blue);
        }
        {
            Shape shape = new BoxShape(4, 0.2f);
            Body platform5 = new StaticBody(this, shape);
            platform5.setPosition(new Vec2(-17, -2f));
            platform5.setFillColor(Color.blue);
            platform5.setLineColor(Color.blue);
        }

        {
            Shape shape = new BoxShape(4, 0.2f);
            Body platform6 = new StaticBody(this, shape);
            platform6.setPosition(new Vec2(-15, -9f));
            platform6.setFillColor(Color.blue);
            platform6.setLineColor(Color.blue);
        }

        {
            Shape shape = new BoxShape(4, 0.2f);
            Body platform7 = new StaticBody(this, shape);
            platform7.setPosition(new Vec2(10, -7f));
            platform7.setFillColor(Color.blue);
            platform7.setLineColor(Color.blue);
        }
        {
            Shape shape = new BoxShape(4, 0.2f);
            Body platform8 = new StaticBody(this, shape);
            platform8.setPosition(new Vec2(-5, -4f));
            platform8.setFillColor(Color.blue);
            platform8.setLineColor(Color.blue);
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
            }
        }

        {
            for (int i = 0; i < 4; i++) {
                Body grenade = new Grenade(game);
                grenade.setPosition(new Vec2(i * 2 - 10, (float) Math.random() * 20.0f - 10.0f));
                grenade.addCollisionListener(new Pickup(getPlayer()));
            }
        }

        {
            for (int i = 0; i < NUM_FISHES; i++) {
                Body fishFood = new FishFood(this);
                fishFood.setPosition(new Vec2(i * 2 - 10, (float) Math.random() * 20.0f - 10.0f));
                fishFood.addCollisionListener(new Pickup(getPlayer()));
            }
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
        return getPlayer().getFishFoodCount() == NUM_FISHES;
    }
}
