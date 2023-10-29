package Entities;

import Launcher.Handler;
import PhysicsHandlers.PhysicsUtils;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 * Abstract Object that describes an Entity in the Game.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public abstract class Entity {
    protected int x;
    protected int y;
    protected int xSize;
    protected int ySize;
    protected int xStepSize;
    protected int yStepSize;
    protected Rectangle bounds;
    protected Handler handler;
    protected PhysicsUtils physUtil;
    protected ImageIcon sprite;
    protected boolean collidable;



    /**
     * Default Constructor that initialises all integer variables to 0.
     */
    public Entity() {
        this.x = 0;
        this.y = 0;
        this.xSize = 0;
        this.ySize = 0;
        this.xStepSize = 0;
        this.yStepSize = 0;
    }

    /**
     * Constructor method that initializes the variables in the class.
     * @param sprite Image object that represents the entity in the GUI.
     */
    public Entity(ImageIcon sprite, Handler handler) {
        this.xSize = sprite.getIconWidth();
        this.ySize = sprite.getIconHeight();
        this.bounds = new Rectangle(x, y, xSize, ySize);
        this.sprite = sprite;
        this.physUtil = new PhysicsUtils();
        this.yStepSize = PhysicsUtils.GRAVITY;
        this.handler = handler;
    }

    /**
     * Constructor method that initializes the variables in the class.
     * @param sprite Image object that represents the entity in the GUI.
     * @param collidable Shows whether the object can be collided with.
     */
    public Entity(ImageIcon sprite, boolean collidable, Handler handler) {
        this.xSize = sprite.getIconWidth();
        this.ySize = sprite.getIconHeight();
        this.sprite = sprite;
        this.bounds = new Rectangle(x, y, xSize, ySize);
        this.collidable = collidable;
        this.physUtil = new PhysicsUtils();
        this.yStepSize = PhysicsUtils.GRAVITY;
        this.handler = handler;
    }

    public abstract void stepX();

    public abstract void stepY();

    @Override
    public String toString() {
        return String.format("x: %d \ny: %d \nxSize: %d \nySize: %d", x, y, xSize, ySize);
    }

    //Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public int getXStepSize() {
        return this.xStepSize;
    }
    
    public int getYStepSize() {
        return this.yStepSize;
    }

    public ImageIcon getSprite() {
        return sprite;
    }

    protected void setSprite(ImageIcon sprite) {
        this.sprite = sprite;
    } 

    protected PhysicsUtils getPhysicsUtils() {
        return this.physUtil;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public boolean collidable() {
        return this.collidable;
    }
}
