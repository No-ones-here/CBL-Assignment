package States;

import Entities.Ground;
import Entities.Player;
import Launcher.Handler;
import ObstacleHandler.ObstacleList;
import World.World;

/**
 * Handles Events while the game is running.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class GameState extends State {
    private Handler handler;
    private World world;

    public GameState(Handler handler) {
        this.handler = handler;
        this.world = new World(handler);
        handler.setWorld(world);
    }

    @Override
    public void run() {
        // TODO: Add Game Processes

    }
}
