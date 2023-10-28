package World;

import Entities.Background;
import Entities.Ground;
import Entities.Player;
import Launcher.Handler;
import ObstacleHandler.ObstacleList;
import Window.Images;

/**
 * Describes the world that the game takes place.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class World {
    private static final int INITIAL_STEP_SIZE = 5;

    private Player player;
    private Ground g1;
    private Ground g2;
    private ObstacleList obsList;
    private Background bg;
    private Images images;
    private int groundLevel;
    private int jumpCeiling;

    /**
     * Constructor method that initializes all instances of the entities
     * existing in the world.
     * 
     * @param handler object that allows access to variable in Game.
     */
    public World(Handler handler) {
        //Image Loader
        this.images = new Images();

        //Background objects
        this.bg = new Background(0, 200, images.getbackground());
        this.g1 = new Ground(0, bg.getY() + bg.getySize(),
                            images.getroad(), handler, INITIAL_STEP_SIZE);
        this.g2 = new Ground(g1.getxSize(), bg.getY() + bg.getySize(),
                            images.getroad(), handler, INITIAL_STEP_SIZE);
        
        //Set Ground level relative to the ground object
        groundLevel = g1.getY() + (g1.getySize() / 2);

        //Initialise Player Variables
        this.player = new Player(50, groundLevel - images.getpilot().getIconHeight(),
                                 images.getpilot(), handler);
        //Set Jump Ceiling relative to the player height
        jumpCeiling = groundLevel - (player.getySize() * 3);
        this.player.setJumpCeiling(jumpCeiling);

        //Initialize Obstacle Handlers
        this.obsList = new ObstacleList(handler, images.getObstacle(), groundLevel 
                                        - images.getObstacle().getIconHeight(), INITIAL_STEP_SIZE);
        
    }

    /**
     * Code that runs every time the timer in the Game class ticks.
     */
    public void tick() {
        //Update Obstacle Variables
        obsList.tick();

        //Update Player variables
        player.tick();
        
        //Update Ground Variables
        g1.stepX();
        g2.stepX();
    }

    //Getters
    public Player getPlayer() {
        return player;
    }

    public Ground getG1() {
        return g1;
    }

    public Ground getG2() {
        return g2;
    }

    public ObstacleList getObstacleList() {
        return this.obsList;
    }

    public Background getBackground() {
        return this.bg;
    }
    
    public int getGroundLevel() {
        return this.groundLevel;
    }
}
