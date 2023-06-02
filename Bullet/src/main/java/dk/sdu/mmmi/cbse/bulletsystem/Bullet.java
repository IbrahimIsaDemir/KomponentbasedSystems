package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;

public class Bullet extends Entity {
    private boolean hit;
    private float speed;
    private int[] color;

    public int[] getColor() {
        return color;
    }

    public void setColor(int[] color) {
        this.color = color;
    }

    public Bullet() {
        hit = false;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public boolean isHit() {
        return hit;
    }

}
