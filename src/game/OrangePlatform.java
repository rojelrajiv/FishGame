/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Rojel
 */
public class OrangePlatform extends StaticBody {

    private static final BoxShape shape = new BoxShape(4, 0.2f);
    //private static final BodyImage image = new BodyImage("data/poison_bottle_T.png");

    /**
     * New variables are initialised which create a PolygonShape for the
     * BodyImage of a bottle of poison
     *
     * @param world - 
A world in which the motion and interaction of a number of rigid bodies is simulated. Bodies are added to the world automatically when they are created.
     */
    public OrangePlatform(World world) {

        super(world, shape);
        setFillColor(Color.orange);
        //addImage(image);
    }

}
