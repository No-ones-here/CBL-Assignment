package Window;

// Imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window {
    Animation anim = new Animation(this);
    

    // Buttons
    JButton wheelie = new JButton("Wheelie", null);
    JButton jump = new JButton("jump", null);
    JButton startGame = new JButton("START GAME");
    JButton instructions = new JButton("INSTRUCTIONS");
 
    // Labels
    JLabel pilotlabel = new JLabel(anim.getimg().getPilot());
    JLabel roadlabel = new JLabel(anim.getimg().getRoad());
    JLabel roadlabel2 = new JLabel(anim.getimg().getRoad2()); 
    JLabel backgroundlabel = new JLabel(anim.getimg().getBackground());
    JLabel instruction = new JLabel("Press: W to wheelie " + "or J to jump");
    JLabel bgmenulabel = new JLabel(anim.getimg().getBgMenu());
    

    // Constructor method
    public Window() {
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
    


    public void runGame() {
        JFrame frame = new JFrame("Wheelie it up!");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        
        roadlabel2.setLocation(anim.getimg().getRoad().getIconWidth(), 200 + anim.getimg().getBackground().getIconHeight());

        // Looping the road
        anim.runAnimation();
       
        // Adding components to the frame 
        frame.add(pilotlabel);
        frame.add(instruction, BorderLayout.NORTH);
        frame.add(wheelie);
        frame.add(jump, BorderLayout.NORTH);
        frame.add(backgroundlabel);
        frame.add(roadlabel);
        frame.add(roadlabel2);

        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setVisible(true);
    }

    public void runMenu() {
        JFrame frame2 = new JFrame("Welocme to OOW", null);
        frame2.setSize(800, 600);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // bgmenulabel.setLocation(0, 250);

        // frame2.add(bgmenulabel);

        frame2.setBackground(Color.ORANGE);
        frame2.setVisible(true);

    }


    
    public static void main(String[] args) {
        new Window().runGame();
    }
}