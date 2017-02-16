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
public class P2PowerUp extends DynamicBody {

    /**
     * Declaring the variables for the fish food Creating a new Polygon Shape
     * for the image Determining the data path which the program can use to find
     * the image
     */
    private static final Shape shape = new PolygonShape(-0.094f, 0.744f, -0.442f, -0.014f, -0.288f, -0.711f, 0.439f, 0.234f, 0.248f, 0.652f);
    private static final BodyImage image = new BodyImage("data/orange_powerup.jpg", 1.7f);

    /**
     *
     * @param world - A world in which the motion and interaction of a P2PowerUp object is simulated. Bodies are added to the world automatically when they are created.
     */
    public P2PowerUp(World world) {
        super(world, shape);
        //setFillColor(Color.orange);
        addImage(image);
    }
}
