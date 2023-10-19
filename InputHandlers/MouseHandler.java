package InputHandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Launcher.Handler;

/**
 * Handles Mouse Events
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class MouseHandler implements ActionListener{

    private Handler handler;

    public MouseHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(null)) {
            //TODO: Fill in each action based on object triggered.
        }
    }

}