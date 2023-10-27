package Entities;

import javax.swing.ImageIcon;

public class Background {
    private ImageIcon sprite;
    private int x;
    private int y;
    private int xSize;
    private int ySize;

    public Background() {

    }

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
