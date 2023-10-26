package Window;

import javax.swing.ImageIcon;

/**
 * Imports Images into the Program
 * 
 * @author Daniele Guggino
 * @id 
 */
public class Images {
    
    ImageIcon background = new ImageIcon("./bg.jpg");
    ImageIcon road = new ImageIcon("./road.jpg");
    ImageIcon pilot = new ImageIcon("./daniel.png");
    ImageIcon obstacle = new ImageIcon("./obstacle.png");

    public Images() {

    }
    
    public ImageIcon getbackground() {
        return this.background;
    }

    public ImageIcon getroad() {
        return this.road;
    }

    public ImageIcon getpilot() {
        return this.pilot;
    }

    public ImageIcon getObstacle() {
        return this.obstacle;
    }
}
