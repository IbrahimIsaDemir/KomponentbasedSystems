package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ShootingPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;

    public EnemyPlugin() {

    }

    @Override
    public void start(GameData gameData, World world) {
        // Add entities to the world
        enemy = createEnemyShip(gameData,world);
        world.addEntity(enemy);
    }

    private Entity createEnemyShip(GameData gameData, World world) {

        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / 7;
        float y = gameData.getDisplayHeight() / 8;
        float radians = 3.1415f / 2;

        Enemy enemyShip = new Enemy();
        enemyShip.setStartingPosition(new PositionPart(x,y,radians));
        enemyShip.add(new ShootingPart(100));
        enemyShip.add(new LifePart(1,5));

        enemyShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        enemyShip.add(new PositionPart(x, y, radians));
        enemyShip.setColor(new int[]{1,0,0});
        float dx =  (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 10) - x;
        float dy = (float) (y+ Math.cos(radians - 4 * 3.1415f / 5) * 10)  - y;
        float vecLength = (float) Math.sqrt(dx*dx + dy*dy);

        enemyShip.setRadius(vecLength );
        System.out.println("dx og dy " +dx +dy);
        System.out.println("enemy radius" +vecLength);
        enemyShip.setRadius(vecLength);
        enemyShip.setDamageFactor(1);
        enemyShip.setShape("Ship");
        enemyShip.setLife(3);



        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy);
    }
}
