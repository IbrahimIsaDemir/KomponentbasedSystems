package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ShootingPart;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.util.ArrayList;

public class CollisionDetectionSystem implements IPostEntityProcessingService {

    ArrayList<Entity> entities = new ArrayList<>();
    @Override
    public void process(GameData gameData, World world) {

        for (Entity entity1 : world.getEntities()) {

            for (Entity entity2 : world.getEntities()) {
                if (entity2 == entity1) {
                    continue;
                }
                if(entities.contains(entity2)){
                    continue;

                }
               if(entity1.isUntouchable() || entity2.isUntouchable()){
                    continue;
                }

               ShootingPart shootingPart1 = entity1.getPart(ShootingPart.class);
               ShootingPart shootingPart2 = entity2.getPart(ShootingPart.class);
               if(shootingPart1 != null ){
                   if(shootingPart1.isShoot()){
                       continue;
                   }
               }

               if(shootingPart2 != null){
                   if(shootingPart2.isShoot()){
                       continue;
                   }
               }


                PositionPart positionPart1 = entity1.getPart(PositionPart.class);
                PositionPart positionPart2 = entity2.getPart(PositionPart.class);

                float dx = positionPart1.getX() - positionPart2.getX();
                float dy = positionPart1.getY() - positionPart2.getY();

                double distance = Math.sqrt(dx*dx+dy*dy);

                float combinedRadius = entity1.getRadius() + entity2.getRadius();

                if(distance < combinedRadius){

                    System.out.println("Distance " + distance);
                    System.out.println("combinedRadius " + combinedRadius );
                    System.out.println("collision");
                    CollisionEvent collisionEvent = new CollisionEvent(entity1,entity2);
                    world.addEvent(collisionEvent);
                }
                entities.add(entity1);


            }
        }

        entities.clear();
    }
}
