/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.World;
import java.awt.Color;
import org.jbox2d.common.Vec2;
import city.cs.engine.*;
import fsm.FSM;
import java.awt.Color;

/**
 *
 * @author Rojel
 */
public class Grenade extends DynamicBody implements StepListener {

    private static final Shape grenadeShape = new CircleShape(0.4f);
    private static final BodyImage image = new BodyImage("data/grenade_1.png");

    /**
     * Variables are initialised in which a CircleShape is created for the
     * BodyImgae of a grenade to which the fish reacts to in the game world
     *
     * @param world - A world in which the motion and interaction of a FishFood object is simulated. Bodies are added to the world automatically when they are created.
     */
    public Grenade(World world) {
        super(world, grenadeShape);
        //setFillColor(Color.red);
        addImage(image);
    }

    /**
     *
     */
    public static final float RANGE = 20;

    private Game game;

    private FSM<Grenade> fsm;

    /**
     *
     * @param game - The computer game.
     */
    public Grenade(Game game) {
        super(game.getWorld(), grenadeShape);
        this.game = game;
        addImage(new BodyImage("data/grenade_1.png"));
        fsm = new FSM<Grenade>(this, new StandStillState());
        getWorld().addStepListener(this);
    }

    /**
     *
     * @return gap - The current position in the world of this body 's origin point to the left of the grenade
     */
    public boolean inRangeLeft() {
        Body a = game.getPlayer();
        //Body b = game2.getPlayer2();
        float gap = getPosition().x - a.getPosition().x;
        //float gap2 = getPosition().x - b.getPosition().x;
        return gap < RANGE && gap > 0;

    }

    /**
     *
     * @return gap - The current position in the world of this body 's origin point to the right of the grenade
     */
    public boolean inRangeRight() {
        Body a = game.getPlayer();
        //Body b = game2.getPlayer2();
        float gap = getPosition().x - a.getPosition().x;
        //float gap2 = getPosition().x - b.getPosition().x;
        return gap > -RANGE && gap < 0;
    }

    /**
     *
     * @return @return gap - The current position in the world of this body 's origin point to the grenade
     */
    public boolean inRange() {
        return inRangeLeft() || inRangeRight();
    }

    /**
     *
     * @param e - Events signalling the start and end of a simulation step
     */
    public void preStep(StepEvent e) {
        fsm.update();
    }

    /**
     *
     * @param e - Events signalling the start and end of a simulation step
     */
    public void postStep(StepEvent e) {
    }
}
