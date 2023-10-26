package Window;

// Imports
import Launcher.Handler;
import World.World;
import java.awt.*;
import java.util.LinkedList;

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
    Animation anim;

    //World
    World world;

    //Handler
    Handler handler;

    //JFrame
    JFrame frame;

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
    ImageComponent obs1;
    // JLabel bgmenulabel = new JLabel(anim.getimg().getBgMenu());
    

    /**
     * Constructor method that initializes initial variables.
     * 
     * @param width describes initial width of window
     * @param height describes initial height of window
     * @param title describes title of window
     */
    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.anim = new Animation(this);
    }

    /**
     * Runs GUI when gameplay is running.
     */
    public void runGame() {
        world = handler.getWorld();
        anim.setWorld(world);

        frame = new JFrame("Wheelie it up!");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());


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
        backgroundlabel = new JLabel(world.getBackground().getSprite());
        frame.add(backgroundlabel);

        //First instance of road
        roadlabel  = new JLabel(world.getG1().getSprite());
        frame.add(roadlabel);

        //Second instance of road
        roadlabel2 = new JLabel(world.getG2().getSprite());
        roadlabel2.setLocation(roadlabel2.getWidth(), 200 + world.getBackground().getySize());
        frame.add(roadlabel2);

        //Add Obstacles
        obs1 = new ImageComponent(world.getObstacle());
        frame.add(obs1);

        // Looping the road
        anim.runAnimation();

        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected void repaint() {
        frame.repaint();
        frame.revalidate();
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

    //Getters and Setters
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
