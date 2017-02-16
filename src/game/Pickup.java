package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {

    private final Fish fish;

    /**
     *
     * @param fish
     */
    public Pickup(Fish fish) {
        this.fish = fish;
        //A new pickup is created which can react with other dynamic bodies in the game world
    }

    /**
     * @param e - Event object describing the geometry and dynamics of a
     * collision between two SolidFixtures in a World. The reporting body is the
     * one that sent this event to all its listeners; the other body is the one
     * it collided with. Another event giving the opposite view of the collision
     * will be sent to all listeners attached to the other body. A collision
     * event is created using nested if statements In the instance of FishFood
     * object if a collision takes place with Fish, the incrementFishFoodCount
     * method is called upon and the reporting body is destroyed and
     * fishFoodCount is increased A collision event is created using nested if
     * statements In the instance of Poison object if a collision takes place
     * with Fish the incrementPoisonCount method is called upon, and the
     * reporting body is destroyed and poisonCount is increased. A collision
     * event is created using nested if statements In the instance of Grenade if
     * a collision takes place with Fish, the KillFish method is called upon and
     * the game is ended. A collision event is created using nested if
     * statements In the instance of Shark if a collision takes place with Fish,
     * the KillFish method is called upon and the game is ended. A collision
     * event is created using nested if statements In the instance of
     * BluePlatform if a collision takes place with Fish, the decrementHealth
     * method is called upon and the health of Fish is reduced. A collision
     * event is created using nested if statements In the instance of
     * RedPlatform if a collision takes place with Fish, the decrementHealth
     * method is called upon and the health of Fish is reduced. A collision
     * event is created using nested if statements In the instance of
     * CyanPlatform if a collision takes place with Fish, the incrementHealth
     * method is called upon and the health of Fish is increased. A collision
     * event is created using nested if statements In the instance of P2PowerUp
     * if a collision takes place with Fish, the incrementBlueScore method is
     * called upon and the orangeScore of Fish is increased.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == fish) {
            if (e.getReportingBody() instanceof FishFood) {
                fish.incrementFishFoodCount();
                e.getReportingBody().destroy();
            }
            if (e.getReportingBody() instanceof Poison) {
                fish.incrementPoisonCount();
                e.getReportingBody().destroy();
            }
            if (e.getReportingBody() instanceof Grenade) {
                fish.killFish();

            }

            if (e.getReportingBody() instanceof Shark) {
                fish.killFish();

            }
            if (e.getReportingBody() instanceof OrangePlatform) {
                fish.decrementHealth();

            }
            if (e.getReportingBody() instanceof RedPlatform) {
                fish.decrementHealth();

            }
            if (e.getReportingBody() instanceof CyanPlatform) {
                fish.incrementHealth();

            }

            if (e.getReportingBody() instanceof P1PowerUp) {
                fish.incrementBlueScore();
                e.getReportingBody().destroy();

            }
        }

    }
}
