package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ShootingPart;
import dk.sdu.mmmi.cbse.common.events.Event;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

public class BulletPlugin implements IGamePluginService {


    @Override
    public void start(GameData gameData, World world) {

        System.out.println("bullet plugin started");
        System.out.println("bullet plugin started");

//read bullet events
        for (Event event : world.getEventList()) {
            if (event instanceof BulletEvent) {
                Bullet bullet = createBullet(event);
                world.addEntity(bullet);
            }


        }
    }

        private Bullet createBullet (Event event){



            Entity entity = event.getSource();
            Bullet bullet = new Bullet();
            PositionPart positionPart = entity.getPart(PositionPart.class);
            ShootingPart shootingPart = entity.getPart(ShootingPart.class);
            bullet.add(new PositionPart(entity.getShapeX()[0], entity.getShapeY()[0], positionPart.getRadians()));
            bullet.setSpeed(shootingPart.getShootingSpeed());
            bullet.setColor(entity.getColor());
            bullet.setRadius(2);
            bullet.setDamageFactor(1);
            bullet.setLife(1);
            bullet.setUntouchable(1000);


            return bullet;


        }




    @Override
    public void stop(GameData gameData, World world) {
        //if ishit remove bullet

    }
}
