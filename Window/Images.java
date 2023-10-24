package Window;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class Images {
    
    ImageIcon background = new ImageIcon("\\Users\\20233231\\Visual Studio\\projects\\CBL-Assignment\\bg.jpg");
    ImageIcon road = new ImageIcon("\\Users\\20233231\\Visual Studio\\projects\\CBL-Assignment\\road.jpg");
    ImageIcon road2 = new ImageIcon("\\Users\\20233231\\Visual Studio\\projects\\CBL-Assignment\\road.jpg");
    ImageIcon pilot = new ImageIcon("\\Users\\20233231\\Visual Studio\\projects\\CBL-Assignment\\daniel.png");

    public Images() {

    }
    
    public ImageIcon getbackground() {
        return this.background;
    }

    public ImageIcon getroad() {
        return this.road;
    }

    public ImageIcon getroad2() {
        return this.road2;
    }

    public ImageIcon getpilot() {
        return this.pilot;
    }
}
