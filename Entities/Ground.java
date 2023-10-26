package Entities;

import Launcher.Handler;
import javax.swing.ImageIcon;

/**
 * Abstract representation of the ground in the game.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class Ground extends Entity {
    private int initialX;

    /**
     * Default constructor method without input variables.
     */
    public Ground() {
        super();
        this.xStepSize = 0;
    }
    
    /**
     * Constructor method that initializes the variables of the class.
     * 
     * @param x describes initial x coordinates of road
     * @param y describes y coordinates of road
     * @param sprite image that represents road on the GUI
     * @param handler object that grants access to variables in Game
     * @param xStepSize int that describes movement size per tick
     */
    public Ground(int x, int y, ImageIcon sprite, Handler handler, int xStepSize) {
        super(sprite, true, handler);
        super.setX(x);
        super.setY(y);
        this.xStepSize = xStepSize;
        this.initialX = x;
    }

    /**
     * Increments the x coordinate of the ground by the stepSize.
     */
    public void step() {
        super.setX(super.getX() + xStepSize);
    }

    //Getters and Setters
    public void setStepSize(int stepSize) {
        this.xStepSize = stepSize;
    }

    
    @Override
    public void stepX() {
        if (x <= initialX - super.xSize) {
            x = initialX;
            x -= xStepSize;
        } else {
            x -= xStepSize;
        }
    }

    @Override
    public void stepY() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stepY'");
    }
}
