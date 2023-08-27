package dk.sdu.mmmi.cbse.enemysystem;


import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ShootingPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.ArrayList;
import java.util.List;

public class EnemyControlSystem implements IEntityProcessingService {


    private List<Integer> moveCounter = new ArrayList<>();
    private boolean isMoveDone = false;
    int direction = 0;

    float dx = 0, dy = 0;


    private int shotCounter;

    @Override
    public void process(GameData gameData, World world) {



        for (Entity entity : world.getEntities(Enemy.class)) {
            Enemy enemy = (Enemy) entity;
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);



            if(positionPart.getX() <= enemy.getStartingPosition().getX() &&  positionPart.getY()<= gameData.getDisplayHeight() - enemy.getStartingPosition().getY()  ){
                direction = 1;
                if(!moveCounter.contains(direction)){
                    moveCounter.add(direction);
                }

            }
            else if( positionPart.getX() < gameData.getDisplayWidth() - enemy.getStartingPosition().getX() && positionPart.getY() >= gameData.getDisplayHeight() - enemy.getStartingPosition().getY()){
                direction = 2;

                if(!moveCounter.contains(direction)){
                    moveCounter.add(direction);
                }
            }
            else if(positionPart.getX() >= gameData.getDisplayWidth() - enemy.getStartingPosition().getX() && positionPart.getY() >=  enemy.getStartingPosition().getY()){
                direction = 3;
                if(!moveCounter.contains(direction)){
                    moveCounter.add(direction);
                }
            }
            else if(positionPart.getX() >= enemy.getStartingPosition().getX() && positionPart.getY() <= enemy.getStartingPosition().getY()){
                direction = 4;
                if(!moveCounter.contains(direction)){
                    moveCounter.add(direction);
                }
            }





            switch (direction) {
                case 1 : {


                    dy += movingPart.getAcceleration() * gameData.getDelta();
                    dx = 0;

                    if(!(positionPart.getRadians() <=0 || positionPart.getRadians() ==2*3.1415f) ){
                        movingPart.setLeft(false);
                        movingPart.setRight(true);
                    }
                    else {
                        movingPart.setRight(false);
                        positionPart.setRadians(2*3.1415f);
                    }

                }
                break;
                case 2 : {
                    dx += movingPart.getAcceleration() * gameData.getDelta();
                    dy = 0;
                    if(positionPart.getRadians()>=(3*3.1415f)/2){
                        movingPart.setRight(true);
                    }
                    else movingPart.setRight(false);
                }
                break;

                case 3 : {
                    dy -= movingPart.getAcceleration() * gameData.getDelta();
                    dx = 0;
                    if(!(positionPart.getRadians()<=3.1415f)){
                        movingPart.setRight(true);
                    }
                    else movingPart.setRight(false);
                }
                break;
                case 4 : {
                    dx -= movingPart.getAcceleration() * gameData.getDelta();
                    dy = 0;
                    if(!(positionPart.getRadians()<=3.1415f/2)){
                        movingPart.setRight(true);
                    }
                    else movingPart.setRight(false);
                }
                break;
            }

            //shooting

            shotCounter++;

            ShootingPart shootingPart = enemy.getPart(ShootingPart.class);

            shootingPart.setShoot(shotCounter % 100 == 0);

            if(shootingPart.isShoot()){
                enemy.setUntouchable(2000);
            }



            if(moveCounter.size() == 4){
                isMoveDone = true;
                moveCounter.clear();
            }


            float positionx = positionPart.getX();
            positionx += dx * gameData.getDelta();

            float positiony = positionPart.getY();
            positiony += dy * gameData.getDelta();

            //wrap

            if (positionx > gameData.getDisplayWidth()) {
                positionx = 0;
            } else if (positionx < 0) {
                positionx = gameData.getDisplayWidth();
            }


            if (positiony > gameData.getDisplayHeight()) {
                positiony = 0;
            } else if (positiony< 0) {
                positiony = gameData.getDisplayHeight();
            }


            positionPart.setX(positionx);
            positionPart.setY(positiony);
            movingPart.process(gameData,enemy);

            updateShape(enemy);
        }


    }





    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 8);
        shapey[0] = (float) (y + Math.sin(radians) * 8);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 8);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 8);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 5);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 5);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 8);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 8);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
