package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.events.Event;

public class CollisionEvent extends Event {

    private Entity source2;
    public CollisionEvent(Entity source, Entity source2) {
        super(source);
        this.source2 = source2;
    }

    public Entity getSource2() {
        return source2;
    }
}
