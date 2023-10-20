package Entities;

import javax.swing.ImageIcon;
/**
 * Abstract representation of the ground in the game.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class Ground extends Entity{
    
    public Ground() {
        super();
    }
    
    public Ground(int x, int y, ImageIcon sprite) {
        super(sprite.getIconWidth(), sprite.getIconHeight(), sprite, true);
        super.setX(x);
        super.setY(y);
    }

    /**
     * Increments the x coordinate of the ground by the stepSize.
     * 
     * @param stepSize int that stores the size of the each step
     */
    public void step(int stepSize) {
        super.setX(super.getX() + stepSize);
    }
}
