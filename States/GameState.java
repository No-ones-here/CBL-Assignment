package States;

import Launcher.Handler;
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
    public void tick() {
        // TODO: Add Game Processes
        
    }

    public void render() {
        //TODO: Implement Graphic Rendering
        handler.getWindow().runGame();
    }
}
