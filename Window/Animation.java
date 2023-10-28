package Window;

import Launcher.Handler;
import PointsSystem.PointsHandler;
import World.World;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




/**
 * Class that Handles the Animations of the GUI.
 * 
 * TODO: FILL IN JAVADOC
 * @author Daniele Guggino
 * @id 1933620
 * @author Luis Santos
 * @id 1998544
 */
public class Animation {
    Window w;
    Handler handler;
    World world;
    PointsHandler pH;

    public Animation(Window win) {
        this.w = win;
    }

    /**
     * Creates a loop with swing Timer to run the animations on the
     * Window.
     * 
     */
    public void runAnimation() {
        Timer timer = new Timer(1000 / 60, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                w.getwheelie().setLocation(600, 350 + world.getBackground().getySize());
                w.getjump().setLocation(800, 350 + world.getBackground().getySize());
                w.getFrame().requestFocus();

                //Render Player
                w.getpilotlabel().setBounds(world.getPlayer().getX(), world.getPlayer().getY(),
                            world.getPlayer().getxSize(), world.getPlayer().getySize());
                if (world.getPlayer().isWheelieState()) {
                    w.getpilotlabel().setIcon(world.getPlayer().getWSprite());
                } else {
                    w.getpilotlabel().setIcon(world.getPlayer().getSprite());
                }

                //Increment Points
                w.getPointsLabel().setText(String.valueOf(pH.getPoints()));

                //Render Obstacle
                w.getObstacle(0).setBounds(world.getObstacleList().getObstacle(0).getX(),
                                        world.getObstacleList().getObstacle(0).getY(),
                                        world.getObstacleList().getObstacle(0).getxSize(),
                                        world.getObstacleList().getObstacle(0).getySize());
                
                w.getObstacle(1).setBounds(world.getObstacleList().getObstacle(1).getX(),
                                        world.getObstacleList().getObstacle(1).getY(),
                                        world.getObstacleList().getObstacle(1).getxSize(),
                                        world.getObstacleList().getObstacle(1).getySize());

                w.getObstacle(2).setBounds(world.getObstacleList().getObstacle(2).getX(),
                                        world.getObstacleList().getObstacle(2).getY(),
                                        world.getObstacleList().getObstacle(2).getxSize(),
                                        world.getObstacleList().getObstacle(2).getySize());

                w.getObstacle(3).setBounds(world.getObstacleList().getObstacle(3).getX(),
                                        world.getObstacleList().getObstacle(3).getY(),
                                        world.getObstacleList().getObstacle(3).getxSize(),
                                        world.getObstacleList().getObstacle(3).getySize());
                
                w.getObstacle(4).setBounds(world.getObstacleList().getObstacle(4).getX(),
                                        world.getObstacleList().getObstacle(4).getY(),
                                        world.getObstacleList().getObstacle(4).getxSize(),
                                        world.getObstacleList().getObstacle(4).getySize());

                // Move first road to the left
                w.getroadlabel().setLocation(world.getG1().getX(), world.getG1().getY());
                
                // Move second road to the left
                w.getroadlabel2().setLocation(world.getG2().getX(), world.getG2().getY());
                
                w.repaint();
            }
            
        });


        

        timer.start();
    }  

    public void setWorld(World world) {
        this.world = world;
    }
    
    public void setPointsHandler(PointsHandler pH) {
        this.pH = pH;
    }
    // public static void main(String[] args) {
    //     new Animation().runAnimation();
    // }
}
