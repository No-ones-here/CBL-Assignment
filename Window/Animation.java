package Window;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Animation {
    Window w;
    Images img = new Images();

    // Getter for img
    public Images getimg() {
        return this.img;
    }

    public Animation(Window win) {
        this.w = win;
    }
    
    public void runAnimation() {
        Timer timer = new Timer(1, new ActionListener() {
            int roadx = 0;
            int roadx2 = img.getroad().getIconWidth();
            
            @Override
            public void actionPerformed(ActionEvent e) {
                w.getbackgroundlabel().setLocation(0, 200);
                w.getwheelie().setLocation(600, 350 + img.getbackground().getIconHeight());
                w.getjump().setLocation(800, 350 + img.getbackground().getIconHeight());
                w.getpilotlabel().setLocation(50, 175 + img.getbackground().getIconHeight());
                

                // Move first road to the left
                roadx = (roadx - 5) % img.getroad().getIconWidth();
                w.getroadlabel().setLocation(roadx, 200 + img.getbackground().getIconHeight());
                
                // Move second road to the left
                // If the second road goes off the window
                if (roadx2 == 0) {    //start again from the original position
                    roadx2 = img.getroad().getIconWidth();                       
                    roadx2 = (roadx2 - 5) % img.getroad().getIconWidth();                     
                    w.getroadlabel2().setLocation(roadx2, 200 + img.getbackground().getIconHeight());           
                } else if (roadx2 > 0) {
                    roadx2 = (roadx2 - 5) % img.getroad().getIconWidth();
                    w.getroadlabel2().setLocation(roadx2, 200 + img.getbackground().getIconHeight());
                }
            
            }
            
        });
        

        timer.start();
    }
    
    // public static void main(String[] args) {
    //     new Animation().runAnimation();
    // }
}
