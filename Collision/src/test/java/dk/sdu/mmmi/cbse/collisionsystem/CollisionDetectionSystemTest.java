package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollisionDetectionSystemTest {

    Entity entity;
    Entity entity2;
    CollisionDetectionSystem collisionDetectionSystem;

    @org.junit.Before
    public void setUp() throws Exception {
        float x = 2;
        float y = 10;
        float radians = 3.1415f / 2;
        entity = new Entity();
        entity2 = new Entity();
        entity.setRadius(10);
        entity2.setRadius(10);
        entity.add(new PositionPart(x,y,radians));
        entity2.add(new PositionPart(x, y, radians));
        collisionDetectionSystem = new CollisionDetectionSystem();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void detectCollisionTest() {
        System.out.println("collides");


        Boolean expResult = true;
        Boolean result = collisionDetectionSystem.collides(entity, entity2);

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}