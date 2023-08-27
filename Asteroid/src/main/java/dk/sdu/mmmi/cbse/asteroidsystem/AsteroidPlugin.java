package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {

    private PositionPart positionPart;
    private AsteroidSizes asteroidSize;
    private float[] radians = {0,3.145f/2,3.145f,3*3145f/2};

    @Override
    public void start(GameData gameData, World world) {

        float radian = radians[new Random().nextInt(radians.length)];

        if (positionPart == null) {
            positionPart = new PositionPart(gameData.getDisplayWidth() - 20, gameData.getDisplayHeight() - new Random().nextInt(gameData.getDisplayHeight() - 10), 2 * 3.145f);
        }
        if(asteroidSize == null){
            asteroidSize = AsteroidSizes.BIG;
        }

        Asteroid asteroid = createAsteroid(radian, positionPart, asteroidSize.getSize());
        asteroid.setUntouchable(2000);
        world.addEntity(asteroid);
        positionPart = null;
        asteroidSize = null;
    }

    public Asteroid createAsteroid(float radian, PositionPart positionPart, int asteroidSize) {
        float deacceleration = 10;
        float acceleration = 20;
        float maxSpeed = 20;
        float rotationSpeed = 5;

        Asteroid asteroid = new Asteroid();



        asteroid.setRadius(asteroidSize);

        asteroid.add(new PositionPart(positionPart.getX(), positionPart.getY(), radian));
        asteroid.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        asteroid.setColor(new int[]{1, 1, 1});
        asteroid.setDamageFactor(5);
        if(asteroidSize == AsteroidSizes.BIG.getSize()){
            asteroid.setLife(3);
        }
        else if (asteroidSize == AsteroidSizes.MEDIUM.getSize()){
            asteroid.setLife(3);
        }
        else if(asteroidSize == AsteroidSizes.SMALL.getSize()){
            asteroid.setLife(3);
        }




        return asteroid;
    }

    public void setPositionPart(PositionPart positionPart) {
        this.positionPart = positionPart;
    }

    public void setAsteroidSize(AsteroidSizes asteroidSize) {
        this.asteroidSize = asteroidSize;
    }

    @Override
    public void stop(GameData gameData, World world) {


    }
}
