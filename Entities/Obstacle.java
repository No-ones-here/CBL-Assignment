package Entities;

import javax.swing.ImageIcon;

public class Obstacle extends Entity{
    private int stepSize;

    public Obstacle() {
        super();
    }

    public Obstacle(int initialX, int initialY, ImageIcon sprite) {
        super(sprite.getIconWidth(), sprite.getIconHeight(), sprite, true);
        super.setX(initialX);
        super.setY(initialY);
    }

    /**
     * Increments the x coordinate of the Obstacle by the stepSize
     */
    public void step() {
        super.setX(super.getX() + stepSize);
    }
}
