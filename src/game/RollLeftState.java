package game;

import fsm.FSMState;

/**
 *
 * @author Rojel
 */
public class RollLeftState extends FSMState<Grenade> {

    protected void update() {
        Grenade grenade = getContext();
        if (grenade.inRangeRight()) {
            gotoState(new RollRightState());
        } else if (!grenade.inRange()) {
            gotoState(new StandStillState());
        } else {
            grenade.setAngularVelocity(6);
        }
    }

    protected void enter() {
        Grenade grenade = getContext();
        grenade.setAngularVelocity(3);
    }

    protected void exit() {
    }
}
