package Entities;

import javax.swing.ImageIcon;

public class Obstacle extends Entity{
    
    public Obstacle() {
        super();
    }

    public Obstacle(int initialX, int initialY, ImageIcon sprite) {
        super(sprite.getIconWidth(), sprite.getIconHeight(), sprite, true);
        super.setX(initialX);
        super.setY(initialY);
    }
}
