package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.events.Event;

public class BulletEvent extends Event {
    public BulletEvent(Entity source) {
        super(source);
    }
}
