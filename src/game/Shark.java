/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 *
 * @author Rojel
 */
public class Shark extends Walker {

    private static final Shape shape = new PolygonShape(-0.29f, 1.25f, 1.98f, 0.56f, 1.29f, -0.64f, -0.53f, -1.3f, -2.03f, -0.08f, -2.05f, 1.33f);
    private static final BodyImage image = new BodyImage("data/Shark2.png", 6.5f);

    /**
     * New variables are initialised which create a PolygonShape for the
     * BodyImage of a bottle of poison
     *
     * @param world A world in which the motion and interaction of a Shark object is simulated. Bodies are added to the world automatically when they are created.
     */
    public Shark(World world) {

        super(world, shape);

        addImage(image);
    }

}
