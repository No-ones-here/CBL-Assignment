package Entities;

import javax.swing.ImageIcon;
/**
 * Abstract Object that describes an Entity in the Game.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class Entity {
    private int x;
    private int y;
    private int xSize;
    private int ySize;
    private ImageIcon sprite;
    private boolean collidable;

    public Entity() {
        this(0, 0, null, false);
    }

    public Entity(int xSize, int ySize, ImageIcon sprite, boolean collidable) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.sprite = sprite;
        this.collidable = collidable;
    }

    @Override
    public String toString() {
        return String.format("x: %d \ny: %d \n xSize: %d \n ySize: %d", x, y, xSize, ySize);
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

    public ImageIcon getSprite() {
        return sprite;
    }
    protected void setSprite(ImageIcon sprite) {
        this.sprite = sprite;
    } 

    public boolean collidable() {
        return this.collidable;
    }
}
