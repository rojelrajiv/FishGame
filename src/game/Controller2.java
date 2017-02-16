package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class Controller2 extends KeyAdapter {

    private static final float JUMPING_SPEED = 15;
    private static final float WALKING_SPEED = 6;

    private Walker body2;

    /**
     *
     * @param body - A dynamic body with fixed orientation and methods to jump and walk.
     */
    public Controller2(Walker body) {
        this.body2 = body;
        //The class which extends walker is being initialised with the body2 of the fish
    }

    /**
     * Handle key press events for walking and jumping.
     *
     * @param a
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent a) {
        int code2 = a.getKeyCode();
        if (code2 == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code2 == KeyEvent.VK_W) { // w = jump
            Vec2 v2 = body2.getLinearVelocity();
            // only jump if body2 is not already jumping
            if (Math.abs(v2.y) < 0.01f) {
                body2.jump(JUMPING_SPEED);
            }
        } else if (code2 == KeyEvent.VK_A) {
            body2.startWalking(-WALKING_SPEED); // 1 = walk left, left arrow = move left
            body2.removeAllImages();
            body2.addImage(new BodyImage("data/fish_3_left.png", 2.25f));
            //if the left arrow is pressed the current body2 image is removed and an image of the fish facing left is used in its place to simuate the movement 
        } else if (code2 == KeyEvent.VK_D) {
            body2.startWalking(WALKING_SPEED); // 2 = walk right, right arrow = move right
            body2.removeAllImages();
            body2.addImage(new BodyImage("data/fish_3_right.png", 2.25f));
            //if the right arrow is pressed the current body2 image is removed and an image of the fish facing right is used in its place to simuate the movement
        } else if (code2 == KeyEvent.VK_S) {
            Vec2 v2 = body2.getLinearVelocity();

            if (Math.abs(v2.y) > 0.01f) {
                body2.setGravityScale(5.0f); // down arrow = move down, and gravity is increased to speed up the decent of the body2
            }

        }
    }

    /**
     * Handle key release events (stop walking).
     *
     * @param a
     */
    @Override
    public void keyReleased(KeyEvent a) {
        int code2 = a.getKeyCode();
        if (code2 == KeyEvent.VK_A) {
            body2.stopWalking(); //if the left arrow is released then the fish body2 stops moving

            //body.removeAllImages();
            //body.addImage(new BodyImage ("data/fish_2_right.png",2.25f));
        } else if (code2 == KeyEvent.VK_D) {
            body2.stopWalking(); // if the right arrow is released then the fish stops moving
            //body.removeAllImages();
            //body.addImage(new BodyImage ("data/fish_2_right.png",2.25f));
        } else if (code2 == KeyEvent.VK_S) {
            body2.setGravityScale(1.0f); // if the down arrow is released the gravity is reset to the default value
        }
    }

    /**
     *
     * @param body2 - A dynamic body with fixed orientation and methods to jump and walk.
     */
    public void setBody2(Walker body2) {
        this.body2 = body2;
    }
}
