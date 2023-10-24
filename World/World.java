package World;

import Entities.Ground;
import Entities.Obstacle;
import Entities.Player;
import Launcher.Handler;
import ObstacleHandler.ObstacleList;

/**
 * Describes the world that the game takes place.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class World {
    private Player player;
    private Ground g1;
    private Ground g2;
    private ObstacleList obsList;
    private Obstacle nearestObstacle;
    //TODO: Add Images!

    /**
     * Constructor method that initializes all instances of the entities
     * existing in the world.
     * 
     */
    public World(Handler handler) {
        //TODO: Implement Images!!!
        this.player = new Player(50, 250, null, handler);
        this.g1 = new Ground(0, 300, null, handler);
        this.g2 = new Ground(g1.getxSize(), 300, null, handler);
        this.obsList = new ObstacleList(handler);
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

    public Obstacle getNextObstacle() {
        return obsList.getNextObstacle();
    }    
    
}
