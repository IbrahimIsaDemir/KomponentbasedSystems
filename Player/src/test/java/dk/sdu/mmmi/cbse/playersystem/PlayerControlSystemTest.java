package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ShootingPart;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static dk.sdu.mmmi.cbse.common.data.GameKeys.SPACE;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class PlayerControlSystemTest {

    private Player player;
    private PlayerControlSystem playerControlSystem;
    private World world;
    private GameData gameData;

    @org.junit.Before
    public void setUp() throws Exception {


        this.player = new Player();
        this.playerControlSystem = new PlayerControlSystem();
        this.world = Mockito.mock(World.class);
        this.gameData = Mockito.mock(GameData.class);

        ShootingPart shootingpart = Mockito.mock(ShootingPart.class);

        when(world.getEntities()).thenReturn(Arrays.asList(player, new Entity(), new Entity()));
        world.addEntity(player);
        when(gameData.getKeys()).thenReturn(Mockito.mock(GameKeys.class));
        when(gameData.getKeys().isDown(GameKeys.LEFT)).thenReturn(true);
        when(gameData.getKeys().isPressed(SPACE)).thenReturn(true);
        when(shootingpart.isShoot()).thenReturn(true);

        player.add(shootingpart);
        player.add(Mockito.mock(MovingPart.class));
        player.add(Mockito.mock(PositionPart.class));
        player.setLife(3);
        player.setColor(new int[]{1,1,1});
        player.setDamageFactor(1);
        player.setShape("Ship");

    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void playerUntouchableWhenShoots() {
       playerControlSystem.process(gameData,world);
      // assert player.isUntouchable();


    }


}