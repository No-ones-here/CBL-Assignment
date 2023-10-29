package ObstacleHandler;

import Entities.Obstacle;
import Launcher.Handler;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 * Handles generation of Obstacles in the world.
 * @author Daniele Guggino
 * @id 1933620
 * 
 * @author Luis Santos
 * @id 1998544
 * 
 * @date 29/10/2023
 */
public class ObstacleList {

    private LinkedList<Obstacle> obstacles;
    private Handler handler;
    private ImageIcon sprite;
    private int defaultHeight;
    private int currentStepSize;

    /**
     * Constructor method that initializes the instance variables of the
     * class.
     * 
     * @param handler object that allows access to vars in Game class
     * @param sprite image that represents the obstacles
     * @param defaultHeight top-left height of the obstacles
     * @param initalStepSize starting step size of the obstacle
     */
    public ObstacleList(Handler handler, ImageIcon sprite,
                         int defaultHeight, int initalStepSize) {

        obstacles = new LinkedList<Obstacle>();
        this.handler = handler;
        this.defaultHeight = defaultHeight;
        this.currentStepSize = - initalStepSize;
        this.sprite = sprite;

    }

    /**
     * Generates 5 obstacles in a Linked List. If an obstacle moves out of the
     * frame, it is removed and another is generated at other end of the frame behind
     * the last obstacle.
     * 
     */
    public void generateObstacles() {
        Random rand = new Random();
        Obstacle previous;
        int bottomLimit;

        if (!(obstacles.isEmpty()) && obstacles.peekFirst().getX() < -sprite.getIconWidth()) {
            obstacles.removeFirst();
        }
        
        while (obstacles.size() < 5) {
            //Empty List Check
            if (obstacles.isEmpty()) {
                obstacles.addLast(new Obstacle(handler.getWidth(), defaultHeight + 10,
                                     sprite, handler, currentStepSize));
            }

            //Generate Obstacle in order
            previous = obstacles.getLast();
            bottomLimit = previous.getX() + previous.getxSize() 
                        + (handler.getWorld().getPlayer().getxSize() * 2);
            
            //Check for on-screen bottom limit.
            if (bottomLimit < handler.getWidth()) {
                bottomLimit = handler.getWidth();
            }

            //Generate and Add new obstacle into list.
            obstacles.addLast(new Obstacle(rand.nextInt(500) + bottomLimit, 
                                            defaultHeight + 10, sprite, handler,
                                            currentStepSize));
        }
    }

    /**
     * Method that runs every time the game ticks.
     * Updates the position variables of the obstacles stored in the class.
     * 
     */
    public void tick() {
        for (Obstacle o : obstacles) {
            o.setXStepSize(currentStepSize);
            o.tick();
        }
    }

    //Getters and Setters
    public Obstacle getObstacle(int i) {
        return this.obstacles.get(i);
    }

    public Obstacle peekNextObstacle() {
        return this.obstacles.peekFirst();
    }

    public int getStepSize() {
        return this.currentStepSize;
    }

    public void setStepSize(int stepSize) {
        this.currentStepSize = stepSize;
    }
}
