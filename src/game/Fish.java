package game;

import city.cs.engine.*;

/**
 * Simple character
 */
public class Fish extends Walker {
//Declaring the variables

    private static final BodyImage image
            = new BodyImage("data/fish_2_left.png", 2.25f);
    private static final Shape fishShape = new PolygonShape(-0.163f, 0.878f, -1.395f, 0.225f, -1.417f, -0.383f, -0.343f, -0.889f, 1.232f, -0.444f, 1.238f, 0.186f, -0.096f, 0.861f);

    private int fishFoodCount;
    private int poisonCount;
    private int gameScoreCount;
    private int health;
    private int blueScore;

    /**
     * @param world this is the world the game lives in, allows you to assign values to Player2. 
     * This constructor initialises variables to the Fish Object, such as fishFoodCount, poisonCount, gameScoreCount, health, blueScore.
     */
    public Fish(World world) {
        super(world, fishShape);
        addImage(image);
        //initalising the variables which are used as counter
        fishFoodCount = 0;
        poisonCount = 0;
        gameScoreCount = 0;
        health = 100;
        blueScore = 0;
    }

    /**
     *
     * @return fishFoodCount is the amount of fish food Fish has collected
     */
    public int getFishFoodCount() {
        return fishFoodCount;
    }

    /**
     *
     * @return gameScoreCount is the score of Fish
     */
    public int getGameScoreCount() {
        return gameScoreCount;
    }

    /**
     *
     * @return health is the amount of a health value Player2 has 
     */
    public int getHealth() {
        return health;
    }

    /**
     *
     * @return orangeScore is the amount of orange pickups Player2 has collected
     */
    public int getBlueScore() {
        return blueScore;
    }

    /**
     * When this method is called fishFoodCount is increased by 1 and gameScoreCount is increased by 5.
     */
    public void incrementFishFoodCount() {
        fishFoodCount++;
        gameScoreCount = gameScoreCount + 5;
        

        
        System.out.println("Yummy ;-> Fish Food count = " + fishFoodCount + " Game Score " + gameScoreCount);
        //This method increments the fish food count by one every time the fish food is collected.
        //This method increments he game score by one everytime fish food is collected
    }

    /**
     * When this method is called gameScoreCount is increased my 10.
     */
    public void incrementGameScoreCount() {
        gameScoreCount = gameScoreCount + 10;
        System.out.println(" Game Score " + gameScoreCount);
    }

    /**
     * When this method is called orangeScore is increased my 10 and gameScoreCount is increased by 10.
     */
    public void incrementBlueScore() {
        blueScore = blueScore + 10;
        gameScoreCount = gameScoreCount + 10;
        System.out.println(" Game Score " + gameScoreCount);
    }

    /**
     *
     * @return poisonCount is the amount of poison bottles Fish has picked up.
     */
    public int getPoisonCount() {
        return poisonCount;
    }

    /**
     * When this method is called poisonCount is increased by 1.
     * gameScoreCount is decreased by 5
     * health is decreased by 10
     */
    public void incrementPoisonCount() {
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
    public void incrementHealth() {
        health++;

        if (health > 100) {
            health = 100;
        }
    }

    /**
     * When this method is called health is decreased by 5
     */
    public void decrementHealth() {
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
    public void killFish() {
        System.out.println("Game Over - wah wah waaaah....." + gameScoreCount);
        System.exit(0);
        //This method exits the game in a certain collision takes place and prints the game score to the console
    }

}
