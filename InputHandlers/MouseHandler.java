package InputHandlers;

import Launcher.Handler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Handles Mouse Events.
 * @author Daniele Guggino
 * @id 1933620
 * 
 * @author Luis Santos
 * @id 1998544
 * 
 * @date 29/10/2023
 */
public class MouseHandler implements ActionListener {

    private Handler handler;
    /**
     * Constructor method for initializing handler.
     * @param handler instance of handler;
     */

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