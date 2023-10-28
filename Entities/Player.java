package Entities;

import Launcher.Handler;
import PhysicsHandlers.PhysicsUtils;
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

    public Player(int initialX, int initialY, ImageIcon sprite, Handler handler) {
        super(sprite, handler);
        super.setX(initialX);
        super.setY(initialY);
        super.xStepSize = 0;
        super.yStepSize = 0;
    }
    
    public void tick(){
        if (handler.getKeyHandler().getJump()) {
            jump();
            //TODO: TEMPORARY CODE//////////
            System.out.println("JUMPED");
            //////////////////////////////
        }
        if (handler.getKeyHandler().getWheelie()) {
            wheelieState = true;
            //TODO: TEMPORARY CODE////////////
            System.out.println("Wheelied");
        }
        stepY();
    }

    public void jump() {
        yStepSize = -20;
    }

    @Override
    public void stepX() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stepX'");
    }

    @Override
    public void stepY() {
        //GRAVITY
        if (physUtil.checkCollisionY(this, handler.getWorld().getGroundLevel())) {
            yStepSize = 0;
        } else {
            yStepSize += PhysicsUtils.GRAVITY;
            setY(getY() + getYStepSize());
        }
    }
    

    
    //Getters and Setters
    public boolean isWheelieState() {
        return wheelieState;
    }

    public void setWheelieState(boolean wheelieState) {
        this.wheelieState = wheelieState;
    }    
}
