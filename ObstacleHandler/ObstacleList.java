package ObstacleHandler;

import Entities.Obstacle;
import Launcher.Handler;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * Handles generation of Obstacles in the world.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class ObstacleList {

    private LinkedList<Obstacle> obstacles;
    private Handler handler;
    private ImageIcon sprite;
    private int defaultHeight;
    private int intitalStepSize;

    public ObstacleList(Handler handler, ImageIcon sprite,
                         int defaultHeight, int initalStepSize) {

        obstacles = new LinkedList<Obstacle>();
        this.handler = handler;
        this.defaultHeight = defaultHeight;
        this.intitalStepSize = - initalStepSize;
        this.sprite = sprite;

    }

    //TODO: Implement Obstacle Generation.
    public void generateObstacles() {
        Random rand = new Random();

        if (!(obstacles.isEmpty()) && obstacles.peekFirst().getX() < -sprite.getIconWidth()) {
            obstacles.removeFirst();
        }
        
        while (obstacles.size() < 5) {
            obstacles.addLast(new Obstacle((handler.getWidth())
                            + (rand.nextInt(sprite.getIconWidth() + 700) + sprite.getIconWidth()),
                            defaultHeight + 10, sprite, handler, intitalStepSize));
        }
    }

    public void stepAll() {
        for (Obstacle o : obstacles) {
            o.stepX();
        }
    }

    //Getters and Setters
    public Obstacle getObstacle(int i) {
        return this.obstacles.get(i);
    }

    public Obstacle peekNextObstacle() {
        return this.obstacles.peekFirst();
    }
}
