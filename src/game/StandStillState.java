package game;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

/**
 *
 * @author Rojel
 */
public class StandStillState extends FSMState<Grenade> {

    protected void update() {
        Grenade grenade = getContext();
        if (grenade.inRangeLeft()) {
            gotoState(new RollLeftState());
        } else if (grenade.inRangeRight()) {
            gotoState(new RollRightState());
        }
    }

    protected void enter() {
        Grenade grenade = getContext();
        grenade.setAngularVelocity(0);
        grenade.setLinearVelocity(new Vec2());
    }

    protected void exit() {
    }
}
