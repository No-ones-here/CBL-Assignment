package Entities;

import Launcher.Handler;
import javax.swing.ImageIcon;

public class Obstacle extends Entity{

    public Obstacle() {
        super();
    }

    public Obstacle(int initialX, int initialY, ImageIcon sprite,
                     Handler handler, int xStepSize) {
        super(sprite, true, handler);
        super.setX(initialX);
        super.setY(initialY);
        super.xStepSize = xStepSize;
    }

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
        //TODO: EMPTY METHOD
    }
}
