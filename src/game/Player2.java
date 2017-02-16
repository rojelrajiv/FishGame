/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *
 * @author Rojel
 */
public class Player2 extends Walker {

    private static final BodyImage image
            = new BodyImage("data/fish_3_left.png", 2.25f);
    private static final Shape fishShape = new PolygonShape(-0.163f, 0.878f, -1.395f, 0.225f, -1.417f, -0.383f, -0.343f, -0.889f, 1.232f, -0.444f, 1.238f, 0.186f, -0.096f, 0.861f);

    private int fishFoodCount;
    private int poisonCount;
    private int gameScoreCount;
    private int health;
    private int orangeScore;

    /**
     *
     * @param world this is the world the game lives in, allows you to assign
     * values to Player2. This constructor initialises variables to the Player2
     * Object, such as fishFoodCount, poisonCount, gameScoreCount, health,
     * orangeScore.
     *
     */
    public Player2(World world) {
        super(world, fishShape);
        addImage(image);
        //initalising the variables which are used as counter
        fishFoodCount = 0;
        poisonCount = 0;
        gameScoreCount = 0;
        health = 100;
        orangeScore = 0;
    }

    /**
     *
     * @return fishFoodCount is the amount of fish food Player2 has collected
     */
    public int getFishFoodCount2() {
        return fishFoodCount;
    }

    /**
     *
     * @return gameScoreCount is the score of Player2
     */
    public int getGameScoreCount2() {
        return gameScoreCount;
    }

    /**
     *
     * @return health is the amount of a health value Player2 has
     */
    public int getHealth2() {
        return health;
    }

    /**
     *
     * @return orangeScore is the amount of orange pickups Player2 has collected
     */
    public int getOrangeScore() {
        return orangeScore;
    }

    /**
     * When this method is called fishFoodCount is increased by 1 and
     * gameScoreCount is increased by 5.
     */
    public void incrementFishFoodCount2() {
        fishFoodCount++;
        gameScoreCount = gameScoreCount + 5;

        System.out.println("Yummy ;-> Fish Food count = " + fishFoodCount + " Game Score " + gameScoreCount);
        //This method increments the fish food count by one every time the fish food is collected.
        //This method increments he game score by one everytime fish food is collected
    }

    /**
     * When this method is called gameScoreCount is increased my 10.
     */
    public void incrementGameScoreCount2() {
        gameScoreCount = gameScoreCount + 10;
        System.out.println(" Game Score " + gameScoreCount);
    }

    /**
     * When this method is called orangeScore is increased my 10 and
     * gameScoreCount is increased by 10.
     */
    public void incrementOrangeScore() {
        orangeScore = orangeScore + 10;
        gameScoreCount = gameScoreCount + 10;
        System.out.println(" Game Score " + gameScoreCount);
    }

    /**
     *
     * @return poisonCount is the amount of poison bottles Player2 has picked
     * up.
     */
    public int getPoisonCount2() {
        return poisonCount;
    }

    /**
     * When this method is called poisonCount is increased by 1. gameScoreCount
     * is decreased by 5 health is decreased by 10
     */
    public void incrementPoisonCount2() {
        poisonCount++;
        gameScoreCount = gameScoreCount - 5;
        health = health - 10;

        if (health == 0) {
            System.out.println("R.I.P.");
            System.exit(0);
        }
        System.out.println("Ohh Noo?!?   Poison = " + poisonCount + " Game Score " + gameScoreCount);
        //This method increments the poison count by one every time poison is collected.
        //This method also decreases the game score by one evry time poison is collected

    }

    /**
     * When this method is called health is increased by 1.
     */
    public void incrementHealth2() {
        health++;

        if (health > 100) {
            health = 100;
        }
    }

    /**
     * When this method is called health is decreased by 5
     */
    public void decrementHealth2() {
        health = health - 5;

        if (health == 0) {
            System.out.println("R.I.P.");
            System.exit(0);
            System.out.println("Game Over - wah wah waaaah....." + gameScoreCount);
        }
    }

    /**
     * When this method is called Player2 is killed by exiting the game.
     */
    public void killFish2() {
        System.out.println("Game Over - wah wah waaaah....." + gameScoreCount);
        System.exit(0);
        //This method exits the game in a certain collision takes place and prints the game score to the console
    }

}
