package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {

    /**
     * Inserts the entity into the game.
     * @param gameData object
     * @param world object
     */
    void start(GameData gameData, World world);

    /**
     * removes the entity from the game.
     * @param gameData object
     * @param world object
     */
    void stop(GameData gameData, World world);
}
