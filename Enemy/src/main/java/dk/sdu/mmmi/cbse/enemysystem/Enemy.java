package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;

public class Enemy extends Entity {
    private PositionPart startingPosition;

    public Enemy() {

    }

    public PositionPart getStartingPosition() {
        return startingPosition;
    }



    public void setStartingPosition(PositionPart startingPosition) {
        this.startingPosition = startingPosition;
    }
}
