package Entities;

import java.awt.Image;
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
    private Image sprite;

    public Entity() {
        this(0, 0, null);
    }

    public Entity(int xSize, int ySize, Image sprite) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.sprite = sprite;
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

    public Image getSprite() {
        return sprite;
    }
}
