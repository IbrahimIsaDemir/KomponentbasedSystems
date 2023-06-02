package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
/**
 * Inteface class for processing an entity and its components. Called every rate before drawing, as a means of updating the game
 */
public interface IEntityProcessingService {

    /**
     * Processes the entity in the game
     * Pre: There is valid gamedata and a world supplied
     * Post: The entity has been processed and component parameters have changed. The entity has been updated and ready to be drwan
     * @param gameData object
     * @param world object
     */
    void process(GameData gameData, World world);
}
