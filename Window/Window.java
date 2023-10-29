package Window;

// Imports
import InputHandlers.KeyHandler;
import Launcher.Handler;
import World.World;
import java.awt.*;
import javax.swing.*;


/**
 * Class for Handling Swing Components and GUI.
 * @author Daniele Guggino
 * @id 1933620
 * 
 * @author Luis Santos
 * @id 1998544
 * 
 * @date 29/10/2023
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
    JButton back;
 
    // Labels
    JLabel pilotlabel;
    JLabel wpilotlabel;
    JLabel roadlabel;
    JLabel roadlabel2; 
    JLabel backgroundlabel;
    JLabel instruction;
    JLabel pointsLabel;
    JLabel pointMultiplierLabel;
    JLabel obs1;
    JLabel obs2;
    JLabel obs3;
    JLabel obs4;
    JLabel obs5;
    JLabel bgmLabel;
    JLabel oow;
    JTextArea instr;
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
        frame = new JFrame("Wheelie it up!");
        init();
    }

    private void init() {
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Runs GUI when gameplay is running.
     */
    public void runGame() {
        world = handler.getWorld();
        anim.setWorld(world);
        anim.setPointsHandler(handler.getPointsHandler());


        //Player Object 
        pilotlabel = new JLabel(world.getPlayer().getSprite());
        pilotlabel.setBounds(world.getPlayer().getX(), world.getPlayer().getY(),
                            world.getPlayer().getxSize(), world.getPlayer().getySize());
        frame.add(pilotlabel);

        //Instructions
        instruction = new JLabel("Press: 'W' to wheelie " + "or Space to jump");
        instruction.setBounds(0, 0, 500, 100);
        frame.add(instruction);

        //Wheelie Button
        wheelie = new JButton("Wheelie", null);
        frame.add(wheelie);

        //Jump Button
        jump = new JButton("jump", null);
        frame.add(jump, BorderLayout.NORTH);

        //Points
        pointsLabel = new JLabel("0", SwingConstants.CENTER);
        pointsLabel.setBounds(width / 2 - 100, 0, 200, 100);
        pointsLabel.setFont(new Font("Arial", Font.BOLD, 28));
        frame.add(pointsLabel);

        //Points Multiplier
        pointMultiplierLabel = new JLabel("MULTIPLIER: \n1", SwingConstants.CENTER);
        pointMultiplierLabel.setBounds(pointsLabel.getX() + pointsLabel.getWidth(),
                                         pointsLabel.getY(), 300, 100);
        pointMultiplierLabel.setFont(new Font("Arial", Font.ITALIC, 28));
        frame.add(pointMultiplierLabel);

        //Background
        backgroundlabel = new JLabel(world.getBackground().getSprite());
        backgroundlabel.setBounds(world.getBackground().getX(), world.getBackground().getY(),
                                world.getBackground().getxSize(), world.getBackground().getySize());
        frame.add(backgroundlabel);

        //First instance of road
        roadlabel  = new JLabel(world.getG1().getSprite());
        roadlabel.setBounds(world.getG1().getX(), world.getG1().getY(), 
                            world.getG1().getxSize(), world.getG1().getySize());
        frame.add(roadlabel);

        //Second instance of road
        roadlabel2 = new JLabel(world.getG2().getSprite());
        roadlabel2.setBounds(world.getG2().getX(), world.getG2().getY(),
                            world.getG2().getxSize(), world.getG2().getySize());
        frame.add(roadlabel2);

        //Add Obstacles
        obs1 = new JLabel(world.getObstacleList().getObstacle(0).getSprite());
        obs1.setBounds(world.getObstacleList().getObstacle(0).getX(),
                        world.getObstacleList().getObstacle(0).getY(),
                        world.getObstacleList().getObstacle(0).getxSize(),
                        world.getObstacleList().getObstacle(0).getySize());
        frame.add(obs1);
        frame.getContentPane().setComponentZOrder(obs1, 3);

        obs2 = new JLabel(world.getObstacleList().getObstacle(1).getSprite());
        obs2.setBounds(world.getObstacleList().getObstacle(1).getX(),
                        world.getObstacleList().getObstacle(1).getY(),
                        world.getObstacleList().getObstacle(1).getxSize(),
                        world.getObstacleList().getObstacle(1).getySize());
        frame.add(obs2);
        frame.getContentPane().setComponentZOrder(obs2, 3);

        obs3 = new JLabel(world.getObstacleList().getObstacle(2).getSprite());
        obs3.setBounds(world.getObstacleList().getObstacle(2).getX(),
                        world.getObstacleList().getObstacle(2).getY(),
                        world.getObstacleList().getObstacle(2).getxSize(),
                        world.getObstacleList().getObstacle(2).getySize());
        frame.add(obs3);
        frame.getContentPane().setComponentZOrder(obs3, 3);
        
        obs4 = new JLabel(world.getObstacleList().getObstacle(3).getSprite());
        obs4.setBounds(world.getObstacleList().getObstacle(3).getX(),
                        world.getObstacleList().getObstacle(3).getY(),
                        world.getObstacleList().getObstacle(3).getxSize(),
                        world.getObstacleList().getObstacle(3).getySize());
        frame.add(obs4);
        frame.getContentPane().setComponentZOrder(obs4, 3);

        obs5 = new JLabel(world.getObstacleList().getObstacle(4).getSprite());
        obs5.setBounds(world.getObstacleList().getObstacle(4).getX(),
                        world.getObstacleList().getObstacle(4).getY(),
                        world.getObstacleList().getObstacle(4).getxSize(),
                        world.getObstacleList().getObstacle(4).getySize());
        frame.add(obs5);
        frame.getContentPane().setComponentZOrder(obs5, 3);

        frame.repaint();
        frame.revalidate();

        // Looping the road
        anim.runAnimation();

    }

    /**
     * Running the main menu.
     */
    public void mainMenu() {

        bgmLabel = new JLabel(handler.getBackground().getSprite());
        bgmLabel.setBounds(handler.getBackground().getX(), handler.getBackground().getY(),
                            handler.getBackground().getxSize(), handler.getBackground().getySize());
        oow = new JLabel("Object Oriented Wheelies");
        oow.setBounds(400, 15, 1000, 100);
        oow.setFont(new Font("West", Font.PLAIN, 60));
        oow.setForeground(Color.RED);
        startGame.setBounds(100, 300, 300, 50);
        startGame.addActionListener(handler.getMouseHandler());
        startGame.setFont(new Font("Arial", Font.BOLD, 20));
        instructions.setBounds(100, 375, 300, 35);
        instructions.addActionListener(handler.getMouseHandler());
        instructions.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(oow);
        frame.add(startGame);
        frame.add(instructions);
        frame.add(bgmLabel);
        

        frame.repaint();
        frame.revalidate();
    }

    /**
    * running Instruction page.
    */
    public void runInstr() {
        instr = new JTextArea(" Welcome to OOW! Before taking part of this great adventure make"
                               + " \n sure you know a couple of tips on how to handle this game." 
                               + " \n The pilot, or I should perhaps say Daniel, cause that is"
                               + " \n his name :), is able to wheelie as long as you press 'W',"
                               + " \n but be careful cause once you release the button he is gonna"
                               + " \n go back down as a programmer when he realises he forgot the"
                               + " \n semicolumn ;). So said, have fun!"
                               + " \n Ohhh don't forget to hit the space bar to jump or you will"
                               + " \n hate wine more than you will ever doo!!");
        instr.setBounds(250, 150, 1000, 500);
        instr.setFont(new Font("Comic sans", Font.CENTER_BASELINE, 30));
        instr.setBackground(Color.ORANGE);

        back = new JButton("<");
        back.setBounds(50, 50, 50, 50);
        back.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        back.addActionListener(handler.getMouseHandler());
        
        instr.setEditable(false);
        frame.getContentPane().removeAll();
        
        frame.add(instr);
        System.out.println("");
        frame.add(back);

        frame.repaint();
        frame.revalidate();

    }

   
    public void generateGameOver() {
        JOptionPane.showMessageDialog(null, "GAME OVER!!");
    }

    

    // Getters for buttons
    public JButton getBack() {
        return this.back;
    }

    public JButton getInstructions() {
        return this.instructions;
    }
    
    public JButton getStartGame() {
        return this.startGame;
    }

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

    public JLabel getPointsMultiplierLabel() {
        return this.pointMultiplierLabel;
    }

    /**
    * Gets the JLabel specified by the integer parameter.
    * 
    * @param i integer representation of the 5 obstactle labels (int from 1 - 4)
    */
    public JLabel getObstacle(int i) {
        switch (i) {
            case 0:
                return this.obs1;
            case 1:
                return this.obs2;
            case 2:
                return this.obs3;
            case 3:
                return this.obs4;
            case 4:
                return this.obs5;
            default:
                System.out.println("Get Obstacle Error");
                return null;
        }
    }
    
    public JLabel getPointsLabel() {
        return this.pointsLabel;
    }

    public void clearFrame() {
        frame.getContentPane().removeAll();
    }

    //Getters and Setters
    public JFrame getFrame() {
        return this.frame;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void addKeyListener(KeyHandler keyListener) {
        frame.addKeyListener(keyListener);
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
