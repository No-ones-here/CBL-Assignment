package Window;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window {
    private int width;
    private int height;
    private String title;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }
 
    public void createWindow() {
        
    }

    public void runGraph() {
        
        JFrame frame = new JFrame("Wheelie it up!");
        JButton wheelie = new JButton("Wheelie", null);
        JButton jump = new JButton("jump", null);
        
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        
        // Imported images and sprite
        ImageIcon background = new ImageIcon("\\Users\\20233231\\Pictures\\Saved Pictures\\OOWbackground3.jpg");
        ImageIcon road = new ImageIcon("\\Users\\20233231\\Pictures\\Saved Pictures\\OOWroad2.jpg");
        ImageIcon pilot = new ImageIcon("C:\\Users\\20233231\\Pictures\\Saved Pictures\\PinClipart.com_reason-clipart_821299.png");
        
        // labels
        JLabel pilotlabel = new JLabel(pilot);
        JLabel roadlabel = new JLabel(road);
        JLabel backgroundlabel = new JLabel(background);
        

        // Panel that contains the background and the road
        JPanel panel = new JPanel(); 
        panel.add(backgroundlabel);
        panel.add(roadlabel);

        // puts the road right under the background
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 

        backgroundlabel.setSize(800, 600);

        
        // Box that contains the panel
        // to be collocated at the centre
        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalGlue());
        box.add(panel);
        box.add(Box.createVerticalGlue());

        // Animation: looping the road
        Timer timer = new Timer(100, new ActionListener() {
            int roadx = 0;
            @Override
            public void actionPerformed(ActionEvent e){
                ArrayList<ImageIcon> loops = new ArrayList<>();
                loops.add(1, road);
                loops.add(2, road);
                roadx = (roadx - 5) % road.getIconWidth();
                roadlabel.setBounds(roadx, 0, road.getIconWidth(), road.getIconHeight());
                
                /* 
                for (int i = 1; i <= 2; i++) {
                    if (i < 2) {
                        roadx = (roadx - 5) % loops.get(i).getIconWidth();
                        roadlabel.setBounds(roadx, 0, loops.get(i).getIconWidth(), loops.get(i).getIconHeight());
                    } else if (i == 2) {
                        i = 1;
                        roadx = (roadx - 5) % loops.get(i).getIconWidth();
                        roadlabel.setBounds(roadx, 0, loops.get(i).getIconWidth(), loops.get(i).getIconHeight());
                    }
                }
                */
            }
        });


        frame.setContentPane(box);
        frame.setBackground(Color.ORANGE);
        pilotlabel.setBackground(Color.lightGray);
        frame.setVisible(true);

        
        
    }

    public static void main(String[] args) {
        new Window(800, 600, "Wheelie it up!").runGraph();
    }
}