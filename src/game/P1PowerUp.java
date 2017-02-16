package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 *
 * @author Rojel
 */
/**
 * An orange.
 */
public class P1PowerUp extends DynamicBody {

    /**
     * Declaring the variables for the fish food Creating a new Polygon Shape
     * for the image Determining the data path which the program can use to find
     * the image
     */
    private static final Shape shape = new PolygonShape(-0.025f, 0.728f, -0.419f, 0.125f, -0.437f, -0.753f, 0.056f, -0.237f, 0.309f, 0.244f, 0.431f, 0.7f);
    private static final BodyImage image = new BodyImage("data/blue_powerup.png", 2.4f);

    /**
     *
     * @param world - A world in which the motion and interaction of a P1PowerUp object is simulated. Bodies are added to the world automatically when they are created.
     */
    public P1PowerUp(World world) {
        super(world, shape);
        //setFillColor(Color.orange);
        addImage(image);
    }
}
