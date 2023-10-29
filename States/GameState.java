package States;

import Launcher.Handler;
import PointsSystem.PointsHandler;
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
    private PointsHandler pH;

    /**
     * Constructor method that initialises all the variables in the Gamestate.
     * 
     * @param handler object that allows access to variables in the Game class
     */
    public GameState(Handler handler) {
        this.handler = handler;
        this.incrementInterval = 60 * 10;
        this.stepMultiplier = 1.25;
    }

    @Override
    public void tick() {
        //Generate Obstacles
        world.getObstacleList().generateObstacles();

        //Update variables of the World.
        world.tick();

        //Update Points System
        pH.tick();

        //Increasing Speed of Road as Game Progresses.
        counter++;
        if (counter >= incrementInterval) {
            world.getG1().setStepSize((int) (world.getG1().getXStepSize() * stepMultiplier));
            world.getG2().setStepSize((int) (world.getG2().getXStepSize() * stepMultiplier));
            counter = 0;
        }
    }

    @Override
    public void render() {
        handler.getWindow().runGame();
    }

    /**
     * Processes that need to be done at the start of the Game.
     * Must be called whenever swapping into this state.
     */
    public void start() {
        playing = true;

        //Initialize Required Game Varaibles
        this.world = new World(handler);
        this.pH = new PointsHandler(handler);
        handler.setWorld(world);

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
    
    public PointsHandler getPointsHandler() {
        return this.pH;
    }
}
