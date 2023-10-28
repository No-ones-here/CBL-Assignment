package Entities;

import Launcher.Handler;
import javax.swing.ImageIcon;


/**
 * Abstract Object that represents the Player in the program.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class Player extends Entity {
    private boolean wheelieState;
    private ImageIcon wSprite;

    public Player() {
        super();
    }

    public Player(int initialX, int initialY, ImageIcon sprite, Handler handler) {
        super(sprite, true, handler);
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
        wheelieState = handler.getKeyHandler().getWheelie();

        stepY();
    }

    public void jump() {
        yStepSize = 100;
    }

    
    @Override
    public void stepX() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stepX'");
    }

    @Override
    public void stepY() {
        if (!super.getPhysicsUtils().checkCollisionY(this, handler.getWorld().getG1())
            || !super.getPhysicsUtils().checkCollisionY(this, handler.getWorld().getG2())) {

            setY(getY() + getYStepSize());
            
        } else {
            //TODO: Temporary Code////////
            // System.out.printf("Collision on %d", (getY() + getySize()));
            //////////////////////////////
        }
    }
    

    
    //Getters and Setters
    public boolean isWheelieState() {
        return wheelieState;
    }

    public void setWheelieState(boolean wheelieState) {
        this.wheelieState = wheelieState;
    }
    
    public void setWSprite(ImageIcon img) {
        this.wSprite = img;
    }

    public ImageIcon getWSprite() {
        return this.wSprite;
    }
}
