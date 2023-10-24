package Window;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window {
    Animation anim = new Animation() 
    // Frame
    JFrame frame = new JFrame("Wheelie it up!");

    // Buttons
    JButton wheelie = new JButton("Wheelie", null);
    JButton jump = new JButton("jump", null);
    
 
    // Labels
    JLabel pilotlabel = new JLabel(anim.getimg().getpilot());
    JLabel roadlabel = new JLabel(road);
    JLabel roadlabel2 = new JLabel(road2); 
    JLabel backgroundlabel = new JLabel(background);
    JLabel instructions = new JLabel("Press: W to wheelie " + "or J to jump");

   
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
    


    public void runGraph() {
        
       
        
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        
        roadlabel2.setLocation(road.getIconWidth(), 200 + background.getIconHeight());

        // Animation: looping the road
        Timer timer = new Timer(1, new ActionListener() {
            int roadx = 0;
            int roadx2 = road.getIconWidth();
            
            @Override
            public void actionPerformed(ActionEvent e) {
                backgroundlabel.setLocation(0, 200);
                wheelie.setLocation(600, 350 + background.getIconHeight());
                jump.setLocation(800, 350 + background.getIconHeight());
                pilotlabel.setLocation(50, 175 + background.getIconHeight());
                

                // Move first road to the left
                roadx = (roadx - 5) % road.getIconWidth();
                roadlabel.setLocation(roadx, 200 + background.getIconHeight());
                
                // Move second road to the left
                // If the second road goes off the window
                if (roadx2 == 0) {    //start again from the original position
                    roadx2 = road.getIconWidth();                       
                    roadx2 = (roadx2 - 5) % road2.getIconWidth();                     
                    roadlabel2.setLocation(roadx2, 200 + background.getIconHeight());           
                } else if (roadx2 > 0) {
                    roadx2 = (roadx2 - 5) % road2.getIconWidth();
                    roadlabel2.setLocation(roadx2, 200 + background.getIconHeight());
                }
            
            }
            
        });
        

        timer.start();
        
        // Adding components to the frame 
        frame.add(pilotlabel);
        frame.add(instructions, BorderLayout.NORTH);
        frame.add(wheelie);
        frame.add(jump, BorderLayout.NORTH);
        frame.add(backgroundlabel);
        frame.add(roadlabel);
        frame.add(roadlabel2);

        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Window(800, 600, "Wheelie it up!").runGraph();
    }
}