package game;

import city.cs.engine.*;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup2 implements CollisionListener {

    private final Player2 fish2;

    /**
     * A new pickup is created which can react with other dynamic bodies in the
     * game world
     *
     * @param fish2 - A controllable Walker Object called Player2
     */
    public Pickup2(Player2 fish2) {
        this.fish2 = fish2;
    }

    /**
     * @param e - Event object describing the geometry and dynamics of a
     * collision between two SolidFixtures in a World. The reporting body is the
     * one that sent this event to all its listeners; the other body is the one
     * it collided with. Another event giving the opposite view of the collision
     * will be sent to all listeners attached to the other body. A collision
     * event is created using nested if statements In the instance of FishFood
     * object if a collision takes place with Player2, the
     * incrementFishFoodCount2 method is called upon and the reporting body is
     * destroyed the fish, the incrementPosionCount method is called upon and. A
     * collision event is created using nested if statements In the instance of
     * Poison object if a collision takes place with Player2 the
     * incrementPoisonCount2 method is called upon, and the reporting body is
     * destroyed. A collision event is created using nested if statements In the
     * instance of Grenade if a collision takes place with Player2, the
     * KillFish2 method is called upon and the game is ended. A collision event
     * is created using nested if statements In the instance of Shark if a
     * collision takes place with Player2, the KillFish2 method is called upon
     * and the game is ended. A collision event is created using nested if
     * statements In the instance of BluePlatform if a collision takes place
     * with Player2, the decrementHealth2 method is called upon and the health
     * of Player2 is reduced. A collision event is created using nested if
     * statements In the instance of RedPlatform if a collision takes place with
     * Player2, the decrementHealth2 method is called upon and the health of
     * Player2 is reduced. A collision event is created using nested if
     * statements In the instance of CyanPlatform if a collision takes place
     * with Player2, the incrementHealth2 method is called upon and the health
     * of Player2 is increased. A collision event is created using nested if
     * statements In the instance of P2PowerUp if a collision takes place with
     * Player2, the incrementOrangeScore method is called upon and the
     * orangeScore of Player2 is increased.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == fish2) {
            if (e.getReportingBody() instanceof FishFood) {
                fish2.incrementFishFoodCount2();
                e.getReportingBody().destroy();

            }
            if (e.getReportingBody() instanceof Poison) {
                fish2.incrementPoisonCount2();
                e.getReportingBody().destroy();

            }
            if (e.getReportingBody() instanceof Grenade) {
                fish2.killFish2();

            }

            if (e.getReportingBody() instanceof Shark) {
                fish2.killFish2();

            }

            if (e.getReportingBody() instanceof BluePlatform) {
                fish2.decrementHealth2();
            }

            if (e.getReportingBody() instanceof RedPlatform) {
                fish2.decrementHealth2();
            }

            if (e.getReportingBody() instanceof CyanPlatform) {
                fish2.incrementHealth2();
            }

            if (e.getReportingBody() instanceof P2PowerUp) {
                fish2.incrementOrangeScore();
                e.getReportingBody().destroy();
            }

        }
    }
}
