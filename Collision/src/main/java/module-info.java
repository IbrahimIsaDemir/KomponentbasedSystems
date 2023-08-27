import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    requires spring.core;
    opens dk.sdu.mmmi.cbse.collisionsystem to spring.core;
    exports dk.sdu.mmmi.cbse.collisionsystem;
    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.collisionsystem.CollisionDetectionSystem;

}