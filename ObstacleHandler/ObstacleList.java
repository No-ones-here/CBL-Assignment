package ObstacleHandler;

import Entities.Obstacle;
import Launcher.Handler;
import java.util.LinkedList;

/**
 * Handles generation of Obstacles in the world.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class ObstacleList {
    private LinkedList<Obstacle> obstacles;
    private int counter;
    private Handler handler;

    public ObstacleList(Handler handler) {
        obstacles = new LinkedList<Obstacle>();
        this.counter = 0;
        this.handler = handler;
    }

    public void generateObstacles() {
        //TODO: Temporary Code//////////////////////////////////////////////
        obstacles.addLast(new Obstacle(0, 0, null, handler));
        ////////////////////////////////////////////////////////////////////
    }

    //Getters and Setters
    public Obstacle getNextObstacle() {
        return this.obstacles.removeFirst();
    }
}
