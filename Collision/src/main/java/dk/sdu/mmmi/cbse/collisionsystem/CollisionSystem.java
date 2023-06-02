package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;


public class CollisionSystem implements IEntityProcessingService {

    @Override
    public synchronized void process(GameData gameData, World world) {
        Object[] collissionEventList =  world.getEventList().stream().filter(e -> e instanceof CollisionEvent).toArray();
        System.out.println("CollissionSystemDeleting Object");
        for(Object object : collissionEventList ){



            CollisionEvent collisionEvent = (CollisionEvent) object;

            Entity entity1 = collisionEvent.getSource();
            Entity entity2 = collisionEvent.getSource2();


            entity1.setUntouchable(true);
            entity2.setUntouchable(true);
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2500);
                        System.out.println("hello");
                        entity1.setUntouchable(false);
                        entity2.setUntouchable(false);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();



            //dont react to asteroid - asteroid collision or bullet to bullet collision
            if(entity1.getClass() != entity2.getClass()){
                entity1.setHit(true);
                entity2.setHit(true);
                entity1.reduceLife(entity2.getDamageFactor());
                entity2.reduceLife(entity1.getDamageFactor());
            }



            if(entity1.getLife() <= 0){
                world.removeEntity(entity1);
            }
            if(entity2.getLife() <= 0){
                world.removeEntity(entity2);
            }
        }
    }
}
