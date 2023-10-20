package Window;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window {
    
   
    public void createWindow() {
        
    }

    

    public void runGraph() {
        
        // Frame
        JFrame frame = new JFrame("Wheelie it up!");

        // Buttons
        JButton wheelie = new JButton("Wheelie", null);
        JButton jump = new JButton("jump", null);
        
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Imported images and sprite
        ImageIcon background = new ImageIcon("\\Users\\20233231\\Pictures\\Saved Pictures\\OOWbackground3.jpg");
        ImageIcon road = new ImageIcon("\\Users\\20233231\\Pictures\\Saved Pictures\\OOWroad2.jpg");
        ImageIcon road2 = new ImageIcon("\\Users\\20233231\\Pictures\\Saved Pictures\\OOWroad2.jpg");
        ImageIcon pilot = new ImageIcon("\\Users\\20233231\\Pictures\\Saved Pictures\\daniel.png");
        
        // Labels
        JLabel pilotlabel = new JLabel(pilot);
        JLabel roadlabel = new JLabel(road);
        JLabel roadlabel2 = new JLabel(road2); 
        JLabel backgroundlabel = new JLabel(background);
        JLabel instructions = new JLabel("Press: W to wheelie" + "\n J to jump");

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
        new Window().runGraph();
    }
}