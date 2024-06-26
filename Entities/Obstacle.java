package Entities;

import Launcher.Handler;
import javax.swing.ImageIcon;

/**
 * Abstract representation of an Obstacle in the game.
 * @author Daniele Guggino
 * @id 1933620
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class Obstacle extends Entity {

    public Obstacle() {
        super();
    }

    /**
     * Constructor that initialises the location of the obstacle and
     * sprite of the obstacle.
     * 
     * @param initialX  initial x coordinate
     * @param initialY initial y coordinate
     * @param sprite image of the obstacle
     * @param handler object that allows access to variables in the Game class
     * @param xStepSize x distance moved per tick
     */
    public Obstacle(int initialX, int initialY, ImageIcon sprite,
                     Handler handler, int xStepSize) {
        super(sprite, true, handler);
        super.setX(initialX);
        super.setY(initialY);
        super.xStepSize = xStepSize;
    }

    /**
     * Code that is run every tick. Mostly to update variables.
     */
    public void tick() {
        boolean checkCollisionX = physUtil.checkCollisionX(this, handler.getWorld().getPlayer());
        boolean checkCollisionY = physUtil.checkCollisionY(handler.getWorld().getPlayer(), this);

        if (!checkCollisionX && checkCollisionY) {

            stepX();

        } else if (checkCollisionX && !checkCollisionY) {

            stepX();

        } else if (checkCollisionX && checkCollisionY) {
            
            handler.getWindow().generateGameOver();
            handler.setPlaying(false);
            
        } else {
            stepX();
        }
    }

    @Override
    public void stepX() {
        setX(getX() + getXStepSize());
    }

    @Override
    public void stepY() {
        //Unnecessary Abstract Method Implementation
    }

}
