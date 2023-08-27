import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Bullet {
    requires Common;
    requires spring.core;
    opens dk.sdu.mmmi.cbse.bulletsystem to spring.core;
    exports dk.sdu.mmmi.cbse.bulletsystem;
    provides IGamePluginService with dk.sdu.mmmi.cbse.bulletsystem.BulletPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.bulletsystem.BulletControlSystem;
    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.bulletsystem.BulletEventSystem;

}