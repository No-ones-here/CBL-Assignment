package Entities;

import Launcher.Handler;
import javax.swing.ImageIcon;

/**
 * Abstract representation of the ground in the game.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class Ground extends Entity{
    private int stepSize;

    public Ground() {
        super();
        this.stepSize = 0;
    }
    
    public Ground(int x, int y, ImageIcon sprite, Handler handler) {
        super(sprite, true, handler);
        super.setX(x);
        super.setY(y);
    }

    /**
     * Increments the x coordinate of the ground by the stepSize.
     */
    public void step() {
        super.setX(super.getX() + stepSize);
    }

    //Getters and Setters
    public void setStepSize(int stepSize) {
        this.stepSize = stepSize;
    }

    
    @Override
    public void stepX() {
        
        
    }

    @Override
    public void stepY() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stepY'");
    }
}
