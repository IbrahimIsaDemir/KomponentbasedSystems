package dk.sdu.mmmi.cbse.common.data;

import dk.sdu.mmmi.cbse.common.data.entityparts.EntityPart;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Entity implements Serializable {
    private final UUID ID = UUID.randomUUID();

    private float[] shapeX = new float[4];
    private float[] shapeY = new float[4];
    private float radius;
    private int[] color = new int[3];
    private int damageFactor;
    private int life;
    private boolean hit;
    private boolean untouchable;
    private String shape;

    private long untouchableTime;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    private Map<Class, EntityPart> parts;

    public Entity() {
        parts = new ConcurrentHashMap<>();
    }

    public void add(EntityPart part) {
        parts.put(part.getClass(), part);
    }

    public void remove(Class partClass) {
        parts.remove(partClass);
    }

    public <E extends EntityPart> E getPart(Class partClass) {
        return (E) parts.get(partClass);
    }

    public void setRadius(float r){
        this.radius = r;
    }

    public float getRadius(){
        return radius;
    }

    public String getID() {
        return ID.toString();
    }

    public float[] getShapeX() {
        return shapeX;
    }

    public void setShapeX(float[] shapeX) {
        this.shapeX = shapeX;
    }

    public float[] getShapeY() {
        return shapeY;
    }

    public void setShapeY(float[] shapeY) {
        this.shapeY = shapeY;
    }

    public int[] getColor() {
        return color;
    }

    public void setColor(int[] color) {
        this.color = color;
    }

    public int getDamageFactor() {
        return damageFactor;
    }

    public void setDamageFactor(int damageFactor) {
        this.damageFactor = damageFactor;
    }

    public void reduceLife(int damageFactor){
        life -= damageFactor;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {


        this.hit = hit;
    }

    public boolean isUntouchable() {

        return System.currentTimeMillis()< untouchableTime + 4000;
    }

    public void setUntouchable(long timeout) {
        this.untouchableTime = System.currentTimeMillis();
    }
}
