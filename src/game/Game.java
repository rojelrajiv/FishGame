package game;

import city.cs.engine.*;
import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * The computer game.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;

    private int level;
    private Controller controller;
    private int fishFoodCount;
    private int poisonCount;
    private int gameScoreCount;
    private int health;
    private Buttons buttons;
    private Controller2 controller2;
    private final JFrame frame = new JFrame("Event handling");

    /**
     * Initialise a new Game.
     */
    public Game() {

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);

        view = new MyView(world, this, 1000, 500);

        fishFoodCount = 0;
        poisonCount = 0;
        gameScoreCount = 0;
        health = 100;
        // make a view
        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // display the view in a frame
        // final JFrame frame = new JFrame("Event handling");
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);

        buttons = new Buttons(view, world, this);

        frame.add(buttons, BorderLayout.SOUTH);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));

        controller = new Controller(world.getPlayer());
        //controller2 = new Controller2(world.getPlayer2());
        frame.addKeyListener(controller);
        //frame.addKeyListener(controller2);
        //frame.addKeyListener(new Controller(world.getPlayer()));

        // uncomment to make the view track the bird
        //world.addStepListener(new Tracker(view, world.getPlayer()));
        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 1000, 500);
        // start!
        world.start();
    }

    /**
     * The player in the current level.
     * @return getPlayer - Retrieves the object Fish from the world
     */
    public Fish getPlayer() {
        return world.getPlayer();
    }

    /**
     * Is the current level of the game finished?
     * @return isCompleted - returns a boolean, of whether the criteria of completing a level has been achieved
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * This method is called when the restart JButton is clicked and the current level is restarted.
     */
    public void restart() {
        System.out.println("...");
        world.stop();

        switch (level) {
            case 1:
                world = new Level1();
                break;
            case 2:
                world = new Level2();
                break;
            case 3:
                world = new Level3();
                break;
            case 4:
                world = new Level4();
                break;
            case 5:
                world = new Level5();
                break;

        }

        world.populate(this);
        controller.setBody(world.getPlayer());
        //controller2.setBody2(world.getPlayer2());

        view.setWorld(world);
        buttons.setWorld(world);
        world.start();
    }

    /**
     * Advance to the next level of the game.
     */
    public void goNextLevel() {
        world.stop();
        if (level == 5) {
            System.out.println("Game Over");
            System.exit(0);
        } else {
            level++;
            // get a new world
            view.setBackgroundForLevel(level);
            world = new Level2();
            System.out.println("This is level " + level);
            if (level == 3) {
                world = new Level3();
                //System.out.println("This is "+ level);
            }
            if (level == 4) {
                world = new Level4();
                //System.out.println("This is "+ level);
            }
            if (level == 5) {
                world = new Level5();
                //System.out.println("This is "+ level);
            }
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //controller2.setBody2(world.getPlayer2());
            // show the new world in the view
            view.setWorld(world);

            world.start();
        }
    }

    /**
     *
     * @return GameScoreCount - The amount of Game Score the Fish has achieved
     */
    public int getGameScoreCount() {
        return world.getPlayer().getGameScoreCount();
    }

    /**
     *
     * @return Health - the amount of health remaining for the Fish object
     */
    public int getHealth() {
        return world.getPlayer().getHealth();
    }

    /**
     *
     * @return world - The World in which the bodies move and interact.
     */

    public GameLevel getWorld() {
        return world;
    }

    /**
     * This method closes/disposes a JFrame window.
     */
    public void CloseWindow() {
        frame.dispose();

    }
}
