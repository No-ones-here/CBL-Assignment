package InputHandlers;

import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Launcher.Handler;
import States.State;

/**
 * Handles Mouse Events
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class MouseHandler implements ActionListener {

    private Handler handler;

    public MouseHandler(Handler handler) {
        this.handler = handler;
        handler.getWindow().getStartGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(handler.getWindow().getStartGame())) {
            handler.setState(1);
            handler.getWindow().clearFrame();
            handler.getWindow().runGame();
        } else if (e.getSource().equals(handler.getWindow().getInstructions())) {
            handler.getWindow().runInstr();
        } else if (e.getSource().equals(handler.getWindow().getBack())) {
            handler.getWindow().clearFrame();
            handler.getWindow().mainMenu();
        }
    }

}