package Entities;

import javax.swing.ImageIcon;
/**
 * Background entity.
 * @author Daniele Guggino
 * @id 1933620
 * 
 * @author Luis Santos
 * @id 1998544
 * 
 * @date 29/10/2023
 * 
 */

public class Background {
    private ImageIcon sprite;
    private int x;
    private int y;
    private int xSize;
    private int ySize;

    /**
     * Background features.
     * @param x length;
     * @param y height;
     * @param sprite image;
     */
    public Background(int x, int y, ImageIcon sprite) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.xSize = sprite.getIconWidth();
        this.ySize = sprite.getIconHeight();
    }


    //Getters
    public ImageIcon getSprite() {
        return sprite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    
    
}
