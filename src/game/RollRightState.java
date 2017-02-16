package game;

import fsm.FSMState;

/**
 *
 * @author Rojel
 */
public class RollRightState extends FSMState<Grenade> {

    protected void update() {
        Grenade grenade = getContext();
        if (grenade.inRangeLeft()) {
            gotoState(new RollLeftState());
        } else if (!grenade.inRange()) {
            gotoState(new StandStillState());
        } else {
            grenade.setAngularVelocity(-6);
        }
    }

    protected void enter() {
        Grenade grenade = getContext();
        grenade.setAngularVelocity(-3);
    }

    protected void exit() {
    }
}
