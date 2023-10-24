package Entities;

import Launcher.Handler;
import javax.swing.ImageIcon;

public class Obstacle extends Entity{
    private int stepSize;

    public Obstacle() {
        super();
    }

    public Obstacle(int initialX, int initialY, ImageIcon sprite, Handler handler) {
        super(sprite, true, handler);
        super.setX(initialX);
        super.setY(initialY);
    }

    /**
     * Increments the x coordinate of the Obstacle by the stepSize.
     */
    public void step() {
        super.setX(super.getX() + stepSize);
    }

    @Override
    public void stepX() {
        if (!super.getPhysicsUtils().checkCollisionX(this, handler.getWorld().getPlayer())) {
            setX(getX() + getXStepSize());
        } else {
            //TODO: Temporary Code////////
            System.out.printf("Collision on %d . GAME OVER!", (getX() + getxSize()));
            //////////////////////////////
        }
    }

    @Override
    public void stepY() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stepY'");
    }
}
