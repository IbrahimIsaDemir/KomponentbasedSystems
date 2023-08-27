package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService {


    @Override
    public void process(GameData gameData, World world) {


        System.out.println("bullet processing ongoing");

        for (Entity entity : world.getEntities(Bullet.class)) {

            Bullet bullet = (Bullet) entity;

            System.out.println("BULLETS:" + world.getEntities(Bullet.class));

            PositionPart bulletPosition = bullet.getPart(PositionPart.class);
            if(bulletPosition.getX()> gameData.getDisplayWidth() ||
            bulletPosition.getX()< 0 ||
            bulletPosition.getY()> gameData.getDisplayHeight() ||
            bulletPosition.getY()< 0){
                world.removeEntity(bullet);
            }else {
                float bulletx = bulletPosition.getX();
                float bullety = bulletPosition.getY();
                bulletx += (float) (bullet.getSpeed() * Math.cos(bulletPosition.getRadians()) * gameData.getDelta());
                bullety += (float) (bullet.getSpeed() * Math.sin(bulletPosition.getRadians()) * gameData.getDelta());
                bulletPosition.setX(bulletx);
                bulletPosition.setY(bullety);
            }




        }









}




}
