package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.ShootingPart;
import dk.sdu.mmmi.cbse.common.events.Event;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

public class BulletEventSystem implements IPostEntityProcessingService {
    private BulletPlugin bulletPlugin = new BulletPlugin();

    @Override
    public void process(GameData gameData, World world) {
        //If someones shoot, create bulletplugin to plug bullet in game
        for(Entity entity : world.getEntities()){
            ShootingPart shootingPart = entity.getPart(ShootingPart.class);
            if(shootingPart!=null){
                if(shootingPart.isShoot()){

                    Event event = new BulletEvent(entity);

                    world.addEvent(event);
                    System.out.println("shoot");

                    bulletPlugin.start(gameData,world);


                }
            }
        }

    }
}
