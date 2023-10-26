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
    private int counter;
    private int incrementInterval;
    private double stepMultiplier;
    private boolean playing;

    public GameState(Handler handler) {
        this.handler = handler;
        this.world = new World(handler);
        this.incrementInterval = 60 * 10;
        this.stepMultiplier = 1.25;
        handler.setWorld(world);
    }

    @Override
    public void tick() {
        // TODO: Add Game Processes

        //Generate Obstacles
        world.getObstacleList().generateObstacles();

        //Update Obstacle Variables
        world.getObstacleList().stepAll();

        //Update Variables
        world.getG1().stepX();
        world.getG2().stepX();

        //Increasing Speed of Road as Game Progresses.
        counter++;
        if (counter >= incrementInterval) {
            world.getG1().setStepSize((int) (world.getG1().getXStepSize() * stepMultiplier));
            world.getG2().setStepSize((int) (world.getG2().getXStepSize() * stepMultiplier));
            counter = 0;
            //TODO: TEST CODE
            System.out.println("INCREMENTED!");
        }
    }

    @Override
    public void render() {
        //TODO: Implement Graphic Rendering
        handler.getWindow().runGame();
    }

    public void start() {
        playing = true;

        //Generate Initial Obstacles
        world.getObstacleList().generateObstacles();
    }

    //Setters and Getters
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    
    public boolean getPlaying() {
        return this.playing;
    }
}
