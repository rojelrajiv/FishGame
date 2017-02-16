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
public class FishFood extends DynamicBody {

    /**
     * Declaring the variables for the fish food Creating a new Polygon Shape
     * for the image Determining the data path which the program can use to find
     * the image
     */
    private static final Shape shape = new PolygonShape(0.07f, 0.486f, -0.674f, -0.062f, -0.031f, -0.458f, 0.608f, -0.016f, 0.126f, 0.486f);
    private static final BodyImage image = new BodyImage("data/Fish_Food.png", 1.2f);

    /**
     *
     * @param world - A world in which the motion and interaction of a FishFood object is simulated. Bodies are added to the world automatically when they are created.
     */
    public FishFood(World world) {
        super(world, shape);
        //setFillColor(Color.orange);
        addImage(image);
    }
}
