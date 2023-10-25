package Window;

import World.World;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



/**
 * Class that Handles the Animations of the GUI.
 * 
 * TODO: FILL IN JAVADOC
 * @author Daniele Guggino
 * @id 193...
 * @author Luis Santos
 * @id 1998544
 */
public class Animation {
    Window w;
    World world;

    public Animation(Window win) {
        this.w = win;
    }

    /**
     * Creates a loop with swing Timer to run the animations on the
     * Window.
     * 
     */
    public void runAnimation() {
        Timer timer = new Timer(1, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                w.getbackgroundlabel().setLocation(world.getBackground().getX(),
                                                    world.getBackground().getY());
                w.getwheelie().setLocation(600, 350 + world.getBackground().getySize());
                w.getjump().setLocation(800, 350 + world.getBackground().getySize());
                w.getpilotlabel().setLocation(50, 175 + world.getBackground().getySize());
                

                // Move first road to the left
                world.getG1().stepX();
                w.getroadlabel().setLocation(world.getG1().getX(), world.getG1().getY());
                
                // Move second road to the left
                world.getG2().stepX();
                w.getroadlabel2().setLocation(world.getG2().getX(), world.getG2().getY());
            
            }
            
        });
        

        timer.start();
    }

    public void setWorld(World world) {
        this.world = world;
    }
    
    // public static void main(String[] args) {
    //     new Animation().runAnimation();
    // }
}
