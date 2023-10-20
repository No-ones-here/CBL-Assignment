package Entities;

import javax.swing.ImageIcon;

/**
 * Abstract Object that represents the Player in the program.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class Player extends Entity{
    private boolean wheelieState;

    public Player() {
        super();
    }

    public Player(int initialX, int initialY, ImageIcon sprite) {
        super(sprite.getIconWidth(), sprite.getIconHeight(), sprite, true);
        super.setX(initialX);
        super.setY(initialY);
    }
    
    //Getters and Setters
    public boolean isWheelieState() {
        return wheelieState;
    }

    public void setWheelieState(boolean wheelieState) {
        this.wheelieState = wheelieState;
    }
    
}
