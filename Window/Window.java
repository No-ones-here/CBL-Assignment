package Window;

// Imports
import Launcher.Handler;
import World.World;
import java.awt.*;
import javax.swing.*;

/**
 * Class for Handling Swing Components and GUI.
 * 
 */
public class Window {
    //Initial Variables
    int width;
    int height;
    String title;

    //Animation
    Animation anim = new Animation(this);

    //World
    World world;

    //Handler
    Handler handler;

    // Buttons
    JButton wheelie;
    JButton jump;
    JButton startGame = new JButton("START GAME");
    JButton instructions = new JButton("INSTRUCTIONS");
 
    // Labels
    JLabel pilotlabel;
    JLabel roadlabel;
    JLabel roadlabel2; 
    JLabel backgroundlabel;
    JLabel instruction;
    // JLabel bgmenulabel = new JLabel(anim.getimg().getBgMenu());
    

    // Constructor method
    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void runGame() {
        world = handler.getWorld();

        JFrame frame = new JFrame("Wheelie it up!");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        
        roadlabel2.setLocation(anim.getimg().getroad().getIconWidth(), 200 + anim.getimg().getbackground().getIconHeight());

        // Looping the road
        anim.runAnimation();
       
        // Adding components to the frame
        //Player Object 
        pilotlabel = new JLabel(world.getPlayer().getSprite());
        frame.add(pilotlabel);

        //Instructions
        instruction = new JLabel("Press: W to wheelie " + "or J to jump");
        frame.add(instruction, BorderLayout.NORTH);

        //Wheelie Button
        wheelie = new JButton("Wheelie", null);
        frame.add(wheelie);

        //Jump Button
        jump = new JButton("jump", null);
        frame.add(jump, BorderLayout.NORTH);

        //Background
        backgroundlabel = new JLabel(anim.getimg().getbackground());
        frame.add(backgroundlabel);

        //First instance of road
        roadlabel  = new JLabel(anim.getimg().getroad());;
        frame.add(roadlabel);

        //Second instance of road
        roadlabel2 = new JLabel(anim.getimg().getroad());
        frame.add(roadlabel2);

        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setVisible(true);
    }

    // Getters for buttons
    public JButton getwheelie() {
        return this.wheelie;
    }

    public JButton getjump() {
        return this.jump;
    }

    
    // Getters for labels
    public JLabel getpilotlabel() {
        return this.pilotlabel;
    }

    public JLabel getroadlabel() {
        return this.roadlabel;
    }

    public JLabel getroadlabel2() {
        return this.roadlabel2;
    }

    public JLabel getbackgroundlabel() {
        return this.backgroundlabel;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    // public void runMenu() {
    //     JFrame frame2 = new JFrame("Welcome to OOW", null);
    //     frame2.setSize(800, 600);
    //     frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    //     frame2.add(bgmenulabel);
    //     frame2.setBackground(Color.ORANGE);
    //     frame2.setVisible(true);
    // }

    // public static void main(String[] args) {
    //     new Window().runMenu();
    // }


}
