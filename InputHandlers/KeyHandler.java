package InputHandlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Launcher.Handler;
/**
 * Handles Keyboard Inputs in the game.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class KeyHandler implements KeyListener{
    //TODO: Implement Unimplemented Abstract Methods.
    Handler handler;
    
    public KeyHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 87) {
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}