package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {

    private static final float JUMPING_SPEED = 15;
    private static final float WALKING_SPEED = 6;

    private Walker body;

    /**
     *
     * @param body - A dynamic body with fixed orientation and methods to jump and walk.
     */
    public Controller(Walker body) {
        this.body = body;
        //The class which extends walker is being initialised with the body of the fish
    }

    /**
     * Handle key press events for walking and jumping.
     *
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { // up arrow = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.startWalking(-WALKING_SPEED); // 1 = walk left, left arrow = move left
            body.removeAllImages();
            body.addImage(new BodyImage("data/fish_2_left.png", 2.25f));
            //if the left arrow is pressed the current body image is removed and an image of the fish facing left is used in its place to simuate the movement 
        } else if (code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // 2 = walk right, right arrow = move right
            body.removeAllImages();
            body.addImage(new BodyImage("data/fish_2_right.png", 2.25f));
            //if the right arrow is pressed the current body image is removed and an image of the fish facing right is used in its place to simuate the movement
        } else if (code == KeyEvent.VK_DOWN) {
            Vec2 v = body.getLinearVelocity();

            if (Math.abs(v.y) > 0.01f) {
                body.setGravityScale(5.0f); // down arrow = move down, and gravity is increased to speed up the decent of the body
            }

        }
    }

    /**
     * Handle key release events (stop walking).
     *
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking(); //if the left arrow is released then the fish body stops moving

            //body.removeAllImages();
            //body.addImage(new BodyImage ("data/fish_2_right.png",2.25f));
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking(); // if the right arrow is released then the fish stops moving
            //body.removeAllImages();
            //body.addImage(new BodyImage ("data/fish_2_right.png",2.25f));
        } else if (code == KeyEvent.VK_DOWN) {
            body.setGravityScale(1.0f); // if the down arrow is released the gravity is reset to the default value
        }
    }

    /**
     *
     * @param body - A dynamic body with fixed orientation and methods to jump and walk.
     */
    public void setBody(Walker body) {
        this.body = body;
    }
}
