package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Rojel
 */
/**
 * A world with some bodies.
 */
public abstract class GameLevel2 extends World {

    /**
     * A controllable Walker Object called Fish
     */
    private Fish fish;

    /**
     * A controllable Walker Object called Player2
     */
    private Player2 fish2;

    /**
     * Creates a new world with the default target frame rate (24).
     */
    public GameLevel2() {
        super();

    }

    /**
     *
     * @param game - The computer game.
     */
    public void populate(Game2 game) {
        fish = new Fish(this);
        fish.setPosition(startPosition());
        fish2 = new Player2(this);
        fish2.setPosition(startPosition2());
        Door door = new Door(this);
        door.setPosition(doorPosition());
        //door.addCollisionListener(new DoorListener(game));
        door.addCollisionListener(new DoorListener2(game));
        // make the ground
        Shape shape = new BoxShape(26, 0.5f);
        Body ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0, -12.9f));
        //ground.addImage(platform);

        // walls
        Shape leftWallShape = new BoxShape(0.5f, 20.5f, new Vec2(-26f, 20f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 20.5f, new Vec2(26f, 20f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
    }

    /**
     * The initial position of the player.
     *
     * @return startPosition - The initial position of the Fish.
     */
    public abstract Vec2 startPosition();

    /**
     *
     * @return startPosition2 - The initial position of Player2.
     */
    public abstract Vec2 startPosition2();

    /**
     * The position of the exit door.
     *
     * @return doorPosition - The position of the exit door.
     */
    public abstract Vec2 doorPosition();

    /**
     * Is this level complete?
     *
     * @return isCompleted - - returns a boolean, of whether the criteria of
     * completing a level has been achieved
     */
    public abstract boolean isCompleted();

    /**
     *
     * @return fish - Retrieves the object Fish from the world
     */
    public Fish getPlayer() {
        return fish;
    }

    /**
     *
     * @return fish2 - Retrieves the object Player2 from the world
     */
    public Player2 getPlayer2() {
        return fish2;
    }

}
