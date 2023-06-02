package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Inteface class for processing an entity and its components after a initial processing.
 */
public interface IPostEntityProcessingService  {

        /**
         * Processes the entity after its initial process in the game
         * Pre: There is valid gamedata and a world supplied
         * Post: The entity has been processed and component parameters have changed. The entity has been updated and ready to be drwan
         * @param gameData object
         * @param world object
         */
        void process(GameData gameData, World world);
}
