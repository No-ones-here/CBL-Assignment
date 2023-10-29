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
public class Player extends Entity {
    private boolean wheelieState;
    private ImageIcon wSprite;
    private boolean jumpState;
    private int jumpCeiling;

    public Player() {
        super();
    }

    /**
     * Constructor that initialises the variables of the Player objects.
     * 
     * @param initialX initial x coordinate
     * @param initialY initial y coordinate
     * @param sprite image that represents the player
     * @param handler object that allows access to variables in Game class
     */
    public Player(int initialX, int initialY, ImageIcon sprite, Handler handler) {
        super(sprite, handler);
        super.setX(initialX);
        super.setY(initialY);
        super.xStepSize = 0;
        super.yStepSize = 0;
    }
    
    /**
     * Code that runs everytime the game ticks.
     * This checks for a jump and wheelie input and updates the 
     * variables accordingly.
     */
    public void tick() {
        if (handler.getKeyHandler().getJump() && !jumpState) {
            jumpState = true;
            jump();
        }
        wheelieState = handler.getKeyHandler().getWheelie();

        stepY();
    }

    public void jump() {
        yStepSize = -20;
    }

    
    @Override
    public void stepX() {
        // Unnecessary Implementation of Abstract Method.
    }

    @Override
    public void stepY() {
        // GRAVITY
        if (physUtil.checkCollisionY(this, handler.getWorld().getGroundLevel())) {
            y = handler.getWorld().getGroundLevel() - ySize;
            jumpState = false;
            yStepSize = 0;
        } else {
            yStepSize += PhysicsUtils.GRAVITY;
            setY(getY() + getYStepSize());
        }

        // Jump Ceiling
        if (physUtil.checkJumpCollision(this, jumpCeiling)) {
            yStepSize = 0;
        } else {
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

    public int getJumpCeiling() {
        return this.jumpCeiling;
    }

    public void setJumpCeiling(int jumpCeiling) {
        this.jumpCeiling = jumpCeiling;
    }
    
    public void setWSprite(ImageIcon img) {
        this.wSprite = img;
    }

    public ImageIcon getWSprite() {
        return this.wSprite;
    }
}
