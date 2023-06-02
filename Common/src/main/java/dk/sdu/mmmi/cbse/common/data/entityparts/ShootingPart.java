package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

public class ShootingPart implements EntityPart{

    private float shootingSpeed ;

    private boolean shoot;

    public ShootingPart(float shootingSpeed) {
        this.shootingSpeed = shootingSpeed;
        this.shoot = false;
    }

    public float getShootingSpeed() {
        return shootingSpeed;
    }

    public void setShootingSpeed(float shootingSpeed) {
        this.shootingSpeed = shootingSpeed;
    }

    public boolean isShoot() {
        return shoot;
    }

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    @Override
    public void process(GameData gameData, Entity entity) {

    }
}
