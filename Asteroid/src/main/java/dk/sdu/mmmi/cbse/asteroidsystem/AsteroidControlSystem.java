package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.ServiceLoader;

public class AsteroidControlSystem implements IEntityProcessingService {
    private int asteroidCounter;
    private AsteroidPlugin asteroidPlugin = new AsteroidPlugin();


    @Override
    public void process(GameData gameData, World world) {
        asteroidCounter++;
        if(asteroidCounter%500 == 0){
            asteroidPlugin.start(gameData,world);
        }

        for(Entity entity : world.getEntities(Asteroid.class)){
            Asteroid asteroid = (Asteroid) entity;
            MovingPart movingPart = asteroid.getPart(MovingPart.class);
            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            movingPart.setUp(true);




            if(asteroid.isHit()){

                asteroid.setUntouchable(2000);

                if(asteroid.getRadius() == AsteroidSizes.BIG.getSize()){
                    asteroid.setRadius(AsteroidSizes.MEDIUM.getSize());
                    asteroidPlugin.setAsteroidSize(AsteroidSizes.MEDIUM);
                }
                else if(asteroid.getRadius() == AsteroidSizes.MEDIUM.getSize()){
                    asteroid.setRadius(AsteroidSizes.SMALL.getSize());
                    asteroidPlugin.setAsteroidSize(AsteroidSizes.SMALL);
                }


                asteroidPlugin.setPositionPart(new PositionPart(positionPart.getX(), positionPart.getY(), positionPart.getRadians()));
                asteroidPlugin.start(gameData,world);
                asteroid.setHit(false);
            }


            movingPart.process(gameData,asteroid);


        }
    }
}
