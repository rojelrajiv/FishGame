/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Rojel
 */
public class Poison extends DynamicBody {

    private static final Shape shape = new PolygonShape(-0.148f, 0.77f, -0.223f, 0.079f, -0.228f, -0.747f, 0.236f, -0.752f, 0.218f, 0.084f, 0.138f, 0.767f);
    private static final BodyImage image = new BodyImage("data/poison_bottle_T.png", 1.7f);

    /**
     * New variables are initialised which create a PolygonShape for the
     * BodyImage of a bottle of poison
     *
     * @param world A world in which the motion and interaction of a Poison object is simulated. Bodies are added to the world automatically when they are created.
     */
    public Poison(World world) {

        super(world, shape);
        //setFillColor(Color.blue);
        addImage(image);
    }

}
